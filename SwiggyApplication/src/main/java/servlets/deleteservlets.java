package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbconnections.swiggydbconnections;
import services.swiggyservices;

@WebServlet("/delete")
public class deleteservlets extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		swiggyservices ss = new swiggyservices(swiggydbconnections.getconnection());
		boolean f = ss.deletebyId(id);
		if (f) {
			resp.sendRedirect("welcome.jsp");
		} else {
            resp.sendRedirect("welcome.jsp");
		}
	}

}
