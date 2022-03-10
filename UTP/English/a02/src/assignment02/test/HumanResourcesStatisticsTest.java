package assignment02.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import assignment02.HumanResourcesStatistics;
import assignment02.employee.Employee;
import assignment02.employee.Manager;
import assignment02.employee.Trainee;
import assignment02.employee.Worker;
import assignment02.payroll.PayrollEntry;

public class HumanResourcesStatisticsTest {
	
	// Create a HR structure which resembles the below one:
	//
	// Director (an instance of Manager class (Director does not have a manager)
	//   |- Manager01
	//        |- Worker
	//        |- Worker
	//        |- Trainee
	//        |- ...
	//   |- Manager02
	//        |- ...
	//   |- ...
	//   |- Worker
	//   |- Worker
	//   |- Trainee
	
	private List<Employee> _allEmployees; // all employees ---  i.e. Workers, Trainees and their Managers and top Director (also an instance of Manager class)
	private List<Employee> directorSubordinates;
	private List<Employee> manager1Subordinates;
	private List<Employee> manager2Subordinates;
	private List<Employee> manager3Subordinates;

	// managers
	private Manager director; // main manager
	private Manager man1;
	private Manager man2;
	private Manager man3;

	// workers
	private Worker wor1;
	private Worker wor2;
	private Worker wor3;
	private Worker wor4;
	private Worker wor5;
	private Worker wor6;
	private Worker wor7;
	private Worker wor8;
	private Worker wor9;

	// trainees
	private Trainee tra1;
	private Trainee tra2;
	private Trainee tra3;

	@Before
	public void before() throws Exception {

		_allEmployees = new ArrayList<>();

		directorSubordinates = new ArrayList<>();
		manager1Subordinates = new ArrayList<>();
		manager2Subordinates = new ArrayList<>();
		manager3Subordinates = new ArrayList<>();

		// initialize managers
		director = new Manager("Daniel", "Kakitek", LocalDate.of(1997,2,10),
				BigDecimal.valueOf(10000), null, LocalDate.of(2018, 1,1), BigDecimal.valueOf(5000), directorSubordinates);

		man1 = new Manager("Jurek", "Killer", LocalDate.of(1999,7,11),
				BigDecimal.valueOf(6500), director, LocalDate.of(2018,2,2), BigDecimal.valueOf(500), manager1Subordinates);

		man2 = new Manager("Stefan", "Siarzewski", LocalDate.of(1989,7,11),
				BigDecimal.valueOf(6000), director, LocalDate.of(2018,3,3), BigDecimal.valueOf(500), manager2Subordinates);

		man3 = new Manager("Stachu", "Jones", LocalDate.of(1990,7,11),
				BigDecimal.valueOf(5000), director, LocalDate.of(2019,4,4), BigDecimal.valueOf(500), manager3Subordinates);

		// initialize workers
		wor1 = new Worker("Jim", "Bimbo", LocalDate.of(1999,7,7),
				BigDecimal.valueOf(3000), man1, LocalDate.of(2020, 9, 9), BigDecimal.valueOf(250));

		wor2 = new Worker("Bogdan", "Boner", LocalDate.of(1999,7,7),
				BigDecimal.valueOf(2500), man1, LocalDate.of(2019, 5, 2), BigDecimal.valueOf(500));

		wor3 = new Worker("Domino", "Jachas", LocalDate.of(1999,7,7),
				BigDecimal.valueOf(3000), man1, LocalDate.of(2019, 3, 3), BigDecimal.valueOf(400));

		wor4 = new Worker("Saruman", "Bialy", LocalDate.of(1975,11,11),
				BigDecimal.valueOf(3000), man1, LocalDate.of(2019, 10, 7), BigDecimal.valueOf(400));

		wor5 = new Worker("Tom", "Ambo", LocalDate.of(1999,7,7),
				BigDecimal.valueOf(3000), man2, LocalDate.of(2020, 9, 9), BigDecimal.valueOf(250));

		wor6 = new Worker("Eustachy", "Lodyga", LocalDate.of(1999,7,7),
				BigDecimal.valueOf(2500), man2, LocalDate.of(2019, 7, 7), BigDecimal.valueOf(500));

		wor7 = new Worker("Gandalf", "Szary", LocalDate.of(1971,6,15),
				BigDecimal.valueOf(3500), man2, LocalDate.of(2021, 7, 9), BigDecimal.valueOf(100));

		wor8 = new Worker("Bilbo", "Baggins", LocalDate.of(1999,4,20),
				BigDecimal.valueOf(4000), man3, LocalDate.of(2018, 4, 27), BigDecimal.valueOf(250));

		wor9 = new Worker("Frodo", "Baggins", LocalDate.of(1999,7,7),
				BigDecimal.valueOf(4000), man3, LocalDate.of(2019, 3, 12), BigDecimal.valueOf(350));

		// initialize trainees
		tra1 = new Trainee("Praktykant", "Zagubiony", LocalDate.of(2002, 12, 12),
				BigDecimal.valueOf(2000), man1, LocalDate.of(2021, 10, 14), 20);

		tra2 = new Trainee("Praktykant", "Zdolny", LocalDate.of(2000, 12, 12),
				BigDecimal.valueOf(2500), man2, LocalDate.of(2021, 9, 18), 50);

		tra3 = new Trainee("Praktykant", "Leniwy", LocalDate.of(2001, 7, 25),
				BigDecimal.valueOf(1001), man2, LocalDate.of(2021, 9, 10), 5);

		// set director subordinates
		directorSubordinates.add(man1);
		directorSubordinates.add(man2);
		directorSubordinates.add(man3);

		// set manager 1 subordinates
		manager1Subordinates.add(wor1);
		manager1Subordinates.add(wor2);
		manager1Subordinates.add(wor3);
		manager1Subordinates.add(wor4);
		manager1Subordinates.add(tra1);

		// set manager 2 subordinates
		manager2Subordinates.add(wor5);
		manager2Subordinates.add(wor6);
		manager2Subordinates.add(wor7);
		manager2Subordinates.add(tra2);
		manager2Subordinates.add(tra3);

		// set manager 3 subordinates
		manager3Subordinates.add(wor8);
		manager3Subordinates.add(wor9);

		// add to all employee list
		_allEmployees.add(director);
		_allEmployees.addAll(directorSubordinates);
		_allEmployees.addAll(manager1Subordinates);
		_allEmployees.addAll(manager2Subordinates);
		_allEmployees.addAll(manager3Subordinates);
	}

	@Test
	public void payroll() {
		List<PayrollEntry> payrollList = HumanResourcesStatistics.payroll(_allEmployees);
		Assert.assertEquals(BigDecimal.valueOf(71001), payrollList.stream()
																	.map(p -> p.getSalaryPlusBonus())
																	.reduce(BigDecimal.ZERO, BigDecimal::add)
		);
	}

	@Test
	public void subordinatesPayroll() throws Exception {
		List<PayrollEntry> payrollList = HumanResourcesStatistics.subordinatesPayroll(man3);
		Assert.assertEquals(BigDecimal.valueOf(8600), payrollList.stream()
																.map(p -> p.getSalaryPlusBonus())
																.reduce(BigDecimal.ZERO, BigDecimal::add)
		);
	}

	@Test
	public void bonusTotal() {
		BigDecimal total = HumanResourcesStatistics.bonusTotal(_allEmployees);
		Assert.assertEquals(BigDecimal.valueOf(9500), total);
	}

	@Test
	public void longestSeniority() {
		Assert.assertEquals(director, HumanResourcesStatistics.longestSeniority(_allEmployees));
	}

	@Test
	public void highestSalaryWithoutBonus() {
		Assert.assertEquals(director.getSalary(), HumanResourcesStatistics.highestSalaryWithoutBonus(_allEmployees));
	}

	@Test
	public void highestSalaryIncludingBonus() {
		BigDecimal expectedSalaryWithBonus = director.getSalary().add(director.getBonus());
		Assert.assertEquals(expectedSalaryWithBonus, HumanResourcesStatistics.highestSalaryIncludingBonus(_allEmployees));
	}

	@Test
	public void surnameBeginsWithA() {
		List<Employee> expectedList = new ArrayList<>();
		expectedList.add(wor5);

		Assert.assertEquals(expectedList, HumanResourcesStatistics.surnameBeginsWithA(man2));
	}

	@Test
	public void earnMoreThan1000() {
		Assert.assertEquals(_allEmployees, HumanResourcesStatistics.earnMoreThan1000(_allEmployees));
	}

}