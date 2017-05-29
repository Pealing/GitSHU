/**
 * Created by Pealing on 2017/5/29.
 */
$(document).ready(function ($) {
    //判断原密码是否正确
    $('#oldPassword').blur(function () {
        var a = $(this).val();
        if(a === "")
            return ;
        $.ajax({
            url: '/user/resetPassword',
            type: 'get',
            data: {oldPassword: a},
            dataType: 'json',
            success: function (data, textStatus) {
                if (!data) {
                    var x = $('<label><span class="glyphicon glyphicon-exclamation-sign"></span>  原密码错误</label>');
                    $("#CheckPassword").append(x);
                    $("#changepwd_submit").attr('disabled',true);
                }
            }
        });
    });

    $("#oldPassword").focus(function () {
        $("#CheckPassword").empty();
        $("#changepwd_submit").attr('disabled',false);
    });
});