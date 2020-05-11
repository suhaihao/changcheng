//获取url 中的参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg); //匹配目标参数
    if(r != null) return decodeURI(r[2]);
    return null; //返回参数值
}
//展示文明实践站列表的
$(function(){
    $(".main-right-top>span").text("实践阵地>文明实践中心>文明实践所>文明实践站");
    var town_name = getUrlParam("town_name");
    $(".nav-left-span").text(town_name);
    showVillage(); 
});
function showVillage(){
	var instituteId = getUrlParam("town_id");
    $.ajax({
		url:"/practice/village/getByInstituteId?institute_id="+instituteId,
		type:"get",
		dataType:"json",
		success:function(result){
			if(result.code==0){
                $(".main-right-middle2").hide();
                $(".main-right-middle1").show()
                $(".main-right-middle-table").html("");
                $(".main-right-middle-table").append(
                    "<tr class='main-right-middle-table-tr'><th>序号</th><th>名称</th><th>创建时间</th><th>地址</th><th>负责人</th><th>电话</th><th>简介</th><th>类型</th><th>图片</th><th>操作</th></tr>");
                    var villageList = result.data;//获取服务器返回信息
	             	for(var village of villageList){
	                   $(".main-right-middle-table").append(
	                        "<tr id=villageId-"+village.id+"><td>"+village.id+"</td>"
	                        +"<td>"+village.stationName+"</td>"
	                        +"<td>"+village.createTime+"</td>"
	                        +"<td>"+village.address+"</td>"
	                        +"<td>"+village.manager+"</td>"
	                        +"<td>"+village.phone+"</td>"
	                        +"<td>"+village.intro+"</td>"
	                        +"<td>"+village.type_id+"</td>"
	                        +"<td>"+village.imgs+"</td>"
                       		+"<td><button class=' btn btn-danger' onclick='deletevillage("+village.id+")'>删除</button></td>"
                   );
                }

			}
		}
	})
}

//删除的方法
function deletevillage(id){
    alert("确认删除吗？");
    $.ajax({
		url:"/practice/village/delete?id="+id,
		type:"get",
		dataType:"json",
		success:function(result){
			if(result.code==0){
                alert(result.msg);
                $("#villageId-"+id).remove();
            }

		}
	})
}
//查询的方法
function selectByName(){
    var name = $("#main-right-middle-name").val();
    $.ajax({
		url:"/practice/village/name?name="+name,
		type:"get",
		dataType:"json",
		success:function(result){
			if(result.code==0){
                $(".main-right-middle-table").html("");
                alert(result.msg);
                var villageList = result.data;//获取服务器返回信息
               $(".main-right-middle-table").append(
                    "<tr class='main-right-middle-table-tr'><th>序号</th><th>名称</th><th>创建时间</th><th>地址</th><th>负责人</th><th>电话</th><th>简介</th><th>类型</th><th>图片</th><th>操作</th></tr>");
                    var villageList = result.data;//获取服务器返回信息
	             	for(var village of villageList){
	                   $(".main-right-middle-table").append(
	                        "<tr id=villageId-"+village.id+"><td>"+village.id+"</td>"
	                        +"<td>"+village.stationName+"</td>"
	                        +"<td>"+village.createTime+"</td>"
	                        +"<td>"+village.address+"</td>"
	                        +"<td>"+village.manager+"</td>"
	                        +"<td>"+village.phone+"</td>"
	                        +"<td>"+village.intro+"</td>"
	                        +"<td>"+village.type_id+"</td>"
	                        +"<td>"+village.imgs+"</td>"
						    +"<td><button class=' btn btn-danger' onclick='deletevillage("+village.id+")'>删除</button></td>"
							);
						}
	
				}
			}
		})
	}   

//新增文明实践中心的列表显示页面
function addVillage(){
    $(".main-right-middle1").hide();
    $(".main-right-middle2").show();
}
//新增的方法
function add(){
    var stationName = $("#center_name").val();
    var address = $("#address").val();
    var manager = $("#manager").val();
    var phone = $("#phone").val();
    var type = $("#type-select").val();
    var timeStr = $("#create_time").val();
    var createTime = new Date(timeStr.replace(/-/g, "/"));
    var intro = $("#intro").val();
    var imgs = document.getElementById("imgs").files;
	var centerId = getUrlParam("center_id");
	var instituteId = getUrlParam("town_id");
    var formData = new FormData();
    for(var i=0;i<imgs.length;i++){
        formData.append("file",imgs[i]);
    }
    formData.append("stationName",stationName);
    formData.append("address",address);
    formData.append("manager",manager);
    formData.append("phone",phone);
    formData.append("typeId",1);
    formData.append("createTime",createTime);
    formData.append("intro",intro);
	formData.append("centerId",centerId);
	formData.append("instituteId",instituteId);
    $.ajax({
		url:"/practice/village/add",
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
