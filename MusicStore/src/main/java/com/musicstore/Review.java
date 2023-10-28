package com.musicstore;

/*The review class implements the Reviewable interface, which defines the common methods
* for reviewing items.
*/

public class Review implements Reviewable {

	    private int id; 
	    private String name;
	    private String rate;
	    private String comment;

	    

		public Review(int id,String name, String rate, String comment) { // overloaded Constructs
	        this.name = name;
	        this.rate = rate;
	        this.comment = comment;
	    }
		public Review() { //Default constructor
			// TODO Auto-generated constructor stub
		}
		public int getId() { //Get the unique id of the review.
			return id;
		}

		public String getName() {//Get name of the reviewer.
			return name;
		}

		public String getRate() { //Get rate 
			return rate;
		}

		public String getComment() { //Get comment
			return comment;
		}

		public void setId(int id) {//Set the unique id of the review.
			this.id = id;
		}

		public void setName(String name) { //Set name of the review.
			this.name = name;
		}

		public void setRate(String rate) {//Set rate
			this.rate = rate;
		}

		public void setComment(String comment) { //Set comment
			this.comment = comment;
		}
		@Override
		public void printReview() { // Implement the printReview method
			// TODO Auto-generated method stub
			System.out.println("Review - ID: " + id);
	        System.out.println("Name: " + name);
	        System.out.println("Rating: " + rate);
	        System.out.println("Comment: " + comment);
			
		}

	    
	}


