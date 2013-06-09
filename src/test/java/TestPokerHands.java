import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestPokerHands {

	@Test
	public void high_card_with_same_cards_are_equal() {
		assertPokerHandsEquals("2S 3D 4H 5C 7S", "2S 3D 4H 5C 7S");
	}

	@Test
	public void high_card_with_only_one_card_different() {
		assertPokerHandsLargerThan("9S 4H 5C 6S 8C", "2S 4H 5C 6S 8C");
		assertPokerHandsSmallerThan("2S 4H 5C 6S 8C", "9S 4H 5C 6S 8C");
		assertPokerHandsLargerThan("2S 9H 5C 6S 8C", "2S 4H 5C 6S 8C");
		assertPokerHandsLargerThan("2S 4H 9C 6S 8C", "2S 4H 5C 6S 8C");
	}
	
	@Test
	public void high_card_with_only_one_card_different_and_highest_card_are_in_different_position() {
		assertPokerHandsLargerThan("2S 4H 9C 6S 8C", "2S 5H 4C 8S 6C");
	}
	
	@Test
	public void high_card_with_card_rank_not_a_number() {
		assertPokerHandsLargerThan("2S 4H 6S 8C TD", "2S 4H 6S 8C 9D");
		assertPokerHandsLargerThan("2S 4H 6S 8C JD", "2S 4H 6S 8C TD");
		assertPokerHandsLargerThan("2S 4H 6S 8C QD", "2S 4H 6S 8C JD");
		assertPokerHandsLargerThan("2S 4H 6S 8C KD", "2S 4H 6S 8C QD");
		assertPokerHandsLargerThan("2S 4H 6S 8C AD", "2S 4H 6S 8C KD");
	} 
	
	@Test
	public void high_card_with_larger_highest_rank_but_smaller_second_highest_card_rank() {
		assertPokerHandsLargerThan("2S 4H 6S 7C AD", "2S 4H 6S 8C KD");
	}
	
	@Test
	public void pair_is_higher_than_high_card() {
		assertPokerHandsLargerThan("2S 2H 3S 4C 5D", "9S JH QS KC AD");
		assertPokerHandsSmallerThan("9S JH QS KC AD", "2S 2H 3S 4C 5D");
		assertPokerHandsLargerThan("2S 3H 3S 4C 5D", "9S JH QS KC AD");
	}
	
	@Test
	public void pair_compare_to_pair_by_pair_card_rank() {
		assertPokerHandsSmallerThan("2S 3H 5S 6C 6D", "2S 3H 5S 7C 7D");
		assertPokerHandsLargerThan("2S 3H 5S 8C 8D", "2S 3H 5S 7C 7D");
	}
	
	private void assertPokerHandsSmallerThan(String firstPokerHands, String secondPokerHands) {
		PokerHands first = new PokerHands(firstPokerHands);
		PokerHands second = new PokerHands(secondPokerHands);
		assertEquals(-1, Integer.signum(first.compareTo(second)));
	}
	
	private void assertPokerHandsLargerThan(String firstPokerHands, String secondPokerHands) {
		PokerHands first = new PokerHands(firstPokerHands);
		PokerHands second = new PokerHands(secondPokerHands);
		assertEquals(1, Integer.signum(first.compareTo(second)));
	}
	
	private void assertPokerHandsEquals(String firstPokerHands, String secondPokerHands) {
		PokerHands first = new PokerHands(firstPokerHands);
		PokerHands second = new PokerHands(secondPokerHands);
		assertEquals(0, Integer.signum(first.compareTo(second)));
	}
	
}
