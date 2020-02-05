$(document).ready(() => {
    getUserFio();
});
const headers = {
    "Content-Type":"application/json",
    "Accept":"application/json",
    'Authorization': `Bearer ${localStorage.getItem('token')}`
};
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
            if (data.rule !== 'admin') {
                window.location.replace("http://localhost:8080/accessError");
            }
            // const elements = $('#fioItems').children();
            // elements[0].innerHTML = data.fio;
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};
