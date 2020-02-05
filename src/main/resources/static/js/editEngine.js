
const editEngine =() =>{
    const name = document.getElementById('name').value;
    const price = document.getElementById('price').value;
    const fuelConsumption = document.getElementById('fuel_consumption').value;
    const power = document.getElementById('power').value;
    const id = document.getElementById('input-id').value;
    const model = document.getElementById('input-idmodel').value;
    //const carcass = document.getElementById('filter-carcass').value;
    const data = JSON.stringify({
        name: name,
        price: price,
        model: {id:model} ,
        fuelConsumption: fuelConsumption,
        power:power
    });
    const oDataSelect = `/admin/engines/${id}`;
    $.ajax({
        url:oDataSelect,
        type:"PUT",
        headers: headers,
        data: data,
        success: function() {
            window.location.replace("http://localhost:8080/enginesHtml");
        },
        error: function(jqXHR,textStatus,errorThrown,data) {
            for (let i =0; i<jqXHR.responseJSON.fieldErrors.length; i++) {

                if (jqXHR.responseJSON.fieldErrors[i].field === 'name') {
                    document.getElementById("errorName").innerHTML = jqXHR.responseJSON.fieldErrors[i].error;
                }
                if (jqXHR.responseJSON.fieldErrors[i].field === 'price') {
                    document.getElementById("errorPrice").innerHTML = jqXHR.responseJSON.fieldErrors[i].error;
                }
                if (jqXHR.responseJSON.fieldErrors[i].field === 'fuelConsumption') {
                    document.getElementById("error_fuel_consumption").innerHTML = jqXHR.responseJSON.fieldErrors[i].error;
                }
                if (jqXHR.responseJSON.fieldErrors[i].field === 'power') {
                    document.getElementById("error_power").innerHTML = jqXHR.responseJSON.fieldErrors[i].error;
                }
            }
        }
    });
};