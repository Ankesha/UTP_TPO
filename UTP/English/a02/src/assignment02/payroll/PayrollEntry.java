/**
 * @Author: Patryk Kamiński
 */

package assignment02.payroll;


import assignment02.employee.Employee;

import java.math.BigDecimal;

public final class PayrollEntry {

	private final Employee _employee;
	private final BigDecimal _salaryPlusBonus;
	
	public PayrollEntry(Employee employee, BigDecimal salary, BigDecimal bonus) {
		_employee = employee;

		// validate whether salary and bonus are not null
		if (salary != null) {
			if (bonus != null)
				_salaryPlusBonus = salary.add(bonus); // salary with bonus
			else
				_salaryPlusBonus = salary; // only salary without bonus
		}
		else
			if (bonus != null)
				_salaryPlusBonus = bonus; // only bonus without salary
			else
				_salaryPlusBonus = BigDecimal.ZERO; // no salary and no bonus
	}

	// getters
	public Employee getEmployee() {
		return _employee;
	}

	public BigDecimal getSalaryPlusBonus() {
		return _salaryPlusBonus;
	}

	@Override
	public String toString() {
		return getEmployee() + " : " + getSalaryPlusBonus();
	}

}