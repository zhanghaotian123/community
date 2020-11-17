package com.nowcoder.community;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages ={ "com.nowcoder.community.controller","com.nowcoder.community.service","com.nowcoder.community.dao","com.nowcoder.community.util"})
public class CommunityApplication {

	public static void main(String[] args) {//***********
		SpringApplication.run(CommunityApplication.class, args);
		System.out.print("sdffffffffffffffffffffffffffffff");
	}

}
