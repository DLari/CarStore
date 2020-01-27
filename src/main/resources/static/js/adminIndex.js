const headers = {
    "Content-Type":"application/json",
    "Accept":"application/json",
    'Authorization': `Bearer ${localStorage.getItem('token')}`
};
$("#button").click(function() {

$.ajax({
// type: "POST",
// url: "/login",
    headers: headers,
success: function(data) {
    window.location.replace("http://localhost:8080/index");
},
 error: function() {
   alert("Login Failed");
   }
 });
});
function logOut(){
    localStorage.setItem('token','')

    window.location.replace("http://localhost:8080/index");
}