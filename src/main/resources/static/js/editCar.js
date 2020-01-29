
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
        error: function() {
            alert("Failed");
        }
    });
};