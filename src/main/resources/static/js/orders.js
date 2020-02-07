let orders = [];

$(document).ready(() => {
    getOrders();
});

const getOrders = () => {
    const oDataSelect = "/admin/orders";
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: headers,
        success: (data) => {
            orders = data;
            renderHTML(data);
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};
function renderHTML(items) {
    let html = '';
    for(let item of items) {
        html += createHTMLByElem(item);
    }
    let tbody = document.getElementById('table-body');
    tbody.insertAdjacentHTML('afterbegin',html);
}

function createHTMLByElem(item) {
    let dateOfBirthPayment = new Date (item.dateOfPayment);
    let yearPayment = dateOfBirthPayment.getFullYear();
    let monthPayment = dateOfBirthPayment.getMonth();
    let dayPayment = dateOfBirthPayment.getDay();

    let dateOfBirth = new Date (item.date);
    let year = dateOfBirth.getFullYear();
    let month = dateOfBirth.getMonth();
    let day = dateOfBirth.getDay();
    return `<tr id="${item.id}">
                <td>${item.id}</td>
                <td>${item.autoInStock.color.name}</td>
                <td>${item.autoInStock.engine.name}</td>
                <td>${item.autoInStock.engine.power}</td>
                <td>${item.autoInStock.engine.fuelConsumption}</td>
                <td>${item.autoInStock.model.name}</td>
                <td>${item.autoInStock.model.widthCarcass}</td>
                <td>${item.autoInStock.model.lenghtCarcass}</td>
                <td>${item.autoInStock.model.dictCarcass.name}</td>
                <td>${item.dictOrderStatus.name}</td>
                <td>${item.users.fio}</td>
                <td>${item.users.phoneNumber}</td>
                <td>${item.users.address}</td>
                <td>${day}.${month} ${year}</td>
                <td>${dayPayment}.${monthPayment} ${yearPayment}</td>
                <td>${item.orderNumber}</td>
                 <td>${item.autoInStock.presence}</td>
                 <td>${item.price}</td>
                <td><button type="button" onclick="editStatus(event)">Перевести в статус доставлено</button></td>
          </tr>`}

const editStatus = (e) => {
    const orderId = +e.currentTarget.parentElement.parentElement.id;
    let order = orders.find(item=>item.id===orderId);
    const userId = order.users.id;
    const autoId = order.autoInStock.id;
    const oDataSelect = `admin/orders/delivered/${userId}/${orderId}`;
    $.ajax({
        url:oDataSelect,
        type:"PUT",
        headers: headers,
        // data: data,
        success:function () {
            deleteAuto(autoId);
            window.location.replace("http://localhost:8080/orders");
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};
const deleteAuto = (autoId) => {
    const oDataSelect = `/admin/cars/${autoId}`;
    $.ajax({
        url:oDataSelect,
        type:"DELETE",
        headers: headers,
        // data: data,
        success:function () {
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};

