const headers = {
    "Content-Type":"application/json",
    "Accept":"application/json",
    'Authorization': 'Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MjE1Njg0NDgsImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6NTAyOTgvIiwiYXVkIjoiaHR0cDovL2xvY2FsaG9zdDo1MDI5OC8ifQ._HLLwRXoZksBSICPHQlLd-0r_uJJN_kmw2p78XOBfmw'
};

const submitForm = () =>{
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

            window.location.replace("http://localhost:8080/adminIndex");
        }
    };
    xmlhttp.open("POST", "/login", true);
    xmlhttp.setRequestHeader("Content-type", "application/json");
    xmlhttp.send(data);
};
// const getAuth = () => {
//     const oDataSelect = "/cars";
//     $.ajax({
//         url: 'http://localhost:50298/api/Validate',
//         headers: {
//             'Accept': 'application/json',
//             'Content-Type': 'application/json',
//             'Authorization': 'Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MjE1Njg0NDgsImlzcyI6Imh0dHA6Ly9sb2NhbGhvc3Q6NTAyOTgvIiwiYXVkIjoiaHR0cDovL2xvY2FsaG9zdDo1MDI5OC8ifQ._HLLwRXoZksBSICPHQlLd-0r_uJJN_kmw2p78XOBfmw'
//         },
//         method: 'GET',
//         dataType: 'json',
//         success: function (data) {
//             console.log('succes: ' + data);
//         }
//     })
// };

//$("#submit").click(function() {
    //$.ajax({
        //type: "POST",
       // url: "/login",
     //   headers: headers,
        // data: {
        //     username: "john.doe",
        //     password: "foobar"
        // },
       // data: "name="+$("#login").val()+"&pass="+$("#pass").val(),
       //  beforeSend : function(xhr) {
       //      xhr.setRequestHeader("Accept", "application/json");
       //      xhr.setRequestHeader("Content-Type", "application/json");
       //      xhr.setRequestHeader("Authorization", "Bearer"+token);
       //  },
       //  error : function() {
       //      // error handler
       //  },
        //success: function(data) {
            //localStorage.token = data.token;
            //alert('Got a token from the server! Token: ' + data.token);
            //console.log(data);
          //  return data;
        //},
      //  error: function() {
        //    alert("Login Failed");
    //    }
  //  });
//});