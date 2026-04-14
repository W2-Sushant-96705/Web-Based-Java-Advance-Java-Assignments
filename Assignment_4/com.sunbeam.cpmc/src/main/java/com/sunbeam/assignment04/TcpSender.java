package com.sunbeam.assignment04;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component 
public class TcpSender implements Sender{
	
	
	public void send(double value) {
		System.out.println("TcpSender: "+ value);
	}

}
