$(document).ready(() => {
    getColors();
        getEngines();
});

const getColors = () => {
    const oDataSelect = "/colors";
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
const openEditColorModal = () => {

};

const getColorById = (e) => {
    const elemId = e.currentTarget.parentElement.parentElement.id;
    const oDataSelect = `/colors/${elemId}`;
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: {
            "Content-Type":"application/json",
            "Accept":"application/json"
        },
        success:function (data) {
            var elements = $('#items').children();
            elements[0].innerHTML = data.id;
            elements[1].innerHTML = data.name;
            elements[2].innerHTML = data.price;
            elements[3].innerHTML = data.colorCode;
            console.log(data);
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};


const deleteColorById = ()=>{};

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

