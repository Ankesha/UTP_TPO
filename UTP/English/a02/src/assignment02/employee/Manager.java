/**
 * @Author: Patryk Kamiński
 */

package assignment02.employee;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Manager extends Worker {

	// attributes
	// * subordinates (a list of immediate subordinates)
	// * all subordinates (derived --- i.e. calculated on the fly --- a list of subordinates in all hierarchy)

	private List<Employee> _subordinates;

	public Manager(String firstName, String surname, LocalDate birthDate, BigDecimal salary, Manager manager,
				   LocalDate employmentDate, BigDecimal bonus, List<Employee> subordinates) throws Exception {

		super(firstName, surname, birthDate, salary, manager, employmentDate, bonus);
		setSubordinates(subordinates);
	}

	// getters
	public List<Employee> getSubordinates() {
		return _subordinates;
	}

	// this method returns list of all subordinates in all hierarchy
	public List<Employee> getAllSubordinates() {
		List<Employee> allSubordinates = new ArrayList<>();

		for (Employee emp : _subordinates) {
			if (emp instanceof Manager)
				((Manager) emp).getAllSubordinates();

			allSubordinates.add(emp);
		}

		return allSubordinates;
	}

	// setters
	public void setSubordinates(List<Employee> subordinates) throws Exception {
			this._subordinates = subordinates;
	}

}