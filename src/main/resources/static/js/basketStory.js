$(document).ready(() => {
    getOrder();
});


const getOrder = () => {
    const oDataSelect = `/orders/mineDeliveredPaid`;
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: headers,
        success: (data) => {
            if (data!== '') {
                renderHTML(data);
            }
            // else {
            //     document.getElementById('orderEmpty').style.display = 'block';
            //     document.getElementById('orderNotEmpty').style.display = 'block';
            // }
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};
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

function createHTMLByElem(item) {
    let dateOfBirth = new Date (item.dateOfPayment);
    let year = dateOfBirth.getFullYear();
    let month = dateOfBirth.getMonth();
    let day = dateOfBirth.getDay();
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
                <td>${day}.${month} ${year}</td>
                <td>${item.price}</td>
                <td> 
                </td>
          </tr>`
}
