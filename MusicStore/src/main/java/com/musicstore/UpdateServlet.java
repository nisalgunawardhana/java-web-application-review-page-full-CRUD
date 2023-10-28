package com.musicstore;

//Java's standard libraries
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Retrieve parameters from the HTTP request
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String rate = request.getParameter("rating");
		String comment = request.getParameter("comment");
		boolean isTrue;
		
		isTrue = ReviewDBUtil.updateReview(id, name, rate, comment);
		//check update was success
		if(isTrue == true) {
			
			
			List<Review> reviews = ReviewDBUtil.getAllReviews(); // Retrieve all reviews
            request.setAttribute("reviews", reviews);// Add the list of reviews to jsp file
			RequestDispatcher dis = request.getRequestDispatcher("review.jsp"); // Forward  to the review.jsp
			dis.forward(request, response);
		}
		else {
			
			
			RequestDispatcher dis = request.getRequestDispatcher("review.jsp");
			dis.forward(request, response);
		}
	}

}
