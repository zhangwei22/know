$("#ajax_1").click(function () {
    $.ajax({
        data: {
            name: 'zhangwei',
            age: 25
        },
        url: "param/sendParam",
        type: "application/json",
        success: function (data) {
            $("#ajax_div_1").html(data);
        }
    });
});
