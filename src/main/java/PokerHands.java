
public class PokerHands implements Comparable<PokerHands> {

	private final String cards;

	public PokerHands(String cards) {
		this.cards = cards;
	}

	public int compareTo(PokerHands another) {
		return getFirstCardRank(cards).compareTo(getFirstCardRank(another.cards));
	}

	private Integer getFirstCardRank(String cards) {
		return Integer.parseInt(String.valueOf(cards.charAt(0)));
	}

}
