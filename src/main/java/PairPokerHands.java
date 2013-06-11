import java.util.ArrayList;
import java.util.List;


public class PairPokerHands extends AbstractPokerHands {

	private static final int NO_PAIR_CARD_INDEX = -1;

	public PairPokerHands(String cards, AbstractPokerHands next) {
		super(cards, next);
	}

	@Override
	public int compareTo(AbstractPokerHands another) {
		if (getType().getRank().compareTo(another.getType().getRank()) != 0)
			return getType().getRank().compareTo(another.getType().getRank());
		else
			return compare(cardRanks, another.cardRanks);
	}

	@Override
	protected PokerHandsType getType() {
		if (isPair())
			return PokerHandsType.PAIR;
		else
			return next.getType();
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

	private boolean isPair() {
		return getPairCardIndex(cardRanks) != NO_PAIR_CARD_INDEX;
	}

	private int getPairCardIndex(List<Integer> cardRanks) {
		for (int index = 0; index < CARD_COUNT - 1; index++)
			if (cardRanks.get(index) == cardRanks.get(index + 1))
				return index;
		
		return NO_PAIR_CARD_INDEX;
	}

	@Override
	protected int compare(List<Integer> cardRanks, List<Integer> anotherCardRanks) {
		if (isPair())
			if (getPairCardRank(cardRanks).compareTo(getPairCardRank(anotherCardRanks)) != 0)
				return getPairCardRank(cardRanks).compareTo(getPairCardRank(anotherCardRanks));
			else
				return compareHighCard(
						getRestHighCardsOfPair(cardRanks), 
						getRestHighCardsOfPair(anotherCardRanks));
		else
			return next.compare(cardRanks, anotherCardRanks);
	}

}
