const headers = {
    "Content-Type":"application/json",
    "Accept":"application/json",
    'Authorization': `Bearer ${localStorage.getItem('token')}`
};
$(document).ready(() => {
    getEngines();
    getUserFio();
});

const getEngines = () => {
    const oDataSelect = "/engines";
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
const openEditEnginesModal = () => {

};

const getEnginesById = (e) => {
    const elemId = e.currentTarget.parentElement.parentElement.id;
    const oDataSelect = `/engines/${elemId}`;
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: headers,
        success:function (data) {
            // var elements = $('#enginesItems').children();
            // elements[0].innerHTML = data.id;
            // elements[1].innerHTML = data.name;
            // elements[2].innerHTML = data.price;
            // elements[3].innerHTML = data.power;
            // elements[4].innerHTML = data.fuelConsumption;
            // console.log(data);
            openEditEngineModel(data);
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};
const openEditEngineModel = (data) => {

    document.getElementById('edit-container').style.display = 'block';

    let inputId = document.getElementById('input-id');
    inputId.value = data.id;

    let inputIdCarcass = document.getElementById('input-idmodel');
    inputIdCarcass.value = data.model.id;

    let inputName = document.getElementById('name');
    inputName.value = data.name;

    let inputPrice = document.getElementById('price');
    inputPrice.value = data.price;

    let inputFuelConsumption = document.getElementById('fuel_consumption');
    inputFuelConsumption.value = data.fuelConsumption;

    let inputPower = document.getElementById('power');
    inputPower.value = data.power;

};

const deleteEnginesById = (e)=>{
    const id = e.currentTarget.parentElement.parentElement.id;
    const oDataSelect = `/admin/engines/${id}`;
    $.ajax({
        url:oDataSelect,
        type:"DELETE",
        headers: headers,
        success: function() {
            window.location.replace("http://localhost:8080/enginesHtml");
        },
        error: function() {
            alert("Failed");
        }
    });
};

function renderHTML(enginesItems) {
    let html = '';
    for(let item of enginesItems) {
        html += createHTMLByElem(item);
    }
    let tbody = document.getElementById('engines-table-body');
    tbody.insertAdjacentHTML('afterbegin',html);
}

function createHTMLByElem(enginesItems) {
    return `<tr id="${enginesItems.id}">
                <td>${enginesItems.id}</td>
                <td>${enginesItems.name}</td>
                <td>${enginesItems.price}</td>
                <td>${enginesItems.power}</td>
                  <td>${enginesItems.fuelConsumption}</td>
                <td>
                    <button type="button" onclick="getEnginesById(event)">Edit</button>
                    <button type="button" onclick="deleteEnginesById(event)">Delete</button>
                </td>
          </tr>`
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
            if (data.role !== 'admin') {
                window.location.replace("http://localhost:8080/accessError");
            }
            const elements = $('#fioItems').children();
            elements[0].innerHTML = data.fio;
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};
