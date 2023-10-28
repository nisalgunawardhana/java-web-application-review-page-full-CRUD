<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Review - Music Store</title>
    <link rel="stylesheet" type="text/css" href="reviewin.css">
    <script>
        // Check if the operationStatus attribute exists
    
  document.querySelector("form").addEventListener("submit", function (e) {
    var ratingInput = document.getElementById("rating");
    var ratingValue = parseInt(ratingInput.value);

    if (ratingValue < 1 || ratingValue > 5) {
      e.preventDefault(); // Prevent form submission
      alert("Rating must be between 1 and 5");
      ratingInput.value = ""; // Clear the input field
    }
  });
</script>
</head>
<body>

<%
//Retrieve parameters from the request
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String rate = request.getParameter("rate");
		String comment = request.getParameter("comment");
		
	%>
    <h2>Update Review</h2>
    <form action="updateReview" method="post">
        <input type="text" name="id" value="<%= id %>"readonly>
        <label for="name">Name:</label>
        <input type="text" name="name" id="name" value="<%= name %>" required><br>
        <label for="rating">Rating(1-5):</label>
        <input type="number" name="rating" id="rating" min="1" max="5" value="<%= rate %>" required><br>
        <label for="comment">Comment:</label>
        <textarea name="comment" id="comment" required><%= comment %></textarea><br>
        <input type="submit" name="submit" value="Update Review">
    </form>
</body>
</html>
