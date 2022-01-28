package s18614.employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Employee extends Person {

	// attributes:
	// * salary (use BigDecimal type for representing currency values)
	// * manager (empty if at top of hierarchy)

	private BigDecimal _salary;
	private Manager _manager;
	
	protected Employee(String firstName, String surname, LocalDate birthDate,
					   BigDecimal salary, Manager manager) {

		super(firstName, surname, birthDate);
		setSalary(salary);
		setManager(manager);
	}

	// getters
	public BigDecimal getSalary() {
		return _salary;
	}

	public Manager getManager() {
		return _manager;
	}

	// setters
	public void setSalary(BigDecimal salary) {
		this._salary = salary;
	}

	public void setManager(Manager manager) {
		this._manager = manager;
	}

}