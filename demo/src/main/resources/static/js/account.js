$(document).ready(function () {
    console.log("ready function!");
   $("#search-account-form").submit(function (event) {
       console.log("search-account-form!");

       event.preventDefault();
       
       search_account();
   });
});

function search_account() {
    var account=$("#account").val();
    console.log(account);
    $("#btn-search-account").prop("disabled", true);

    $.ajax({
        type: "POST",
        url: "/hello",
        data: {
            account: account
        },
        dataType: 'json',
        cache: false,
        timeout: 30000,

        success: function (data) {
            console.log(data['message']);
            $('#query-users-result').html(data['message']);

            $("#btn-search-account").prop("disabled", false);
        },
        error: function (e) {
            var errorInfo = "<div class='col-sm-5'><label class='label-warning'>query fail!</label><br>"
                + e.responseText + "</div>";
            $('#query-users-result').html(errorInfo);

            console.log("ERROR : ", e);
            $("#btn-search-account").prop("disabled", false);

        }
    });
}