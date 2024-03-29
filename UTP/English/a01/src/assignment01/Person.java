/**
 * @Author: Patryk Kamiński
 */

package assignment01;

public final class Person implements IAggregable<Person, Integer>, IDeeplyCloneable<Person> {
	
	private final int _age;
	
	public Person(int age) {
		//
		_age = age;
	}
	
	public int age() {
		//
		return _age;
	}

	public Integer aggregate(Integer partial) {
		if  (partial == null) {
			return _age;
		}
		return _age + partial;
	}
	
	public Person deepClone() {
		//
		return new Person(_age);
	}
}