package com.musicstore;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve parameters from the HTTP request
		String name = request.getParameter("name");
		String rate = request.getParameter("rating");
		String comment = request.getParameter("comment");
		
		boolean isTrue;
		
		isTrue = ReviewDBUtil.insertReview(name, rate, comment);
		
		if (isTrue) {
			/*
			 *  If the review insertion was successful
			 */
            List<Review> reviews = ReviewDBUtil.getAllReviews(); // Retrieve all reviews
            request.setAttribute("reviews", reviews); // Add reviews to the request
            RequestDispatcher dis = request.getRequestDispatcher("review.jsp");
            dis.forward(request, response);
        } else {
        	/*
			 *  If the review insertion was unsuccessful
			 */
            RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
            dis2.forward(request, response);
        }
		
		
		
		
	}
	
	
}