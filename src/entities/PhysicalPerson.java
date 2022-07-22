package entities;

public class PhysicalPerson extends Person{

	private Double healthExpenses;
	
	public PhysicalPerson() {
		super();
	}
	
	public PhysicalPerson(String name, Double annualIncome, Double healthExpenses) {
		super(name, annualIncome);
		this.healthExpenses = healthExpenses;
	}

	public Double getHealthExpenses() {
		return healthExpenses;
	}

	public void setHealthExpenses(Double healthExpenses) {
		this.healthExpenses = healthExpenses;
	}

	@Override
	public Double tax() {
		double tax = (super.getAnnualIncome() < 20000.00) ? super.getAnnualIncome() * 0.15 : super.getAnnualIncome() * 0.25;
		
		if(tax < 0.0) {
			tax = 0.0;
		}
		return tax - healthExpenses * 0.50;
	}

}
