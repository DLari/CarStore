
const payment = (idUser) => {
    const oDataSelect = `/orders/paid/${idUser}`;
    $.ajax({
        url:oDataSelect,
        type:"PUT",
        headers: headers,
        success: () => {
            window.location.replace("http://localhost:8080/basketStory");
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};
const mineId = () => {

    const oDataSelect = `/users/mine`;
    $.ajax({
        url:oDataSelect,
        type:"GET",
        headers: headers,
        success: (data) => {
          payment(data.id);
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};