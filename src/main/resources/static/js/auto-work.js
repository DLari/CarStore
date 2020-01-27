
let query = '/cars/search/?takeSize=100&takeNumber=0';
const headers = {
    "Content-Type":"application/json",
    "Accept":"application/json"
};
$(document).ready(() => {
    if (localStorage.getItem('token')) {
        document.getElementById('login-container').style.display = 'none';
        document.getElementById('logout-container').style.display = 'block';
    }
    getAuto();
   // getUserFio();
    //  writeModelFilter();
});

// const getUserFio = () => {
//     const oDataSelect = "/user/mine";
//     $.ajax({
//         url:oDataSelect,
//         type:"GET",
//         headers: {
//         "Content-Type":"application/json",
//             "Accept":"application/json",
//             'Authorization': `Bearer ${localStorage.getItem('token')}`
//     },
//         success: (data) => {
//           return  `h1 id="fio" ${data.fio}`;
//         }, error:function (jqXHR,textStatus,errorThrown) {
//         }
//     });
// };

function logOut(){
    localStorage.setItem('token','');

    window.location.replace("http://localhost:8080/index");
}

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

const createQuery = (selectElem) => {
    const selectId = selectElem.id.split('filter-')[1];
    const value =  selectElem.value;

    let queryArray = query.split('&');
    const usedFilterIndex = queryArray.findIndex(item=>item.includes(selectId));

    if(usedFilterIndex !== -1){
        queryArray.splice(usedFilterIndex,1);
    }
    if(value) queryArray.push(`${selectId}=${value}`);

    query = queryArray.join('&');
};

const changeFilter = (event) => {

    createQuery(event.target);

    $.ajax({
        url: query,
        type: "GET",
        headers: headers,
        success: (data) => {
          renderHTML(data.content);
        }, error: (jqXHR, textStatus, errorThrown) => {
        }
    });
};


const openEditAutoModal = () => {
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
    let tbodyModels = document.getElementById('filter-model');
    tbodyModels.insertAdjacentHTML('afterbegin',htmlModels);

    let htmlEngines ='';
    for (let el of elemEngines) {
        htmlEngines+=createSelectForModels(el);
    }
    let tbodyEngines = document.getElementById('filter-engine');
    tbodyEngines.insertAdjacentHTML('afterbegin',htmlEngines);

    let htmlColors ='';
    for (let el of elemColors) {
        htmlColors+=createSelectForModels(el);
    }
    let tbodyColors = document.getElementById('filter-color');
    tbodyColors.insertAdjacentHTML('afterbegin',htmlColors);

    let htmlCarcass ='';
    for (let el of elemCarcass) {
        htmlCarcass+=createSelectForModels(el);
    }
    let tbodyCarcass = document.getElementById('filter-carcass');
    tbodyCarcass.insertAdjacentHTML('afterbegin',htmlCarcass);
};

const createSelectForModels = (item)=> {
    return `<option value="${item.id}">${item.name}</option>`
};

const deletAutoById = ()=>{};

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