$(document).ready(() => {
    getModels();
    getUserFio();
});

const headers = {
    "Content-Type":"application/json",
    "Accept":"application/json",
    'Authorization': `Bearer ${localStorage.getItem('token')}`
};
function createEngine(){
    const name = document.getElementById('name').value;
    const price = document.getElementById('price').value;
    const model = document.getElementById('filter-models').value;
    const fuelConsumption = document.getElementById('fuel_consumption').value;
    const power = document.getElementById('power').value;
    let data;
    if (model === '') {
         data = JSON.stringify({
            name: name,
            price: price,
            fuelConsumption: fuelConsumption,
            power:power
        });
    } else {
         data = JSON.stringify({
            name: name,
            price: price,
            model: {id: model},
            fuelConsumption: fuelConsumption,
            power: power
        });
    }
    const oDataSelect = `/admin/engines`;
    $.ajax({
        url:oDataSelect,
        type:"POST",
        headers: headers,
        data: data,
        success: function() {
            window.location.replace("http://localhost:8080/enginesHtml");
        },
        error: function(jqXHR,textStatus,errorThrown,data) {
            for (let i =0; i<jqXHR.responseJSON.fieldErrors.length; i++) {

                if (jqXHR.responseJSON.fieldErrors[i].field === 'name') {
                    document.getElementById("errorName").innerHTML = jqXHR.responseJSON.fieldErrors[i].error;
                }
                if (jqXHR.responseJSON.fieldErrors[i].field === 'price') {
                    document.getElementById("errorPrice").innerHTML = jqXHR.responseJSON.fieldErrors[i].error;
                }
                if (jqXHR.responseJSON.fieldErrors[i].field === 'fuelConsumption') {
                    document.getElementById("error_fuel_consumption").innerHTML = jqXHR.responseJSON.fieldErrors[i].error;
                }
                if (jqXHR.responseJSON.fieldErrors[i].field === 'power') {
                    document.getElementById("error_power").innerHTML = jqXHR.responseJSON.fieldErrors[i].error;
                }
                if (jqXHR.responseJSON.fieldErrors[i].field === 'model') {
                    document.getElementById("error_model").innerHTML = jqXHR.responseJSON.fieldErrors[i].error;
                }
            }
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
