/**
 * Created by Pealing on 2017/5/30.
 */
$(document).ready(function () {
    $('button').click(
        function () {
            var id = $(this).attr("id");
            $.ajax({
                url: '/mail/readMail',
                type: 'get',
                data: {id: id},
                dataType: 'text',
                success: function (data) {
                   $("#inbox_content_show_body").text(data);
                   $("#inbox_content_show").css("visibility", "visible");
                    $("#cover").css("visibility", "visible");
                }
            });
        }
    );
    $("#close").click(function () {
        $("#inbox_content_show").css("visibility", "hidden");
        $("#cover").css("visibility", "hidden");

    });

});
