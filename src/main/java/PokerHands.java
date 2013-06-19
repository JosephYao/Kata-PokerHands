

public class PokerHands implements Comparable<PokerHands> {

	private final String cards;

	public PokerHands(String cards) {
		this.cards = cards;
	}

	public int compareTo(PokerHands another) {
		return  new FlushPokerHands(cards, 
				new StraightPokerHands(cards,
				new ThreeOfAKindPokerHands(cards, 
				new TwoPairsPokerHands(cards,
				new PairPokerHands(cards, 
				new HighCardPokerHands(cards)))))).compareTo(
				new FlushPokerHands(another.cards,
				new StraightPokerHands(another.cards,
				new ThreeOfAKindPokerHands(another.cards,
				new TwoPairsPokerHands(another.cards, 
				new PairPokerHands(another.cards, 
				new HighCardPokerHands(another.cards)))))));
	}

}
