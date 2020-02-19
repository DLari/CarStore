
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
            alert("Регистрация прошла успешно. Вы будете переведены на главную страницу");
            window.location.replace("http://localhost:8080/index");
        },
        error: function(jqXHR,textStatus,errorThrown,data) {
            for (let i =0; i<jqXHR.responseJSON.fieldErrors.length; i++) {

                if (jqXHR.responseJSON.fieldErrors[i].field === 'login') {
                    document.getElementById("error_login").innerHTML = jqXHR.responseJSON.fieldErrors[i].error;
                }
                if (jqXHR.responseJSON.fieldErrors[i].field === 'password') {
                    document.getElementById("error_password").innerHTML = jqXHR.responseJSON.fieldErrors[i].error;
                }
                if (jqXHR.responseJSON.fieldErrors[i].field === 'fio') {
                    document.getElementById("error_fio").innerHTML = jqXHR.responseJSON.fieldErrors[i].error;
                }
                if (jqXHR.responseJSON.fieldErrors[i].field === 'address') {
                    document.getElementById("error_adress").innerHTML = jqXHR.responseJSON.fieldErrors[i].error;
                }
                if (jqXHR.responseJSON.fieldErrors[i].field === 'phoneNumber') {
                    document.getElementById("error_phone_number").innerHTML = jqXHR.responseJSON.fieldErrors[i].error;
                }
            }
        }
    });
}