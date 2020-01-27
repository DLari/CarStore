// const headers = {
//     "Content-Type":"application/json",
//     "Accept":"application/json",
//     'Authorization': 'Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MjE1Njg0NDgsImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6NTAyOTgvIiwiYXVkIjoiaHR0cDovL2xvY2FsaG9zdDo1MDI5OC8ifQ._HLLwRXoZksBSICPHQlLd-0r_uJJN_kmw2p78XOBfmw'
// };

const logIn = () =>{
    const userName = document.getElementById('login').value;
    const password = document.getElementById('password').value;

    const data = JSON.stringify({
        username: userName,
        password: password
    });
    let xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            const response = JSON.parse(this.response);
            localStorage.token = response.token;
            getUser();
        }
    };
    xmlhttp.open("POST", "/login", true);
    xmlhttp.setRequestHeader("Content-type", "application/json");
    xmlhttp.send(data);
};

const userRedirect = (user) =>{
    if (user.rule === 'admin')
        window.location.replace("http://localhost:8080/adminIndex");
    else  window.location.replace("http://localhost:8080/index");
    // switch (user.rule) {
    //     case 'admin': window.location.replace("http://localhost:8080/adminIndex");
    //     case 'user':  window.location.replace("http://localhost:8080/index");
    //     //default: window.location.replace("http://localhost:8080/login");
    // }
};

const getUser = () => {
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
            userRedirect(data);
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};

