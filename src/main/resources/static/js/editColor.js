
const editColor =() =>{
    const name = document.getElementById('name').value;
    const price = document.getElementById('price').value;
    const colorCode = document.getElementById('color_code').value;
    const id = document.getElementById('input-id').value;
    const data = JSON.stringify({
        name: name,
        price: price,
        colorCode: colorCode
    });
    const oDataSelect = `/users/${id}`;
    $.ajax({
        url:oDataSelect,
        type:"PUT",
        headers: headers,
        data: data,
        success: function() {
            window.location.replace("http://localhost:8080/personalAreaHtml");
        },
        error: function() {
            alert("Failed");
        }
    });
};