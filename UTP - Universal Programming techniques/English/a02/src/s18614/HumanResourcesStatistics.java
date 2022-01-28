package s18614;


import s18614.employee.Employee;
import s18614.employee.Manager;
import s18614.employee.Trainee;
import s18614.employee.Worker;
import s18614.payroll.PayrollEntry;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class HumanResourcesStatistics {

	// preparing payroll for all the employees
	public static List<PayrollEntry> payroll(List<Employee> employees) {
		if (employees == null)
			return null;
		else
			return employees.stream()
					.map(e -> new PayrollEntry(e, e.getSalary(), (e instanceof Worker) ? ((Worker) e).getBonus() : null))
					.collect(Collectors.toList());
	}

	// preparing payroll for subordinates of the given manager
	public static List<PayrollEntry> subordinatesPayroll(Manager manager) throws Exception {
		if (manager == null)
			return null;
		else {
			List<Employee> subordinates = manager.getSubordinates();

			return payroll(subordinates);
		}
	}

	// calculating the total cost of bonuses
	public static BigDecimal bonusTotal(List<Employee> employees) {
		if (employees == null)
			return null;
		else
			return employees
					.stream()
					.map(e -> (e instanceof Worker) ? ((Worker) e).getBonus() : BigDecimal.ZERO)
					.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	// searching for an employee with the longest seniority
	public static Employee longestSeniority(List<Employee> employees) {
		if (employees == null)
			return null;
		else
			return employees
					.stream()
					.filter(e -> e instanceof Worker)
					.map(e -> (Worker) e)
					.sorted(Comparator.comparing(e -> e.getEmploymentDate()))
					.collect(Collectors.toList())
					.get(0);
	}

	// searching for the highest salary without bonus
	public static BigDecimal highestSalaryWithoutBonus(List<Employee> employees) {
		if (employees == null)
			return null;
		else
			return employees
					.stream()
					.map(e -> e.getSalary())
					.sorted()
					.collect(Collectors.toList())
					.get(employees.size() - 1);
	}

	// searching for the highest salary with bonus
	public static BigDecimal highestSalaryIncludingBonus(List<Employee> employees) {
		if (employees == null)
			return null;
		else
			return employees
					.stream()
					.map(e -> !(e instanceof Trainee) ? e.getSalary().add(((Worker) e).getBonus()) : e.getSalary())
					.sorted()
					.collect(Collectors.toList())
					.get(employees.size() - 1);
	}

	// searching for employees whose surnames begin with ‘A’ subordinates of the given manager
	public static List<Employee> surnameBeginsWithA(Manager manager) {
		if (manager == null)
			return null;
		else {
			List<Employee> subordinates = manager.getSubordinates();

			if (subordinates == null)
				return null;
			else
				return subordinates
						.stream()
						.filter(e -> e.getSurname().startsWith("a") || e.getSurname().startsWith("A"))
						.collect(Collectors.toList());
		}
	}

	// searching for employees who earn more than 1000 PLN
	public static List<Employee> earnMoreThan1000(List<Employee> employees) {
		if (employees == null)
			return null;
		else
			return employees
					.stream()
					.filter(e -> e.getSalary().compareTo(BigDecimal.valueOf(1000)) > 0)
					.collect(Collectors.toList());
	}

	/// ...
	// rest of the methods specified in the assignment description
	
	
	/**
	 * samples for functional processing in Java
	 * 
	 */
	public static List<Short> getAges(List<Employee> employees) {
		if (employees == null) {
			return null;
		}
		List<Short> ages = employees //
				.stream() //
				.map(emp -> emp.getAge()) //
				.collect(Collectors.toList());
		return ages;
	}

	public static void printAges(List<Employee> employees) {
		if (employees == null) {
			return;
		}
		employees //
				.stream() //
				.map(emp -> (int) emp.getAge()) //
				.forEach(age -> System.out.print(age + ", "));
	}

	//
	// average age for the Employees whose first name starts with 'A' and they are older than 20
	public static short getAverageAgeInline(List<Employee> employees) {
		if (employees == null) {
			return 0;
		}
		int employeeTotalAge = employees //
				.stream() //
				.filter(emp -> emp.getFirstName().startsWith("A") && emp.getAge() > 20) //
				.map(emp -> (int) emp.getAge()) //
				.reduce(0, //
						(total, age) -> total + age);

		long filteredEmployeesCount = employees //
				.stream() //
				.filter(emp -> emp.getFirstName().startsWith("A") && emp.getAge() > 20) //
				.count();

		return (short) (employeeTotalAge / filteredEmployeesCount);
	}

	public static short getAverageAgeMethodReference(List<Employee> employees) {
		if (employees == null) {
			return 0;
		}
		int employeeTotalAge = employees //
				.stream() //
				.map(emp -> (int) emp.getAge()) //
				.reduce(0, HumanResourcesStatistics::totalAge);
		return (short) (employeeTotalAge / employees.size());
	}

	public static short getMaxAgeInline(List<Employee> employees) {
		short employeeMaxAge = employees //
				.stream() //
				.map(emp -> emp.getAge()) //
				.reduce((short) 0, //
						(maxAge, age) -> {
							if (maxAge < age) {
								return age;
							} else {
								return maxAge;
							}
						});
		return employeeMaxAge;
	}

	public static short getMaxAgeMethodReference(List<Employee> employees) {
		short employeeMaxAge = employees //
				.stream() //
				.map(emp -> emp.getAge()) //
				.reduce((short) 0, HumanResourcesStatistics::maxAge);
		return employeeMaxAge;
	}

	private static int totalAge(int totalAge, int age) {
		//
		return totalAge + age;
	}

	private static short maxAge(short maxAge, short age) {
		if (maxAge < age) {
			return age;
		} else {
			return maxAge;
		}
	}

}