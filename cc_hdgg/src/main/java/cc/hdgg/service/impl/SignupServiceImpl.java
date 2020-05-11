package cc.hdgg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cc.common.PracConstant;
import cc.common.PracResult;
import cc.hdgg.dao.ActivitySignupMapper;
import cc.hdgg.entity.ActivitySignup;
import cc.hdgg.service.SignupService;



@Service
public class SignupServiceImpl implements SignupService {
	
	@Autowired
	private ActivitySignupMapper signupDao;

	/**
	 * 查询所有的报名信息
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
		List<ActivitySignup> signupLists = signupDao.selectAll(); 
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setPage(page);
		result.setSize(size);
		result.setData(signupLists);
		return result;
	}
	
	/**
	 * 根据id 查询报名信息的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	@Override
	public PracResult selectById(int id) {
		PracResult result = new PracResult();
		ActivitySignup signup = signupDao.selectByPrimaryKey(id);
		if(signup == null) {
			result.setCode(PracConstant.ERROR1);
			result.setMsg(PracConstant.QUERY_EMPTY_ERROR);
			return result;
		}
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setData(signup);
		return result;
	}
	
	/**
	 * 根据id 删除报名信息的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	@Override
	public PracResult deleteById(int id) {
		PracResult result = new PracResult();
		ActivitySignup signup = signupDao.selectByPrimaryKey(id);
		if(signup == null) {
			result.setCode(PracConstant.ERROR1);
			result.setMsg(PracConstant.QUERY_EMPTY_ERROR);
			return result;
		}
		int row = signupDao.deleteByPrimaryKey(id);
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
	 * 修改报名信息的方法
	 * @param signup 更新后的报名信息类
	 * @return 信息类
	 */
	@Override
	public PracResult update(ActivitySignup signup) {
		PracResult result = new PracResult();
		int row = signupDao.updateByPrimaryKeySelective(signup);
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
	 * 新增报名信息
	 * @param signup 新增的报名信息类
	 * @return 信息类
	 */
	@Override
	public PracResult insert(ActivitySignup signup) {
		PracResult result = new PracResult();
		int row = signupDao.insert(signup);
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
		List<ActivitySignup> signupLists = signupDao.selectByActivityId(activity_Id); 
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setPage(page);
		result.setSize(size);
		result.setData(signupLists);
		return result;
	}

	@Override
	public PracResult selectByPhone(String phone, int page, int size, String orderField, String orderSeq) {
		PracResult result = new PracResult();
		String orderBy = orderField + " "+orderSeq;
		PageHelper.startPage(page, size, orderBy);
		List<ActivitySignup> activityLists = signupDao.selectByPhone(phone); 
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setPage(page);
		result.setSize(size);
		result.setData(activityLists);
		return result;
	}
	
	@Override
	public PracResult selectByUserId(int user_id, int page, int size, String orderField, String orderSeq) {
		PracResult result = new PracResult();
		String orderBy = orderField + " "+orderSeq;
		PageHelper.startPage(page, size, orderBy);
		List<ActivitySignup> activityLists = signupDao.selectByUserId(user_id); 
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setPage(page);
		result.setSize(size);
		result.setData(activityLists);
		return result;
	}


}
