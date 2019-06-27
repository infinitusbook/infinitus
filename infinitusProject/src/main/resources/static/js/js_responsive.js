
function myFunction() {
  var x = document.getElementById("mySidenav")
    if (x.className === "topnav") {
      x.className += " responsive";
    } else {
      x.className = "sidenav";
    }
  }
  