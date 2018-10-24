package com.lei.encryptor;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JasyptEncryptor {
	
	@Autowired
	private StringEncryptor encryptor;
	
	
	@Test
	public void getPass() {
	    String name = encryptor.encrypt("userName");
	    String password = encryptor.encrypt("password");
	    System.out.println(name + "----------------");
	    System.out.println(password + "----------------");
	    
	    String encryptName = encryptor.decrypt(name);
	    System.out.println(encryptName);
	}
}
