package com.prode.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "MAIL")
    private String mail;

    @Column(name = "AVATAR")
    private String avatar;

    @Column(name = "ROLE_ADMIN")
    private boolean roleAdmin;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @JsonIgnore
    private Set<MatchUser> myMatchUsers;


    public User() {
    }

    public User(String name, String mail, String avatar, boolean roleAdmin) {
        this.name = name;
        this.mail = mail;
        this.avatar = avatar;
        this.roleAdmin = roleAdmin;
    }

    public User(String name, String mail, boolean roleAdmin, String avatar) {
        this.name = name;
        this.mail = mail;
        this.avatar = avatar;
        this.roleAdmin = roleAdmin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isRoleAdmin() {
        return roleAdmin;
    }

    public void setRoleAdmin(boolean roleAdmin) {
        this.roleAdmin = roleAdmin;
    }

    public Set<MatchUser> getMyMatchUsers() {
        return myMatchUsers;
    }

    public void setMyMatchUsers(Set<MatchUser> myMatchUsers) {
        this.myMatchUsers = myMatchUsers;
    }
}
