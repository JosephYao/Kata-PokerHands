
public class PokerHands implements Comparable<PokerHands> {

	private static final int CARD_INDEX_STEP = 3;
	private static final int CARD_COUNT = 5;
	private final String cards;

	public PokerHands(String cards) {
		this.cards = cards;
	}

	public int compareTo(PokerHands another) {
		for (int cardIndex = 0; cardIndex < CARD_COUNT; cardIndex++)
			if (getFirstCardRank(cardIndex).compareTo(another.getFirstCardRank(cardIndex)) != 0)
				return getFirstCardRank(cardIndex).compareTo(another.getFirstCardRank(cardIndex));
		
		return 0;
	}

	private Integer getFirstCardRank(int cardIndex) {
		return Integer.parseInt(String.valueOf(cards.charAt(cardIndex * CARD_INDEX_STEP)));
	}

}
