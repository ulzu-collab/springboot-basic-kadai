package com.example.samuraitravel.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.samuraitravel.entity.House;
import com.example.samuraitravel.entity.Review;
import com.example.samuraitravel.entity.User;



public interface ReviewRepository extends JpaRepository<Review, Integer> {

    // ① 特定の民宿に対する最新のレビュー6件を取得
    public List<Review> findTop6ByHouseOrderByCreatedAtDesc(House house);

    // ② 特定の民宿とユーザーに紐づくレビューを取得
    public Review findByHouseAndUser(House house, User user);

    // ③ 特定の民宿に対するレビュー総数をカウント
    public long countByHouse(House house);

    // ④ 特定の民宿に関するレビューを作成日時の降順で取得（ページネーション対応）
    public Page<Review> findByHouseOrderByCreatedAtDesc(House house, Pageable pageable);
}