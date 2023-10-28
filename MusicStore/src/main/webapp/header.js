/**
 * 
 */
 // main.js

document.addEventListener("DOMContentLoaded", function () {
    const mobileNavButton = document.querySelector(".mobile-nav-button");
    const mobileMenu = document.querySelector(".mobile-menu");
    const closeButton = document.querySelector(".close-button");

    mobileNavButton.addEventListener("click", () => {
        mobileMenu.classList.add("open");
    });

    closeButton.addEventListener("click", () => {
        mobileMenu.classList.remove("open");
    });
});

const searchInput = document.getElementById("search-input");
const searchButton = document.getElementById("search-button");

searchButton.addEventListener("click", function() {
    const searchQuery = searchInput.value;
    // Perform a search action with the searchQuery
    // Update the UI with search results
});

// You can also add event listeners for key presses (e.g., Enter key) in the input field.
