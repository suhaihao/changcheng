//获取url 中的参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg); //匹配目标参数
    if(r != null) return decodeURI(r[2]);
    return null; //返回参数值
}
//展示文明实践站列表的
$(function(){
    $(".main-right-top>span").text("实践阵地>文明实践中心>文明实践所");
    var center_name = getUrlParam("center_name");
    $(".nav-left-span").text(center_name+"文明实践中心");
    showTown(); 
});
function showTown(){
	var center_id = getUrlParam("center_id");
    $.ajax({
		url:"/practice/town/getByCenterId?center_id="+center_id,
		type:"get",
		dataType:"json",
		success:function(result){
			if(result.code==0){
                $(".practice").show()    
                $(".main-right-middle2").hide();
                $(".main-right-middle1").show()
                $(".main-right-middle-table").html("");
                $(".main-right-middle-table").append(
                    "<tr class='main-right-middle-table-tr'><th>序号</th><th>名称</th><th>创建时间</th><th>地址</th><th>负责人</th><th>电话</th><th>简介</th><th>类型</th><th>图片</th><th>操作</th><th>查看详情</th></tr>");
                    var townList = result.data;//获取服务器返回信息
	                for(var town of townList){
	                   $(".main-right-middle-table").append(
	                        "<tr id=townId-"+town.id+"><td>"+town.id+"</td>"
	                        +"<td>"+town.instituteName+"</td>"
	                        +"<td>"+town.createTime+"</td>"
	                        +"<td>"+town.address+"</td>"
	                        +"<td>"+town.manager+"</td>"
	                        +"<td>"+town.phone+"</td>"
	                        +"<td>"+town.intro+"</td>"
	                        +"<td>"+town.type_id+"</td>"
	                        +"<td>"+town.imgs+"</td>"
	                        +"<td><button class=' btn btn-danger' onclick='deleteTown("+town.id+")'>删除</button></td>"
	                        +"<td><a href=/practice/center/village?center_id="+center_id+"&town_id="+town.id+"&town_name="+town.instituteName+">查看详情</a></td>"
	
	                   );
	                }

			}
		}
	})
}

//删除的方法
function deleteTown(id){
    alert("确认删除吗？");
    $.ajax({
		url:"/practice/town/delete?id="+id,
		type:"get",
		dataType:"json",
		success:function(result){
			if(result.code==0){
                alert(result.msg);
                $("#townId-"+id).remove();
            }

		}
	})
}
//查询的方法
function selectByName(){
    var name = $("#main-right-middle-name").val();
    var center_id = $(".display-em").text();
    $.ajax({
		url:"/practice/town/name?name="+name,
		type:"get",
		dataType:"json",
		success:function(result){
			if(result.code==0){
                $(".main-right-middle-table").html("");
                alert(result.msg);
                var townList = result.data;//获取服务器返回信息
                $(".main-right-middle-table").append(
                    "<tr class='main-right-middle-table-tr'><th>序号</th><th>名称</th><th>创建时间</th><th>地址</th><th>负责人</th><th>电话</th><th>简介</th><th>类型</th><th>图片</th><th>操作</th><th>查看详情</th></tr>");
                    var townList = result.data;//获取服务器返回信息
	                for(var town of townList){
	                   $(".main-right-middle-table").append(
	                        "<tr id=townId-"+town.id+"><td>"+town.id+"</td>"
	                        +"<td>"+town.instituteName+"</td>"
	                        +"<td>"+town.createTime+"</td>"
	                        +"<td>"+town.address+"</td>"
	                        +"<td>"+town.manager+"</td>"
	                        +"<td>"+town.phone+"</td>"
	                        +"<td>"+town.intro+"</td>"
	                        +"<td>"+town.type_id+"</td>"
	                        +"<td>"+town.imgs+"</td>"
	                        +"<td><button class=' btn btn-danger' onclick='deleteTown("+town.id+")'>删除</button></td>"
	                        +"<td><a href=/practice/center/village?center_id="+center_id+"&town_id="+town.id+"&town_name="+town.instituteName+">查看详情</a></td>"
	
	                   );
	                }

			}
		}
	})
}
//新增文明实践中心的列表显示页面
function addTown(){
    $(".main-right-middle1").hide();
    $(".main-right-middle2").show();
}
//新增的方法
function add(){
    var instituteName = $("#center_name").val();
    var address = $("#address").val();
    var manager = $("#manager").val();
    var phone = $("#phone").val();
    var type = $("#type-select").val();
    var timeStr = $("#create_time").val();
    var createTime = new Date(timeStr.replace(/-/g, "/"));
    var intro = $("#intro").val();
    var imgs = document.getElementById("imgs").files;
    var center_id = getUrlParam("center_id");
    var formData = new FormData();
    for(var i=0;i<imgs.length;i++){
        formData.append("file",imgs[i]);
    }
    formData.append("instituteName",instituteName);
    formData.append("address",address);
    formData.append("manager",manager);
    formData.append("phone",phone);
    formData.append("typeId",1);
    formData.append("createTime",createTime);
    formData.append("intro",intro);
    formData.append("centerId",center_id);
    $.ajax({
		url:"/practice/town/add",
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
