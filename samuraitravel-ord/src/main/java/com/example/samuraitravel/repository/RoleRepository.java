package com.example.samuraitravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.samuraitravel.entity.Role;

// JpaRepository インターフェースを継承するだけで基本的なCRUD操作を行うメソッドが利用可能になる。
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
