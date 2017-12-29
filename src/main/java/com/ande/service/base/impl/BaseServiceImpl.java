package com.ande.service.base.impl;

import java.util.List;

import org.apache.log4j.Logger;

import util.PageResult;

import com.ande.dao.base.IBaseDao;
import com.ande.service.base.IBaseService;
import com.github.pagehelper.PageHelper;


/**
 * 通用Service接口定义了新增、修改、删除、查询单个记录、查询记录列表、分页查询列表的方法
 * 
 * @author: chengzb
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T> {

    private static Logger logger = Logger.getLogger(BaseServiceImpl.class);

    protected abstract IBaseDao<T> getMapper();

    @Override
    public int insertSelective(T entity) throws Exception {
        	return getMapper().insertSelective(entity);
    }
    @Override
    public int updateByPrimaryKeySelective(T entity) throws Exception {
        return getMapper().updateByPrimaryKeySelective(entity);
    }


    public int updateByPrimaryKeySelective(Integer userId,T entity) throws Exception {
        return getMapper().updateByPrimaryKeySelective(entity);
    }
    @Override
    public int deleteByPrimaryKey(int id){
         return getMapper().deleteByPrimaryKey(id);
    }
    @Override
    public T selectByPrimaryKey(int id) {
        T obj = null;
        try {
            obj = getMapper().selectByPrimaryKey(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return obj;
    }
    @Override
    public int getCount(T entity) {
        int result = 0;
        try {
            result = getMapper().getCount(entity);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }
    public List<T> getAll(){
    	 List<T> list = null;
         try {
             list = getMapper().getAll();
         } catch (Exception e) {
             logger.error(e.getMessage(), e);
         }
         return list;
    }
    public List<T> getAllBySelect(T entity){
    	 List<T> list = null;
         try {
             list = getMapper().getAllBySelect(entity);
         } catch (Exception e) {
             logger.error(e.getMessage(), e);
         }
         return list;
    }
  
    @Override
    public List<T> getPage(T obj){
        List<T> list = null;
        try {
            list = getMapper().getPage(obj);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } 
        return list;
    }
    @Override
	public PageResult<T> queryByPage(PageResult<T> t,T entity) {
    	int pageNo=t.getPageNo();
    	int pageSize=t.getPageSize();
		pageNo = pageNo == 0?1:pageNo;
		pageSize = pageSize == 0?10:pageSize;
		PageHelper.startPage(pageNo,pageSize); 
		return PageResult.toPageResult(getPage(entity),t);
	}
    
   
    @Override
    public List<T> getPageFront(T obj){
        List<T> list = null;
        try {
            list = getMapper().getPageFront(obj);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return list;
    }
    
    @Override
	public PageResult<T> queryByPageFront(PageResult<T> t,T entity) {
    	int pageNo=t.getPageNo();
    	int pageSize=t.getPageSize();
		pageNo = pageNo == 0?1:pageNo;
		pageSize = pageSize == 0?10:pageSize;
		PageHelper.startPage(pageNo,pageSize); 
		return PageResult.toPageResult(getPageFront(entity),t);
	}
    
}
