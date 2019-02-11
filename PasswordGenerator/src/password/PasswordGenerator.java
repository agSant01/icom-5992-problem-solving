/**
 * PasswordGenerator.main
 * PasswordGenerator.java
 * @date Feb 9, 2019
 * @author Gabriel S. Santiago
 */
package password;

import java.util.Date;
import java.util.Random;

/**
 * @author Gabriel S. Santiago
 * @date Feb 9, 2019
 *
 */
public class PasswordGenerator {		
	private static final int MIN_LENGTH = 8;
	private static final int MAX_LENGTH = 20;

	private String invalidCharacters = "";

	private String username;
	private String website;
	private int minLength;
	private int maxLength;
	private long time = new Date().getTime();

	/**
	 * Creates a PasswordGenerator instance
	 *
	 * @author Gabriel S. Santiago
	 */
	public PasswordGenerator(String username, String website) {
		this(username, website, MIN_LENGTH, MAX_LENGTH);
	}

	/**
	 * Creates a PasswordGenerator instance with custom MIN and MAX password lengths
	 *
	 * @author Gabriel S. Santiago
	 */
	public PasswordGenerator(String username, String website, int minLength, int maxLength) {
		this.username = username;
		this.website = website;
		this.minLength = minLength;
		this.maxLength = maxLength;
	}

	private long getValueOfString(String str) {
		long sum = 0;

		for (int i = 0; i < str.length(); i++)
			sum += Character.getNumericValue(str.charAt(i));

		return sum;
	}

	public void setInvalidCahracterRegex(String regex) {
		this.invalidCharacters = regex;
	}

	public String generatePassword() {
		String password = "";

		while (password.length() < minLength) {
			password = addCharacters(password);
			password = replace(password);
		}

		return password;
	}
	
	private String replace(String str) {
		for (int i = 0; i < invalidCharacters.length(); i++) {
			str = str.replace(String.valueOf(invalidCharacters.charAt(i)),"");
		}
		return str;
	}

	private String addCharacters(String pass) {
		StringBuilder password = new StringBuilder(pass);
		String charactersSeed = username + website;
		long charactersSeedValue = getValueOfString(charactersSeed);
		long charValue, temp;
		int characterSeedIterator = 0;
		
		long seed = charactersSeedValue * time;

		Random rand = new Random(seed);

		int numberOfCharacters = rand.nextInt(minLength) + maxLength - minLength - pass.length();

		for (int i = 0; i < numberOfCharacters; i++) {
			charValue = charactersSeed.charAt(characterSeedIterator);

			if (charValue % 2 == 0)
				characterSeedIterator += 1;
			else
				characterSeedIterator += 2;

			characterSeedIterator = characterSeedIterator % charactersSeed.length();
			temp = (charValue * charactersSeedValue * rand.nextInt(charactersSeed.length())) % 93 + 33;
			password.append((char) temp);
		}
				
		return password.toString();
	}
}
