/**
 * This class represents a dice. The dice is rolled to get values between 1 and 6
 * 
 * @author Kevin Chau 251215166
 *
 */
public class Dice {
	private int value;

	/**
	 * Constructor creates a dice with the initialized value of -1
	 */
	public Dice() {
		value = -1;
	}

	/**
	 * Constructor creates a dice with the passed through values
	 * 
	 * @param value value of the die
	 */
	public Dice(int value) {
		this.value = value;
	}

	/**
	 * Method that sets the variable value with a random number 1-6
	 */
	public void roll() {
		value = RandomNumber.getRandomNumber(1, 6);
	}

	/**
	 * Getter Method that returns the value of the die
	 * 
	 * @return value
	 */
	public int getValue() {
		return value;
	}
}
