package com.company.manage.controller.imp;

import com.company.manage.dao.getSession.sqlSession;
import com.company.manage.dao.inter.Department;
import com.company.manage.dao.mapping.Departinter;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

public class DeaprtmentImp {
    private SqlSession session;
    //添加
    public int addDepart(String departName){
        if(departName == null){
            return 110;
        }
        try{
            System.out.println("departName");
            session = sqlSession.getSqlSession();
            Departinter departinter  = session.getMapper(Departinter.class);
            Department department = new Department();
            department.setDepartName(departName);
            departinter.insertDate(department);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            return 500;
        }finally {
            sqlSession.sesstionClose(session);
        }
        return 200;
    }
    //删除
    public int delDepart(String departName){
        if(departName == null){
            return 110;
        }
        try{
            session = sqlSession.getSqlSession();
            Departinter departinter  = session.getMapper(Departinter.class);
            Department department = new Department();
            department.setDepartName(departName);
            departinter.deleteData(department);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            return 500;
        }finally {
            sqlSession.sesstionClose(session);
        }
        return 200;
    }
    public int updataDepart(String departName,String updataData){
        if(departName == null || updataData == null){
            return 110;
        }
        try {
            session = sqlSession.getSqlSession();
            HashMap<String,String> map = new HashMap<String,String>();
            map.put("updataData",updataData);
            map.put("original",departName);
            Departinter departinter = session.getMapper(Departinter.class);
            departinter.updataData(map);
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
            return 500;
        }finally {
            sqlSession.sesstionClose(session);
        }
        return 200;
    }
    public List findDepart(){
     List<Department> list = null;
     try {
            session = sqlSession.getSqlSession();
            Departinter departinter = session.getMapper(Departinter.class);
            list = departinter.findData();
        }catch (Exception e){
            Department department = new Department();
            department.setDepartName("错误！");
            department.setDepartId(0);
            list.add(department);
            return  list;
        }finally {
            sqlSession.sesstionClose(session);
        }
        return list;
    }

}
