package healthclinicpro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Doctor extends Person {

	public boolean doctorLogin(String name, String password) {

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("Doctors.txt"));

			try {
				String line;
				while ((line = br.readLine()) != null) {
					String str[] = line.split(",");

					String realName = str[0];
					String realPassword = str[1];

					String hashedPass = getHash(password);

					if (name.equals(realName) && hashedPass.equals(realPassword)) {
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

	public void doctorInfo(String name) {

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("Doctors.txt"));

			try {
				String line;
				while ((line = br.readLine()) != null) {
					String str[] = line.split(",");

					if (name.equals(str[0])) {

						System.out.println("Name: " + str[0]);
						System.out.println("Phone Number: " + str[2]);
						System.out.println("Age: " + str[3]);
						System.out.println("Gender: " + str[4]);

					}

				}

			} finally {
				br.close();
			}
		} catch (IOException e) {
			System.out.println("something wrong");
		}

	}

	public void enterMedicalInfo() {

		Patient p = new Patient();

		Scanner sc = new Scanner(System.in);

		while (p.getName() == null) {

			System.out.println("enter patient name");
			p.setName(sc.next());
		}

		while (p.getMedicalSituation() == null) {

			System.out.println("enter medical situation");
			p.setMedicalSituation(sc.next());

		}

		while (p.getMedicalTreatment() == null) {

			System.out.println("enter medical treatment");
			p.setMedicalTreatment(sc.next());

		}

		BufferedWriter bw = null;

		try {
			bw = new BufferedWriter(new FileWriter("MedicalInfo.txt", true));

			try {
				bw.write(p.getName() + ",");
				bw.write(p.getMedicalSituation() + ",");
				bw.write(p.getMedicalTreatment() + ",");
				System.out.println();

			} finally {
				bw.close();
				sc.close();
			}
		} catch (IOException e) {
			System.out.println("something wrong");
		}

		System.out.println("added successfully");

	}

}
