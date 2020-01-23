$(document).ready(() => {
    getCarcass();
});

const getCarcass = () => {
    const oDataSelect = "/carcass";
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
const openEditCarcassModal = () => {

};

const getCarcassById = (e) => {
    const elemId = e.currentTarget.parentElement.parentElement.id;
    const oDataSelect = `/carcass/${elemId}`;
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: {
            "Content-Type":"application/json",
            "Accept":"application/json"
        },
        success:function (data) {
            var elements = $('#carcassItems').children();
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
    let tbody = document.getElementById('carcass-table');
    tbody.insertAdjacentHTML('afterbegin',html);
}

function createHTMLByElem(item) {
    return `<tr id="${item.id}">
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>
                    <button type="button" onclick="getCarcassById(event)">Edit</button>
                    <button type="button" onclick="deleteCarcassById(event)">Delete</button>
                </td>
          </tr>`
}