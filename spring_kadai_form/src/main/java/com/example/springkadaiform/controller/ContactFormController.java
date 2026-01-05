package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

import jakarta.validation.Valid;

@Controller
public class ContactFormController {

    // 入力画面表示
    @GetMapping("/form")
    public String showForm(@ModelAttribute("contactForm") ContactForm form) {
        return "contactFormView";
    }
    
    // 確認画面へ
    @PostMapping("/form/confirm")
    public String confirm(
    		@Valid ContactForm form,
    		BindingResult bindingResult,
    		RedirectAttributes redirectAttributes,
    		Model model) {
    	
    	// バリデーションエラーがあれば入力画面に戻す
    	if (bindingResult.hasErrors()) {
    		// 入力値とエラー情報をフラッシュ属性に保存
    		redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.contactForm", bindingResult);
    		redirectAttributes.addFlashAttribute("contactForm", form);
    		return "contactFormView";
    		
    	}
    	
    	// 入力内容を確認画面へ渡す
    	model.addAttribute("contactForm", form);
    	return "confirmView";
    }

}