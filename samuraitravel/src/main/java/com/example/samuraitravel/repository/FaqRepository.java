package com.example.samuraitravel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.samuraitravel.entity.Faq;

public interface FaqRepository extends JpaRepository<Faq, Integer> {
    // 質問文による部分一致検索（ページネーション対応）
    public Page<Faq> findByQuestionLike(String keyword, Pageable pageable);
}