package com.adson.aplimc.services;

import org.springframework.mail.SimpleMailMessage;

import com.adson.aplimc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}


