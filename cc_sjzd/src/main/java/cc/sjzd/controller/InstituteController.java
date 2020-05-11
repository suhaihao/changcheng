package cc.sjzd.controller;

import java.io.File;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cc.common.PracConstant;
import cc.common.PracResult;
import cc.sjzd.entity.PracticeCenter;
import cc.sjzd.entity.PracticeInstitute;
import cc.sjzd.service.InstituteService;

@RestController
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST})
public class InstituteController {
	
	@Autowired
	private InstituteService townService;
	
	//查找所有的方法
	@GetMapping("/practice/town/all")
	public PracResult selectAll(
		@RequestParam(name="page",required=false,defaultValue="1")int page, 
		@RequestParam(name="size",required=false,defaultValue="10")int size,
		@RequestParam(name="orderField",required=false,defaultValue="id")String orderField,
		@RequestParam(name="orderSeq",required=false,defaultValue="desc")String orderSeq) {
			PracResult result = townService.selectAll(page,size,orderField,orderSeq);		
			return result;
	} 
	
	//根据id查找文明实践中心的方法
	@GetMapping("/practice/town/get")
	public PracResult selectOne(int id) {
		PracResult result = townService.selectById(id);
		return result;
	} 
	
	//根据id 删除文明实践中心的方法
	@GetMapping("/practice/town/delete")
	public PracResult deleteTown(int id) {
		PracResult result = townService.deleteById(id);
		return result;
	} 
	//修改文明实践中心的方法
	@PostMapping("/practice/town/update")
	public PracResult updateTown(PracticeInstitute town) {
		PracResult result = townService.update(town);
		return result;
	} 
	//根据center_id 查询文明实践所的方法
	@GetMapping("/practice/town/getByCenterId")
	public PracResult selectByCenterId(int center_id) {
		PracResult result = townService.selectByCenterId(center_id);
		return result;
	} 
	//根据名称模糊查询实践站
	@GetMapping("/practice/town/name")
	public PracResult selectByTownName(String name,
		@RequestParam(name="page",required=false,defaultValue="1")int page, 
		@RequestParam(name="size",required=false,defaultValue="10")int size,
		@RequestParam(name="orderField",required=false,defaultValue="id")String orderField,
		@RequestParam(name="orderSeq",required=false,defaultValue="desc")String orderSeq) {
			PracResult result = townService.selectByInstituteName(name,page,size,orderField,orderSeq);
			return result;
	} 
	//添加订单列表
    @PostMapping("/practice/town/add")
    public PracResult getOrderDtl(@RequestParam(value = "file") MultipartFile files[],
    	String instituteName,String address,Date createTime,String intro,String manager,String phone,int typeId ,int centerId) {
    	 PracResult result = new PracResult();
    	//指定下载文件的存放位置)   	
        String uploadPath = "D:/lixuehe/Myself/lixuehe/web-practice/static/imgs/img/";
        //文件夹不存在创建
        File uploadDirectory = new File(uploadPath);
        if (uploadDirectory.exists()) {
            if (!uploadDirectory.isDirectory()) {
                uploadDirectory.delete();
            }
        } else {
            uploadDirectory.mkdir();
        }
        //这里可以支持多文件上传
        String imgs = "";
        if (files != null && files.length >= 1) {
                for (MultipartFile file : files) {
                	String originalFileName = file.getOriginalFilename();//获取原始图片的扩展名
                    String newFileName = UUID.randomUUID()+"-"+originalFileName;
                    String newFilePath=uploadPath+newFileName; //新文件的路径
                    imgs = imgs+newFileName +";";
                    try {
                    	file.transferTo(new File(newFilePath));//将传来的文件写入新建的文件
                    }catch (Exception e ) {
                        //处理异常
                    	result.setCode(PracConstant.SUCCESS);
                    	result.setMsg(PracConstant.INSERT_SUCCESS);
                    	return result;
                    }
                }
               //获取对应的数据   
               	PracticeInstitute town = new PracticeInstitute(instituteName, createTime, address,manager,phone,intro, typeId, centerId,imgs);
               	//将所有数据存入数据库
                result = townService.insert(town);
        }       
        return result;
    }
}
