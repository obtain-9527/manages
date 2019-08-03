package com.company.manage.dao.getSession;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class sqlSession {
    private static org.apache.ibatis.session.SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    private static SqlSession session;
    static {
        try {
            reader = Resources.getResourceAsReader("config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(){
         session = sqlSessionFactory.openSession();
        return session;
    }
    public static void sesstionClose(SqlSession session){
        if(session!=null){
            session.close();
        }else{
            System.out.println("session为控");
        }
    }

}
