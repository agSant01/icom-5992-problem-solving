/**
 * PasswordGenerator.test
 * Test.java
 * @date Feb 10, 2019
 * @author Gabriel S. Santiago
 */
package test;

import java.util.Scanner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import main.PasswordGenerator;

/**
 * @author Gabriel S. Santiago
 * @date Feb 10, 2019
 *
 */
public class Test {
	public static void main(String[] args) {
		String filepath = "../Passwords.txt";
		Scanner website =new Scanner(System.in);
		
		print("Please enter the url for the webiste you would like to create a password for: ");
		
		String url = website.next();
		
		print("Please enter the username you would like to use:  ");
		
		String userName = website.next();
		
		PasswordGenerator generator = new PasswordGenerator(userName, url);
		generator.setInvalidCahracterRegex(",L-");
		
		String pass = generator.generatePassword();
		
		print("For "+url+ ", you have chosen your username to be "+userName+". The secure password that was generated for you is: "+pass);
		print("It's length is : " + pass.length());
		
		String info = "\n\t\t "+url+"\n Username: "+userName+"\t Passcode: "+ pass;
		appendUsingFileWriter(filepath, info);
	}
		private static void appendUsingFileWriter(String filePath, String text) {
			File file = new File(filePath);
			FileWriter fr = null;
			try {
				// Below constructor argument decides whether to append or override
				fr = new FileWriter(file, true);
				fr.write(text);

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	
	public static void print(Object o) {
		System.out.println(o.toString());
	}
}
