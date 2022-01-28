package s18614;


import java.util.Comparator;
import s18614.Person;

public final class BirthdateComparator implements Comparator<Person> {

	@Override
	public int compare(Person person1, Person person2) {
		return person1.get_birthdate().compareTo(person2.get_birthdate());
	}

}