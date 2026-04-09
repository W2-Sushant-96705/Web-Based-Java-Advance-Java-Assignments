package com.sunbeam.assignment03;

public class UdpSender implements Sender{
	
	@Override
	public void send(double value) {
		System.out.println("UdpSender: "+ value);
	}
}
