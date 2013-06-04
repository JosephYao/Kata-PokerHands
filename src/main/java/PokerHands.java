import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class PokerHands implements Comparable<PokerHands> {

	private static final int CARD_INDEX_STEP = 3;
	private static final int CARD_COUNT = 5;
	private final List<Integer> cardRanks;

	public PokerHands(String cards) {
		cardRanks = initializeCardRanks(cards);
	}

	private List<Integer> initializeCardRanks(String cards) {
		List<Integer> cardRanks = new ArrayList<>();
		for (int cardIndex = 0; cardIndex < CARD_COUNT; cardIndex++)
			cardRanks.add(getCardRank(cardIndex, cards));
		Collections.sort(cardRanks);
		return cardRanks;
	}

	public int compareTo(PokerHands another) {
		for (int cardIndex = 0; cardIndex < CARD_COUNT; cardIndex++)
			if (cardRanks.get(cardIndex).compareTo(another.cardRanks.get(cardIndex)) != 0)
				return cardRanks.get(cardIndex).compareTo(another.cardRanks.get(cardIndex));
		
		return 0;
	}

	private Integer getCardRank(int cardIndex, String cards) {
		return Integer.parseInt(String.valueOf(cards.charAt(cardIndex * CARD_INDEX_STEP)));
	}

}
