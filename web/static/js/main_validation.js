$(document).ready(function ($) {
    $('#signup_form').validationEngine('attach', {
        promptPosition: 'centerRight',
        scroll: false
    });

    $('#changepwd_form').validationEngine('attach', {
        promptPosition: 'centerRight',
        scroll: false
    });

    //Ajax注册时判断用户名是否重复
    $('#signup_username').blur(function () {
        var a = $(this).val();
        if(a == "")
        {
            var x = $('<label style="color: palevioletred";><span class="glyphicon glyphicon-remove-sign"></span>  用户名不能为空</label>');
            $("#CheckUser").append(x);
             $("#register_submit").attr('disabled',true);
             return;
        }
        $.ajax({
            url: '/user/checkUsername',
            type: 'get',
            data: {username: a},
            dataType: 'json',
            success: function (data, textStatus) {
                if (data) {
                    var x = $('<label style="color: palevioletred";><span class="glyphicon glyphicon-remove-sign"></span>  该用户名已存在</label>');
                    $("#CheckUser").append(x);
                    $("#register_submit").attr('disabled',true);

                }
                else {
                    var x = $('<label style="color: mediumseagreen";><span class="glyphicon glyphicon-ok-sign"></span>  该用户名可用</label>');
                    $("#CheckUser").append(x);
                    $("#register_submit").attr('disabled',false);

                }
            }
        });
    });
    $("#signup_username").focus(function () {
        $("#CheckUser").empty();
    });

});
    