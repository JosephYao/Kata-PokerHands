
public class PokerHands implements Comparable<PokerHands> {

	private final String cards;

	public PokerHands(String cards) {
		this.cards = cards;
	}

	public int compareTo(PokerHands another) {
		if (getFirstCardRank(cards) > getFirstCardRank(another.cards))
			return 1;
		
		return 0;
	}

	private int getFirstCardRank(String cards) {
		return Integer.parseInt(String.valueOf(cards.charAt(0)));
	}

}
