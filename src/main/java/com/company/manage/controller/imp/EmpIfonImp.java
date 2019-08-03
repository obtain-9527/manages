package com.company.manage.controller.imp;

import com.company.manage.dao.getSession.sqlSession;
import com.company.manage.dao.mapping.EmInfo;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;

public class EmpIfonImp {
    private SqlSession session;
    public int delEmpInfo(Long number){
        if(number == null || number == 0){
            return 110;
        }
        try {
            session = sqlSession.getSqlSession();
            EmInfo emInfo = session.getMapper(EmInfo.class);
            emInfo.deleteData(number);
            session.commit();
        }catch (Exception e){
            session.rollback();
            return 500;
        }finally {
            sqlSession.sesstionClose(session);
        }
        return 200;
    }
    public int updataEmpInfo(String name,Long number,int money){
        if(number==null||name==null||money==0||number==0){
            return 110;
        }
        try {
            session = sqlSession.getSqlSession();
            EmInfo emInfo = session.getMapper(EmInfo.class);
            HashMap map = new HashMap();
            map.put("money",money);
            map.put("number",number);
            map.put("name",name);
            emInfo.updataData(map);
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
