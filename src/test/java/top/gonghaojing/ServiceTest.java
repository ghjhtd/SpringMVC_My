package top.gonghaojing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.gonghaojing.config.SpringConfig;
import top.gonghaojing.dao.EmpDao;
import top.gonghaojing.domain.Emp;
import top.gonghaojing.service.EmpServices;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class ServiceTest {

    @Autowired
    private EmpServices empServices;

    @Autowired
    private EmpDao empDao;

    @Test
    public void Test01(){
        System.out.println(empServices.selectById(19));
    }

    @Test
    public void Test02(){
        List<Emp> list = empServices.select();
        list.forEach(ee -> System.out.println(ee));
    }

    @Test
    public void Test03(){
        Emp emp = new Emp();
        emp.setId(19);
        emp.setName("龚");
        emp.setAge(22);
        emp.setJob("不知道");
        emp.setSalary(1000);
        emp.setEntrydate(new Date());
        emp.setManagerid(2);
        emp.setDept_id(1);
        System.out.println(empServices.save(emp));
    }

    @Test
    public void Test04(){
        Emp emp = new Emp();
        emp.setId(19);
        emp.setName("龚皓靖");
        emp.setAge(22);
        emp.setJob("不知道");
        emp.setSalary(1000);
        emp.setEntrydate(new Date());
        emp.setManagerid(2);
        emp.setDept_id(1);
        System.out.println(empServices.update(emp));
    }

    @Test
    public void Test05(){
        System.out.println(empServices.delete(19));
    }
}
