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

const setPage = (value, event) => {
    let currentButton = event.target;

    for(let child of currentButton.parentElement.childNodes){
        if(child.className && child.className.includes('button-active')) {
            child.className = child.className.replace('button-active','');
        }
    }

    currentButton.className = 'button-active';
    queryData.takeNumber  = +value;
    getDataPaginate(queryData.getQuery());
};

const renderPaginateControl = (data) => {
    let activeButtonIndex = -1;
    let paginateControl = document.getElementById("pagination");

    let buttons = $('#pagination button');

    for(let index = 0; index<buttons.length; index++){
        if(buttons[index].className === 'button-active'){
            activeButtonIndex = index;
        }
    }

    for(let button of buttons){
        let parent = button.parentNode;
        parent.removeChild(button);
    }

    for (let i=0; i<data.totalPage;i++) {
        const paginateButton = `<button type="button" onclick="setPage(${i}, event)">${i+1}</button>`;
        paginateControl.insertAdjacentHTML('beforeEnd', paginateButton);
    }
    if(!data.totalPage) return;

    buttons = $('#pagination button');

    buttons[activeButtonIndex !== -1 ? activeButtonIndex: 0].className = 'button-active';
    buttons[activeButtonIndex !== -1 ? activeButtonIndex: 0].disabled = true;
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

const createOrder = (e) => {
    const elemId = e.currentTarget.parentElement.parentElement.id;
    const data = JSON.stringify({
        autoInStock: {id:elemId},
    });
    const oDataSelect = `/orders`;
    $.ajax({
        url:oDataSelect,
        type:"POST",
        headers:{
            "Content-Type":"application/json",
        "Accept":"application/json",
        'Authorization': `Bearer ${localStorage.getItem('token')}`
},
        data: data,
        success:function (data) {
            window.location.replace("http://localhost:8080/basket");
        },   error: function() {
            alert("Необходима авторизация!");
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

// <button type="button" onclick="getAutoById(event)">Подробнее</button>
const createHTMLByElem = (item) =>{
    let modelId = item.model.id;
    return `<tr id="${item.id}">
                <td>${item.model.name}</td>
                  <td>${item.price}</td>
                <td>${item.engine.name}</td>
                <td>${item.engine.power}</td>
                <td>${item.engine.fuelConsumption}</td>
                <td>${item.model.name}</td>
                <td>${item.model.lenghtCarcass}</td>
                <td>${item.model.widthCarcass}</td>
                <td>${item.model.dictCarcass.name}</td>
                <td>${item.color.name}</td>
                <td><div style="height: 120px">
    <img src="/images/${modelId}"  style="height: 100%" />
</div></td>
                <td>
                    <button type="button" onclick="createOrder(event)">Добавить в корзину</button>
                </td>
          </tr>`
};