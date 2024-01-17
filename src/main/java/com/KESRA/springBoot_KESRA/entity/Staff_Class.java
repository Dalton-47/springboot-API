package com.KESRA.springBoot_KESRA.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "staff_records")
public class Staff_Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emp_no;

    @Column(name = "first_name")
    private String first_name;

    @Column(name="second_name")
    private String second_name;

    @Column(name="department")
    private String department;

    @Column(name="wage")
    private Double wage;

    @Column(name="project_completion_rate")
    private Double project_completion_rate;

    public Staff_Class() {

    }

    public Staff_Class(String first_name, String second_name, String department, Double wage, Double project_completion_rate) {
        this.first_name = first_name;
        this.second_name = second_name;
        this.department = department;
        this.wage = wage;
        this.project_completion_rate = project_completion_rate;
    }

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }

    public Double getProject_completion_rate() {
        return project_completion_rate;
    }

    public void setProject_completion_rate(Double project_completion_rate) {
        this.project_completion_rate = project_completion_rate;
    }
}
