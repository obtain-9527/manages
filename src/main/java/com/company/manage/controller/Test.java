package com.company.manage.controller;

import com.company.manage.dao.inter.Admin;
import com.company.manage.dao.getSession.Session;
import com.company.manage.dao.inter.EmpInfo;
import com.company.manage.dao.mapping.EmInfo;
import com.company.manage.util.JsonResult;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.Date;


public class Test {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    static {
        try {
            reader = Resources.getResourceAsReader("config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JsonResult getAdmin() {
        SqlSession session = Session.getSession();
        String state = "com.company.manage.dao.getAdmin";//getName为id唯一家n
        Admin admin = session.selectOne(state, 1);//创建查询
        Session.sqlClost(session);
        return JsonResult.ok(admin);
    }
    public static void main(String[] arr){
        Date data =new Date();

        try {
            SqlSession session = sqlSessionFactory.openSession();
            EmInfo Registry = session.getMapper(EmInfo.class);
            EmpInfo empInfo = new EmpInfo();
            empInfo.setEmpinfoName("xianshi");
            empInfo.setEmpAddress("贵阳");
            empInfo.setEmpAge(21);
            empInfo.setEmpDepmentName("总经理");
            empInfo.setEmpinfoTel("18846055231");
            empInfo.setEmpSex("男");
            empInfo.setEmpMoney("3000");
            empInfo.setEmpRegdata(data);
            Registry.insertDate(empInfo);
            session.commit();
            System.out.println("After insert");
        }catch (Exception e){
            e.printStackTrace();
        }


    }


}
