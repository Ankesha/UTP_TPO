package s18614;


import java.util.Date;
import java.util.Objects;

public class Person implements Comparable<Person> {

	private final String _firstName;
	private final String _surname;
	private final Date _birthdate;
	
	public Person(String firstName, String surname, Date birthdate) {
		_firstName = firstName;
		_surname = surname;
		_birthdate = birthdate;
	}

	// getters
	public String get_firstName() { return _firstName; }
	public String get_surname() { return _surname; }
	public Date get_birthdate() { return _birthdate; }

	@Override
	public int compareTo(Person otherPerson) {
		int comparationResult;

		comparationResult = this._surname.compareTo(otherPerson._surname);
		if (comparationResult != 0)
			return  comparationResult;

		comparationResult = this._firstName.compareTo(otherPerson._firstName);
		if (comparationResult != 0)
			return  comparationResult;

		comparationResult = this._birthdate.compareTo(otherPerson._birthdate);
		return comparationResult;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		Person person = (Person) o;
		return Objects.equals(_firstName, person._firstName) && Objects.equals(_surname, person._surname) && Objects.equals(_birthdate, person._birthdate);
	}

	@Override
	public String toString() {
		return  get_firstName() + " " + get_surname() + " " + get_birthdate() + "\n";
	}
}