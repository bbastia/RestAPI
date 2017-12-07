package org.biswajit.data.entities;

import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class Test {
	public static void main(String[] args) {
		StandardPasswordEncoder encoder=new StandardPasswordEncoder();
		String pass="password@123";
		String enodedPass=encoder.encode(pass);
		System.out.println(enodedPass);
		
	}
}
