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
