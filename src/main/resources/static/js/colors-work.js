
$(document).ready(() => {
    getColors();
    getUserFio();
});

let currentEditColor;
const getColors = () => {
    const oDataSelect = "/colors";
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
const openEditColorModal = () => {

};

const getColorById = (e) => {
    const elemId = e.currentTarget.parentElement.parentElement.id;
    const oDataSelect = `/colors/${elemId}`;
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: headers,
        success:function (data) {
          //  document.getElementById('demo-container').style.display = 'block';
            // var elements = $('#items').children();
            // elements[0].innerHTML = data.id;
            // elements[1].innerHTML = data.name;
            // elements[2].innerHTML = data.price;
            // elements[3].innerHTML = data.colorCode;
            openEditColorModel(data);


        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};

const openEditColorModel = (data) => {

    document.getElementById('edit-container').style.display = 'block';

    let inputId = document.getElementById('input-id');
    inputId.value = data.id;

    let inputName = document.getElementById('name');
    inputName.value = data.name;

    let inputPrice = document.getElementById('price');
    inputPrice.value = data.price;

    let inputColorCode = document.getElementById('color_code');
    inputColorCode.value = data.colorCode;

};

const deleteColorById = (e)=>{
    const id = e.currentTarget.parentElement.parentElement.id;
    const oDataSelect = `/admin/colors/${id}`;
    $.ajax({
        url:oDataSelect,
        type:"DELETE",
        headers: headers,
        success: function() {
            window.location.replace("http://localhost:8080/colorsHtml");
        },
        error: function() {
            alert("Failed");
        }
    });
};

function renderHTML(items) {
    let html = '';
    for(let item of items) {
        html += createHTMLByElem(item);
    }
    let tbody = document.getElementById('table-body');
    tbody.insertAdjacentHTML('afterbegin',html);
}

function createHTMLByElem(item) {
   return `<tr id="${item.id}">
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.price}</td>
                <td>${item.colorCode}</td>
                <td>
                     <button type="button" onclick="getColorById(event)">Edit</button>
                    <button type="button" onclick="deleteColorById(event)">Delete</button>
                </td>
          </tr>`
}

function postDataFromAPI() {
    var modelObj = {
        // id:$("#color_id").val(),
        name:$("#color_name").val(),
        price:$("#color_price").val(),
        code:$("#color_code").val()
    };

    console.log("post data:"+modelObj);

    $ajax({
        type:"POST",
        url:"postdata",
        headers: {
            "Content-Type":"application/json",
            "Accept":"application/json"
        },
        data:JSON.stringify(modelObj),
        success:function (data) {
            console.log("POST API RESPONSE::"+data);
        },
        error:function (jqXHR,textStatus,errorThrown) {
        }
    });
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
            if (data.rule !== 'admin') {
                window.location.replace("http://localhost:8080/accessError");
            }
            const elements = $('#fioItems').children();
            elements[0].innerHTML = data.fio;
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};

