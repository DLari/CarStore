const headers = {
    "Content-Type":"application/json",
    "Accept":"application/json",
    'Authorization': `Bearer ${localStorage.getItem('token')}`
};

$(document).ready(() => {
    if (localStorage.getItem('token')) {
        document.getElementById('fio').style.display = 'block';
    }
    getUserFio();
    //  writeModelFilter();
});


$("#button").click(function() {

$.ajax({
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
    localStorage.setItem('token','');

    window.location.replace("http://localhost:8080/index");
}
const getUserFio = () => {
    const oDataSelect = `/users/mine`;
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: {
            "Content-Type":"application/json",
            "Accept":"application/json",
            'Authorization': `Bearer ${localStorage.getItem('token')}`
        },
        success: (data) => {
            if (data.rule !== 'admin') {
                window.location.replace("http://localhost:8080/accessError");
            }
            const elements = $('#fioItems').children();
            elements[0].innerHTML = data.fio;
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};
