import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class TestPokerHands {

	@Test
	public void high_card_with_same_cards_are_equal() {
		PokerHands first = new PokerHands("2S 3D 4H 5C 7S");
		PokerHands second = new PokerHands("2S 3D 4H 5C 7S");
		assertEquals(0, first.compareTo(second));
	}

}
