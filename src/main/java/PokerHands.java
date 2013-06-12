

public class PokerHands implements Comparable<PokerHands> {

	private final String cards;

	public PokerHands(String cards) {
		this.cards = cards;
	}

	public int compareTo(PokerHands another) {
		return  new TwoPairsPokerHands(cards,
				new PairPokerHands(cards, 
				new HighCardPokerHands(cards))).compareTo(
				new TwoPairsPokerHands(another.cards, 
				new PairPokerHands(another.cards, 
				new HighCardPokerHands(another.cards))));
	}

}
