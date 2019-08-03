package com.company.manage.dao.inter;


import java.math.BigInteger;
import java.util.Date;

public class EmpInfo {
    private int id;
    private  String empinfoName;
    private String empinfoTel;
    private  String empDepmentName;
    private  String empSex;
    private  int empAge;
    private  String empAddress;
    private  String empMoney;
    private Date empRegdata;
    private long empNumber;

    public long getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(long empNumber) {
        this.empNumber = empNumber;
    }

    public String getEmpinfoName() {
        return empinfoName;
    }

    public void setEmpinfoName(String empinfoName) {
        this.empinfoName = empinfoName;
    }

    public String getEmpinfoTel() {
        return empinfoTel;
    }

    public void setEmpinfoTel(String empinfoTel) {
        this.empinfoTel = empinfoTel;
    }

    public String getEmpDepmentName() {
        return empDepmentName;
    }

    public void setEmpDepmentName(String empDepmentName) {
        this.empDepmentName = empDepmentName;
    }

    public String getEmpSex() {
        return empSex;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex;
    }

    public int  getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmpMoney() {
        return empMoney;
    }

    public void setEmpMoney(String empMoney) {
        this.empMoney = empMoney;
    }

    public Date getEmpRegdata() {
        return empRegdata;
    }

    public void setEmpRegdata(Date empRegdata) {
        this.empRegdata = empRegdata;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
