const headers = {
    "Content-Type":"application/json",
    "Accept":"application/json",
    'Authorization': `Bearer ${localStorage.getItem('token')}`
};
$(document).ready(() => {
    getModels();
    getUserFio();
});

const getModels = () => {
    const oDataSelect = "/models";
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
const openEditModelsModal = () => {

};

const getModelsById = (e) => {
    const elemId = e.currentTarget.parentElement.parentElement.id;
    const oDataSelect = `/models/${elemId}`;
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: headers,
        success:function (data) {
            // var elements = $('#modelsItems').children();
            // elements[0].innerHTML = data.id;
            // elements[1].innerHTML = data.name;
            // elements[2].innerHTML = data.lenghtCarcass;
            // elements[3].innerHTML = data.widthCarcass;
            // console.log(data);
            openEditModelsModel(data);
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};
const openEditModelsModel = (data) => {

    document.getElementById('edit-container').style.display = 'block';

    let inputId = document.getElementById('input-id');
    inputId.value = data.id;

    let inputIdCarcass = document.getElementById('input-idcarcass');
    inputIdCarcass.value = data.dictCarcass.id;

    let inputName = document.getElementById('name');
    inputName.value = data.name;

    let inputPrice = document.getElementById('price');
    inputPrice.value = data.price;

    let inputFuelConsumption = document.getElementById('width_carcass');
    inputFuelConsumption.value = data.widthCarcass;

    let inputLengthCarcass = document.getElementById('length_carcass');
    inputLengthCarcass.value = data.lenghtCarcass;

};


const deleteModelsById = (e)=>{
    const id = e.currentTarget.parentElement.parentElement.id;
    const oDataSelect = `/admin/models/${id}`;
    $.ajax({
        url:oDataSelect,
        type:"DELETE",
        headers: headers,
        success: function() {
            window.location.replace("http://localhost:8080/modelsHtml");
        },
        error: function() {
            alert("Failed");
        }
    });
};

function renderHTML(modelsItems) {
    let html = '';
    for(let item of modelsItems) {
        html += createHTMLByElem(item);
    }
    let tbody = document.getElementById('models-table');
    tbody.insertAdjacentHTML('afterbegin',html);
}

function createHTMLByElem(modelsItem) {
    return `<tr id="${modelsItem.id}">
                <td>${modelsItem.id}</td>
                <td>${modelsItem.name}</td>
                 <td>${modelsItem.price}</td>
                <td>${modelsItem.lenghtCarcass}</td>
                <td>${modelsItem.widthCarcass}</td>
                <td>
                    <button type="button" onclick="getModelsById(event)">Edit</button>
                    <button type="button" onclick="deleteModelsById(event)">Delete</button>
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
