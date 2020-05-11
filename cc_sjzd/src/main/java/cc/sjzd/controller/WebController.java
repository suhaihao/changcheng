package cc.sjzd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
	
	
	//加载主页面
	@GetMapping("/practice/center/index")
	public String index() {	
		return "/page/html/index.html";
	} 
	//加载文明实践所的页面
	@GetMapping("/practice/center/town")
	public String townIndex() {	
		return "/page/html/town.html";
	}
	//加载文明实践站的页面
	@GetMapping("/practice/center/village")
	public String villageIndex() {	
		return "/page/html/village.html";
	}


}
