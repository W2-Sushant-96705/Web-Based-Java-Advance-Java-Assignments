package com.sunbeam.assignment04;

import org.springframework.stereotype.Component;

@Component
public class UdpSender implements Sender{

	public void send(double value) {
		System.out.println("UdpSender: "+ value);
	}
}
