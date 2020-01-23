const headers = {
    "Content-Type":"image/jpeg",
    "Accept":"image/jpeg"
};
$(document).ready(() => {
    getImage();
});
const getImage = () => {
    const oDataSelect = "/images";
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: headers,
        success: (data) => {
          console.log(data);
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};