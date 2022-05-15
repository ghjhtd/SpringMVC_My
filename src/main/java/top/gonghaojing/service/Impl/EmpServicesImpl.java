package top.gonghaojing.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.gonghaojing.controller.Code;
import top.gonghaojing.dao.EmpDao;
import top.gonghaojing.domain.Emp;
import top.gonghaojing.exception.BusinessException;
import top.gonghaojing.exception.SystemException;
import top.gonghaojing.service.EmpServices;

import java.util.List;

@Service
public class EmpServicesImpl implements EmpServices {

    @Autowired
    EmpDao empDao;

    @Override
    public boolean save(Emp emp) {
        boolean b;
        try{
            b = empDao.add(emp) > 0 ? true : false;
        }catch (Exception e){
            throw new SystemException(Code.SYSTEM_ERR, e.getMessage());
        }
        return b;
    }

    @Override
    public boolean delete(Integer id) {
        if(id < 0){
            throw new BusinessException(Code.BUSINESS_ERR, "id输入错误");
        }
        boolean b;
        try{
            b = empDao.delete(id) > 0 ? true : false;
        }catch (Exception e){
            throw new SystemException(Code.SYSTEM_ERR, e.getMessage());
        }
        return b;
    }

    @Override
    public boolean update(Emp emp) {
        boolean b;
        try{
            b =  empDao.update(emp) > 0 ? true : false;
        }catch (Exception e){
            throw new SystemException(Code.SYSTEM_ERR, e.getMessage());
        }
        return b;
    }

    @Override
    public Emp selectById(Integer id) {
        if(id < 0){
            throw new BusinessException(Code.BUSINESS_ERR, "id输入错误");
        }
        Emp emp;
        try{
            emp =  empDao.selectById(id);
        }catch (Exception e){
            throw new SystemException(Code.SYSTEM_ERR, e.getMessage());
        }
        return emp;
    }

    @Override
    public List<Emp> select() {
        List<Emp> list;
        try{
             list = empDao.select();
        }catch (Exception e){
            throw new SystemException(Code.SYSTEM_ERR, e.getMessage());
        }
        return list;
    }
}
