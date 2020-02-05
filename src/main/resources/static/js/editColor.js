
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
    //const oDataSelect = `/users/${id}`;
    $.ajax({
        url:`/admin/colors/${id}`,
        type:"PUT",
        headers: headers,
        data: data,
        success: function() {
            window.location.replace("http://localhost:8080/colorsHtml");
        },
        error: function(jqXHR,textStatus,errorThrown,data) {
            for (let i =0; i<jqXHR.responseJSON.fieldErrors.length; i++) {

                if (jqXHR.responseJSON.fieldErrors[i].field === 'name') {
                    document.getElementById("errorName").innerHTML = jqXHR.responseJSON.fieldErrors[i].error;
                }
                if (jqXHR.responseJSON.fieldErrors[i].field === 'price') {
                    document.getElementById("errorPrice").innerHTML = jqXHR.responseJSON.fieldErrors[i].error;
                }
                if (jqXHR.responseJSON.fieldErrors[i].field === 'colorCode') {
                    document.getElementById("error_color_code").innerHTML = jqXHR.responseJSON.fieldErrors[i].error;
                }
            }
        }
    });
};