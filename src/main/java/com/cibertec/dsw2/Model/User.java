package com.cibertec.dsw2.Model;

import javax.persistence.*;

@SequenceGenerator(name="seq_user_id", initialValue=1)
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user_id")
    @Column(name = "num_user_id")
    private Long num_user_id;

    @Column(name = "str_username")
    private String str_username;

    @Column(name = "str_password")
    private String str_password;

    @Column(name = "num_customer_id")
    private String num_customer_id;

    @Column(name = "chr_status")
    private String chr_status;

    public User() {
    }

    public User(String str_username, String str_password, String num_customer_id, String chr_status) {
        this.str_username = str_username;
        this.str_password = str_password;
        this.num_customer_id = num_customer_id;
        this.chr_status = chr_status;
    }

    @Override
    public String toString() {
        return "User{" +
                "num_user_id=" + num_user_id +
                ", str_username='" + str_username + '\'' +
                ", str_password='" + str_password + '\'' +
                ", num_customer_id='" + num_customer_id + '\'' +
                ", chr_status='" + chr_status + '\'' +
                '}';
    }

    public Long getNum_user_id() {
        return num_user_id;
    }

    public void setNum_user_id(Long num_user_id) {
        this.num_user_id = num_user_id;
    }

    public String getStr_username() {
        return str_username;
    }

    public void setStr_username(String str_username) {
        this.str_username = str_username;
    }

    public String getStr_password() {
        return str_password;
    }

    public void setStr_password(String str_password) {
        this.str_password = str_password;
    }

    public String getNum_customer_id() {
        return num_customer_id;
    }

    public void setNum_customer_id(String num_customer_id) {
        this.num_customer_id = num_customer_id;
    }

    public String getChr_status() {
        return chr_status;
    }

    public void setChr_status(String chr_status) {
        this.chr_status = chr_status;
    }
}
