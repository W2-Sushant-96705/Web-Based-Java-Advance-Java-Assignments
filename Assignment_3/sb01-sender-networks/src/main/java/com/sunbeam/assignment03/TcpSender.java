package com.sunbeam.assignment03;

public class TcpSender implements Sender{
	
	@Override
	public void send(double value) {
		System.out.println("TcpSender: "+ value);
	}
	
	
}
