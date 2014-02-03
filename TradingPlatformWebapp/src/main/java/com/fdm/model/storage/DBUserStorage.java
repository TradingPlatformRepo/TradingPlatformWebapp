package com.fdm.model.storage;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fdm.model.service.ConnectionPool;

public class DBUserStorage implements IUserStorage
{
    private String url;
    private String name;
    private String password;
    private Connection c = null;
    
    public DBUserStorage()
    {
        url = "jdbc:oracle:thin:@//orabtn001:1521/xe";
        name = "jonaswieneke";
        password = "Oracle101";
    }
    
    public void addUser(User user)
    {

        // TODO Auto-generated method stub
        try
        {
            c = getCP().checkout();
            String addUserToDB = "{call ADD_USER(?,?,?,?,?,?,?)}";
            CallableStatement call = c.prepareCall(addUserToDB);
            call.setString(1, user.getUsername());
            call.setString(2, user.getPassword());
            call.setString(3, user.getEmail());
            call.setString(4, user.getFirstname());
            call.setString(5, user.getLastname());
            call.setString(6, user.getRole());
            call.setString(7, user.getBanned().toString());
            call.executeUpdate();
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally
        {
            getCP().checkin(c);
        }
        
    }

    public ConnectionPool getCP()
    {
//        System.out.println("here2");
        return ConnectionPool.getInstance(url, name, password);
    }

    public User getUser(String user)
    {
        Connection c = null;
        User newUser = new User(null, null, null, null, null, null, null);
        try 
        {
            c = getCP().checkout();
            CallableStatement call = c.prepareCall("{call GET_USER(?,?)}");
            call.setString(1, user);
            call.registerOutParameter(2, oracle.jdbc.OracleTypes.CURSOR);
            call.executeQuery();
            ResultSet rs = (ResultSet) call.getObject(2);
            if(rs.next())
            {
                newUser.setUsername(rs.getString("username"));
                newUser.setPassword(rs.getString("password"));
                newUser.setFirstname(rs.getString("firstname"));
                newUser.setLastname(rs.getString("lastname"));
                newUser.setEmail(rs.getString("email"));
                newUser.setRole(rs.getString("role"));
                newUser.setBanned(Boolean.parseBoolean(rs.getString("banned")));   
            }
        } catch (SQLException e) 
        {
               // TODO Auto-generated catch block
               e.printStackTrace();
        }
        finally
        {
               getCP().checkin(c);
        }
        
        return newUser;         

    }

    public void removeUser(String user)
    {
        Connection c = null;
        // TODO Auto-generated method stub
        try
        {
            c = getCP().checkout();
            String removeUserFromDB = "{call REMOVE_USER(?)}";
            CallableStatement call = c.prepareCall(removeUserFromDB);
            call.setString(1, user);
            call.executeUpdate();
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }
        finally
        {
            getCP().checkin(c);
        }
        
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

//    public Connection getConnection() throws SQLException
//    {
////        Connection c = null;
////        c = ConnectionPool.getInstance(url, name, password).checkout();
////        return c;
//        return getCP().checkout();
//    }
}
