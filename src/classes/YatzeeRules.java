package classes;
/**
 * The purpose of this class is to tally the values of 5 dice
 * that have been rolled using the standard rules for the 
 * board game Yatzee.
 * 
 * Each scoring option has a function that evaluates the number
 * of pips for each die and adds them together.
 * 
 * @author J. Michael Brewer
 *
 */

public class YatzeeRules {

	public YatzeeRules() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param diceValues 	An array of integers indicating the number of pips rolled on each die
	 * @param pips 			The number of pips being evaluated
	 * @return 				The sum of of diceValues matching the value of pups.
	 */
	public int scorePips(int[] diceValues, int pips) {
		int score = 0;
		
		for(int index = 0; index < diceValues.length; index++) {
			if(diceValues[index] == pips) {
				score += pips ;
			}
		}
		
		return score;
	}
	
	/**
	 * @param diceValues	An array of integers indicating the number of pips rolled on each die
	 * @return				The sum of the highest pair of values; If no pairs, return 0;
	 */
	public int scorePair(int[] diceValues) {
		int score = 0;
		int[] pipCounts;
		
		//Count pips
		pipCounts = countPips(diceValues);
		
		//Select highest pair
		for(int index = 0; index < pipCounts.length; index++) {
			if(pipCounts[index] > 1) {
				score = (index + 1) * 2;
			}			
		}
		
		return score;
	}
	
	/**
	 * 
	 * @param diceValues 	An array of integers indicating the number of pips rolled on each die
	 * @return				The sum of two pair; If less than two pair return 0;
	 */
	public int scoreTwoPair(int[] diceValues) {
		int score = 0;
		int pairCount = 0;
		int[] pipCounts;
		
		pipCounts = countPips(diceValues);
		
		//Total two pair
		for(int index = 0; index < pipCounts.length; index++) {
			if(pipCounts[index] > 1) {
				score += (index + 1) * 2;
				pairCount++;
			}
		}
		
		if(pairCount < 2) {
			score = 0;
		}
		
		
		return score;
	}
	
	/**
	 * @param diceValues 	An array of integers indicating the number of pips rolled on each die
	 * @return				The sum of three of a kind; If less than three of a kind return 0;
	 */
	public int scoreThreeOfAKind(int[] diceValues) {
		int score = 0;
		int[] pipCounts;
		
		//Count pips
		pipCounts = countPips(diceValues);
		
		//Sum three of a kind
		for(int index = 0; index < pipCounts.length; index++) {
			if(pipCounts[index] >= 3) {
				score = (index + 1) * 3;
			}
		}
		
		return score;
	}
	
	/**
	 * @param diceValues 	An array of integers indicating the number of pips rolled on each die
	 * @return				The sum of four of a kind; If less than four of a kind return 0;
	 */
	public int scoreFourOfAKind(int[] diceValues) {
		int score = 0;
		int[] pipCounts;
		
		//Count pips
		pipCounts = countPips(diceValues);
		
		//Sum four of a kind
		for(int index = 0; index < pipCounts.length; index++) {
			if(pipCounts[index] >= 4) {
				score = (index + 1) * 4;
			}
		}
		
		return score;
	}
	
	/**
	 * @param diceValues 	An array of integers indicating the number of pips rolled on each die
	 * @return				The value of 50; If less than five of a kind(yatzee) return 0;
	 */
	public int scoreYatzee(int[] diceValues) {
		int score = 0;
		int[] pipCounts;
		
		//Count pips
		pipCounts = countPips(diceValues);
		
		//Sum yatzee
		for(int index = 0; index < pipCounts.length; index++) {
			if(pipCounts[index] >= 5) {
				score = 50;
			}
		}
		
		return score;
	}
	
	/**
	 * @param diceValues	An array of integers indicating the number of pips rolled on each die
	 * @return				A value of 15; If not a small straight, return 0;
	 */
	public int scoreSmallStraight(int[] diceValues) {
		int score = 0;
		int[] pipCounts;
		boolean smallStraight = true;
		
		//Count pips
		pipCounts = countPips(diceValues);
		
		for(int index = 0; index < pipCounts.length - 1; index++) {
			if(pipCounts[index] != 1) {
				smallStraight = false;
			}
		}
		
		if(smallStraight) {
			score = 15;
		}
		
		return score;
	}
	
	/**
	 * @param diceValues	An array of integers indicating the number of pips rolled on each die
	 * @return				A value of 20; If not a large straight, return 0;
	 */
	public int scoreLargeStraight(int[] diceValues) {
		int score = 0;
		int[] pipCounts;
		boolean largeStraight = true;
		
		//Count pips
		pipCounts = countPips(diceValues);
		
		for(int index = 1; index < pipCounts.length; index++) {
			if(pipCounts[index] != 1) {
				largeStraight = false;
			}
		}
		
		if(largeStraight) {
			score = 20;
		}
		
		return score;
	}
	
	/**
	 * @param diceValues	An array of integers indicating the number of pips rolled on each die
	 * @return				A sum of all dice; If not a Full House, return 0;
	 */
	public int scoreFullHouse(int[] diceValues) {
		int score = 0;
		int[] pipCounts;
		boolean onePair = false;
		boolean threeOfAKind = false;
		
		//Count pips
		pipCounts = countPips(diceValues);
		
		for(int index = 0; index < pipCounts.length; index++) {
			if(pipCounts[index] == 2) {
				score += (index + 1) * 2;
				onePair = true;
			}
			
			if(pipCounts[index] == 3) {
				score += (index + 1) * 3;
				threeOfAKind = true;
			}
		}
		
		if(!onePair && !threeOfAKind) {
			score = 0;
		}
		
		return score;
	}
	
	/**
	 * @param diceValues	An array of integers indicating the number of pips rolled on each die	
	 * @return				A sum of all dice;
	 */
	public int scoreChance(int[] diceValues) {
		int score = 0;
		
		for(int index = 0; index < diceValues.length; index++) {
			score += diceValues[index];
		}
		
		return score; 
	}
	
	/**
	 * @param diceValues	An array of integers indicating the number of pips rolled on each die
	 * @return				An array of pip counts;
	 */
	private int[] countPips(int[] diceValues) {
		int[] pipCounts = new int[6];
		
		for(int index = 0; index < diceValues.length; index++) {
			pipCounts[(diceValues[index] - 1)]++;
		}
		
		return pipCounts;
	}
}
