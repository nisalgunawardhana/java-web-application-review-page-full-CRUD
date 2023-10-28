<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review - Music store</title>
<link rel="stylesheet" type="text/css" href="reviewin.css">

<script>
        // Check if the operationStatus 
        var operationStatus = "<%= request.getAttribute("operationStatus") %>";
        if (operationStatus === "success") {
            alert("Operation successful!");
        } else if (operationStatus === "unsuccess") {
            alert("Operation unsuccessful!");
        }
      
</script>

<script src="header.js"></script>

</head>
<body>
<!-- include header.jsp -->
<jsp:include page="header.jsp" />

<h1 >BE THE FIRST TO REVIEW</h1>
<!-- Create a form for submitting reviews -->
<div class="review-form">
<form action="insertReview" method="post">
	<label for="name">Name:</label>
    <input type="text" name="name" id="name" required><br> 
    <label for="rating">Rating(1-5):</label>
    <input type="number" name="rating" id="rating" min="1" max="5" required><br> 
    <label for="comment">Comment:</label>
    <textarea name="comment" id="comment" required></textarea><br>
    <input type="submit" name="submit" value="Submit Review">
</form>
</div>

<!-- Display reviews  -->
<section class="reviews">
  <h2>Reviews</h2>
   
  <ul class="review-list">
  <c:choose>
      <c:when test="${not empty reviews}">
    <c:forEach items="${reviews}" var="review">
    <c:set var="id" value="${review.id}"/>
	<c:set var="name" value="${review.name}"/>
	<c:set var="rate" value="${review.rate}"/>
	<c:set var="comment" value="${review.comment}"/>
    
      <li class="review-item">
        <div class="review-header">
        
          <p class="hidden">${review.id}</p>
          <p><strong>${review.name}</strong></p>
          <p>Rating:
            <c:forEach var="i" begin="1" end="${review.rate}">
              <span class="star-icon"></span>
            </c:forEach>
          </p>
        </div>
        <p class="review-comment">${review.comment}</p>
        <div class="review-actions">
        <!-- Provide options to delete and edit the review -->
          <a href="DeleteReviewServlet?reviewId=${review.id}" class="delete-review">Delete Review</a>
     <c:url value="updateReview.jsp" var="reviewdata">
		<c:param name="id" value="${id}"/>
		<c:param name="name" value="${name}"/>
		<c:param name="rate" value="${rate}"/>
		<c:param name="comment" value="${comment}"/>
		</c:url>
		<a href="${reviewdata}" class="update-review">Edit Review </a>
     </div>
      </li>
    </c:forEach>
    <!-- Display a message when no reviews are available -->
    </c:when>
      <c:otherwise>
        <p>No reviews yet.</p>
      </c:otherwise>
      </c:choose>
  </ul>
</section>

<!-- include footer.jsp -->
<div class="footer-container">
  <jsp:include page="footer.jsp" />
</div>
    <script src="home.js"></script>
</body>
</html>