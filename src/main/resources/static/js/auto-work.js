const url = '/cars/search/';
const headers = {
    "Content-Type":"application/json",
    "Accept":"application/json"
};
let queryData = {
    takeSize : 5,
    takeNumber : 0,
    model: '',
    color : '',
    carcass : '',
    engine : '',
    getQuery : function() {
        return url + '?takeSize=' + this.takeSize +
        '&takeNumber=' + this.takeNumber +
        '&carcass=' + this.carcass +
        '&color=' + this.color +
        '&model=' + this.model +
        '&engine=' + this.engine
    }
};

$(document).ready(() => {
    getFilters();
    getDataPaginate(queryData.getQuery());
    //getAuto();
    //  writeModelFilter();
});

const getFilters = () => {
    const oDataSelect = "/cars/getFilters";
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: headers,
        success: (data) => {
            renderFilters(data);
        }, error: (jqXHR,textStatus,errorThrown)=> {
        }
    });
};

const changeElemCount = (event) => {
    queryData.takeSize = event.target.value;
    queryData.takeNumber = 0;
    getDataPaginate(queryData.getQuery());
};

const setPage = (value) => {
    queryData.takeNumber  = +value;
    getDataPaginate(queryData.getQuery());
};

const renderPaginateControl = (data) => {
    let paginateControl = document.getElementById("pagination");
    let buttons = $('#pagination button');

    for(let button of buttons){
        let parent = button.parentNode;
        parent.removeChild(button);
    }

    for (let i=0; i<data.totalPage;i++) {
        const paginateButton = `<button type="button" onclick="setPage(${i})">${i+1}</button>`;
        paginateControl.insertAdjacentHTML('beforeEnd', paginateButton);
    }
};



const getAuto = () => {
    const oDataSelect = "/cars";
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: headers,
        success: (data) => {
            renderHTML(data.Autos);
            renderFilters(data);
         //   getFiltersAuto(elemModels,elemEngines,elemColors,elemCarcass);
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};

const setQuery = (selectElem) => {
    queryData[selectElem.id] = selectElem.value;
};

const changeFilter = (event) => {
    setQuery(event.target);
    getDataPaginate(queryData.getQuery());
};

const getDataPaginate = (query) => {
    $.ajax({
        url: query,
        type: "GET",
        headers: headers,
        success: (data) => {
            renderHTML(data.content);
            renderPaginateControl(data)
        }, error: (jqXHR, textStatus, errorThrown) => {
        }
    });
};

const getAutoById = (e) => {
    const elemId = e.currentTarget.parentElement.parentElement.id;
    const oDataSelect = `/cars/${elemId}`;
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: headers,
        success:function (data) {
            document.getElementById('car-container').style.display = 'block';
            const elements = $('#items').children();
            elements[0].innerHTML = data.engine.name;
            elements[1].innerHTML = data.engine.power;
            elements[2].innerHTML = data.engine.fuelConsumption;
            elements[3].innerHTML = data.model.name;
            elements[4].innerHTML = data.model.lenghtCarcass;
            elements[5].innerHTML = data.model.widthCarcass;
            elements[6].innerHTML = data.model.dictCarcass.name;
            elements[7].innerHTML = data.color.name;
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};

const renderFilters = (data) => {
    const elemModels = data.Models;
    const elemEngines = data.Engines;
    const elemColors = data.Colors;
    const elemCarcass = data.Carcass;
    let htmlModels ='';
    for (let el of elemModels) {
        htmlModels += createSelectForModels(el);
    }
    let tbodyModels = document.getElementById('model');
    tbodyModels.insertAdjacentHTML('afterbegin',htmlModels);

    let htmlEngines ='';
    for (let el of elemEngines) {
        htmlEngines+=createSelectForModels(el);
    }
    let tbodyEngines = document.getElementById('engine');
    tbodyEngines.insertAdjacentHTML('afterbegin',htmlEngines);

    let htmlColors ='';
    for (let el of elemColors) {
        htmlColors+=createSelectForModels(el);
    }
    let tbodyColors = document.getElementById('color');
    tbodyColors.insertAdjacentHTML('afterbegin',htmlColors);

    let htmlCarcass ='';
    for (let el of elemCarcass) {
        htmlCarcass+=createSelectForModels(el);
    }
    let tbodyCarcass = document.getElementById('carcass');
    tbodyCarcass.insertAdjacentHTML('afterbegin',htmlCarcass);
};

const createSelectForModels = (item)=> {
    return `<option value="${item.id}">${item.name}</option>`
};

const renderHTML = (items)=> {
    let html = '';
    for(let item of items) {
        html += createHTMLByElem(item);
    }
    let tbody = document.getElementById('table-body');

    while (tbody.firstChild) tbody.removeChild(tbody.firstChild);

    tbody.insertAdjacentHTML('afterbegin',html);
};

const createHTMLByElem = (item) =>{
    return `<tr id="${item.id}">
                <td>${item.model.name}</td>
                <td>${item.price}</td>
                <td>
                    <button type="button" onclick="getAutoById(event)">Подробнее</button>
                </td>
          </tr>`
};