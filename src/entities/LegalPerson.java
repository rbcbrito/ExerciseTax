package entities;

public class LegalPerson extends Person {

	private Integer numberEmployees;
	
	public LegalPerson() {
		super();
	}
	
	public LegalPerson(String name, Double annualIncome, Integer numberEmployees) {
		super(name, annualIncome);
		this.numberEmployees = numberEmployees;
	}

	public Integer getNumberEmployees() {
		return numberEmployees;
	}

	public void setNumberEmployees(Integer numberEmployees) {
		this.numberEmployees = numberEmployees;
	}

	@Override
	public Double tax() {
		double tax = (numberEmployees > 10) ? super.getAnnualIncome() * 0.14 : super.getAnnualIncome() * 0.16 ;
		return tax;
	}

}
