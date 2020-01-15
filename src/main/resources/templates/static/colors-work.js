
var getDataFromAPI = function () {
    var oDataSelect = "/colors"
        // + "?$select=id,name,price,code"
    ;
    $.ajax({
        url:oDataSelect,
        type:"GET",
        success:function (data) {
            var record = data.d.results;
            for (var key in record) {
                alert("id:" + record[key].id + "/n" +
                    "name:" + record[key].name + "/n" +
                    "price:" + record[key].price + "/n" +
                    "code:" + record[key].code + "/n"
                );
            }
            console.log("GET DATA API RESPONSE ID::"+data.id);
            console.log("GET DATA API RESPONSE NAME::"+data.name);
            console.log("GET DATA API RESPONSE PRICE::"+color.price);
            console.log("GET DATA API RESPONSE CODE::"+color.code);
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
}

function postDataFromAPI() {
    var modelObj = {
        // id:$("#color_id").val(),
        name:$("#color_name").val(),
        price:$("#color_price").val(),
        code:$("#color_code").val()
    };

    console.log("post data:"+modelObj);

    $ajax({
        type:"POST",
        url:"postdata",
        headers: {
            "Content-Type":"application/json",
            "Accept":"application/json"
        },
        data:JSON.stringify(modelObj),
        success:function (data) {
            console.log("POST API RESPONSE::"+data);
        },
        error:function (jqXHR,textStatus,errorThrown) {
        }
    });

}

