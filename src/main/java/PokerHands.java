
public class PokerHands implements Comparable<PokerHands> {

	private final String cards;

	public PokerHands(String cards) {
		this.cards = cards;
	}

	public int compareTo(PokerHands another) {
		if (getFirstCardRank(0).compareTo(another.getFirstCardRank(0)) == 0)
			return getFirstCardRank(3).compareTo(another.getFirstCardRank(3));
		
		return getFirstCardRank(0).compareTo(another.getFirstCardRank(0));
	}

	private Integer getFirstCardRank(int cardIndex) {
		return Integer.parseInt(String.valueOf(cards.charAt(cardIndex)));
	}

}
