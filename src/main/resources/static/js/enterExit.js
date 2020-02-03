
$(document).ready(() => {
    if (localStorage.getItem('token')) {
        document.getElementById('login-container').style.display = 'none';
        document.getElementById('logout-container').style.display = 'block';
        document.getElementById('fio').style.display = 'block';
    }
    // getFilters();
    getUserFio();
    //getAuto();

    //  writeModelFilter();
});
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
            const elements = $('#fioItems').children();
            elements[0].innerHTML = data.fio;
        }, error:function (jqXHR,textStatus,errorThrown) {
        }
    });
};

function logOut(){
    localStorage.setItem('token','');

    window.location.replace("http://localhost:8080/index");
}

