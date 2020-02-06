let orders = [];

$(document).ready(() => {
    getOrder();
});

const getOrder = () => {
    const oDataSelect = `/orders/mineBasket`;
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: headers,
        success: (data) => {
            if (data!== '') {
                renderHTML(data);
                orders = data;
                let totalPrice = 0;
                for (let i=0; i<data.length; i++)
                    totalPrice = totalPrice + data[i].price;
                document.getElementById("order_price").innerHTML = totalPrice;
            }
            // else {
            //     document.getElementById('orderEmpty').style.display = 'block';
            //     document.getElementById('orderNotEmpty').style.display = 'block';
            // }
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};
const openEditColorModal = () => {

};

const DeleteFromBasket = (e)=>{
    const orderId = +e.currentTarget.parentElement.parentElement.id;
    let order = orders.find(item=>item.id===orderId);
    const userId = order.users.id;
    const autoId = order.autoInStock.id;
    const oDataSelect = `/orders/${userId}/${autoId}`;
    $.ajax({
        url:oDataSelect,
        type:"DELETE",
        headers: headers,
        success: function() {
            window.location.replace("http://localhost:8080/basket");
        },
        error: function() {
            alert("Failed");
        }
    });
};

const toConfirmed = (e)=>{
    //const id = e.currentTarget.parentElement.parentElement.id;
    const oDataSelect = `/orders/confirmed`;
    $.ajax({
        url:oDataSelect,
        type:"PUT",
        headers: headers,
        success: function() {
            window.location.replace("http://localhost:8080/basket");
        },
        error: function() {
            alert("Failed");
        }
    });
};
const toPaid = (e)=>{
    //const id = e.currentTarget.parentElement.parentElement.id;
    const oDataSelect = `/orders/paid`;
    $.ajax({
        url:oDataSelect,
        type:"PUT",
        headers: headers,
        success: function() {
            window.location.replace("http://localhost:8080/basket");
        },
        error: function() {
            alert("Failed");
        }
    });
};
const toDelivered = (e)=>{
    //const id = e.currentTarget.parentElement.parentElement.id;
    const oDataSelect = `/orders/delivered`;
    $.ajax({
        url:oDataSelect,
        type:"PUT",
        headers: headers,
        success: function() {
            window.location.replace("http://localhost:8080/basket");
        },
        error: function() {
            alert("Failed");
        }
    });
};

// const getUserEdit = (e) => {
//     const oDataSelect = `/users/mine`;
//     $.ajax({
//         url:oDataSelect,
//         type:"GET",
//         headers: headers,
//         success:function (data) {
//             openEditUserModel(data);
//         }, error:function (jqXHR,textStatus,errorThrown) {
//         }
//     });
// };

// const openEditUserModel = (data) => {
//
//     document.getElementById('edit-container').style.display = 'block';
//
//     let inputId = document.getElementById('input-id');
//     inputId.value = data.id;
//
//     // let inputRole = document.getElementById('role');
//     // inputRole.value = data.rule;
//
//     let inputFio = document.getElementById('fio');
//     inputFio.value = data.fio;
//
//     let inputDateOfBirth = document.getElementById('date_of_birth');
//     inputDateOfBirth.value = data.dateOfBirth;
//
//     let inputPhoneNumber = document.getElementById('phone_number');
//     inputPhoneNumber.value = data.phoneNumber;
//
//     let inputAddress = document.getElementById('address');
//     inputAddress.value = data.address;
//
//     let inputLogin = document.getElementById('login');
//     inputLogin.value = data.login;
//
//     let inputPassword = document.getElementById('password');
//     inputPassword.value = data.password;
//
// };


function renderHTML(items) {
    document.getElementById('orderEmpty').style.display = 'none';
    document.getElementById('orderNotEmpty').style.display = 'block';
    let html = '';
    for(let item of items) {
        html += createHTMLByElem(item);
    }
    let tbody = document.getElementById('table-body');
    tbody.insertAdjacentHTML('afterbegin',html);
}

// <button type="button" onclick="get(event)">Edit</button>
//     <button type="button" onclick="deleteOrder(event)">Отменить заказ</button>
// <button type="button" onclick="toConfirmed(event)">Зазаз подтвержден</button>
// <button type="button" onclick="toPaid(event)">Зазаз оплачен</button>
// <button type="button" onclick="toDelivered(event)">Зазаз доставлен</button>
function createHTMLByElem(item) {
    return `<tr id="${item.id}">   
               <td>${item.users.fio}</td>
               <td>${item.users.address}</td>
                <td>${item.dictOrderStatus.name}</td>
                <td>${item.autoInStock.model.name}</td>          
                <td>${item.autoInStock.model.dictCarcass.name}</td>              
                <td>${item.autoInStock.model.lenghtCarcass}</td>
                <td>${item.autoInStock.model.widthCarcass}</td>
                <td>${item.autoInStock.engine.name}</td>          
                <td>${item.autoInStock.engine.power}</td>
                <td>${item.autoInStock.engine.fuelConsumption}</td>
                <td>${item.autoInStock.color.name}</td>
                <td>${item.orderNumber}</td>
                <td>${item.price}</td>
                <td>
                     <button type="button" onclick="DeleteFromBasket(event)">Удалить из корзины</button>
                </td>
          </tr>`
}
