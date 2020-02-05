
const editCar =() =>{
    const presence = document.getElementById('presence').value;
    const engine = document.getElementById('input-idengine').value;
    const model = document.getElementById('input-idmodel').value;
    const color = document.getElementById('input-idcolor').value;
    const id = document.getElementById('input-id').value;
    const data = JSON.stringify({
        presence: presence,
        model: {id:model} ,
        engine: {id:engine} ,
        color: {id:color}
    });
    const oDataSelect = `/admin/cars/${id}`;
    $.ajax({
        url:oDataSelect,
        type:"PUT",
        headers: headers,
        data: data,
        success: function() {
            window.location.replace("http://localhost:8080/carsHtml");
        },
        error: function(jqXHR,textStatus,errorThrown) {
            for (let i =0; i<jqXHR.responseJSON.fieldErrors.length; i++) {

                if (jqXHR.responseJSON.fieldErrors[i].field === 'presence') {
                    document.getElementById("error_presence").innerHTML = jqXHR.responseJSON.fieldErrors[i].error;
                }
            }
        }
    });
};

