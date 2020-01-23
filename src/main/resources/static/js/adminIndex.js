
$("#button").click(function() {

$.ajax({
// type: "POST",
// url: "/login",
    headers: {
        "Content-Type":"application/json",
        "Accept":"application/json",
        'Authorization': `Bearer ${localStorage.setItem('')}`
    },
success: function(data) {
    window.location.replace("http://localhost:8080/login");
},
 error: function() {
   alert("Login Failed");
   }
 });
});
