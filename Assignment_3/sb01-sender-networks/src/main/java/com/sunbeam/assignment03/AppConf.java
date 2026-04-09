package com.sunbeam.assignment03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConf {

	
	@Primary
	@Bean
	public HttpSender httpSender() {
		HttpSender hs = new HttpSender();
		return hs;
	}
	
	@Bean
	public TcpSender tcpSender() {
	TcpSender ts = new TcpSender();
	return ts;
	}
	
	@Bean
	public UdpSender udpSender() {
		UdpSender us = new UdpSender();
		return us;
	}
}
