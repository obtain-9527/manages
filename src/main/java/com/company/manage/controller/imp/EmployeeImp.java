package com.company.manage.controller.imp;

import com.company.manage.dao.getSession.sqlSession;
import com.company.manage.dao.mapping.EmpMaping;
import org.apache.ibatis.session.SqlSession;

public class EmployeeImp {
    private SqlSession session;
    public int deleEmp(Long id){
        if(id == null){
            return 110;
        }
        try {
            session = sqlSession.getSqlSession();
            EmpMaping empMaping = session.getMapper(EmpMaping.class);
            empMaping.deteleUser(id);
            session.commit();
        }catch (Exception e){
            session.rollback();
            return 500;
        }finally {
            sqlSession.sesstionClose(session);
        }
        return 200;
    }
}
