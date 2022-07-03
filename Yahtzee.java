/**
 * This class represents the game Yahtzee, When the dice is rolled scores based
 * on 13 different scoring options are checked and added up which can be later
 * modified.
 * 
 * @author Kevin Chau 251215166
 * 
 */

public class Yahtzee {
	private Dice[] dice;

	/**
	 * Constructor that intializes the dice array and rolls it for random values
	 */
	public Yahtzee() {
		dice = new Dice[5]; //create a new dice object
		for (int i = 0; i < dice.length; i++) { //roll it 5 times
			dice[i] = new Dice(); //create new die
			dice[i].roll(); //call the roll method for random values
		}

	}

	/**
	 * Constructor that intialize the dice array with given arguments
	 * 
	 * @param Dice[] die being rolled
	 */
	public Yahtzee(Dice[] die) {
		dice = die;
	}

	/**
	 * Getter Method to get the array showing the values of the die that was rolled
	 * 
	 * @return countArray array holding all possible values from 1-6
	 */
	public int[] getValueCount() {
		int[] countArray = new int[6];
		for (int i = 0; i < countArray.length - 1; i++) {
			if (dice[i].getValue() == 1) { //statement to check if the rolled dice has this number
				countArray[0]++; //increment countArray at given index
			}
			if (dice[i].getValue() == 2) {
				countArray[1]++;
			}
			if (dice[i].getValue() == 3) {
				countArray[2]++;
			}
			if (dice[i].getValue() == 4) {
				countArray[3]++;
			}
			if (dice[i].getValue() == 5) {
				countArray[4]++;
			}
			if (dice[i].getValue() == 6) {
				countArray[5]++;
			}
		}
		return countArray;
	}

	/**
	 * Method that checks if there are three index elements that are the same in
	 * countArray from getValueCount
	 * 
	 * @return true if there are three index elements that are the same
	 * @return false if there are no index elements that are the same
	 */
	public boolean threeOfAKind() {
		int[] countArray = getValueCount();
		for (int i = 0; i < countArray.length; i++) {
			if (countArray[i] >= 3) { //statement to see if there is an element of countArray that is greater than or equal to three
				return true;
			}

		}

		return false;
	}

	/**
	 * Method that checks if there are four index elements that are the same in
	 * countArray from getValueCount
	 * 
	 * @return true if there are four index elements that are the same
	 * @return false if there are less than four elements that are the same
	 */
	public boolean fourOfAKind() {
		int[] countArray = getValueCount();
		for (int i = 0; i < countArray.length; i++) {
			if (countArray[i] >= 4) { //statement to see if there is an element of countArray that is greater than or equal to four
				return true;
			}
		}
		return false;
	}

	/**
	 * Method that checks if there are three index elements and two index elements
	 * that are both the same ie. 4,4,4,2,2
	 * 
	 * @return true if counter is equal to two
	 * @return false if counter is not equal to two
	 */
	public boolean fullHouse() {
		int[] countArray = getValueCount();
		int counter = 0;
		for (int i = 0; i < countArray.length; i++) {
			if (countArray[i] == 3) { //statement to check if there is a three in countArray
				counter++; //increment counter 
			}
			if (countArray[i] == 2) {
				counter++;
			}
		}
		if (counter == 2) { //statement to check if counter is equal to two
			return true;
		}
		return false;
	}

	/**
	 * Method that determines if there are consecutive numbers inside of countArray
	 * 
	 * @return max is the number of times there is 1 or 2 inside the array which
	 *         shows that there is a number is in countArray if max is 4 that means
	 *         it is a small straight with four consecutive and if max is 5 it means
	 *         it is a large straight with five consecutive
	 */
	public int Straights() {
		int[] countArray = getValueCount();
		int x = 0;
		int max = 0;

		for (int i = 0; i < 6; i++) { //loop through 6 times
			if (countArray[i] == 1 || countArray[i] == 2) { //statement to check if there are one or twos in countArray
				x++;
				max = x; //max is how many times 1 or 2 show up in countArray
			} else {
				x = 0;//reset the first counter
			}

		}
		return max;
	}

	/**
	 * Method that checks if all indexes in the array have the same element
	 * 
	 * @return true if all indexes have the same elements
	 * @return false if there are no elements that are the same
	 */
	public boolean Yahtzee() {
		int[] countArray = getValueCount();
		for (int i = 0; i < countArray.length; i++) { 
			if (countArray[i] == 5) { //statement to check if any of the elements are equal to five
				return true;
			}

		}
		return false;
	}

	/**
	 * Method that takes the countArray from getValueCount and uses it to calculate
	 * store based on 13 scoring options
	 * 
	 * @return scoreArray an array that stores all possible scores for the dice
	 */
	public int[] getScoreOptions() {
		int[] scoreArray = new int[13];
		int[] countArray = getValueCount();

		if (countArray[0] >= 1) { // statement to check if countArray satisifies the scoring need
			scoreArray[0] = countArray[0]; // add into scoreArray
		}
		if (countArray[1] >= 1) {
			scoreArray[1] = countArray[1] * 2;
		}
		if (countArray[2] >= 1) {
			scoreArray[2] = countArray[2] * 3;
		}
		if (countArray[3] >= 1) {
			scoreArray[3] = countArray[3] * 4;
		}
		if (countArray[4] >= 1) {
			scoreArray[4] = countArray[4] * 5;
		}
		if (countArray[5] >= 1) {
			scoreArray[5] = countArray[5] * 6;
		}
		if (threeOfAKind()) {
			scoreArray[6] = this.dice[0].getValue() + this.dice[1].getValue() + this.dice[2].getValue()
					+ this.dice[3].getValue() + this.dice[4].getValue(); // add all elements together and add into
																			// scoreArray at that index
		} else {
			scoreArray[6] = 0;
		}
		if (fourOfAKind()) {
			scoreArray[7] = this.dice[0].getValue() + this.dice[1].getValue() + this.dice[2].getValue()
					+ this.dice[3].getValue() + this.dice[4].getValue();
		} else {
			scoreArray[7] = 0;
		}
		if (fullHouse()) {
			scoreArray[8] = 25; // set scoreArray at that index to 25
		} else {
			scoreArray[8] = 0;
		}
		if (Straights() == 4) {
			scoreArray[9] = 30;
		}
		if (Straights() == 5) {
			scoreArray[10] = 40;
		}
		if (Yahtzee()) {
			scoreArray[11] = 50;
		}
		scoreArray[12] = this.dice[0].getValue() + this.dice[1].getValue() + this.dice[2].getValue()
				+ this.dice[3].getValue() + this.dice[4].getValue(); // chance is automatically put into score Array

		return scoreArray;

	}

	/**
	 * Method that checks scoreArray from getScoreOptions and takes the highest
	 * score in the smallest index and stores it into a new array
	 * 
	 * @return scores an array that holds the highest score at the smallest index
	 */
	public int[] score() {
		int[] scores = new int[2];
		int[] scoreArray = getScoreOptions();
		int max = scores[0];
		int ind = 0;
		for (int i = 1; i < scoreArray.length; i++) { //loop through scoreArray array
			if (scoreArray[i] > max) //searches to see if that index is greater than the current max
				max = scoreArray[i]; //make max the current index
		}
		scores[0] = max;

		for (int i = 1; i < scoreArray.length; i++) { 
			if (scoreArray[i] > scoreArray[ind]) //checks to see if the scoreArray index is greater than the scoreArray at current index
				ind = i; //makes ind the current index
		}

		scores[1] = ind;

		return scores;
	}

	/**
	 * Method that takes two Yahtzee objects and compares the countArray from
	 * getValueCount to see if they match elements (not in order)
	 * 
	 * @param Yahtzee other object of type Yahtzee
	 * @return true if the countArray from the first object and second object are
	 *         the same
	 * @return false if the countArray from the first object and second object arent
	 *         the same
	 */
	public boolean equals(Yahtzee other) {
		boolean bool;
		bool = false;
		for (int i = 0; i < dice.length; i++) { //loop through object dice
			if (this.getValueCount()[i] == other.getValueCount()[i]) { //statement to check if each element in countArray is the same
				bool = true;
			} else {
				return bool = false;
			}
		}
		return bool;
	}

	/**
	 * Method that returns the current object dice and shows its rolled values
	 * 
	 * @return String
	 */
	public String toString() {
		String message = "Dice: {";
		for (int index = 0; index < 5; index++) { //for loop of five times
			message += dice[index].getValue(); //puts each down of the die
			if (index < 4) // statement to check how many numbers are put down
				message += ", ";
			if (index == 4)
				message += "}";
		}
		return message;
	}
}
