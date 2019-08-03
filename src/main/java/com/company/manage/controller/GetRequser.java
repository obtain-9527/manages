package com.company.manage.controller;

import com.company.manage.controller.imp.DeaprtmentImp;
import com.company.manage.controller.imp.EmpIfonImp;
import com.company.manage.controller.imp.EmployeeImp;
import com.company.manage.dao.getSession.sqlSession;
import com.company.manage.dao.inter.Department;
import com.company.manage.dao.inter.EmpInfo;
import com.company.manage.dao.mapping.EmInfo;
import com.company.manage.util.JsonResult;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetRequser {
        private DeaprtmentImp departmentImp = new DeaprtmentImp();
        private EmpIfonImp empIfonImp = new EmpIfonImp();
        private EmployeeImp employeeImp = new EmployeeImp();
        private SqlSession session;
        @RequestMapping("/empinfo")
        @CrossOrigin(value = "*",allowedHeaders = "*")
        public JsonResult getEmpInfos(){
            List<EmpInfo> list = null;
            try{
                session = sqlSession.getSqlSession();
                EmInfo emInfo = session.getMapper(EmInfo.class);
                list = emInfo.findData();
            }catch (Exception e){
                return JsonResult.ok("错误!");
            }finally {
                sqlSession.sesstionClose(session);
            }
            return JsonResult.ok(list);
        }
        /*
            部门相关get请求
         */
        //查
        @RequestMapping("/departname")
        @CrossOrigin(value = "*",allowedHeaders = "*")
        public JsonResult getDepartName() {
            List<Department> list = null;
            list = departmentImp.findDepart();
            return JsonResult.ok(list);
        }
        //改
        @RequestMapping("/updatadepartment")
        @CrossOrigin(value = "*",allowedHeaders = "*")
        public int updataDepart(@RequestParam(value = "original",required = false) String departName,@RequestParam(value = "updata",required = false) String updataData){
            int flag = 0;
            flag = departmentImp.updataDepart(departName,updataData);
            return flag;
        }
        //add
        @RequestMapping("/adddepartment")
        @CrossOrigin(value = "*",allowedHeaders = "*")
        public int addPartment(@RequestParam(value = "departname",required = false) String departName){
            int flag = 0;
            flag = departmentImp.addDepart(departName);
            return flag;
        }
        //del
        @RequestMapping("/deldepartment")
        @CrossOrigin(value = "*",allowedHeaders = "*")
        public int delPartment(@RequestParam(value = "departname",required = false) String departName){
            int flag = 0;
            flag = departmentImp.delDepart(departName);
            return flag;
        }
        /*
        部门+员工部门查询
        */
        @RequestMapping("/departname/empinfo")
        @CrossOrigin(value = "*",allowedHeaders = "*")
        public  JsonResult getDepartEmp(@RequestParam(value = "departname",required = false) String departName){
            List<EmpInfo> list = null;
            try {
                session = sqlSession.getSqlSession();
                EmInfo emInfo = session.getMapper(EmInfo.class);
                list = emInfo.departFindData(departName);
            }catch (Exception e){
                return JsonResult.ok("错误！");
            }finally {
                sqlSession.sesstionClose(session);
            }
            return JsonResult.ok(list);
    }
     @RequestMapping("/delempinfo")
     @CrossOrigin(value = "*",allowedHeaders = "*")
     public int delInfo(@RequestParam(value = "number",required = false) Long number){
            int flag = 0;
            flag = empIfonImp.delEmpInfo(number);
            employeeImp.deleEmp(number);
            return flag;
     }
    @RequestMapping("/updatampinfo")
    @CrossOrigin(value = "*",allowedHeaders = "*")
    public int updataInfo(@RequestParam(value = "number",required = false) Long number,@RequestParam(value = "name",required = false) String  name,@RequestParam(value = "money",required = false) int money){
        int flag = 0;
        flag = empIfonImp.updataEmpInfo(name,number,money);
        return flag;
    }

    }
