package s18614.employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Worker extends Employee {

	// attributes
	// * employment date
	// * bonus

	private final LocalDate _employmentDate;
	private BigDecimal _bonus;
	
	public Worker(String firstName, String surname, LocalDate birthDate, BigDecimal salary, Manager manager,
				  LocalDate employmentDate, BigDecimal bonus) {

		super(firstName, surname, birthDate, salary, manager);
		this._employmentDate = employmentDate;
		setBonus(bonus);
	}

	// getters
	public LocalDate getEmploymentDate() {
		return _employmentDate;
	}

	public BigDecimal getBonus() {
		return _bonus;
	}

	// setters
	public void setBonus(BigDecimal bonus) {
		if (bonus != null)
			this._bonus = bonus;
	}

}