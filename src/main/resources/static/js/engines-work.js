$(document).ready(() => {
    getEngines();
});

const getEngines = () => {
    const oDataSelect = "/engines";
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: {
            "Content-Type":"application/json",
            "Accept":"application/json"
        },
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
        headers: {
            "Content-Type":"application/json",
            "Accept":"application/json",
            'Authorization': `Bearer ${localStorage.getItem('token')}`
        },
        success:function (data) {
            var elements = $('#enginesItems').children();
            elements[0].innerHTML = data.id;
            elements[1].innerHTML = data.name;
            elements[2].innerHTML = data.price;
            elements[3].innerHTML = data.power;
            elements[4].innerHTML = data.fuelConsumption;
            console.log(data);
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};


const deleteEnginesById = ()=>{};

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