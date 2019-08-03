package com.company.manage.dao.getSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Session {
    private static InputStream is;
    private static SqlSessionFactory sqlFaction;
    private static SqlSession session;
    static{
        try{
            String res = "config.xml";
            is = com.company.manage.dao.getSession.Session.class.getClassLoader().getResourceAsStream(res);
            sqlFaction = new SqlSessionFactoryBuilder().build(is);
            if(is != null){
                is.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
        public static SqlSession getSession() { ;
            session = sqlFaction.openSession();
            return session;
    }
    public static void sqlClost(SqlSession session){
        if(session!=null){
            session.close();
        }
    }
}
