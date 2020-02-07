
$(document).ready(() => {
    getUserTable();
});

let currentEditColor;
const getUserTable = () => {
    const oDataSelect = `/users/mine`;
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: headers,
        success: (data) => {
            renderHTML(data);
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};
const openEditColorModal = () => {

};

const getUserEdit = (e) => {
    const oDataSelect = `/users/mine`;
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: headers,
        success:function (data) {
            openEditUserModel(data);
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};

const openEditUserModel = (data) => {

    document.getElementById('edit-container').style.display = 'block';

    let inputId = document.getElementById('input-id');
    inputId.value = data.id;

    // let inputRole = document.getElementById('role');
    // inputRole.value = data.rule;

    let inputFio = document.getElementById('fio');
    inputFio.value = data.fio;

    let inputDateOfBirth = document.getElementById('date_of_birth');
    inputDateOfBirth.value = data.dateOfBirth;

    let inputPhoneNumber = document.getElementById('phone_number');
    inputPhoneNumber.value = data.phoneNumber;

    let inputAddress = document.getElementById('address');
    inputAddress.value = data.address;

    let inputLogin = document.getElementById('login');
    inputLogin.value = data.login;

    let inputPassword = document.getElementById('password');
    inputPassword.value = data.password;

};


function renderHTML(item) {
    let html = '';
        html += createHTMLByElem(item);
    let tbody = document.getElementById('table-body');
    tbody.insertAdjacentHTML('afterbegin',html);
}

function createHTMLByElem(item) {
    let dateOfBirth = new Date (item.dateOfBirth);
    let year = dateOfBirth.getFullYear();
    let month = dateOfBirth.getMonth();
    let day = dateOfBirth.getDay();
    return `<tr id="${item.id}">
                <td>${item.fio}</td>
                <td>${day}.${month} ${year}</td>
                <td>${item.phoneNumber}</td>
                <td>${item.address}</td>
                <td>
                     <button type="button" onclick="getUserEdit(event)">Edit</button>
                </td>
          </tr>`
}

// function postDataFromAPI() {
//     var modelObj = {
//         // id:$("#color_id").val(),
//         name:$("#color_name").val(),
//         price:$("#color_price").val(),
//         code:$("#color_code").val()
//     };
//
//     console.log("post data:"+modelObj);
//
//     $ajax({
//         type:"POST",
//         url:"postdata",
//         headers: {
//             "Content-Type":"application/json",
//             "Accept":"application/json"
//         },
//         data:JSON.stringify(modelObj),
//         success:function (data) {
//             console.log("POST API RESPONSE::"+data);
//         },
//         error:function (jqXHR,textStatus,errorThrown) {
//         }
//     });
// }
//
