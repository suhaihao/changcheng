package cc.sjzd.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST})
public class uploadController {
	
	    //请求订单列表
	    @ResponseBody
	    @PostMapping("/practice/upload")
	    public String getOrderDtl(@RequestParam(value = "file") MultipartFile files[],HttpServletRequest request) {
	    	//指定下载文件的存放位置)
	    	System.out.println(request.getParameter("centerName"));
	        String uploadPath = "D:/lixuehe/Myself/lixuehe/web-practice/static/imgs/";
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
	        if (files != null && files.length >= 1) {
	                for (MultipartFile file : files) {
	                	String originalFileName = file.getOriginalFilename();//获取原始图片的扩展名
	                    String newFileName = UUID.randomUUID()+"-"+originalFileName;
	                    String newFilePath=uploadPath+newFileName; //新文件的路径
	                    try {
	                    	file.transferTo(new File(newFilePath));//将传来的文件写入新建的文件
	                    }catch (IllegalStateException e ) {
	                        //处理异常
	                    }catch(IOException e1){
	                        //处理异常
	                    }
	                }
	        }
	        return "";
	    }
	                    
	 //判断图片类型
	    private Boolean isImageFile(String fileName) {
	        String[] img_type = new String[]{".jpg", ".jpeg", ".png", ".gif", ".bmp"};
	        if (fileName == null) {
	            return false;
	        }
	        fileName = fileName.toLowerCase();
	        for (String type : img_type) {
	            if (fileName.endsWith(type)) {
	                return true;
	            }
	        }
	        return false;
	    }
	 
	    /**
	     * 获取文件后缀名
	     *
	     * @param fileName
	     * @return
	     */
	    private String getFileType(String fileName) {
	        if (fileName != null && fileName.indexOf(".") >= 0) {
	            return fileName.substring(fileName.lastIndexOf("."), fileName.length());
	        }
	        return "";
	    }
	 
	 
}
