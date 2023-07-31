package com.vti.entity;

public class User {
    private int id;
    private String fullName;
    private String email;
    private String password;
    private Integer expInYear;
    private String proSkill;
    private Integer projectId;
    private String role;

    public User(int id, String fullName, String email, String password, Integer expInYear, String proSkill, Integer projectIdFromDb, String role) {
    }

    public User(String fullName, String email, String password, Integer expInYear, String proSkill, Integer projectId, String role) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.expInYear = expInYear;
        this.proSkill = proSkill;
        this.projectId = projectId;
        this.role = role;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(Integer expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String toString() {
        return "User:" +
                "id=" + id +
                ", fullName='" + fullName +
                ", email='" + email +
                ", password='" + password +
                ", expInYear=" + expInYear +
                ", proSkill='" + proSkill +
                ", projectId=" + projectId +
                ", role='" + role +
                '}';
    }

}
