package com.example.ComplaintReg_backend.model;


import jakarta.persistence.*;

@Entity
@Table(name = "complaints")
public class ComplaintModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="CUST_SEQ")
    private int id;
    private int userId;
    private String complaint;

    public ComplaintModel() {
    }

    public ComplaintModel(int id, int userId, String complaint) {
        this.id = id;
        this.userId = userId;
        this.complaint = complaint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }
}
