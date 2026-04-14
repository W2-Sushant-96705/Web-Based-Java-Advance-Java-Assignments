package com.sunbeam.assignment04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConf {

	
	TcpSender tcpSender() {
		TcpSender ts = new TcpSender();
		return ts;
	}
	HttpSender httpSender() {
		HttpSender hs = new HttpSender();
		return hs;
	}
	UdpSender UdpSender() {
		UdpSender us = new UdpSender();
		return us;
	}
	
}
