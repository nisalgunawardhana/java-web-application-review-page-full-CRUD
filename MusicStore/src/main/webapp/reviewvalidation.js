
  document.querySelector("form").addEventListener("submit", function (e) {
    var ratingInput = document.getElementById("rating"); // Getting a reference to the "rating" input element
    var ratingValue = parseInt(ratingInput.value); // Parsing the input value to an integer

// Checking if the rating is not within the valid range (1 to 5)
    if (ratingValue < 1 || ratingValue > 5) {
      e.preventDefault(); // Prevent form submission.
      
      alert("Rating must be between 1 and 5");
      ratingInput.value = ""; // Clear  input field
    }
  });