

public class PokerHands implements Comparable<PokerHands> {

	private final String cards;

	public PokerHands(String cards) {
		this.cards = cards;
	}

	public int compareTo(PokerHands another) {
		return  new StraightFlushPokerHands(cards,
				new FourOfAKindPokerHands(cards,
				new FullhousePokerHands(cards,
				new FlushPokerHands(cards, 
				new StraightPokerHands(cards,
				new ThreeOfAKindPokerHands(cards, 
				new TwoPairsPokerHands(cards,
				new PairPokerHands(cards, 
				new HighCardPokerHands(cards))))))))).compareTo(
				new StraightFlushPokerHands(another.cards, 
				new FourOfAKindPokerHands(another.cards,
				new FullhousePokerHands(another.cards, 
				new FlushPokerHands(another.cards,
				new StraightPokerHands(another.cards,
				new ThreeOfAKindPokerHands(another.cards,
				new TwoPairsPokerHands(another.cards, 
				new PairPokerHands(another.cards, 
				new HighCardPokerHands(another.cards))))))))));
	}

}
