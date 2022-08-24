package com.project.Java_Project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "registration", uniqueConstraints = @UniqueConstraint(columnNames = ("student_email")))
public class Registration {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long student_id;

    @Column(name = "student_name")
    private String student_name;

    @Column(name = "student_address")
    private String student_address;

    @Column(name = "student_email")
    private String student_email;

    @Column(name = "student_password")
    private String student_password;

    @Column(name = "course_name")
    private String course_name;

    //private Collection<User> users;

    public Registration(String student_name, String student_address, String student_email, String student_password,
            String course_name) {
        this.student_name = student_name;
        this.student_address = student_address;
        this.student_email = student_email;
        this.student_password = student_password;
        this.course_name = course_name;
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_address() {
        return student_address;
    }

    public void setStudent_address(String student_address) {
        this.student_address = student_address;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getStudent_password() {
        return student_password;
    }

    public void setStudent_password(String student_password) {
        this.student_password = student_password;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
}
