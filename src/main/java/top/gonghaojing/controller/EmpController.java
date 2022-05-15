package top.gonghaojing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import top.gonghaojing.domain.Emp;
import top.gonghaojing.service.EmpServices;

import java.sql.ResultSet;
import java.util.List;

@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    EmpServices empServices;

    @PostMapping
    public Result insert(@RequestBody Emp emp){
        Result result = new Result(empServices.save(emp) ? Code.ADD_OK:Code.ADD_ERR, null, "添加");
        return result;
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id){
        Result result = new Result(empServices.delete(id) ? Code.DELETE_OK:Code.DELETE_ERR, null, "删除id为" + id);
        return result;
    }

    @PutMapping
    public Result update(@RequestBody Emp emp){
        Result result = new Result(empServices.update(emp) ? Code.UPDATE_OK:Code.UPDATE_ERR, null, "更新");
        return result;
    }

    @GetMapping("/{id}")
    public Result selectById(@PathVariable int id){
        Emp emp = empServices.selectById(id);
        Result result = new Result(emp != null ? Code.SELECT_OK:Code.SELECT_ERR, emp, "查询");
        return result;
    }

    @GetMapping
    public Result selectAll(){
        List<Emp> emp = empServices.select();
        Result result = new Result(emp.size() > 0 ? Code.SELECT_OK:Code.SELECT_ERR, emp, "查询到" + emp.size() + "条数据");
        return result;
    }
}
