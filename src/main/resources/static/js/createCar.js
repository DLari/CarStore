$(document).ready(() => {
    getModels();
    getEngines();
    getColors();
    getUserFio();
});

const headers = {
    "Content-Type":"application/json",
    "Accept":"application/json",
    'Authorization': `Bearer ${localStorage.getItem('token')}`
};
function createCar(){
    const presence = document.getElementById('presence').value;

    const model = document.getElementById('filter-models').value;
    const color = document.getElementById('filter-colors').value;
    const engine = document.getElementById('filter-engines').value;
    const data = JSON.stringify({
        presence: presence,
        model: {id:model} ,
        color: {id:color} ,
        engine: {id:engine}
    });
    const oDataSelect = `/admin/cars`;
    $.ajax({
        url:oDataSelect,
        type:"POST",
        headers: headers,
        data: data,
        success: function() {
            window.location.replace("http://localhost:8080/carsHtml");
        },
        error: function(jqXHR,textStatus,errorThrown) {
            for (let i =0; i<jqXHR.responseJSON.fieldErrors.length; i++) {

                if (jqXHR.responseJSON.fieldErrors[i].field === 'presence') {
                    document.getElementById("error_presence").innerHTML = jqXHR.responseJSON.fieldErrors[i].error;
                }
            }
        }
    });
}

const getEngines = () => {
    const oDataSelect = "/engines/forFilter";
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: headers,
        success: (data) => {
            renderFiltersEngine(data);
            //   getFiltersAuto(elemModels,elemEngines,elemColors,elemCarcass);
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};

const getColors = () => {
    const oDataSelect = "/colors/forFilter";
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: headers,
        success: (data) => {
            renderFiltersColors(data);
            //   getFiltersAuto(elemModels,elemEngines,elemColors,elemCarcass);
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};

const getModels = () => {
    const oDataSelect = "/models/forFilter";
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: headers,
        success: (data) => {
            renderFiltersModel(data);
            //   getFiltersAuto(elemModels,elemEngines,elemColors,elemCarcass);
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};

const renderFiltersModel = (data) => {
    const elemModels = data.Models;

    let htmlModels ='';
    for (let el of elemModels) {
        htmlModels += createSelectForModels(el);
    }
    let tbodyModels = document.getElementById('filter-models');
    tbodyModels.insertAdjacentHTML('afterbegin',htmlModels);

};

const renderFiltersEngine = (data) => {
    const elemModels = data.Engines;

    let htmlModels ='';
    for (let el of elemModels) {
        htmlModels += createSelectForModels(el);
    }
    let tbodyModels = document.getElementById('filter-engines');
    tbodyModels.insertAdjacentHTML('afterbegin',htmlModels);

};

const renderFiltersColors = (data) => {
    const elemModels = data.Colors;

    let htmlModels ='';
    for (let el of elemModels) {
        htmlModels += createSelectForModels(el);
    }
    let tbodyModels = document.getElementById('filter-colors');
    tbodyModels.insertAdjacentHTML('afterbegin',htmlModels);

};

const createSelectForModels = (item)=> {
    return `<option value="${item.id}">${item.name}</option>`
};
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
            if (data.rule !== 'admin') {
                window.location.replace("http://localhost:8080/accessError");
            }
            const elements = $('#fioItems').children();
            elements[0].innerHTML = data.fio;
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};
