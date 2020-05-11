package cc.hdgg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cc.common.PracConstant;
import cc.common.PracResult;
import cc.hdgg.dao.ActivityNoticeMapper;
import cc.hdgg.entity.ActivityNotice;
import cc.hdgg.service.NoticeService;


@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private ActivityNoticeMapper noticeDao;

	/**
	 * 查询所有的活动公告
	 * @param page  页码
	 * @param size  每页的条数
	 * @param orderField  排序字段
	 * @param orderSeq    排序方式  desc asc
	 * @return  信息类
	 */
	@Override
	public PracResult selectAll(int page, int size,String orderField,String orderSeq) {
		PracResult result = new PracResult();
		String orderBy = orderField + " "+orderSeq;
		PageHelper.startPage(page, size, orderBy);
		List<ActivityNotice> noticeLists = noticeDao.selectAll(); 
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setPage(page);
		result.setSize(size);
		result.setData(noticeLists);
		return result;
	}
	
	/**
	 * 根据id 查询活动公告的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	@Override
	public PracResult selectById(int id) {
		PracResult result = new PracResult();
		ActivityNotice notice = noticeDao.selectByPrimaryKey(id);
		if(notice == null) {
			result.setCode(PracConstant.ERROR1);
			result.setMsg(PracConstant.QUERY_EMPTY_ERROR);
			return result;
		}
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setData(notice);
		return result;
	}
	
	/**
	 * 根据id 删除活动公告的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	@Override
	public PracResult deleteById(int id) {
		PracResult result = new PracResult();
		ActivityNotice notice = noticeDao.selectByPrimaryKey(id);
		if(notice == null) {
			result.setCode(PracConstant.ERROR1);
			result.setMsg(PracConstant.QUERY_EMPTY_ERROR);
			return result;
		}
		int row = noticeDao.deleteByPrimaryKey(id);
		if(row<0) {
			result.setCode(PracConstant.ERROR2);
			result.setMsg(PracConstant.DELETE_ERROR);
			return result;
		}
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.DELETE_SUCCESS);
		return result;
	}

	/**
	 * 修改活动公告的方法
	 * @param notice 更新后的活动公告类
	 * @return 信息类
	 */
	@Override
	public PracResult update(ActivityNotice notice) {
		PracResult result = new PracResult();
		int row = noticeDao.updateByPrimaryKeySelective(notice);
		if(row<0) {
			result.setCode(PracConstant.ERROR3);
			result.setMsg(PracConstant.UPDATE_ERROR);
			return result;
		}
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.UPDATE_SUCCESS);
		return result;
	}


	/**
	 * 新增活动公告
	 * @param notice 新增的活动公告类
	 * @return 信息类
	 */
	@Override
	public PracResult insert(ActivityNotice notice) {
		PracResult result = new PracResult();
		int row = noticeDao.insert(notice);
		if(row<0) {
			result.setCode(PracConstant.ERROR4);
			result.setMsg(PracConstant.INSERT_ERROR);
			return result;
		}
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.INSERT_SUCCESS);
		return result;
	}

	/**
	 * 根据名称模糊查询
	 * @param name 名称
	 * @return 信息类
	 */
	@Override
	public PracResult selectByTitle(String title,int page, int size,String orderField,String orderSeq) {
		PracResult result = new PracResult();
		String orderBy = orderField + " "+orderSeq;
		PageHelper.startPage(page, size, orderBy);
		List<ActivityNotice> noticeList = noticeDao.selectByTitle(title);
		if(noticeList == null) {
			result.setCode(PracConstant.ERROR1);
			result.setMsg(PracConstant.QUERY_EMPTY_ERROR);
			return result;
		}
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setPage(page);
		result.setSize(size);
		result.setData(noticeList);
		return result;
	}

}
