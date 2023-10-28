package com.musicstore;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteReviewServlet")
public class DeleteReviewServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("reviewId")); // Retrieve the review ID

        boolean isDeleted = ReviewDBUtil.deleteReview(id);

        if (isDeleted) {
            /* if deletion successful 
             * Redirect to the review.jsp page 
             * // Retrieve a list of all reviews
             */
        	List<Review> reviews = ReviewDBUtil.getAllReviews(); // Retrieve all reviews
            request.setAttribute("reviews", reviews); // Add reviews to the request
            RequestDispatcher dis = request.getRequestDispatcher("review.jsp");//Redirect to the review.jsp page
            dis.forward(request, response);
        } else {
            // Redirect to an error page 
            response.sendRedirect("unsuccess.jsp");
        }
    }
}

