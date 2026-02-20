package com.example.springtutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springtutorial.form.CalculatorForm;

@Controller
public class CalculatorController {

    // GET：フォーム表示
    @GetMapping("/calculator")
    public String showForm(Model model) {
        model.addAttribute("calculaforForm", new CalculatorForm());
        return "calculator";
    }

    // POST：計算処理
    @PostMapping("/calculate")
    public String calculate(CalculatorForm form, Model model) {

        try {
            Integer num1 = form.getNum1();
            Integer num2 = form.getNum2();
            String operator = form.getOperator();

            Integer result = null;

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    // ゼロ除算チェック
                    if (num2 == 0) {
                        throw new ArithmeticException("ゼロ除算");
                    }
                    result = num1 / num2;
                    break;
                default:
                    throw new IllegalArgumentException("不正な演算子");
            }

            model.addAttribute("result", result);

        } catch (Exception e) {
            // 例外発生時のエラーメッセージ
            model.addAttribute("errorMessage", "正しく計算できませんでした。");
        }

        // 入力値を保持したままビューへ返す
        model.addAttribute("calculaforForm", form);

        return "calculator";
    }
}