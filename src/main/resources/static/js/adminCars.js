// const headers = {
//     "Content-Type":"application/json",
//     "Accept":"application/json",
//     'Authorization': `Bearer ${localStorage.getItem('token')}`
// };
let orders = [];

$(document).ready(() => {
    getCars();
    getUserFio();
});

const getCars = () => {
    const oDataSelect = "/cars/all";
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: headers,
        success: (data) => {
            renderHTML(data);
            orders = data;
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};
const openEditEnginesModal = () => {

};

const getCarsById = (e) => {
    const elemId = e.currentTarget.parentElement.parentElement.id;
    const oDataSelect = `/cars/${elemId}`;
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: headers,
        success:function (data) {
            openEditCarModel(data);
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};
const openEditCarModel = (data) => {

    document.getElementById('edit-container').style.display = 'block';

    let inputId = document.getElementById('input-id');
    inputId.value = data.id;

    let inputIdModel = document.getElementById('input-idmodel');
    inputIdModel.value = data.model.id;

    let inputColor = document.getElementById('input-idcolor');
    inputColor.value = data.color.id;

    let inputEngine = document.getElementById('input-idengine');
    inputEngine.value = data.engine.id;

    let inputPresencee = document.getElementById('presence');
    inputPresencee.value = data.presence;

    let modelId = data.model.id;
    let autoId = data.id;

    let html = `<input type="file" class="file" name="file" type="hidden"/>
        <button type="button" id="but_upload"  onclick="uploadImage(event,${modelId},${autoId})">Загрузить изображение</button> 
        <span id="imageDownolad"></span>`;
    let tbody = document.getElementById('image');
    tbody.insertAdjacentHTML('afterbegin',html);


};

const deleteCarById = (e)=>{
    const id = e.currentTarget.parentElement.parentElement.id;
    const oDataSelect = `/admin/cars/${id}`;
    $.ajax({
        url:oDataSelect,
        type:"DELETE",
        headers: headers,
        success: function() {
            window.location.replace("http://localhost:8080/carsHtml");
        },
        error: function() {
            alert("Failed");
        }
    });
};

function renderHTML(CarsItems) {
    let html = '';
    for(let item of CarsItems) {
        html += createHTMLByElem(item);
    }
    let tbody = document.getElementById('cars-table-body');
    tbody.insertAdjacentHTML('afterbegin',html);
}

function createHTMLByElem(CarsItems) {
    return `<tr id="${CarsItems.id}">
                <td>${CarsItems.id}</td>
                <td>${CarsItems.price}</td>
                <td>${CarsItems.engine.name}</td>
                <td>${CarsItems.engine.power}</td>
                <td>${CarsItems.engine.fuelConsumption}</td>
                <td>${CarsItems.model.name}</td>
                <td>${CarsItems.model.lenghtCarcass}</td>
                <td>${CarsItems.model.widthCarcass}</td>
                <td>${CarsItems.model.dictCarcass.name}</td>
                <td>${CarsItems.color.name}</td>
                <td>${CarsItems.presence}</td>
                <td>
                    <button type="button" onclick="getCarsById(event)">Edit</button>
                    <button type="button" onclick="deleteCarById(event)">Delete</button>              
                </td>
          </tr>`
}


const uploadImage = (event,inputIdModel,autoId) => {


        const inputContainer = $(`input[type=file]`);
        let fd = new FormData();
        let files = inputContainer[0].files[0];
        fd.append('file',files);
    fd.append('modelId', inputIdModel);
        $.ajax({
            url: '/admin/images/upload',
            type: 'POST',
            headers:   {'Authorization': `Bearer ${localStorage.getItem('token')}`},
            //requestHeaders
            data: fd,
            contentType: false,
            processData: false,
            success: function() {
                let htmlImageDownoladSpan = 'изображение загружено';
                let body = document.getElementById('imageDownolad');
                body.insertAdjacentHTML('afterbegin',htmlImageDownoladSpan);
            },
        });
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
            if (data.role !== 'admin') {
                window.location.replace("http://localhost:8080/accessError");
            }
            const elements = $('#fioItems').children();
            elements[0].innerHTML = data.fio;
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};
