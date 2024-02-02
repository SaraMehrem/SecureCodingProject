package healthclinicpro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Register {

	public boolean recordKeeperLogin(String name, String password) {

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("RecordKeeper.txt"));

			try {
				String line;
				while ((line = br.readLine()) != null) {
					String str[] = line.split(",");

					String realName = str[0];
					String realPassword = str[1];
					String hashedPass = Person.getHash(password);

					if (name.equals(realName) && realPassword.equals(hashedPass)) {
						return true;
					}

				}

			} finally {
				br.close();
			}
		} catch (IOException e) {
			System.out.println("something wrong");
		}
		return false;

	}

	public void docRegister() {
		Doctor dr = new Doctor();

		Scanner sc = new Scanner(System.in);

		while (dr.getName() == null) {

			System.out.println("enter doctor name");
			dr.setName(sc.next());

		}

		while (dr.getPassword() == null) {

			System.out.println("enter doctor password");
			dr.setPassword(sc.next());

		}

		while (dr.getPhoneNum() == null) {

			System.out.println("enter doctor phone number");
			dr.setPhoneNum(sc.next());

		}

		while (dr.getAge() == 0) {

			System.out.println("enter doctor age");
			dr.setAge(sc.nextInt());

		}

		while (dr.getGender() == null) {

			System.out.println("enter doctor gender");
			dr.setGender(sc.next());

		}

		System.out.println("Doctor added successfully");

		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter("Doctors.txt", true));

			try {

				bw.write(dr.getName() + ",");
				bw.write(dr.getPassword() + ",");
				bw.write(dr.getPhoneNum() + ",");
				bw.write(dr.getAge() + ",");
				bw.write(dr.getGender() + "\n");

			} finally {
				bw.close();
				sc.close();
			}
		} catch (IOException e) {
			System.out.println("something wrong");
		}

	}

	public void patRegister() {

		Patient pat = new Patient();

		Scanner sc = new Scanner(System.in);

		while (pat.getName() == null) {

			System.out.println("enter patient name");
			pat.setName(sc.next());

		}

		while (pat.getPassword() == null) {

			System.out.println("enter patient password");
			pat.setPassword(sc.next());

		}

		while (pat.getPhoneNum() == null) {

			System.out.println("enter patient phone number");
			pat.setPhoneNum(sc.next());

		}

		while (pat.getAge() == 0) {

			System.out.println("enter patient age");
			pat.setAge(sc.nextInt());

		}

		while (pat.getGender() == null) {

			System.out.println("enter patient gender");
			pat.setGender(sc.next());

		}

		System.out.println("Patient added successfully");

		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter("Patients.txt", true));

			try {
				bw.write(pat.getName() + ",");
				bw.write(pat.getPassword() + ",");
				bw.write(pat.getPhoneNum() + ",");
				bw.write(pat.getAge() + ",");
				bw.write(pat.getGender() + "\n");

			} finally {
				bw.close();
				sc.close();
			}
		} catch (IOException e) {
			System.out.println("something wrong");
		}

	}

}