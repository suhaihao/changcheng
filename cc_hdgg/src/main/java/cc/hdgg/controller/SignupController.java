package cc.hdgg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import cc.common.PracResult;
import cc.hdgg.entity.ActivitySignup;
import cc.hdgg.service.SignupService;

@RestController
@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST})
public class SignupController {
	
	@Autowired
	private SignupService signupService;
	
	//查找所有的方法(分页)
	@GetMapping("/activity/signup/all")
	public PracResult selectAll(
			@RequestParam(name="page",required=false,defaultValue="1")int page, 
			@RequestParam(name="size",required=false,defaultValue="10")int size,
			@RequestParam(name="orderField",required=false,defaultValue="id")String orderField,
			@RequestParam(name="orderSeq",required=false,defaultValue="desc")String orderSeq) {
		PracResult result = signupService.selectAll(page,size,orderField,orderSeq);		
		return result;
	} 
	
	//根据id查找报名信息的方法
	@GetMapping("/activity/signup/get")
	public PracResult selectOne(int id) {
		PracResult result = signupService.selectById(id);
		return result;
	} 
	
	//根据id 删除报名信息的方法
	@GetMapping("/activity/signup/delete")
	public PracResult deletesignup(int id) {
		PracResult result = signupService.deleteById(id);
		return result;
	} 
	//修改报名信息的方法
	@PostMapping("/activity/signup/update")
	public PracResult updatesignup(ActivitySignup signup) {
		PracResult result = signupService.update(signup);
		return result;
	} 
	//添加报名信息列表
    @PostMapping("/activity/signup/add")
    public PracResult insert(ActivitySignup signup) {
    	PracResult result = signupService.insert(signup);
		return result;
    }
    
    //根据activity_id查找所有的方法(分页)
  	@GetMapping("/activity/signup/select/activityId")
  	public PracResult selectByActivityId(int activity_id,
  			@RequestParam(name="page",required=false,defaultValue="1")int page, 
  			@RequestParam(name="size",required=false,defaultValue="10")int size,
  			@RequestParam(name="orderField",required=false,defaultValue="id")String orderField,
  			@RequestParam(name="orderSeq",required=false,defaultValue="desc")String orderSeq) {
  		PracResult result = signupService.selectByActivityId(activity_id,page,size,orderField,orderSeq);		
  		return result;
  	} 
  	//根据用户手机号查询该用户报名的所有活动id
  	@GetMapping("/activity/signup/select/phone")
  	public PracResult selectByPhone(String phone,
  			@RequestParam(name="page",required=false,defaultValue="1")int page, 
  			@RequestParam(name="size",required=false,defaultValue="10")int size,
  			@RequestParam(name="orderField",required=false,defaultValue="id")String orderField,
  			@RequestParam(name="orderSeq",required=false,defaultValue="desc")String orderSeq) {
  		PracResult result = signupService.selectByPhone(phone,page,size,orderField,orderSeq);
  		return result;
  	} 
  //根据用户手机号查询该用户报名的所有活动id
  	@GetMapping("/activity/signup/select/user")
  	public PracResult selectByPhone(int user_id,
  			@RequestParam(name="page",required=false,defaultValue="1")int page, 
  			@RequestParam(name="size",required=false,defaultValue="10")int size,
  			@RequestParam(name="orderField",required=false,defaultValue="id")String orderField,
  			@RequestParam(name="orderSeq",required=false,defaultValue="desc")String orderSeq) {
  		PracResult result = signupService.selectByUserId(user_id,page,size,orderField,orderSeq);
  		return result;
  	} 
    
}
