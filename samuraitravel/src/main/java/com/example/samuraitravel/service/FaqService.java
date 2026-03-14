package com.example.samuraitravel.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.samuraitravel.entity.Faq;
import com.example.samuraitravel.repository.FaqRepository;

@Service
public class FaqService {
    private final FaqRepository faqRepository;

    // コンストラクタインジェクション
    public FaqService(FaqRepository faqRepository) {
        this.faqRepository = faqRepository;
    }

    // 全てのFAQデータを取得（ページネーション対応）
    public Page<Faq> getAllFaqs(Pageable pageable) {
        return faqRepository.findAll(pageable);
    }

    // キーワードに部分一致するFAQデータを検索（ページネーション対応）
    public Page<Faq> findAllFaqs(String keyword, Pageable pageable) {
        return faqRepository.findByQuestionLike("%" + keyword + "%", pageable);
    }
}