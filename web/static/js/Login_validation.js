/**
 * Created by Pealing on 2017/5/29.
 */
$(document).ready(function ($) {
    //登录时判断用户名是否存在
    $('#login_username').blur(function () {
        var a = $(this).val();
        if(a == "")
            return ;
        $.ajax({
            url: '/user/checkUsername',
            type: 'get',
            data: {username: a},
            dataType: 'json',
            success: function (data, textStatus) {
                if (!data) {
                    var x = $('<label><span class="glyphicon glyphicon-exclamation-sign"></span>该用户不存在</label>');
                    $("#CheckUser").append(x);
                    $("#login_submit").attr('disabled',true);
                }
                else
                {
                    $("#login_submit").attr('disabled',false);
                }

            }
        });
    });

    $("#login_username").focus(function () {
        $("#CheckUser").empty();
    });
});
