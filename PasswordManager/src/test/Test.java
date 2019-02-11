/**
 * PasswordGenerator.test
 * Test.java
 * @date Feb 10, 2019
 * @author Gabriel S. Santiago
 */
package test;

import password.PasswordGenerator;;

/**
 * @author Gabriel S. Santiago
 * @date Feb 10, 2019
 *
 */
public class Test {
	public static void main(String[] args) {
		PasswordGenerator generator = new PasswordGenerator("agSav-nt01", "facebook.com");
		generator.setInvalidCahracterRegex(",L-");
		String pass = generator.generatePassword();
		
		print("Password: " + pass);
		print("Length: " + pass.length());
	}
	
	public static void print(Object o) {
		System.out.println(o.toString());
	}
}
