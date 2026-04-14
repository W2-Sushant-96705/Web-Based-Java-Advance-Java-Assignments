package com.sunbeam.assignment04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SenderComponentApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SenderComponentApplication.class, args);
	}

	@Autowired
	private ApplicationContext ctx;
	
	@Override
	public void run(String... args) throws Exception {
		TcpSender ts = ctx.getBean(TcpSender.class);
		ts.send(200);

		HttpSender hs = ctx.getBean(HttpSender.class);
		hs.send(300);
		
		UdpSender us = ctx.getBean(UdpSender.class);
		us.send(400);
		
		Sender s = ctx.getBean(Sender.class);
		s.send(500);
	}

}
