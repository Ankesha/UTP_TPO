package s18614.employee;

import java.time.LocalDate;

public abstract class Person {

	// To implement an attribute means that you provide a backing field and
	// getter or optionally setter for read-write properties/attributes
	// 
	// NO BACKING FIELDS SHOULD BE PROVIDED FOR DERIVED ATTRIBUTES
	// THOSE SHOULD BE COMPUTED ON-LINE
	//
	// attributes:
	// * first name (read-only)
	// * surname (read-only)
	// * birth date (read-only) --- date MUST BE represented by an instance of
	// the type designed for date representation (either Date or LocalDate)
	//
	// * age (derived --- computed based on birth date) --- implemented as a
	// getter calculating the difference between the current date and birth date

	private final String _firstName; // backing field
	private final String _surname; // backing field
	private final LocalDate _birthDate; // backing field

	protected Person(String firstName, String surname, LocalDate birthDate) {
		this._firstName = firstName;
		this._surname = surname;
		this._birthDate = birthDate;
	}

	// getters
	public String getFirstName() {
		return _firstName;
	}

	public String getSurname() {
		return _surname;
	}

	public LocalDate getBirthDate() {
		return _birthDate;
	}

	// this method calculates age from birth date and returns it
	public short getAge() {
		return (short) (LocalDate.now().getYear() - _birthDate.getYear() );
	}

	@Override
	public String toString() {
		return getFirstName() + " " + getSurname();
	}

}