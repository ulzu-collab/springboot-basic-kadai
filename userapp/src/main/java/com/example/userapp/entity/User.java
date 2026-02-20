package com.example.userapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity		//このクラスがDBのテーブルになるという宣言。
public class User {

    @Id		//主キー（行を一意に識別するID）。
    @GeneratedValue(strategy = GenerationType.IDENTITY)	//IDを自動的に割り振られるようにする。
    private Long id;

    @Column(nullable = false)		//nullの時にfalseにして、空白を許さないようにする。
    private String username;

    @Column(nullable = false)
    private String password;

    // --- Getter & Setter ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}