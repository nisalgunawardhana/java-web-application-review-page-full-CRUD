<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="home.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script type="text/javascript">
    //popup welcome text
    document.addEventListener("DOMContentLoaded", function() {
        const popup = document.getElementById("welcome-popup");
        const closeBtn = document.getElementById("close-popup");

        // Show the popup on page load
        popup.style.display = "block";

        // Close the popup when the close button is clicked
        closeBtn.addEventListener("click", function() {
            popup.style.display = "none";
        });

        // Close the popup when clicking outside of it
        window.addEventListener("click", function(event) {
            if (event.target == popup) {
                popup.style.display = "none";
            }
        });
    });

    
    </script>
</head>
<body>
<!-- include header.jsp -->
<jsp:include page="header.jsp" />

<div id="welcome-popup" class="popup">
        <div class="popup-content">
            <span class="close" id="close-popup">&times;</span>
            <h2>Welcome to Retroz.music</h2>

        </div>
            
        </div>
    

<main>
        <div class="slideshow-container">
        <div class="slide fade">
            <img src="./img/Orange & White Minimalist Music Channel Youtube Banner.png" alt="Slide 1">
        </div>
        <div class="slide fade">
            <img src="./img/Orange & White Minimalist Music Channel Youtube Banner-2.png" alt="Slide 2">
        </div>
        <div class="slide fade">
            <img src="./img/Orange & White Minimalist Music Channel Youtube Banner.png" alt="Slide 3">
        </div>
    </div>

    <div class="shop-banners">
        <div class="shop-banner">
            <img src="./img/1.jpg" alt="Album 1">
            <h2>Broken Album</h2>
        	<p>Price: $10.99</p>
            <button class="shop-button">Buy now</button>
        </div>
        <div class="shop-banner">
            <img src="./img/2.jpg" alt="Album 2">
            <h2>Dream Album</h2>
        	<p>Price: $10.99</p>
            <button class="shop-button">Buy now</button>
        </div>
    </div>

    <div class="section">
        <div class="review-images">
            <img src="./img/company-rating.png" alt="Review 1">
            
            <!-- Add more review images as needed -->
        </div>
        <div class="visit-button">
            <p>Check out the reviews!</p>
            <button onclick="window.location.href='review.jsp'">Visit Reviews</button>
        </div>
    </div>
    
    
    
    </main>
<!-- include footer.jsp -->
<div class="footer-container">
  <jsp:include page="footer.jsp" />
  </div>
  <script src="home.js"></script>
</body>
</html>