package com.example.springkadaiform.form;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContactForm {
	
	@NotBlank(message = "名前を入力してください。")
	private String name;
	@NotBlank@Email(message = "メールアドレスの入力形式が正しくありません。")
	private String email;
	@NotBlank(message = "お問い合わせ内容を入力してください。")
	private String message;
	
}
