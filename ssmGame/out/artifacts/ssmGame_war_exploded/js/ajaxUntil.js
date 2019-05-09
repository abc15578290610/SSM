var ajaxUntil={
    sendPost:function (url,data,callback,_parent) {
          $.ajax({
            headers: {
                Accept: "application/json;charset=utf-8"
            },
            url: url,
            type: 'POST',
            data:data,
            async: true,
            success: function (res) {
                try {
                    if(callback)callback.call(_parent,res);
                } catch (error) {
                    console.log(_parent,'获取异常',res)
                }
            }
        });
    },
    sendGet:function (url,callback,_parent) {
        $.ajax({
            url:url,
            type: 'GET',
            async: true,
            success: function (res) {
                try {
                    if(callback)callback.call(_parent,res);
                } catch (error) {
                    console.log(_parent,'获取异常',res)
                }
            }
        });
    }
}