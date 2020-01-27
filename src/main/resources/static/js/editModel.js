
const editModel =() =>{
    const name = document.getElementById('name').value;
    const price = document.getElementById('price').value;
    const widthCarcass = document.getElementById('width_carcass').value;
    const lenghtCarcass = document.getElementById('length_carcass').value;
    const id = document.getElementById('input-id').value;
    const dictCarcass = document.getElementById('input-idcarcass').value;
    const data = JSON.stringify({
        name: name,
        price: price,
        widthCarcass:widthCarcass,
        lenghtCarcass:lenghtCarcass,
        dictCarcass:{id: dictCarcass}
    });
    const oDataSelect = `/admin/models/${id}`;
    $.ajax({
        url:oDataSelect,
        type:"PUT",
        headers: headers,
        data: data,
        success: function() {
            window.location.replace("http://localhost:8080/modelsHtml");
        },
        error: function() {
            alert("Failed");
        }
    });
};