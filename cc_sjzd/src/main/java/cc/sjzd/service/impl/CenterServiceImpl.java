package cc.sjzd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cc.common.PracConstant;
import cc.common.PracResult;
import cc.sjzd.dao.PracticeCenterMapper;
import cc.sjzd.entity.PracticeCenter;
import cc.sjzd.service.CenterService;

@Service
public class CenterServiceImpl implements CenterService {
	
	@Autowired
	private PracticeCenterMapper centerDao;

	/**
	 * 查询所有的文明实践中心
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
		List<PracticeCenter> centerLists = centerDao.selectAll(); 
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setPage(page);
		result.setSize(size);
		result.setData(centerLists);
		return result;
	}
	
	/**
	 * 根据id 查询文明实践中心的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	@Override
	public PracResult selectById(int id) {
		PracResult result = new PracResult();
		PracticeCenter center = centerDao.selectByPrimaryKey(id);
		if(center == null) {
			result.setCode(PracConstant.ERROR1);
			result.setMsg(PracConstant.QUERY_EMPTY_ERROR);
			return result;
		}
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setData(center);
		return result;
	}
	
	/**
	 * 根据id 删除文明实践中心的方法
	 * @param id 主键id
	 * @return 信息类
	 */
	@Override
	public PracResult deleteById(int id) {
		PracResult result = new PracResult();
		PracticeCenter center = centerDao.selectByPrimaryKey(id);
		if(center == null) {
			result.setCode(PracConstant.ERROR1);
			result.setMsg(PracConstant.QUERY_EMPTY_ERROR);
			return result;
		}
		int row = centerDao.deleteByPrimaryKey(id);
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
	 * 修改文明实践中心的方法
	 * @param center 更新后的文明实践中心类
	 * @return 信息类
	 */
	@Override
	public PracResult update(PracticeCenter center) {
		PracResult result = new PracResult();
		int row = centerDao.updateByPrimaryKeySelective(center);
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
	 * 新增文明实践中心
	 * @param center 新增的文明实践中心类
	 * @return 信息类
	 */
	@Override
	public PracResult insert(PracticeCenter center) {
		PracResult result = new PracResult();
		int row = centerDao.insert(center);
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
	public PracResult selectByCenterName(String name,int page, int size,String orderField,String orderSeq) {
		PracResult result = new PracResult();
		String orderBy = orderField + " "+orderSeq;
		PageHelper.startPage(page, size, orderBy);
		List<PracticeCenter> centerList = centerDao.selectByCenterName(name);
		if(centerList == null) {
			result.setCode(PracConstant.ERROR1);
			result.setMsg(PracConstant.QUERY_EMPTY_ERROR);
			return result;
		}
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setPage(page);
		result.setSize(size);
		result.setData(centerList);
		return result;
	}

	/**
	 * 查询所有的实践中心名称
	 * @return 信息类
	 */
	@Override
	public PracResult selectAllCenterName() {	
		PracResult result = new PracResult();
		List<String> nameList = centerDao.selectAllCenterName();
		if(nameList == null) {
			result.setCode(PracConstant.ERROR1);
			result.setMsg(PracConstant.QUERY_EMPTY_ERROR);
			return result;
		}
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setData(nameList);
		return result;
	}

	@Override
	public PracResult selectAllCenter() {
		PracResult result = new PracResult();
		List<PracticeCenter> centerLists = centerDao.selectAll(); 
		result.setCode(PracConstant.SUCCESS);
		result.setMsg(PracConstant.QUERY_SUCCESS);
		result.setData(centerLists);
		return result;
	}

}
