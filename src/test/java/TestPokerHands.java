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
