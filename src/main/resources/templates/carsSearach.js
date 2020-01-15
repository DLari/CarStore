$(document).ready(function () {
    $.ajax({
        url:"http://localhost:8080/colors/{id}"
    }).then(function (data) {
        $('.id').append(data.id);
        $('.name').append(data.name);
    });
});