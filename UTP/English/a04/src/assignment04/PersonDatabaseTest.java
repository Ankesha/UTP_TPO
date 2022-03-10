/**
 * @Author: Patryk Kamiński
 */

package assignment04;


import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonDatabaseTest {

    public static void main(String[] args) throws Exception {

        File listFile = new File("list.txt");
        PersonDatabase personDatabaseTest = new PersonDatabase(InputParser.parse(listFile));

        // equals test
        try {
            System.out.println("Are people same test: " + "\n");

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Person personTest1 = new Person("Jurek", "Killer", simpleDateFormat.parse("1999-06-25"));
            Person personTest2 = new Person("Stefan", "Siarzewski", simpleDateFormat.parse("1989-03-12"));

            System.out.print("person 1 to compare: " + personTest1);
            System.out.print("person 2 to compare: " + personTest2);

            if (personTest1.equals(personTest2))
                System.out.println("those people are same");
            else
                System.out.println("those people are different");

        } catch (ParseException e) {
            System.err.println("File: " + listFile + " has invalid format!");
        }

        System.out.println();
        System.out.println("List of people sorted by first name: ");
        System.out.println(personDatabaseTest.sortedByFirstName());

        System.out.println();
        System.out.println("List of people sorted by birth date: ");
        System.out.println(personDatabaseTest.sortedByBirthdate());

        System.out.println();
        System.out.println("List of people sorted by natural order: ");
        System.out.println(personDatabaseTest.sortedBySurnameFirstNameAndBirthdate());

        // search by date test
        try {
            System.out.println();
            System.out.println("Search by date test: " + "\n");

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateToSearch = simpleDateFormat.parse("1989-03-12");

            System.out.println("People with birthdate: " + dateToSearch);
            System.out.println(personDatabaseTest.bornOnDay(dateToSearch));

        } catch (ParseException e) {
            System.err.println("File: " + listFile + " has invalid format!");
        }

    }

}