package com.fdm.controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdm.model.storage.DBUserStorage;
import com.fdm.model.storage.User;

public class RegisterServlet extends HttpServlet {

                RequestDispatcher dispatcher;
                
                public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
                                dispatcher = req.getRequestDispatcher("/register.jsp");
                                dispatcher.forward(req, resp);
                }
                
                public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
                                String username = req.getParameter("Username");
                                String password = req.getParameter("Password");
                                String fname = req.getParameter("Firstname");
                                String lname = req.getParameter("Lastname");
                                String email = req.getParameter("Email");
                                String shareholder = req.getParameter("Shareholder");
                                String broker = req.getParameter("Broker");
                                String admin = req.getParameter("Manager");
                                String manager = req.getParameter("Admin");
                                StringBuilder sb = new StringBuilder();
                                
                                if(shareholder == null){
                                                shareholder = "0";
                                }
                                if(broker == null){
                                                broker = "0";
                                }
                                if(admin == null){
                                                admin = "0";
                                }
                                if(manager == null){
                                                manager = "0";
                                }
                                sb.append(shareholder);
                                sb.append(broker);
                                sb.append(admin);
                                sb.append(manager);    
                                
                                String role = sb.toString();
                                
                                User user = new User();
                                user.setUsername(username);
                                user.setPassword(password);
                                user.setFirstname(fname);
                                user.setLastname(lname);
                                user.setEmail(email);
                                user.setRole(role);
                                user.setBanned(false);
                                
                                DBUserStorage db = new DBUserStorage();
                                db.addUser(user);
                                
                                req.setAttribute("usern", username);
                                req.setAttribute("userp", password);
                                req.setAttribute("fname", fname);
                                req.setAttribute("lname", lname);
                                req.setAttribute("email", email);


                                
                                dispatcher = req.getRequestDispatcher("/regconfirmation.jsp");
                                dispatcher.forward(req, resp);
                }
}
