package top.gonghaojing.service;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import top.gonghaojing.domain.Emp;

import java.util.List;


public interface EmpServices {
    public boolean save(Emp emp);

    public boolean delete(Integer id);

    public boolean update(Emp emp);

    public Emp selectById(Integer id);

    public List<Emp> select();
}
