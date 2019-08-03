package com.company.manage.dao.mapping;

import com.company.manage.dao.inter.EmpInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.HashMap;
import java.util.List;

public interface EmInfo {
    public void insertDate(EmpInfo empInfo);

    @Delete("delete from empinfo where empNumber = #{empNumber}")
    public void deleteData(Long empNumber);
    @Update("update empinfo set empMoney = #{money} where empNumber = #{number} and empInfoName = #{name}")
    public void updataData(HashMap map);

    public List<EmpInfo> findData();
    @Select("select * from empinfo where empDepmentName = #{departName}")
    public List<EmpInfo> departFindData(String departName);
}
