package s18614.employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Trainee extends Employee {

	// attributes:
	// * apprenticeship start date
	// * apprenticeship length (in days)

	private final LocalDate _apprenticeshipStartDate;
	private int _apprenticeshipLength;
	
	public Trainee(String firstName, String surname, LocalDate birthDate, BigDecimal salary, Manager manager,
				   LocalDate apprenticeshipStartDate, int apprenticeshipLength) throws Exception {

		super(firstName, surname, birthDate, salary, manager);
		this._apprenticeshipStartDate = apprenticeshipStartDate;
		setApprenticeshipLength(apprenticeshipLength);
	}

	// getters
	public LocalDate getApprenticeshipStartDate() {
		return _apprenticeshipStartDate;
	}

	public int getApprenticeshipLength() {
		return _apprenticeshipLength;
	}

	// setters
	public void setApprenticeshipLength(int apprenticeshipLength) throws Exception {
		if (apprenticeshipLength >= 0) {
			if (apprenticeshipLength > _apprenticeshipLength)
				this._apprenticeshipLength = apprenticeshipLength;
			else
				throw new Exception("Value to set must be higher than current value!");
		}
		else
			throw new Exception("Value to set must be higher than 0!");
	}

}