import java.util.List;


public class TwoPairsPokerHands extends AbstractPokerHands {

	public TwoPairsPokerHands(String cards, AbstractPokerHands next) {
		super(cards, next);
	}

	@Override
	public int compareTo(AbstractPokerHands another) {
		if (isTwoPairs(cardRanks))
			return 1;
		
		if (isTwoPairs(another.cardRanks))
			return -1;
		
		return next.compareTo(another.next);
	}

	private boolean isTwoPairs(List<Integer> cardRanks) {
		int pairCount = 0;
		
		for (int index = 0; index < CARD_COUNT - 1; index++)
			if (cardRanks.get(index) == cardRanks.get(index + 1))
				pairCount++;
		
		return pairCount == 2;
	}

	@Override
	protected PokerHandsType getType() {
		return null;
	}

	@Override
	protected int compare(List<Integer> cardRanks, List<Integer> anotherCardRanks) {
		return 0;
	}

}
