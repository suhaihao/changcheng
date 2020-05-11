package cc.wmhhb.controller;

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
import cc.wmhhb.entity.BlackList;
import cc.wmhhb.entity.RedList;
import cc.wmhhb.service.BlackListService;

@RestController
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST})
public class BlackListController {
	
	@Autowired
	private BlackListService blackService;
	
	//查找所有的方法(分页)
	@GetMapping("/black/all")
	public PracResult selectAll(
			@RequestParam(name="page",required=false,defaultValue="1")int page, 
			@RequestParam(name="size",required=false,defaultValue="10")int size,
			@RequestParam(name="orderField",required=false,defaultValue="id")String orderField,
			@RequestParam(name="orderSeq",required=false,defaultValue="asc")String orderSeq) {
		PracResult result = blackService.selectAll(page,size,orderField,orderSeq);		
		return result;
	} 
	
	//根据id查找活动公告的方法
	@GetMapping("/black/get")
	public PracResult selectOne(int id) {
		PracResult result = blackService.selectById(id);
		return result;
	} 
	
	
	//根据id 删除活动公告的方法
	@GetMapping("/black/delete")
	public PracResult deleteblack(int id) {
		PracResult result = blackService.deleteById(id);
		return result;
	} 
	//修改活动公告的方法
	@PostMapping("/black/update")
	public PracResult updateblack(BlackList black) {
		PracResult result = blackService.update(black);
		return result;
	} 
	//添加黑榜信息列表
    @PostMapping("/black/add")
    public PracResult insert(@RequestParam(value = "img") MultipartFile files[],
    	String address,Date createTime,String content,String link,int createBy,
    	@RequestParam(name="likes",required=false,defaultValue="0")int likes ) {
    	PracResult result = new PracResult();
    	//指定下载文件的存放位置)   	
        String uploadPath = "D:/lixuehe/Myself/lixuehe/cc-prac/web-practice/qinghe/static/imgs/img/";
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
        String img = "";
        if (files != null && files.length >= 1) {
            for (MultipartFile file : files) {
            	String originalFileName = file.getOriginalFilename();//获取原始图片的扩展名
                String newFileName = UUID.randomUUID()+"-"+originalFileName;
                String newFilePath=uploadPath+newFileName; //新文件的路径
                img = img+newFileName;
                try {
                	file.transferTo(new File(newFilePath));//将传来的文件写入新建的文件
                }catch (Exception e ) {    
                    //处理异常
                	result.setCode(PracConstant.SUCCESS);
                	result.setMsg(PracConstant.FILE_ERROR);
                	return result;
                }
            }
           //获取对应的数据   
           	BlackList black = new BlackList(img,content,link, address,createTime,createBy,likes);
           	//将所有数据存入数据库
            result = blackService.insert(black);
        }  
        else {
        	result.setCode(PracConstant.SUCCESS);
        	result.setMsg(PracConstant.FILE_ERROR);
        }
        return result;
    }
    
    
}
