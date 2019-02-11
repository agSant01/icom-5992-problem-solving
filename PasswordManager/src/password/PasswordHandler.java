package password;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import models.Password;

public class PasswordHandler {
	private static final String FILE_NAME = "udsxji89.txt";
	private File file = new File(FILE_NAME);

	public PasswordHandler() {
		if (!this.file.exists())
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	public ArrayList<Password> getPasswords() {
		ArrayList<Password> passwords = new ArrayList<>();
		String[] data;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			while (line != null) {
				if (line.length() == 0)
					break;
				
				data = line.split("`~` ");
				passwords.add(new Password(data[0], data[1], data[2]));
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return passwords;
	}
	
	public void savePassword(Password password) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			
			String toWrite = password.getPassword() + "`~` " 
			+ password.getUsername() + "`~` "
			+ password.getWebsite() + "\n";
			
			writer.write(toWrite);
			
			writer.close();			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
