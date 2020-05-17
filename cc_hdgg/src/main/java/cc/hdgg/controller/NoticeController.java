package cc.hdgg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import cc.common.PracResult;
import cc.hdgg.entity.ActivityNotice;
import cc.hdgg.service.NoticeService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    //查找所有的方法(分页)
    @GetMapping("/activity/notice/all")
    public PracResult selectAll(
            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
            @RequestParam(name = "size", required = false, defaultValue = "10") int size,
            @RequestParam(name = "type", required = false) int type,
            @RequestParam(name = "orderField", required = false, defaultValue = "id") String orderField,
            @RequestParam(name = "orderSeq", required = false, defaultValue = "desc") String orderSeq) {
        PracResult result = noticeService.selectAll(page, size, type, orderField, orderSeq);
        return result;
    }

    //根据id查找活动公告的方法
    @GetMapping("/activity/notice/get")
    public PracResult selectOne(int id) {
        PracResult result = noticeService.selectById(id);
        return result;
    }

    //根据名称模糊查询查找活动公告的方法
    @GetMapping("/activity/notice/title")
    public PracResult selectBynoticeName(String title,
                                         @RequestParam(name = "page", required = false, defaultValue = "1") int page,
                                         @RequestParam(name = "size", required = false, defaultValue = "10") int size,
                                         @RequestParam(name = "orderField", required = false, defaultValue = "id") String orderField,
                                         @RequestParam(name = "orderSeq", required = false, defaultValue = "desc") String orderSeq) {
        PracResult result = noticeService.selectByTitle(title, page, size, orderField, orderSeq);
        return result;
    }


    //根据id 删除活动公告的方法
    @GetMapping("/activity/notice/delete")
    public PracResult deletenotice(int id) {
        PracResult result = noticeService.deleteById(id);
        return result;
    }

    //修改活动公告的方法
    @PostMapping("/activity/notice/update")
    public PracResult updatenotice(ActivityNotice notice) {
        PracResult result = noticeService.update(notice);
        return result;
    }

    //添加活动公告列表
    @PostMapping("/activity/notice/add")
    public PracResult insert(ActivityNotice notice) {
        PracResult result = noticeService.insert(notice);
        return result;
    }
}
