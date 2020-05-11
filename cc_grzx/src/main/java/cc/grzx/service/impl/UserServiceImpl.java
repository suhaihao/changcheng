package cc.grzx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;

import cc.common.PracConstant;
import cc.common.PracResult;
import cc.grzx.dao.UserMapper;
import cc.grzx.entity.User;
import cc.grzx.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userDao;
	
	/**
	 * 查询所有的用户
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
		List<User> messageLists = userDao.selectAll(); 
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setPage(page);
		result.setSize(size);
		result.setData(messageLists);
		return result;
	}
	/**
	 * 根据id 查询用户的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	@Override
	public PracResult selectById(int id) {
		PracResult result = new PracResult();
		User user = userDao.selectByPrimaryKey(id);
		if(user == null) {
			result.setCode(PracConstant.ERROR1);
			result.setMsg(PracConstant.QUERY_EMPTY_ERROR);
			return result;
		}
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setData(user);
		return result;
	}
	
	/**
	 * 根据id 删除用户的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	@Override
	public PracResult deleteById(int id) {
		PracResult result = new PracResult();
		User user = userDao.selectByPrimaryKey(id);
		if(user == null) {
			result.setCode(PracConstant.ERROR1);
			result.setMsg(PracConstant.QUERY_EMPTY_ERROR);
			return result;
		}
		int row = userDao.deleteByPrimaryKey(id);
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
	 * 修改用户的方法
	 * @param user 更新后的用户类
	 * @return 信息类
	 */
	@Override
	public PracResult update(User user) {
		PracResult result = new PracResult();
		int row = userDao.updateByPrimaryKeySelective(user);
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
	 * 新增用户
	 * @param user 新增的用户类
	 * @return 信息类
	 */
	@Override
	public PracResult insert(User user) {
		PracResult result = new PracResult();
		int row = userDao.insert(user);
		if(row<0) {
			result.setCode(PracConstant.ERROR4);
			result.setMsg(PracConstant.INSERT_ERROR);
			return result;
		}
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.INSERT_SUCCESS);
		return result;
	}





}
