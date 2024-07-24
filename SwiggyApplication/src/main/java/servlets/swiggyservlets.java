package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnections.swiggydbconnections;
import models.swiggy;
import services.swiggyservices;


@WebServlet("/register")
public class swiggyservlets extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String confirmpassword = req.getParameter("confirmpassword");
//		long phonenumber = Long.parseLong(req.getParameter("phonenumber"));
		swiggy s = new swiggy(0, name, email, password, confirmpassword);
		swiggyservices ss = new swiggyservices(swiggydbconnections.getconnection());
		
		 boolean f = ss.adding(s);
		
		if (f) {
			resp.sendRedirect("welcome.jsp");
			
			
		} else {
            resp.sendRedirect("register.jsp");
		}
	}

}
