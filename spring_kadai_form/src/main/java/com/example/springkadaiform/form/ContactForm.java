package com.example.springkadaiform.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ContactForm {

    @NotBlank(message = "お名前を入力してください。")
    private String name;

    @Email(message = "メールアドレスの入力形式が正しくありません。")
    @NotBlank(message = "メールアドレスを入力してください。")
    private String email;

    @NotBlank(message = "お問い合わせ内容を入力してください。")
    @Size(max = 500, message = "お問い合わせ内容は500文字以内で入力してください。")
    private String content;

    // --- Getter / Setter ---

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}