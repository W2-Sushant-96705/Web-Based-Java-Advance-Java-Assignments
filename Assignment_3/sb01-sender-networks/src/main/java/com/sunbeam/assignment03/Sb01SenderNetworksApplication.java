package com.sunbeam.assignment03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Sb01SenderNetworksApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Sb01SenderNetworksApplication.class, args);
	}

	@Autowired
	private ApplicationContext ctx;
	
	@Override
	public void run(String... args) throws Exception {
		HttpSender hs = ctx.getBean(HttpSender.class);
		hs.send(256.11);
		TcpSender ts = ctx.getBean(TcpSender.class);
		ts.send(200.11);
		UdpSender us = ctx.getBean(UdpSender.class);
		us.send(222.11);
		Sender s = ctx.getBean(Sender.class);
		s.send(300.11);
		
	}

}




//Error if @Primary is not used=




//[32m :: Spring Boot :: [39m             [2m (v3.5.13)[0;39m
//
//[2m2026-04-09T15:56:25.611+05:30[0;39m [32m INFO[0;39m [35m23560[0;39m [2m--- [sb01-sender-networks] [           main] [0;39m[36mc.s.a.Sb01SenderNetworksApplication     [0;39m [2m:[0;39m Starting Sb01SenderNetworksApplication using Java 21.0.6 with PID 23560 (D:\Sunbeam\Web-Based Java\Web-Based-Java Assignments\Assignment_3\sb01-sender-networks\target\classes started by SUSHANT in D:\Sunbeam\Web-Based Java\Web-Based-Java Assignments\Assignment_3\sb01-sender-networks)
//[2m2026-04-09T15:56:25.612+05:30[0;39m [32m INFO[0;39m [35m23560[0;39m [2m--- [sb01-sender-networks] [           main] [0;39m[36mc.s.a.Sb01SenderNetworksApplication     [0;39m [2m:[0;39m No active profile set, falling back to 1 default profile: "default"
//[2m2026-04-09T15:56:25.887+05:30[0;39m [32m INFO[0;39m [35m23560[0;39m [2m--- [sb01-sender-networks] [           main] [0;39m[36mc.s.a.Sb01SenderNetworksApplication     [0;39m [2m:[0;39m Started Sb01SenderNetworksApplication in 0.497 seconds (process running for 0.822)
//[2m2026-04-09T15:56:25.890+05:30[0;39m [32m INFO[0;39m [35m23560[0;39m [2m--- [sb01-sender-networks] [           main] [0;39m[36m.s.b.a.l.ConditionEvaluationReportLogger[0;39m [2m:[0;39m 
//
//Error starting ApplicationContext. To display the condition evaluation report re-run your application with 'debug' enabled.
//[2m2026-04-09T15:56:25.900+05:30[0;39m [31mERROR[0;39m [35m23560[0;39m [2m--- [sb01-sender-networks] [           main] [0;39m[36mo.s.b.d.LoggingFailureAnalysisReporter  [0;39m [2m:[0;39m 
//
//***************************
//APPLICATION FAILED TO START
//***************************
//
//Description:
//
//A component required a single bean, but 3 were found:
//	- httpSender: defined by method 'httpSender' in class path resource [com/sunbeam/assignment03/AppConf.class]
//	- tcpSender: defined by method 'tcpSender' in class path resource [com/sunbeam/assignment03/AppConf.class]
//	- udpSender: defined by method 'udpSender' in class path resource [com/sunbeam/assignment03/AppConf.class]
//
//This may be due to missing parameter name information
//
//Action:
//
//Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed
//
//Ensure that your compiler is configured to use the '-parameters' flag.
//You may need to update both your build tool settings as well as your IDE.
//(See https://github.com/spring-projects/spring-framework/wiki/Spring-Framework-6.1-Release-Notes#parameter-name-retention)
//
