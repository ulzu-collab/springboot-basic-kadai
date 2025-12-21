package com.example.spring_kadai_todo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring_kadai_todo.entity.ToDo;

//JpaRepositoryはSpring Data JPAが提供するリポジトリ実装用インターフェース。継承するだけでCRUD機能を利用できる。
public interface ToDoRepository extends JpaRepository<ToDo, Integer> {
    // ユーザー名で完全一致検索
    Optional<ToDo> findById(Integer id);
}