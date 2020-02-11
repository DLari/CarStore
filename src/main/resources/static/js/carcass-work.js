const headers = {
    "Content-Type":"application/json",
    "Accept":"application/json",
    'Authorization': `Bearer ${localStorage.getItem('token')}`
};
$(document).ready(() => {
    getCarcass();
    getUserFio();
});

const getCarcass = () => {
    const oDataSelect = "/carcass";
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
    const oDataSelect = `/carcass/${elemId}`;
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: headers,
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
                </td>
          </tr>`
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
            if (data.role !== 'admin') {
                window.location.replace("http://localhost:8080/accessError");
            }
            const elements = $('#fioItems').children();
            elements[0].innerHTML = data.fio;
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};
