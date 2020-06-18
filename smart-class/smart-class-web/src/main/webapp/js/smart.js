var table, tableObject, layer;
;!function (win) {
    var Smart = function () {
        this.version = "1.0.1";

    }
    Smart.prototype.initPage = function (initParam) {
        if (initParam["tableParam"] != null) {
            this.initTable(initParam["tableParam"]);
        }
        layui.use('layer', function () {
            layer = layui.layer;
        });
    }
    Smart.prototype.getDiff = function (diff) {
        var diffNew = diff || 55;
        var top = $("#table_wrap").offset().top;
        return top + diffNew;
    }
    /**
     *
     * @param title iframe标题
     * @param content iframe地址
     * @param width iframe宽度
     * @param height iframe高度
     * @param yesParam 点击确定按钮后的方法
     * @param successParam 渲染完成后执行的方法
     */
    Smart.prototype.open = function (title, content, width, height, yesParam, successParam) {

        let defaultParam = {
            type: 2,
            title: title,
            content: content,
            btn: ["确定", "取消"],
            shade: 0.8,
            area: [width + "px", height + "px"],
            offset: "20px"
        }
        layer.open($.extend(defaultParam,yesParam,successParam))
        // if (yesParam&&successParam){
        //     layer.open($.extend(defaultParam,yesParam,successParam))
        // }else if (yesParam){
        //     layer.open($.extend(defaultParam,yesParam))
        // }
    }
    /**
     *
     * @param message 弹框消息
     * @param title 弹框标题
     * @param dataId 数据主键
     * @param ajaxParam ajax参数
     */
    Smart.prototype.confirm = function (message, title, dataId, ajaxParam) {
        layer.confirm(message, {icon: 3, title: title, offset: '20px'}, function (index) {
            $.ajax(ajaxParam)
            layer.close(index);
            table.reload("dataTable");
        });

    }
    Smart.prototype.initTable = function (tableParam) {
        defaultParam = {
            elem: '#dataTable'
            , height: 'full-200'
            , url: './' //数据接口
            , request: {
                pageName: "pageNum",
                limitName: "pageSize",
            }
            , page: true
        }
        layui.use('table', function () {
            table = layui.table;
            tableObject = table.render($.extend(defaultParam, tableParam));
        });
    }
    win.smart = new Smart();
}(window)
