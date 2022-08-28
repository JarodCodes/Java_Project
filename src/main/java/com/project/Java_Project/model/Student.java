package com.project.Java_Project.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "student", uniqueConstraints = @UniqueConstraint(columnNames = ("email")))
public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long studentid;

    public String studentname;


    public String studentaddress;

    public String email;

    public String studentpassword;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "coursestud",
        joinColumns = @JoinColumn(name = "studid" , referencedColumnName = "studentid"),
        inverseJoinColumns = @JoinColumn(name = "courseid" , referencedColumnName = "id")
    )
    
    public Collection<Course> coursestud;

    public Student() {
        
    }

    public Student(String studentname, String studentaddress, String email, String studentpassword, Collection<Course> coursestud) {
        this.studentname = studentname;
        this.studentaddress = studentaddress;
        this.email = email;
        this.studentpassword = studentpassword;
        this.coursestud = coursestud;
    } 

    

    public Collection<Course> getCourse() {
        return coursestud;
    }

    public void setCourse(Collection<Course> coursestud) {
        this.coursestud = coursestud;
    }
    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public String getStudentaddress() {
        return studentaddress;
    }

    public void setStudentaddress(String studentaddress) {
        this.studentaddress = studentaddress;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getStudentpassword() {
        return studentpassword;
    }

    public void setStudentpassword(String studentpassword) {
        this.studentpassword = studentpassword;
    }
}
