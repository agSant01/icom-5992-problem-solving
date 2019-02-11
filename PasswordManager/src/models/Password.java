package models;

public class Password {
	private String password;
	private String username;
	private String website;
	
	public Password(String password, String username, String website) {
		this.password = password.trim();
		this.username = username.trim();
		this.website = website.trim();
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public String getWebsite() {
		return website;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Password [password=");
		builder.append(password);
		builder.append(", username=");
		builder.append(username);
		builder.append(", website=");
		builder.append(website);
		builder.append("]");
		return builder.toString();
	}
}
