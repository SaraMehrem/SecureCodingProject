package healthclinicpro;

//HealthClinicPro

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {

			int choiceNum;
			
			System.out.println("HEALTH CLINIC PRO");
			System.out.println("Welcome To  HealthClinicPro");
			System.out.println("Choose According To Numbers");

			System.out.println("1. Registration Employee");
			System.out.println("2. Doctor");
			System.out.println("3. Patient");
			choiceNum = sc.nextInt();

			switch (choiceNum) {

			case 1:
				Register r = new Register();

				String name;
				String password;

				name = null;
				password = null;

				int count = 1;

				while (count <= 3) {

					System.out.println("enter your name");
					name = sc.next();
					MyLogger.writeToLog("the input of record keeper : " + name);

					System.out.println("enter your password");
					password = sc.next();
					MyLogger.writeToLog("the input of record keeper : " + password);

					boolean validate = r.recordKeeperLogin(name, password);
					if (validate) {

						System.out.println("Login Successfully");
						// while(true) { ////////////////////////////////////////////
						int registChoice;
						// sc = new Scanner(System.in);
						System.out.println("Choose According To Numbers");
						System.out.println("1. To register a doctor");
						System.out.println("2. To register a patient");
						registChoice = sc.nextInt();

						if (registChoice == 1) {
							r.docRegister();
							// break;
						} else if (registChoice == 2) {
							r.patRegister();
							// break;
						} else {
							System.out.println("invalid choice");
							// break;
						}
						// }

						break;
					} else {
						System.out.println("invalid name or password");
					}
					count++;
					if (count > 3) {
						System.out.println("lock your account");
						return;
					}
				}
				break;

			case 2:
				Doctor dr = new Doctor();

				String drName;
				String drPassword;

				int count2 = 1;

				while (count2 <= 3) {

					System.out.println("enter your name");
					drName = sc.next();
					MyLogger.writeToLog("the input od doctor: " + drName);

					System.out.println("enter your password");
					drPassword = sc.next();
					MyLogger.writeToLog("the input of doctor: " + drPassword);

					boolean drValidate = dr.doctorLogin(drName, drPassword);
					if (drValidate) {
						count2 = 1;
						System.out.println("Login Successfully");

						int drChoice;

						System.out.println("Choose According To Numbers");
						System.out.println("1. To view my information");
						System.out.println("2. To enter medical information");
						drChoice = sc.nextInt();

						if (drChoice == 1) {
							System.out.println("your information");
							dr.doctorInfo(drName);
							// break;
						} else if (drChoice == 2) {
							dr.enterMedicalInfo();
							// break;
						} else {
							System.out.println("invalid choice");
							// break;
						}
						break;

					} else {
						System.out.println("invalid name or password");
					}
					count2++;
					if (count2 > 3) {
						System.out.println("lock your account");
						return;
					}
				}
				break;

			case 3:
				Patient p = new Patient();

				String patientName;
				String patientPassword;

				int count3 = 1;

				while (count3 <= 3) {

					System.out.println("enter your name");
					patientName = sc.next();
					MyLogger.writeToLog("the input of patient: " + patientName);

					System.out.println("enter your password");
					patientPassword = sc.next();
					MyLogger.writeToLog("the input of patient :" + patientPassword);

					boolean patientValidate = p.patientLogin(patientName, patientPassword);
					if (patientValidate) {
						count3 = 1;
						System.out.println("Login Successfully");

						int patientChoice;

						System.out.println("Choose According To Numbers");
						System.out.println("1. To view my information");
						System.out.println("2. To view my medical information");
						patientChoice = sc.nextInt();

						if (patientChoice == 1) {
							p.patientInfo(patientName);
							// break;
						} else if (patientChoice == 2) {
							p.medicalInfo(patientName);
							// break;
						} else {
							System.out.println("invalid choice");
							// break;
						}
						break;
					} else {
						System.out.println("invalid name or password");
					}
					count3++;
					if (count3 > 3) {
						System.out.println("lock your account");
						return;
					}
				}
				break;

			default:
				System.out.println("invalid choice");

			}

		} catch (InputMismatchException e) {
			System.out.println("something wrong");
			MyLogger.writeToLog("Exception:: ", e);
		} catch (RuntimeException e) {
			System.out.println("something wrong");
			MyLogger.writeToLog("Exception:: ", e);
		} finally {
			sc.close();
		}

	}
}
