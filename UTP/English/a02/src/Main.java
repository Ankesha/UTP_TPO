/**
 * @Author: Patryk Kamiński
 */

import assignment02.HumanResourcesStatistics;
import assignment02.employee.Employee;
import assignment02.employee.Manager;
import assignment02.employee.Trainee;
import assignment02.employee.Worker;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        List<Employee> allEmployees = new ArrayList<>();

        List<Employee> directorSubordinates = new ArrayList<>();
        List<Employee> manager1Subordinates = new ArrayList<>();
        List<Employee> manager2Subordinates = new ArrayList<>();
        List<Employee> manager3Subordinates = new ArrayList<>();

        // initialize managers
        Manager director = new Manager("Daniel", "Kakitek", LocalDate.of(1997,2,10),
                BigDecimal.valueOf(10000), null, LocalDate.of(2018, 1,1), BigDecimal.valueOf(5000), directorSubordinates);

        Manager man1 = new Manager("Jurek", "Killer", LocalDate.of(1999,7,11),
                BigDecimal.valueOf(6500), director, LocalDate.of(2018,2,2), BigDecimal.valueOf(500), manager1Subordinates);

        Manager man2 = new Manager("Stefan", "Siarzewski", LocalDate.of(1989,7,11),
                BigDecimal.valueOf(6000), director, LocalDate.of(2018,3,3), BigDecimal.valueOf(500), manager2Subordinates);

        Manager man3 = new Manager("Stachu", "Jones", LocalDate.of(1990,7,11),
                BigDecimal.valueOf(5000), director, LocalDate.of(2019,4,4), BigDecimal.valueOf(500), manager3Subordinates);

        // initialize workers
        Worker wor1 = new Worker("Jim", "Bimbo", LocalDate.of(1999,7,7),
                BigDecimal.valueOf(3000), man1, LocalDate.of(2020, 9, 9), BigDecimal.valueOf(250));

        Worker wor2 = new Worker("Bogdan", "Boner", LocalDate.of(1999,7,7),
                BigDecimal.valueOf(2500), man1, LocalDate.of(2019, 5, 2), BigDecimal.valueOf(500));

        Worker wor3 = new Worker("Domino", "Jachas", LocalDate.of(1999,7,7),
                BigDecimal.valueOf(3000), man1, LocalDate.of(2019, 3, 3), BigDecimal.valueOf(400));

        Worker wor4 = new Worker("Saruman", "Bialy", LocalDate.of(1975,11,11),
                BigDecimal.valueOf(3000), man1, LocalDate.of(2019, 10, 7), BigDecimal.valueOf(400));

        Worker wor5 = new Worker("Tom", "Ambo", LocalDate.of(1999,7,7),
                BigDecimal.valueOf(3000), man2, LocalDate.of(2020, 9, 9), BigDecimal.valueOf(250));

        Worker wor6 = new Worker("Eustachy", "Lodyga", LocalDate.of(1999,7,7),
                BigDecimal.valueOf(2500), man2, LocalDate.of(2019, 7, 7), BigDecimal.valueOf(500));

        Worker wor7 = new Worker("Gandalf", "Szary", LocalDate.of(1971,6,15),
                BigDecimal.valueOf(3500), man2, LocalDate.of(2021, 7, 9), BigDecimal.valueOf(100));

        Worker wor8 = new Worker("Bilbo", "Baggins", LocalDate.of(1999,4,20),
                BigDecimal.valueOf(4000), man3, LocalDate.of(2018, 4, 27), BigDecimal.valueOf(250));

        Worker wor9 = new Worker("Frodo", "Baggins", LocalDate.of(1999,7,7),
                BigDecimal.valueOf(4000), man3, LocalDate.of(2019, 3, 12), BigDecimal.valueOf(350));

        // initialize trainees
        Trainee tra1 = new Trainee("Praktykant", "Zagubiony", LocalDate.of(2002, 12, 12),
                BigDecimal.valueOf(2000), man1, LocalDate.of(2021, 10, 14), 20);

        Trainee tra2 = new Trainee("Praktykant", "Zdolny", LocalDate.of(2000, 12, 12),
                BigDecimal.valueOf(2500), man2, LocalDate.of(2021, 9, 18), 50);

        Trainee tra3 = new Trainee("Praktykant", "Leniwy", LocalDate.of(2001, 7, 25),
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
        allEmployees.add(director);
        allEmployees.addAll(directorSubordinates);
        allEmployees.addAll(manager1Subordinates);
        allEmployees.addAll(manager2Subordinates);
        allEmployees.addAll(manager3Subordinates);

        // tests
        System.out.println("=== hierarchy ===");
        for (Employee emp : allEmployees) {
            if (emp instanceof Manager)
                System.out.println(emp.toString() + "'s subordinates: \n" + ((Manager) emp).getSubordinates() + "\n");
        }

        System.out.println();

        sumSalPlusBonus(allEmployees);

        System.out.println();

        System.out.println(HumanResourcesStatistics.payroll(allEmployees));
        System.out.println(HumanResourcesStatistics.subordinatesPayroll(director));
        System.out.println(HumanResourcesStatistics.bonusTotal(allEmployees));
        System.out.println(HumanResourcesStatistics.longestSeniority(allEmployees));
        System.out.println(HumanResourcesStatistics.highestSalaryWithoutBonus(allEmployees));
        System.out.println(HumanResourcesStatistics.highestSalaryIncludingBonus(allEmployees));
        System.out.println(HumanResourcesStatistics.surnameBeginsWithA(man2));
        System.out.println(HumanResourcesStatistics.earnMoreThan1000(allEmployees));
    }

    public static void sumSalPlusBonus(List<Employee> allEmployees)
    {
        BigDecimal sum = BigDecimal.ZERO;

        for (Employee e : allEmployees) {
            if (e instanceof Worker)
                sum = sum.add(e.getSalary().add(((Worker) e).getBonus()));
            else if (e instanceof Trainee)
                sum = sum.add(e.getSalary());
        }

        System.out.println("sum: " + sum);
    }

}