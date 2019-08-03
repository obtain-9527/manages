package com.company.manage.dao.mapping;

import com.company.manage.dao.inter.Employee;
import org.apache.ibatis.annotations.Delete;

import java.util.HashMap;

public interface EmpMaping {
    public void insertUser(Employee employee);
    public void updatetUser(Employee employee);
    @Delete("delete from employee where empNumber = #{id}")
    public void deteleUser(Long id);
    public Employee findOne(HashMap map);
}
