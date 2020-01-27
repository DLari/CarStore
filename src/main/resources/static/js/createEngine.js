$(document).ready(() => {
    getModels();
});

const headers = {
    "Content-Type":"application/json",
    "Accept":"application/json",
    'Authorization': `Bearer ${localStorage.getItem('token')}`
};
function createEngine(){
    const name = document.getElementById('name').value;
    const price = document.getElementById('price').value;
    //const model = document.getElementById('model_id').value;
    const model = document.getElementById('filter-models').value;
    const fuelConsumption = document.getElementById('fuel_consumption').value;
    const power = document.getElementById('power').value;
    const data = JSON.stringify({
        name: name,
        price: price,
        model: {id:model} ,
        fuelConsumption: fuelConsumption,
        power:power
    });
    const oDataSelect = `/admin/engines`;
    $.ajax({
        url:oDataSelect,
        type:"POST",
        headers: headers,
        data: data,
        success: function() {
            window.location.replace("http://localhost:8080/enginesHtml");
        },
        error: function() {
            alert("Failed");
        }
    });
}

const getModels = () => {
    const oDataSelect = "/models/forFilter";
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: headers,
        success: (data) => {
            renderFilters(data);
            //   getFiltersAuto(elemModels,elemEngines,elemColors,elemCarcass);
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};
const renderFilters = (data) => {
    const elemModels = data.Models;

    let htmlModels ='';
    for (let el of elemModels) {
        htmlModels += createSelectForModels(el);
    }
    let tbodyModels = document.getElementById('filter-models');
    tbodyModels.insertAdjacentHTML('afterbegin',htmlModels);

};

const createSelectForModels = (item)=> {
    return `<option value="${item.id}">${item.name}</option>`
};

// const changeFilter = (event) => {
//     $.ajax({
//         url: query,
//         type: "GET",
//         headers: headers,
//         success: (data) => {
//             renderHTML(data.content);
//         }, error: (jqXHR, textStatus, errorThrown) => {
//         }
//     });
// };
