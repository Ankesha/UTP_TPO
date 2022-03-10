/**
 * @Author: Patryk Kamiński
 */

package assignment04;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class InputParser {

	// 1. Use regular expresssions (Pattern) for validating input data
	//    U�y� regularnych wyra�e� (Pattern) do walidacji danych wej�ciowych
	//
	// 2. Convert input string representing date using SimpleDateFormat "yyyy-MM-dd"
	//    Konwersj� wej�ciowego ci�gu znak�w reprezentuj�cego dat� nale�y oprze� np. DateFormat
	//    SimpleDateFormat format "yyyy-MM-dd"

	// group names
	private static final String firstNameGroupName = "firstName";
	private static final String surnameGroupName = "surname";
	private static final String birthdateGroupName = "birthdate";

	// patterns
	private static final String firstNamePattern = "(?<" + firstNameGroupName + ">" + "(?:[A-Ż]([a-z])+)" + ")";
	private static final String surnamePattern = "(?<" + surnameGroupName + ">" + "(?:[A-Ż]([a-z])+)" + ")";
	private static final String birthdatePattern = "(?<" + birthdateGroupName + ">" + "(?!0000)[0-9]{4}" + "-" + "(0?[1-9]|1[012])\\" + "-" + "(0?[1-9]|[12][0-9]|3[01])" + ")";
	private static final String personPattern = firstNamePattern + "(?:[ \0]+)" + surnamePattern + "(?:[ \0]+)" + birthdatePattern;

	private static final Pattern personRegex = Pattern.compile(personPattern);

	private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	// parse line into person type
	private static Person parse(String line) {
		Matcher matcher = personRegex.matcher(line);

		if (matcher.matches())
			return new Person(matcher.group(firstNameGroupName), matcher.group(surnameGroupName), parseBirthDate(matcher));
		else
			return null;
	}

	// parse birth date based on matcher
	private static Date parseBirthDate(Matcher matcher) {
		try {
			String input = matcher.group(birthdateGroupName);

			return dateFormat.parse(input);

		} catch (ParseException e) {
			System.err.print("Date format is wrong!");
			e.printStackTrace();

			return null;
		}
	}

	// parse whole file into person types, line by line
	public static List<Person> parse(File file) {
		List<Person> resultPeopleList= new ArrayList<>();
		BufferedReader bufferedReader;

		try {
			bufferedReader = new BufferedReader(new FileReader(file.getName()));
			String line = bufferedReader.readLine();

			while (line != null) {
				if(parse(line) != null)
					resultPeopleList.add(parse(line));

				line = bufferedReader.readLine();
			}
			bufferedReader.close();

		} catch (IOException e) {
			System.err.print("IO Exception occurred!");
			e.printStackTrace();
		}

		if (!resultPeopleList.isEmpty())
			return resultPeopleList;
		else
			return null;
	}

}