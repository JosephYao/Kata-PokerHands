import java.util.ArrayList;
import java.util.List;


public class PairPokerHands extends AbstractPokerHands {

	private static final int NO_PAIR_CARD_INDEX = -1;

	public PairPokerHands(String cards, AbstractPokerHands next) {
		super(cards, PokerHandsType.PAIR, next);
	}

	private List<Integer> getRestHighCardsOfPair(List<Integer> cardRanks) {
		List<Integer> result = new ArrayList<>(cardRanks);
		int pairCardIndex = getPairCardIndex(cardRanks);
		result.remove(pairCardIndex);
		result.remove(pairCardIndex);
		return result;
	}

	private Integer getPairCardRank(List<Integer> cardRanks) {
		return cardRanks.get(getPairCardIndex(cardRanks));
	}

	private int getPairCardIndex(List<Integer> cardRanks) {
		for (int index = 0; index < CARD_COUNT - 1; index++)
			if (cardRanks.get(index) == cardRanks.get(index + 1))
				return index;
		
		return NO_PAIR_CARD_INDEX;
	}

	@Override
	protected int compare(List<Integer> cardRanks, List<Integer> anotherCardRanks) {
		if (getPairCardRank(cardRanks).compareTo(getPairCardRank(anotherCardRanks)) != 0)
			return getPairCardRank(cardRanks).compareTo(getPairCardRank(anotherCardRanks));
		else
			return compareHighCard(
					getRestHighCardsOfPair(cardRanks), 
					getRestHighCardsOfPair(anotherCardRanks));
	}

	@Override
	protected boolean isMatched() {
		return getPairCardIndex(cardRanks) != NO_PAIR_CARD_INDEX;
	}

}
