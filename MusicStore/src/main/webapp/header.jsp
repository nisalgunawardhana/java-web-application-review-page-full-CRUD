<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="home.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="header.js"></script>
   
    
</head>
<body>
<header>
        <div class="logo">
            <img src="./img/1.png" alt="Your Logo">
        </div>
        <nav>
            <ul>
                <li><a href="Home.jsp">Home</a></li>
                <li><a href="Shop.jsp">Shop</a></li>
                <li><a href="about.jsp">About Us</a></li>
                <li><a href="#">Contact Us</a></li>
                <li><div class="search-container">
        <input type="text" id="search-input" placeholder="Search...">
        <button id="search-button">Search</button>
    </div></li>
            </ul>
        </nav>
        <div class="user-actions">
            <a href="login-or-signup.html" class="login-signup-button">
                <i class="fas fa-user"></i> My Acoount
            </a>
            
            
        </div>

        <button class="mobile-nav-button">
            <i class="fas fa-bars"></i>
        </button>
    
        <ul class="mobile-menu">
        	
            
            <li><a href="Home.jsp">Home</a></li>
            <li><a href="Shop.jsp">Shop</a></li>
            <li><a href="about.jsp">About Us</a></li>
            <li><a href="#">Contact Us</a></li>
            <li><a href="login-or-signup.html">My Account</a></li>
            <li><button class="close-button">
                <i class="fas fa-times"></i> </button></li>
            
            
        </ul>
        
    </header>

</body>
</html>