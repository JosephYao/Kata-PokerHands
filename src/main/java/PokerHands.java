import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class PokerHands implements Comparable<PokerHands> {

	private static final int CARD_INDEX_STEP = 3;
	private static final int CARD_COUNT = 5;
	private final List<Integer> cardRanks;
	private final static List<Character> CARD_RANK_SYMBOLS = Arrays.asList(new Character[]{
			'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'
	});

	public PokerHands(String cards) {
		cardRanks = initializeCardRanks(cards);
	}

	private List<Integer> initializeCardRanks(String cards) {
		List<Integer> cardRanks = new ArrayList<>();
		for (int cardIndex = 0; cardIndex < CARD_COUNT; cardIndex++)
			cardRanks.add(getCardRank(cardIndex, cards));
		Collections.sort(cardRanks, Collections.reverseOrder());
		return cardRanks;
	}

	public int compareTo(PokerHands another) {
		if (isPair() && another.isPair())
			return getPairCardRank().compareTo(another.getPairCardRank());
		
		if (isPair())
			return 1;
		
		if (another.isPair())
			return -1;
		
		for (int cardIndex = 0; cardIndex < CARD_COUNT; cardIndex++)
			if (cardRanks.get(cardIndex).compareTo(another.cardRanks.get(cardIndex)) != 0)
				return cardRanks.get(cardIndex).compareTo(another.cardRanks.get(cardIndex));
		
		return 0;
	}

	private Integer getPairCardRank() {
		return cardRanks.get(getPairCardIndex());
	}

	private boolean isPair() {
		return getPairCardIndex() != -1;
	}

	private int getPairCardIndex() {
		for (int index = 0; index < CARD_COUNT - 1; index++)
			if (cardRanks.get(index) == cardRanks.get(index + 1))
				return index;
		
		return -1;
	}

	private Integer getCardRank(int cardIndex, String cards) {
		return CARD_RANK_SYMBOLS.indexOf(cards.charAt(cardIndex * CARD_INDEX_STEP));
	}

}
