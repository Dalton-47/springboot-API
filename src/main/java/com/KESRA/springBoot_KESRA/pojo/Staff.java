package com.KESRA.springBoot_KESRA.pojo;

import jakarta.persistence.*;
import lombok.Data;

@Entity//this annotation marks the class as a JPA entity for mapping java objects to database entities
@Table(name = "staff_records")
@Data
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long emp_no;

    @Column(name = "name")
    private String name;

    @Column(name="password")
    private String password;

    @Column(name="second_name")
    private String second_name;

    @Column(name="department")
    private String department;

    @Column(name="wage")
    private Double wage;

    @Column(name="roles")
    private String roles;

    @Column(name="project_completion_rate")
    private Double project_completion_rate;

    public Staff() {
        super();

    }

    public Staff(String name, String password, String second_name, String department, Double wage, String roles, Double project_completion_rate) {
       super();
        this.name = name;
        this.password = password;
        this.second_name = second_name;
        this.department = department;
        this.wage = wage;
        this.roles = roles;
        this.project_completion_rate = project_completion_rate;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public long getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(long emp_no) {
        this.emp_no = emp_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
