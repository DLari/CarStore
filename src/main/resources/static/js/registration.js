
function createUser(){
    const login = document.getElementById('login').value;
    const password = document.getElementById('password').value;
    const fio = document.getElementById('fio').value;
    const dateOfBirth = document.getElementById('dateOfBirth').value;
    const address = document.getElementById('adress').value;
    const phoneNumber = document.getElementById('phone_number').value;
    const data = JSON.stringify({
        login: login,
        password: password,
        fio: fio,
        dateOfBirth: dateOfBirth,
        address: address,
        phoneNumber: phoneNumber
    });
    const oDataSelect = `/users`;
    $.ajax({
        url:oDataSelect,
        type:"POST",
        headers:  {"Content-Type":"application/json",
        "Accept":"application/json"},
        data: data,
        success: function() {
            window.location.replace("http://localhost:8080/index");
        },
        error: function() {
            alert("Failed");
        }
    });
}