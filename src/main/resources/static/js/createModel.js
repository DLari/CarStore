$(document).ready(() => {
    getCarcass();
    getUserFio();
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
    let data;
    if (carcass === '') {
        data = JSON.stringify({
            name: name,
            price: price,
            widthCarcass: widthCarcass,
            lenghtCarcass:lenghtCarcass
        });
    } else {
        data = JSON.stringify({
            name: name,
            price: price,
            dictCarcass: {id: carcass},
            widthCarcass: widthCarcass,
            lenghtCarcass: lenghtCarcass
        });
    }
    const oDataSelect = `/admin/models`;
    $.ajax({
        url:oDataSelect,
        type:"POST",
        headers: headers,
        data: data,
        success: function() {
            window.location.replace("http://localhost:8080/modelsHtml");
        },
        error: function(jqXHR,textStatus,errorThrown,data) {
            for (let i =0; i<jqXHR.responseJSON.fieldErrors.length; i++) {

                if (jqXHR.responseJSON.fieldErrors[i].field === 'name') {
                    document.getElementById("error_name").innerHTML = jqXHR.responseJSON.fieldErrors[i].error;
                }
                if (jqXHR.responseJSON.fieldErrors[i].field === 'dictCarcass') {
                    document.getElementById("error_carcass").innerHTML = jqXHR.responseJSON.fieldErrors[i].error;
                }
                if (jqXHR.responseJSON.fieldErrors[i].field === 'price') {
                    document.getElementById("error_price").innerHTML = jqXHR.responseJSON.fieldErrors[i].error;
                }
                if (jqXHR.responseJSON.fieldErrors[i].field === 'widthCarcass') {
                    document.getElementById("error_width").innerHTML = jqXHR.responseJSON.fieldErrors[i].error;
                }
                if (jqXHR.responseJSON.fieldErrors[i].field === 'lenghtCarcass') {
                    document.getElementById("error_length").innerHTML = jqXHR.responseJSON.fieldErrors[i].error;
                }
            }
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
