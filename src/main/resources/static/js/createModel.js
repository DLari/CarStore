$(document).ready(() => {
    getCarcass();
});

const headers = {
    "Content-Type":"application/json",
    "Accept":"application/json",
    'Authorization': `Bearer ${localStorage.getItem('token')}`
};
function createModel(){
    const carcass = document.getElementById('filter-carcass').value;
    const name = document.getElementById('name').value;
    const price = document.getElementById('price').value;
    const widthCarcass = document.getElementById('width').value;
    const lenghtCarcass = document.getElementById('length').value;
    const data = JSON.stringify({
        name: name,
        price: price,
        dictCarcass: {id:carcass} ,
        widthCarcass: widthCarcass,
        lenghtCarcass:lenghtCarcass
    });
    const oDataSelect = `/admin/models`;
    $.ajax({
        url:oDataSelect,
        type:"POST",
        headers: headers,
        data: data,
        success: function() {
            window.location.replace("http://localhost:8080/modelsHtml");
        },
        error: function() {
            alert("Failed");
        }
    });
}

const getCarcass = () => {
    const oDataSelect = "/carcass";
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: headers,
        success: (data) => {
            renderFilters(data);
            //   getFiltersAuto(elemModels,elemEngines,elemColors,elemCarcass);
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};
const renderFilters = (data) => {
    const elemModels = data;

    let htmlModels ='';
    for (let el of elemModels) {
        htmlModels += createSelectForModels(el);
    }
    let tbodyModels = document.getElementById('filter-carcass');
    tbodyModels.insertAdjacentHTML('afterbegin',htmlModels);

};

const createSelectForModels = (item)=> {
    return `<option value="${item.id}">${item.name}</option>`
};
