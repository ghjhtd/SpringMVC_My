package top.gonghaojing.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import top.gonghaojing.domain.Emp;

import java.util.List;

public interface EmpDao {
    @Insert("insert into emp  values(#{id}, #{name}, #{age}, #{job}, #{salary}, #{entrydate}, #{managerid}, #{dept_id})")
    public int add(Emp emp);

    @Delete("delete from emp where id = #{id}")
    public int delete(Integer id);

    @Update("update emp set name = #{name}, age = #{age}, job = #{job}, salary = #{salary}, entrydate = #{entrydate}, managerid = #{managerid}, dept_id = #{dept_id} where id = #{id}")
    public int update(Emp emp);

    @Select("select * from emp where id = #{id}")
    public Emp selectById(Integer id);

    @Select("select * from emp")
    public List<Emp> select();
}
