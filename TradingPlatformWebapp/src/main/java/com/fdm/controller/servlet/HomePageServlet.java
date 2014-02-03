package com.fdm.controller.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fdm.model.Validator;
import com.fdm.model.storage.DBUserStorage;
import com.fdm.model.Login;

public class HomePageServlet extends HttpServlet {

	RequestDispatcher dispatcher;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		dispatcher = req.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String username = req.getParameter("Username");
		String password = req.getParameter("Password");
		boolean valid = false; 
		
		Validator val = new Validator();
		Login log = new Login(new DBUserStorage());
		
		if(val.checkUsername(username) && val.checkPassword(password)){
			if(log.authenticate(username, password)){
				valid = true;
			}
		} else {
			valid = false;
		}
		
		req.setAttribute("valid", valid);
		dispatcher = req.getRequestDispatcher("/logincheck.jsp");
		dispatcher.forward(req, resp);
	}
}