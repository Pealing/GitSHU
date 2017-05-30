/**
 * Created by Pealing on 2017/5/30.
 */
$(document).ready(function ($) {
    $('#workflow_form').validationEngine('attach', {
        promptPosition: 'centerRight',
        scroll: false
    });

    //点击工作结点触发显示框定位结点
    $('#workTree button').click(function () {
        var id = $(this).attr('id');
        $('#panel_nodeName').text($(this).text());
        $('#panle_nodeInfo').text($('#' + id + 's').val());
        //完成一个结点
        $("#nodeComplete").click(function () {
            var name = $('#panel_nodeName').text();
            $("#" + name).attr("class", "btn btn-success");
            location.href = "WorkflowStatusUpdate.action?id=" + id + "&status=" + "2";
        });
        //过程一个结点
        $("#nodeProgress").click(function () {
            var name = $('#panel_nodeName').text();
            $("#" + name).attr("class", "btn btn-warning");
            location.href = "/workflow/action/WorkflowStatusUpdate.action?id=" + id + "&status=" + "0";
        });
        //删除一个结点
        $("#nodeDelete").click(function () {
            location.href = "/workflow/action/WorkflowDelete.action?id=" + id;
        });
    });
});
