package s18614;


import java.util.*;
import java.util.stream.Collectors;

public final class PersonDatabase {

	private List<Person> personList;
	private List<Person> firstNameList;
	private List<Person> birthdateList;
	private Map<Date, List<Person>> searchForBirthDate;

	private static final Comparator<Person> sortByFirstNameComp = new FirstNameComparator();
	private static final Comparator<Person> sortByBirthdateComp = new BirthdateComparator();
	private static final Comparator<Person> sortByFirstNameSurnameBirthdateComp = Comparator.naturalOrder();

	// constructor
	public PersonDatabase(List<Person> list) {
		this.personList = list;
	}

	// return person list sorted by first name
	public List<Person> sortedByFirstName() {
		firstNameList = new ArrayList<>(personList);

		if (firstNameList.isEmpty())
			return null;
		else {
			firstNameList.sort(sortByFirstNameComp);
			return firstNameList;
		}
	}

	// return person list sorted by birthdate
	public List<Person> sortedByBirthdate() {
		birthdateList = new ArrayList<>(personList);

		if (birthdateList.isEmpty())
			return null;
		else {
			birthdateList.sort(sortByBirthdateComp);
			return birthdateList;
		}
	}

	// return person list sorted by natural order
	public List<Person> sortedBySurnameFirstNameAndBirthdate() {
		personList.sort(sortByFirstNameSurnameBirthdateComp);
		return personList;
	}

	// return people born in specific date
	public List<Person> bornOnDay(Date date) {
		searchForBirthDate = personList
									.stream()
									.collect(Collectors.groupingBy(Person::get_birthdate));

		if (searchForBirthDate == null) {

			System.err.println("The list is empty!");
			return null;
		}
		else {
			if (!searchForBirthDate.containsKey(date)) {

				System.err.println("There is no people born at this date!");
				return null;
			}
			else
				return new ArrayList<Person>(searchForBirthDate.get(date));
		}
	}

}