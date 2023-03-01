package com.gec.attendance.attendancesystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class ProxyTimeTable {

    @Id
    @GeneratedValue
    private int id;

    private Date date;

    private String absentTeacherUid;

    private String proxyTeacherUid;

    private String day;

    private String period;

    protected ProxyTimeTable(){}

    public ProxyTimeTable(Date date, String absentTeacherUid, String proxyTeacherUid, String day, String period) {
        this.date = date;
        this.absentTeacherUid = absentTeacherUid;
        this.proxyTeacherUid = proxyTeacherUid;
        this.day = day;
        this.period = period;
    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAbsentTeacherUid() {
        return absentTeacherUid;
    }

    public void setAbsentTeacherUid(String absentTeacherUid) {
        this.absentTeacherUid = absentTeacherUid;
    }

    public String getProxyTeacherUid() {
        return proxyTeacherUid;
    }

    public void setProxyTeacherUid(String proxyTeacherUid) {
        this.proxyTeacherUid = proxyTeacherUid;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "ProxyTimeTable{" +
                "id=" + id +
                ", date=" + date +
                ", absentTeacherUid='" + absentTeacherUid + '\'' +
                ", proxyTeacherUid='" + proxyTeacherUid + '\'' +
                ", day='" + day + '\'' +
                ", period='" + period + '\'' +
                '}';
    }
}
