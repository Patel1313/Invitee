package com.bb.invitee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InviteeApplication {

	public static void main(String[] args) {
		SpringApplication.run(InviteeApplication.class, args);
		System.out.println("Invitee Project Started....");	
		System.out.println("Running at : http://localhost:5000");
		
//        try {
//            Properties properties = new Properties();
//            InputStream inputStream = InviteeApplication.class.getClassLoader().getResourceAsStream("application.properties");
//            properties.load(inputStream);
//            String serverPort = properties.getProperty("server.port");
//            System.out.println("Running at : http://localhost:"+serverPort);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
	}
}
