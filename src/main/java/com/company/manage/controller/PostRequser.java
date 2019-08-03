package com.company.manage.controller;

import com.company.manage.dao.getSession.sqlSession;
import com.company.manage.dao.inter.Admin;
import com.company.manage.dao.getSession.Session;
import com.company.manage.dao.inter.Employee;
import com.company.manage.dao.inter.EmpInfo;
import com.company.manage.dao.mapping.EmInfo;
import com.company.manage.dao.mapping.EmpMaping;
import com.company.manage.util.random;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;

@RestController
public class PostRequser {
    private SqlSession  session;
    private SqlSession session1;
    @PostMapping("/admin/login")
    public boolean adminlogin(@RequestParam(value = "username", required = false) String username, @RequestParam(value = "password", required = false) String password, HttpServletResponse response){
        boolean flag = false;
        HashMap<String,String> map = new HashMap<String,String>();
        session = Session.getSession();
        map.put("name",username);
        map.put("password",password);
        String state = "com.company.manage.dao.Login";//getName为id唯一家n
        Admin admin = session.selectOne(state,map);
        if(admin!=null){
            System.out.println(admin.getAdminName()+admin.getAdminPassword());
            flag = true;
        }
        Session.sqlClost(session);
        return flag;
    }
    @PostMapping("/login")
    @CrossOrigin(value = "*",allowedHeaders = "*")
    public boolean login( @RequestParam(value = "username", required = false) String username, @RequestParam(value = "password", required = false) String password, HttpServletResponse response){
        boolean flag = false;
        if(username == null || password == null){
            return  false;
        }
        String tolk = "188460552333333";
        HashMap<String,String> map = new HashMap<String,String>();
        try {
            session = sqlSession.getSqlSession();
            map.put("username", username);
            map.put("password", password);
            EmpMaping em = session.getMapper(EmpMaping.class);
            Employee employee = em.findOne(map);
            if (employee != null) {
                flag = true;
                Cookie cookie = new Cookie(username, tolk);
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }catch (Exception e){
            session.rollback();
        }finally {
            sqlSession.sesstionClose(session);
        }
        return flag;
    }
    @PostMapping("/register")
    @CrossOrigin(value = "*",allowedHeaders = "*")
    public boolean register(@RequestParam(value = "username", required = false) String username, @RequestParam(value = "password", required = false) String password,@RequestParam(value = "sex", required = false) String sex, @RequestParam(value = "age", required = false) int age,@RequestParam(value = "tel", required = false) String tel,
                            @RequestParam(value = "address", required = false) String address,@RequestParam(value = "depment", required = false) String depment){
        Date data =new Date();
        boolean flag = false;
        Long id = Long.parseLong(random.number());
        if(username==null || tel == null || address == null || age == 0 || sex == null || depment == null){
            return false;
        }
        try {
            session = sqlSession.getSqlSession();
            EmInfo Registry = session.getMapper(EmInfo.class);
            EmpInfo empInfo = new EmpInfo();
            empInfo.setEmpinfoName(username);
            empInfo.setEmpAddress(address);
            empInfo.setEmpAge(age);
            empInfo.setEmpDepmentName(depment);
            empInfo.setEmpinfoTel(tel);
            empInfo.setEmpSex(sex);
            empInfo.setEmpRegdata(data);
            empInfo.setEmpNumber(id);
            Registry.insertDate(empInfo);
            session.commit();
        }catch (Exception e){
            session.rollback();
        }finally {
            sqlSession.sesstionClose(session);
        }
        try{
            session = sqlSession.getSqlSession();
            EmpMaping empMaping = session.getMapper(EmpMaping.class);
            Employee employee = new Employee();
            employee.setEmpName(username);
            employee.setEmpPassword(password);
            employee.setEmpNumber(id);
            empMaping.insertUser(employee);
            session.commit();
            flag = true;
        }catch (Exception e){
            session.rollback();
        }finally {
            sqlSession.sesstionClose(session);
        }
        return flag;
    }

}
