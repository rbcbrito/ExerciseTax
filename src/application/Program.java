package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.LegalPerson;
import entities.Person;
import entities.PhysicalPerson;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Person> list = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int number = sc.nextInt();

		for (int i = 1; i <= number; i++) {
			System.out.println("Tax payer #" + i + " data: ");
			System.out.print("Individual or company (i/c)? ");
			char individualCompany = sc.next().charAt(0);
			while(individualCompany != 'i' && individualCompany != 'c') {
				System.out.println("Opcao Invalida! Digite uma opcao correta!");
				System.out.print("Individual or company (i/c)? ");
				individualCompany = sc.next().charAt(0);
			}
			System.out.print("Name: ");
			sc.nextLine();
			String namePerson = sc.nextLine();
			System.out.print("Anual income: ");
			Double annualIncome = sc.nextDouble();
			if(individualCompany == 'i') {
				System.out.print("Health Expenditures: ");
				Double healthExpend = sc.nextDouble();
				list.add(new PhysicalPerson(namePerson, annualIncome, healthExpend));
			}
			else if(individualCompany == 'c') {
				System.out.print("Number of employees: ");
				Integer numberEmployees = sc.nextInt();
				list.add(new LegalPerson(namePerson, annualIncome, numberEmployees));
			}

		}
		
		System.out.println();
		System.out.println("TAXES PAID: ");
		
		list.forEach(p -> System.out.println(p.getName() + ": $ " + p.tax()));
		
		Double sum = 0.0;		
		for(Person p : list){
			sum += p.tax();
		}
		
		System.out.println();
		System.out.print("TOTAL TAXES: $ " + sum);

	}

}
