package com.gec.attendance.attendancesystem.model;

import jakarta.persistence.*;

@Entity
public class Teacher {

    @Id
    private String uid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phoneNumber;

    public Teacher(String uid, String name, String phoneNumber) {
        this.uid = uid;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    protected Teacher(){}

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
