package com.dubovskiy.movc.entity;

import org.hibernate.validator.constraints.NotEmpty;
import sun.nio.cs.Surrogate;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by mikhail on 22.09.14.
 */

@Entity
@Table(name = "User")
public class User {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;

@NotEmpty @Size(min=3,max = 10)
private String name;

@NotNull
@Min(1) @Max(100)
private int age;

private Boolean isAdmin;

@Temporal(TemporalType.TIMESTAMP)
private Date createdDate;

    public User() {
        this.createdDate= new Date();
        this.isAdmin =  false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
