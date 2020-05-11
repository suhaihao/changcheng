//展示文明实践中心列表的方法
function showVolunteerList(){
    $(".main-right-top>span").text("志愿点单")
    $.ajax({
		url:"http://106.12.11.4:8081/zydd/order/list",
		type:"get",
		dataType:"json",
		success:function(result){
			if(result.code==200){
				$(".practice").hide()       
                $(".volunteer").show();              
                $(".volunteer-middle2").hide();
                $(".volunteer-middle1").show()
                $(".volunteer-table").html("");
                $(".volunteer-table").append(
                    "<thead> <tr class='volunteer-table-tr'><th>序号</th><th>创建时间</th><th>修改时间</th><th>修改者</th><th>类型</th><th>活动标题</th><th>活动内容</th><th>开始时间</th><th>结束时间</th><th>地址</th><th>图片</th><th>操作</th></tr></thead>");
                var volunteerList = result.rows;//获取服务器返回信息
                for(var volunteer of volunteerList){
                   $(".volunteer-table").append(
                        "<tbody> <tr id=volunteer-"+volunteer.id+"><td>"+volunteer.id+"</td>"
                        +"<td>"+volunteer.createTime+"</td>"
                        +"<td>"+volunteer.updateTime+"</td>"
                        +"<td>"+volunteer.updateBy+"</td>"
                        +"<td>"+volunteer.type+"</td>"
                        +"<td>"+volunteer.title+"</td>"
                        +"<td>"+volunteer.content+"</td>"
                        +"<td>"+volunteer.startTime+"</td>"
                        +"<td>"+volunteer.endstartTime+"</td>"
                        +"<td>"+volunteer.address+"</td>"
                        +"<td>"+volunteer.files+"</td>"
                        +"<td><button class=' btn btn-danger' onclick='deleteVolunteer("+volunteer.id+")'>删除</button></td></tbody>"
                        

                   );
                }

			}
		}
	})
}

//删除的方法
function deleteVolunteer(id){
    alert("确认删除吗？");
    $.ajax({
		url:"http://106.12.11.4:8081/zydd/order?id="+id,
		type:"get",
		dataType:"json",
		success:function(result){
			if(result.code==0){
                alert(result.msg);
                $("#volunteer-"+id).remove();
            }

		}
	})
}
//查询的方法
function selectByName(){
    var name = $("#main-right-middle-name").val();
    $.ajax({
		url:"http://localhost:8002/practice/center/name?name="+name,
		type:"get",
		dataType:"json",
		success:function(result){
			if(result.code==0){
                $(".volunteer-table").html("");
                alert(result.msg);
                var centerList = result.data;//获取服务器返回信息
                $(".volunteer-table").append(
                    "<thead> <tr class='volunteer-table-tr'><th>序号</th><th>创建时间</th><th>修改时间</th><th>修改者</th><th>类型</th><th>活动标题</th><th>活动内容</th><th>开始时间</th><th>结束时间</th><th>地址</th><th>图片</th><th>操作</th></tr></thead>");
                var volunteerList = result.rows;//获取服务器返回信息
                for(var volunteer of volunteerList){
                   $(".volunteer-table").append(
                        "<tbody> <tr id=volunteer-"+volunteer.id+"><td>"+volunteer.id+"</td>"
                        +"<td>"+volunteer.createTime+"</td>"
                        +"<td>"+volunteer.updateTime+"</td>"
                        +"<td>"+volunteer.updateBy+"</td>"
                        +"<td>"+volunteer.type+"</td>"
                        +"<td>"+volunteer.title+"</td>"
                        +"<td>"+volunteer.content+"</td>"
                        +"<td>"+volunteer.startTime+"</td>"
                        +"<td>"+volunteer.endstartTime+"</td>"
                        +"<td>"+volunteer.address+"</td>"
                        +"<td>"+volunteer.files+"</td>"
                        +"<td><button class=' btn btn-danger' onclick='deleteVolunteer("+volunteer.id+")'>删除</button></td></tbody>"
                        
                   );
                }

			}
		}
	})
}

//新增文明实践中心的列表显示页面
function addVolunteer(){
    $(".volunteer-middle1").hide();
    $(".volunteer-middle2").show();
}

//新增的方法
function addVol(){
    var title = $("#volunteer-title").val();
    var content = $("#volunteer-content").val();
    var startTime = $("#volunteer-startTime").val();
    var endstartTime = $("#volunteer-endstartTime").val();
    var address = $("#volunteer-address").val();
    var updateBy = $("#volunteer-updateBy").val();
    var createTime = new Date();
    var updateTime  = new Date();
    var imgs = document.getElementById("volunteer-imgs").files;
    var formData = new FormData();
    for(var i=0;i<imgs.length;i++){
        formData.append("file",imgs[i]);
    }
    formData.append("title",title);
    formData.append("content",content);
    formData.append("startTime",startTime);
    formData.append("endstartTime",endstartTime);
    formData.append("address",address);
    formData.append("updateBy",updateBy);
    formData.append("createTime",createTime);
    formData.append("updateTime",updateTime);
    $.ajax({
		url:"http://localhost:8002/practice/center/add",
        type:"post",
        data:formData,
        processData: false,//必写
        contentType: false,//必写
		dataType:"json",
		success:function(result){
			if(result.code==0){
                alert(result.msg);
            }
        },
        error:function(){
            alert("出错了");
        }
	})


}

// 展示图片的方法

function showVolImg(obj) {
    $("#vol-img").show();
    var fileList=obj.files;    //获取文件信息
    var imgdata='';
    if(fileList){
        for(var i=0;i<fileList.length;i++){
            var reader= new FileReader();
            reader.readAsDataURL(fileList[i]);
			 // 当文件读取成功时执行的函数
			reader.onload=function(e){
                alert(this.result)
                // 显示追加的图片            
                var img ='<img class="col-sm-2" src="'+this.result+'" />';
                $("#vol-img").append(img);
            }  
        }  

    }
    else{
        alert("上传失败");
    }
}
