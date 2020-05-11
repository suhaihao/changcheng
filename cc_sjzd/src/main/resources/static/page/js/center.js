
//展示文明实践中心列表的方法
function showCenterList(){
    $(".main-right-top>span").text("实践阵地>文明实践中心")
    $.ajax({
		url:"/practice/center/all?size=30",
		type:"get",
		dataType:"json",
		success:function(result){
			if(result.code==0){
			 	$(".volunteer").hide()
                $(".practice").show()              
                $(".main-right-middle2").hide();
                $(".main-right-middle1").show()
                $(".main-right-middle-table").html("");
                $(".main-right-middle-table").append(
                    "<thead> <tr class='main-right-middle-table-tr'><th>序号</th><th>名称</th><th>创建时间</th><th>地址</th><th>负责人</th><th>电话</th><th>简介</th><th>类型</th><th>图片</th><th>操作</th><th>查看详情</th></tr></thead>");
                var centerList = result.data;//获取服务器返回信息
                for(var center of centerList){
                   $(".main-right-middle-table").append(
                        "<tbody> <tr id=centerId-"+center.id+"><td>"+center.id+"</td>"
                        +"<td>"+center.centerName+"</td>"
                        +"<td>"+center.createTime+"</td>"
                        +"<td>"+center.address+"</td>"
                        +"<td>"+center.manager+"</td>"
                        +"<td>"+center.phone+"</td>"
                        +"<td>"+center.intro+"</td>"
                        +"<td>"+center.type_id+"</td>"
                        +"<td>"+center.imgs+"</td>"
                        +"<td><button class=' btn btn-danger' onclick='deleteCenter("+center.id+")'>删除</button></td>"
                       	+"<td><a href=/practice/center/town?center_name="+center.centerName+"&center_id="+center.id+">查看详情</a></td> </tbody>"
                        

                   );
                }

			}
		}
	})
}

//删除的方法
function deleteCenter(id){
    alert("确认删除吗？");
    $.ajax({
		url:"/practice/center/delete?id="+id,
		type:"get",
		dataType:"json",
		success:function(result){
			if(result.code==0){
                alert(result.msg);
                $("#centerId-"+id).remove();
            }

		}
	})
}
//查询的方法
function selectByName(){
    var name = $("#main-right-middle-name").val();
    $.ajax({
		url:"/practice/center/name?name="+name,
		type:"get",
		dataType:"json",
		success:function(result){
			if(result.code==0){
                $(".main-right-middle-table").html("");
                alert(result.msg);
                var centerList = result.data;//获取服务器返回信息
                $(".main-right-middle-table").append(
                    "<tr class='main-right-middle-table-tr'><th>序号</th><th>名称</th><th>创建时间</th><th>地址</th><th>负责人</th><th>电话</th><th>简介</th><th>类型</th><th>图片</th><th>操作</th><th>查看详情</th></tr>");
                var centerList = result.data;//获取服务器返回信息
                for(var center of centerList){
                   $(".main-right-middle-table").append(
                        "<tr id=centerId-"+center.id+"><td>"+center.id+"</td>"
                        +"<td>"+center.centerName+"</td>"
                        +"<td>"+center.createTime+"</td>"
                        +"<td>"+center.address+"</td>"
                        +"<td>"+center.manager+"</td>"
                        +"<td>"+center.phone+"</td>"
                        +"<td>"+center.intro+"</td>"
                        +"<td>"+center.type_id+"</td>"
                        +"<td>"+center.imgs+"</td>"
                        +"<td><button class=' btn btn-danger' onclick='deleteCenter("+center.id+")'>删除</button></td>"
                       	+"<td><a href=/practice/center/town?center_name="+center.centerName+"&center_id="+center.id+">查看详情</a></td>"

                   );
                }

			}
		}
	})
}

//新增文明实践中心的列表显示页面
function addCenter(){
    $(".main-right-middle1").hide();
    $(".main-right-middle2").show();
}

//新增的方法
function add(){
    var centerName = $("#center_name").val();
    var address = $("#address").val();
    var manager = $("#manager").val();
    var phone = $("#phone").val();
    var type = $("#type-select").val();
    var timeStr = $("#create_time").val();
    var createTime = new Date(timeStr.replace(/-/g, "/"));
    var intro = $("#intro").val();
    var imgs = document.getElementById("imgs").files;
    var formData = new FormData();
    for(var i=0;i<imgs.length;i++){
        formData.append("file",imgs[i]);
    }
    formData.append("centerName",centerName);
    formData.append("address",address);
    formData.append("manager",manager);
    formData.append("phone",phone);
    formData.append("typeId",1);
    formData.append("createTime",createTime);
    formData.append("intro",intro);
    $.ajax({
		url:"/practice/center/add",
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

function showImg(obj) {
    $("#img").show();
    var fileList=obj.files;    //获取文件信息
    var imgdata='';
    if(fileList){
        for(var i=0;i<fileList.length;i++){
            var reader= new FileReader();
            reader.readAsDataURL(fileList[i]);
			 // 当文件读取成功时执行的函数
			reader.onload=function(e){
                // 显示追加的图片            
                var img ='<img  class="col-sm-2" src="'+this.result+'" />';
                $("#img").append(img);
            }  
        }  

    }
    else{
        alert("上传失败");
    }
}