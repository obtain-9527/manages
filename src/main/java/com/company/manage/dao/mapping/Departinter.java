package com.company.manage.dao.mapping;

import com.company.manage.dao.inter.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;

public interface Departinter {
    @Insert("insert into department(departName) values(#{departName})" )
    public void insertDate(Department department);
    @Delete("delete from department where departName = #{departName}")
    public void deleteData(Department department);
    @Update("update department set departName = #{updataData} where departName = #{original}")
    public void updataData(HashMap map);

    public List<Department> findData();//部门查询
}
