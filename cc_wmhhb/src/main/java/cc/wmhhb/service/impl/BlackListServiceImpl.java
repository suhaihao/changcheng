package cc.wmhhb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cc.common.PracConstant;
import cc.common.PracResult;
import cc.wmhhb.dao.BlackListMapper;
import cc.wmhhb.entity.BlackList;
import cc.wmhhb.service.BlackListService;


@Service
public class BlackListServiceImpl implements BlackListService {
	
	@Autowired
	private BlackListMapper blackDao;

	/**
	 * 查询所有的黑榜信息
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
		List<BlackList> BlackLists = blackDao.selectAll(); 
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setPage(page);
		result.setSize(size);
		result.setData(BlackLists);
		return result;
	}
	
	/**
	 * 根据id 查询黑榜信息的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	@Override
	public PracResult selectById(int id) {
		PracResult result = new PracResult();
		BlackList black = blackDao.selectByPrimaryKey(id);
		if(black == null) {
			result.setCode(PracConstant.ERROR1);
			result.setMsg(PracConstant.QUERY_EMPTY_ERROR);
			return result;
		}
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setData(black);
		return result;
	}
	
	/**
	 * 根据id 删除黑榜信息的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	@Override
	public PracResult deleteById(int id) {
		PracResult result = new PracResult();
		BlackList black = blackDao.selectByPrimaryKey(id);
		if(black == null) {
			result.setCode(PracConstant.ERROR1);
			result.setMsg(PracConstant.QUERY_EMPTY_ERROR);
			return result;
		}
		int row = blackDao.deleteByPrimaryKey(id);
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
	 * 修改黑榜信息的方法
	 * @param black 更新后的黑榜信息类
	 * @return 信息类
	 */
	@Override
	public PracResult update(BlackList black) {
		PracResult result = new PracResult();
		int row = blackDao.updateByPrimaryKeySelective(black);
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
	 * 新增黑榜信息
	 * @param black 新增的黑榜信息类
	 * @return 信息类
	 */
	@Override
	public PracResult insert(BlackList black) {
		PracResult result = new PracResult();
		int row = blackDao.insert(black);
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
