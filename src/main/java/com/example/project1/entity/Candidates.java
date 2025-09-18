package com.example.project1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Candidates {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String email;
    private String phone;
    private String current_status;
    private String resume_link;

    @Override
    public String toString() {
        return "Candidates{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", current_status='" + current_status + '\'' +
                ", resume_link='" + resume_link + '\'' +
                '}';
    }

    public Candidates(long id, String name, String email, String phone, String current_status, String resume_link) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.current_status = current_status;
        this.resume_link = resume_link;
    }

    public Candidates() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCurrent_status() {
        return current_status;
    }

    public void setCurrent_status(String current_status) {
        this.current_status = current_status;
    }

    public String getResume_link() {
        return resume_link;
    }

    public void setResume_link(String resume_link) {
        this.resume_link = resume_link;
    }
}
