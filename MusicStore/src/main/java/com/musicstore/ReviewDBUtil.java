package com.musicstore;

//Java's standard libraries 
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ReviewDBUtil {
	
	// static variable for database connection
	private static Connection con = null;
	

	//insert review
	public static boolean insertReview(String name,String rate , String comment) {
		
		boolean is_success = false;
		//using try catch and error handling
		try {
			// Get a database connection
			con = DBConnect.getConnection();
			
		        String sql = "INSERT INTO review (name, rate, comment) VALUES (?, ?, ?)";
		        java.sql.PreparedStatement pstmt = con.prepareStatement(sql); // prepared statement to execute the SQL query 
		        pstmt.setString(1, name); // Set the parameters
		        pstmt.setString(2, rate);
		        pstmt.setString(3, comment);

		        int rs1 = pstmt.executeUpdate(); // Execute query and get the no of rows affected
			
		     // Check if was successful
			if(rs1 >0) {
				is_success = true;
			}else {
				is_success = false;
			}	
		}catch(Exception e){
			e.printStackTrace();
			
		}
		return is_success; //return result 
		
	}
	
	//retrieve data 
	
	public static List<Review> getAllReviews() {
        List<Review> reviews = new ArrayList<>(); // Create  list to store review objects
        Connection con = null;
      //using try catch and error handling
        try {
            con = DBConnect.getConnection(); //get DB connection
            String sql = "SELECT id, name, rate, comment FROM review"; // Define the SQL query
            java.sql.PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();// Execute  query ,get the result set
            
            
            //while loop
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String rate = rs.getString("rate");
                String comment = rs.getString("comment");
                Review review = new Review(); //create new object
                review.setId(id); //using setters and set values
                review.setName(name);//using setters and set values
                review.setRate(rate);//using setters and set values
                review.setComment(comment);//using setters and set values
                reviews.add(review);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 

        return reviews;// Return review list
    }
	
	//Update review
	
	
	public static boolean updateReview(int id,String name,String rate , String comment) {
    	
		boolean isSuccess = false;
		
		//using try catch and error handling
    		try {
    		
    			con = DBConnect.getConnection(); //get DB connection

    			String sql = "update review set name='"+name+"',rate='"+rate+"',comment='"+comment+"'"+"where id ='"+id+"'"; //SQL query to update reviews
    			java.sql.PreparedStatement pstmt = con.prepareStatement(sql); //prepared statement to execute SQL query
    			
    			int rs = pstmt.executeUpdate(sql);//execute query and get no of row affected
    			
    			
    			//check is was successful
    			if(rs > 0) {
    			isSuccess = true;
    			}
    			else {
    			isSuccess = false;
    			}
    		
    		}
    		catch(Exception e) {
    			e.printStackTrace();
    		}
    	
    		return isSuccess;// Return status
    	}



	//delete review
    public static boolean deleteReview(int id) {
        boolean isDeleted = false;
        Connection con = null;
        
      //using try catch for error handling
        try {
        	
            con = DBConnect.getConnection();//get DB connection
            String sql = "DELETE FROM review WHERE id=?";  //SQL query for delete reviews
            java.sql.PreparedStatement pstmt = con.prepareStatement(sql); //prepared statement to execute SQL query
            pstmt.setInt(1, id); //set id to prepared statement

            int rowsDeleted = pstmt.executeUpdate();
            //check if was success
            if (rowsDeleted > 0) {
                isDeleted = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return isDeleted; //return status
    }
	
	
    
    public static void printReviewInfo(Reviewable review) { // Method for printing review  using polymorphism
        review.printReview();
    }
}
