/**
 * Created by Pealing on 2017/5/29.
 */
$(document).ready(function ($) {
    $('#sendMail_form').validationEngine('attach', {
        promptPosition: 'centerRight',
        scroll: false
    });
    $("#sendMail_reset").click(function () {
        $("#sendMail_receiver").val('');
        $("#sendMail_content").val('');
    });
    $("#sendMail_receiver").blur(function () {
        var a = $(this).val();
        if(a === "")
        {
            ("#sendMail_submit").attr("disabled",true);
            return;
        }
        $.ajax({
            url: '/user/checkUsername',
            type: 'get',
            data: {username: a},
            dataType: 'json',
            success: function (data, textStatus) {
                if (!data) {
                    alert("该用户不存在！");
                    $("#sendMail_submit").attr("disabled",true);
                    return;
                }
                else
                {
                    $("#sendMail_submit").attr("disabled",false);
                }
            }
        });
    });
});
