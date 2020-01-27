
function createColor(){
    const name = document.getElementById('name').value;
    const price = document.getElementById('price').value;
    const colorCode = document.getElementById('color_code').value;
    const data = JSON.stringify({
        name: name,
        price: price,
        colorCode: colorCode
    });
    const oDataSelect = `/admin/colors`;
    $.ajax({
        url:oDataSelect,
        type:"POST",
        headers: headers,
        data: data,
        success: function() {
            window.location.replace("http://localhost:8080/colorsHtml");
        },
        error: function() {
            alert("Failed");
        }
    });
}