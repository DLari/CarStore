const headers = {
    "Content-Type":"application/json",
    "Accept":"application/json",
    'Authorization': `Bearer ${localStorage.getItem('token')}`
};
$(document).ready(() => {
    getCars();
});

const getCars = () => {
    const oDataSelect = "/cars/search?takeNumber=0&takeSize=100";
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
const openEditCarcassModal = () => {

};

const getCarcassById = (e) => {
    const elemId = e.currentTarget.parentElement.parentElement.id;
    const oDataSelect = `/cars/${elemId}`;
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: headers,
        success:function (data) {
            var elements = $('#carsItems').children();
            elements[0].innerHTML = data.id;
            elements[1].innerHTML = data.name;
            console.log(data);
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};


const deleteCarcassById = ()=>{};

function renderHTML(carcassItems) {
    let html = '';
    for(let item of carcassItems) {
        html += createHTMLByElem(item);
    }
    let tbody = document.getElementById('cars-table');
    tbody.insertAdjacentHTML('afterbegin',html);
}

function createHTMLByElem(item) {
    return `<tr id="${item.id}">
                <td>${item.id}</td>
                <td>${item.name}</td>
                 <td>${item.engine.name}</td>
                <td>${item.engine.power}</td>
                 <td>${item.engine.fuel_consumption}</td>
                <td>${item.models.name}</td>
                 <td>${item.model.lenghtCarcass}</td>
                <td>${item.model.widthCarcass}</td>
                 <td>${item.model.dictCarcass.name}</td>
                <td>${item.color.name}</td>
                <td>
                    <button type="button" onclick="getCarsById(event)">Edit</button>
                    <button type="button" onclick="deleteCarsById(event)">Delete</button>
                </td>
          </tr>`
}