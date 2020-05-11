package cc.hdgg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cc.common.PracConstant;
import cc.common.PracResult;
import cc.hdgg.dao.ActivityMessageMapper;
import cc.hdgg.entity.ActivityMessage;
import cc.hdgg.service.MessageService;


@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired
	private ActivityMessageMapper messageDao;

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
		List<ActivityMessage> messageLists = messageDao.selectAll(); 
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setPage(page);
		result.setSize(size);
		result.setData(messageLists);
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
		ActivityMessage message = messageDao.selectByPrimaryKey(id);
		if(message == null) {
			result.setCode(PracConstant.ERROR1);
			result.setMsg(PracConstant.QUERY_EMPTY_ERROR);
			return result;
		}
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setData(message);
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
		ActivityMessage message = messageDao.selectByPrimaryKey(id);
		if(message == null) {
			result.setCode(PracConstant.ERROR1);
			result.setMsg(PracConstant.QUERY_EMPTY_ERROR);
			return result;
		}
		int row = messageDao.deleteByPrimaryKey(id);
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
	 * @param message 更新后的活动公告类
	 * @return 信息类
	 */
	@Override
	public PracResult update(ActivityMessage message) {
		PracResult result = new PracResult();
		int row = messageDao.updateByPrimaryKeySelective(message);
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
	 * @param message 新增的活动公告类
	 * @return 信息类
	 */
	@Override
	public PracResult insert(ActivityMessage message) {
		PracResult result = new PracResult();
		int row = messageDao.insert(message);
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
	 * 根据activity_id 查询留言信息列表的方法
	 * @param activity_id 活动公告id
	 * @return 信息类
	 */
	@Override
	public PracResult selectByActivityId(int activity_Id,int page, int size,String orderField,String orderSeq) {
		PracResult result = new PracResult();
		String orderBy = orderField + " "+orderSeq;
		PageHelper.startPage(page, size, orderBy);
		List<ActivityMessage> messageLists = messageDao.selectByActivityId(activity_Id); 
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setPage(page);
		result.setSize(size);
		result.setData(messageLists);
		return result;
	}


}
