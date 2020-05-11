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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cc.common.PracConstant;
import cc.common.PracResult;
import cc.sjzd.entity.PracticeInstitute;
import cc.sjzd.entity.PracticeStation;
import cc.sjzd.service.StationService;

@RestController
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST})
public class StationController {
	
	@Autowired
	private StationService villageService;
	
	//查找所有的方法
	@GetMapping("/practice/village/all")
	public PracResult selectAll(
			@RequestParam(name="page",required=false,defaultValue="1")int page, 
			@RequestParam(name="size",required=false,defaultValue="10")int size,
			@RequestParam(name="orderField",required=false,defaultValue="id")String orderField,
			@RequestParam(name="orderSeq",required=false,defaultValue="desc")String orderSeq) {
		PracResult result = villageService.selectAll(page,size,orderField,orderSeq);		
		return result;
	} 
	
	//根据id查找文明实践中心的方法
	@GetMapping("/practice/village/get")
	public PracResult selectOne(int id) {
		PracResult result = villageService.selectById(id);
		return result;
	} 
	
	//根据id 删除文明实践中心的方法
	@GetMapping("/practice/village/delete")
	public PracResult deleteCenter(int id) {
		PracResult result = villageService.deleteById(id);
		return result;
	} 
	//修改文明实践中心的方法
	@PostMapping("/practice/village/update")
	public PracResult updateCenter(PracticeStation village) {
		PracResult result = villageService.update(village);
		return result;
	} 
	//根据名称模糊查询
	@GetMapping("/practice/village/name")
	public PracResult selectByName(String name,
			@RequestParam(name="page",required=false,defaultValue="1")int page, 
			@RequestParam(name="size",required=false,defaultValue="10")int size,
			@RequestParam(name="orderField",required=false,defaultValue="id")String orderField,
			@RequestParam(name="orderSeq",required=false,defaultValue="desc")String orderSeq){
		PracResult result = villageService.selectByName(name,page,size,orderField,orderSeq);
		return result;
	}
	//根据town_id查找下属的所有的实践站
	@GetMapping("/practice/village/getByInstituteId")
	public PracResult selectByTownId(int institute_id) {
		PracResult result = villageService.selectByInstituteId(institute_id);
		return result;
	} 
	
	//添加订单列表
    @PostMapping("/practice/village/add")
    public PracResult getOrderDtl(@RequestParam(value = "file") MultipartFile files[],
    	String stationName,String address,Date createTime,String intro,String manager,String phone,int typeId ,int centerId,int instituteId) {
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
               	PracticeStation village = new PracticeStation(stationName, createTime, address, manager, phone, intro, typeId, centerId, instituteId, imgs);
               	//将所有数据存入数据库
               	result = villageService.insert(village);
        }       
        return result;
    }
}
