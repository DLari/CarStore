const editUser =() =>{
    const id = document.getElementById('input-id').value;
    const fio = document.getElementById('fio').value;
    const dateOfBirth = document.getElementById('date_of_birth').value;
    const address = document.getElementById('address').value;
    const login = document.getElementById('login').value;
    const password = document.getElementById('password').value;
    const phoneNumber = document.getElementById('phone_number').value;
    // const rule = document.getElementById('role').value;
    const data = JSON.stringify({
        fio: fio,
        dateOfBirth: dateOfBirth,
        address: address,
        login: login,
        password: password,
        phoneNumber:phoneNumber
        // rule:rule
    });
    const oDataSelect = `/users/${id}`;
    $.ajax({
        url:oDataSelect,
        type:"PUT",
        headers: headers,
        data: data,
        success: function() {
            window.location.replace("http://localhost:8080/index");
        },
        error: function() {
            alert("Failed");
        }
    });
};