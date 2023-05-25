package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelDemo;
@WebServlet("/groceryshop")
public class Demo extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		double bill;
		String itemName=req.getParameter("productitem");
		String deliveryType=req.getParameter("deliverytype");
		ModelDemo m1=new ModelDemo();
		bill=m1.getBill(itemName,deliveryType);
		RequestDispatcher rd=req.getRequestDispatcher("displayBill.jsp");
		req.setAttribute("finalbill",bill);
		rd.forward(req, resp);
		
	}

}
