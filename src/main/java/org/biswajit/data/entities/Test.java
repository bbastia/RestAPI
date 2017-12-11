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
//62301d626b351adbf5fac119e742657c2a043c47339c2936c4b8ceb038a9d07228c727a695e93dc0
//4e7d759bbc4898e56d129d48d1382b1784d9d8fd407cbd8ed144d8fb7e0b4288ca61ea2aab99be5a
//d7d5845923402fe247eb51010959fc95904c77d35b3692216083940869998c0bc87039a31b50198a
//31605a93fd2522d6afad9359f5ac6e006a6eef50d8cdafff0501cb3fb5abaaffcab1c34aa0d2dc8c