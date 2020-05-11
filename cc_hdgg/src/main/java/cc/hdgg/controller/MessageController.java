package cc.hdgg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import cc.common.PracResult;
import cc.hdgg.entity.ActivityMessage;
import cc.hdgg.service.MessageService;

@RestController
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST})
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	//查找所有的方法(分页)
	@GetMapping("/activity/message/all")
	public PracResult selectAll(
			@RequestParam(name="page",required=false,defaultValue="1")int page, 
			@RequestParam(name="size",required=false,defaultValue="10")int size,
			@RequestParam(name="orderField",required=false,defaultValue="id")String orderField,
			@RequestParam(name="orderSeq",required=false,defaultValue="desc")String orderSeq) {
		PracResult result = messageService.selectAll(page,size,orderField,orderSeq);		
		return result;
	} 
	
	//根据id查找活动公告的方法
	@GetMapping("/activity/message/get")
	public PracResult selectOne(int id) {
		PracResult result = messageService.selectById(id);
		return result;
	} 
	
	
	//根据id 删除活动公告的方法
	@GetMapping("/activity/message/delete")
	public PracResult deletemessage(int id) {
		PracResult result = messageService.deleteById(id);
		return result;
	} 
	//修改活动公告的方法
	@PostMapping("/activity/message/update")
	public PracResult updatemessage(ActivityMessage message) {
		PracResult result = messageService.update(message);
		return result;
	} 
	//添加活动公告列表
    @PostMapping("/activity/message/add")
    public PracResult insert(ActivityMessage message) {
    	PracResult result = messageService.insert(message);
		return result;
    }
    
    
    //根据activity_id查找所有的方法(分页)
  	@GetMapping("/activity/message/select/activityId")
  	public PracResult selectByActivityId(int activity_id,
  			@RequestParam(name="page",required=false,defaultValue="1")int page, 
  			@RequestParam(name="size",required=false,defaultValue="10")int size,
  			@RequestParam(name="orderField",required=false,defaultValue="id")String orderField,
  			@RequestParam(name="orderSeq",required=false,defaultValue="desc")String orderSeq) {
  		PracResult result = messageService.selectByActivityId(activity_id,page,size,orderField,orderSeq);		
  		return result;
  	} 
}
