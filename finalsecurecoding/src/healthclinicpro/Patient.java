package healthclinicpro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Patient extends Person {

	private String medicalSituation;
	private String medicalTreatment;

	public String getMedicalSituation() {
		return medicalSituation;
	}

	public void setMedicalSituation(String medicalSituation) {
		if (medicalSituation.length() <= 100) {
			this.medicalSituation = medicalSituation;
		} else {
			System.out.println("somthing wrong, try again");
		}
	}

	public String getMedicalTreatment() {
		return medicalTreatment;
	}

	public void setMedicalTreatment(String medicalTreatment) {
		if (medicalTreatment.length() <= 100) {
			this.medicalTreatment = medicalTreatment;
		} else {
			System.out.println("somthing wrong, try again");
		}
	}

	public boolean patientLogin(String name, String password) {

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("Patients.txt"));

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

	public void patientInfo(String name) {

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("Patients.txt"));

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

	public void medicalInfo(String name) {

		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader("MedicalInfo.txt"));

			try {
				String line;
				while ((line = br.readLine()) != null) {
					String str[] = line.split(",");

					if (name.equals(str[0])) {

						System.out.println("Medical Situation: " + str[1]);
						System.out.println("Medical Treatment: " + str[2]);

					}

				}

			} finally {
				br.close();
			}
		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
