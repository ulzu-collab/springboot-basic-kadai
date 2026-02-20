package com.example.samuraitravel.event;

import java.util.UUID;

import org.springframework.context.event.EventListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.example.samuraitravel.entity.User;
import com.example.samuraitravel.service.VerificationTokenService;

@Component	// DIコンテナにインスタンスが登録される。
public class SignupEventListener {
	private final VerificationTokenService verificationTokenService;
	private final JavaMailSender javaMailSender;

	public SignupEventListener(VerificationTokenService verificationTokenService, JavaMailSender mailSender) {
		this.verificationTokenService = verificationTokenService;
		this.javaMailSender = mailSender;
	}

	@EventListener	// イベント発生時に実行され、どのイベントの発生時かの通知を受け付ける、Eventクラスを引数にする。
	private void onSignupEvent(SignupEvent signupEvent) {
		User user = signupEvent.getUser();
		String token = UUID.randomUUID().toString();	// トークンをUUID（ほぼ重複しないID）で生成する。
		verificationTokenService.create(user, token);

		String senderAddress = "springboot.samuraitravel@example.com";
		String recipientAddress = user.getEmail();
		String subject = "メール認証";
		String confirmationUrl = signupEvent.getRequestUrl() + "/verify?token=" + token;
		String message = "以下のリンクをクリックして会員登録を完了してください。";

		SimpleMailMessage mailMessage = new SimpleMailMessage();	// シンプルなメールメッセージをオブジェクトとして生成するクラス。
		mailMessage.setFrom(senderAddress);
		mailMessage.setTo(recipientAddress);
		mailMessage.setSubject(subject);
		mailMessage.setText(message + "\n" + confirmationUrl);
		javaMailSender.send(mailMessage);	// メールの送信処理を実行。send()の引数にオブジェクトを渡す。
	}
}