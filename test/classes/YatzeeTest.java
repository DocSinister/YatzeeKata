package classes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class YatzeeTest {
	YatzeeRules rules;
	
	@Before
	public void setUp() {
		rules = new YatzeeRules();
	}
	
	@Test
	public void scorePipsFunctionReceivesFiveOnesAndReturnsTheValueFive() {
		int[] ones = {1, 1, 1, 1, 1};
		
		assertEquals(5, rules.scorePips(ones, 1));
	}
	
	@Test
	public void scorePipsFunctionReceivesThreeFivesAndReturnsAValueOfFifteen() {
		int[] fives = {5, 5, 5, 3, 4};
		
		assertEquals(15, rules.scorePips(fives, 5));
	}
	
	@Test
	public void scorePairFunctionReceivesTwoThreesAndReturnsAValueOfSix() {
		int[] pairs = {5, 1, 1, 3, 3};
		
		assertEquals(6, rules.scorePair(pairs));
	}
	
	@Test
	public void scoreTwoPairFunctionReceivesTwoTwosAndTwoFivesAndReturnsValueOfFourteen() {
		int[] twoPair = {1, 2, 2, 5, 5};
		
		assertEquals(14, rules.scoreTwoPair(twoPair));
	}
	
	@Test
	public void scoreThreeOfAKindReceivesThreeFoursAndREturnsAValueOfTwelve() {
		int[] threeOfAKind = {5, 4, 4, 4, 6};
		
		assertEquals(12, rules.scoreThreeOfAKind(threeOfAKind));
	}
	
	@Test
	public void scoreFourOfAKindReceivesFourSizesAndReturnsValueOfTwentyFour() {
		int[] fourOfAKind = {6, 6, 2, 6, 6 };
		
		assertEquals(24, rules.scoreFourOfAKind(fourOfAKind));
	}
	
	@Test
	public void scoreYatzeeReceivesFiveTwosAndReturnsFifty() {
		int[] yatzee = {2, 2, 2, 2, 2};
		
		assertEquals(50, rules.scoreYatzee(yatzee));
	}
	
	@Test
	public void scoreSmallStraightReceivesSmallStraightAndReturnsValueOfFifteen() {
		int[] smallStraight = {1, 2, 3, 4, 5};
		
		assertEquals(15, rules.scoreSmallStraight(smallStraight));
	}

	@Test
	public void scoreLargeStraightReceivesLargeStraightAndReturnsValueOfTwenty() {
		int[] largeStraight = {2, 3, 4, 5, 6};
		
		assertEquals(20, rules.scoreLargeStraight(largeStraight));
	}
	
	@Test
	public void scoreFulHouseReceivesFullHouseAndReturnsSumOfAllSice() {
		int[] fullHouse = {1, 1, 1, 3, 3};
		
		assertEquals(9, rules.scoreFullHouse(fullHouse));
	}
	
	@Test
	public void scoreChanceReceivesSixSixTwoOneFourAndReturnsValueOfNinteen() {
		int[] chance = {6, 6, 2, 1, 4};
		
		assertEquals(19, rules.scoreChance(chance));
	}
}
