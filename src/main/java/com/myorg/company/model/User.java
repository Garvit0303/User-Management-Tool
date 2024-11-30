package com.myorg.company.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "USER_TABLE")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private long uId;

    @Column(name = "user_name")
    private String uName;

    @Column(name = "user_contact_no")
    private String uContactNo;

    @Column(name = "user_email")
    private String uEmail;

    @Column(name = "user_role")
    private String uRole;

    @Column(name = "password")
    private String password;

    public User() {
    }

    public User(String uName, String uContactNo, String uEmail, String uRole, String password) {
        this.uName = uName;
        this.uContactNo = uContactNo;
        this.uEmail = uEmail;
        this.uRole = uRole;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId='" + uId + '\'' +
                ", uName='" + uName + '\'' +
                ", uContactNo='" + uContactNo + '\'' +
                ", uEmail='" + uEmail + '\'' +
                ", uRole='" + uRole + '\'' +
                '}';
    }
}
