package healthclinicpro;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Person {

	private String name;
	private String password;
	private int age;
	private String gender;
	private String phoneNum;

	public Person() {
		name = null;
		password = null;
		age = 0;
		gender = null;
		phoneNum = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.length() <= 30) {
			this.name = name;
		} else {
			System.out.println("somthing wrong");
		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		boolean flag = checkRules(password);
		boolean regex = regex(password);
		if (flag == true && regex == true) {
			String hashedPass = getHash(password);
			this.password = hashedPass;
		} else {
			System.out.println("weak password or somthing wrong, try again");
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age <= 100) {
			this.age = age;
		} else {
			System.out.println("somthing wrong");
		}
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		if (gender.length() <= 6) {
			this.gender = gender;
		} else {
			System.out.println("somthing wrong");
		}
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		if (phoneNum.length() <= 10) {
			this.phoneNum = phoneNum;
		} else {
			System.out.println("somthing wrong");
		}
	}

	private static boolean checkRules(String password) {
		if (password.length() >= 8 && password.length() <= 25) {
			return true;
		}
		return false;
	}

	static String getHash(String password) {
		String result = "";

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			result = encode(md.digest(password.getBytes(StandardCharsets.UTF_8)));
		} catch (NoSuchAlgorithmException e) {
			System.out.println("the algorithm does not exist");
		}
		return result;
	}

	private static String encode(byte[] password) {
		return Base64.getUrlEncoder().encodeToString(password);
	}

	private boolean regex(String password) {

		String regex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).+";

		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);

		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}

	}

}
