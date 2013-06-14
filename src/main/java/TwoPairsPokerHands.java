import java.util.List;


public class TwoPairsPokerHands extends AbstractPokerHands {

	public TwoPairsPokerHands(String cards, AbstractPokerHands next) {
		super(cards, PokerHandsType.TWO_PAIRS, next);
	}

	@Override
	protected int compare(List<Integer> cardRanks, List<Integer> anotherCardRanks) {
		return 0; 
	}

	@Override
	protected boolean isMatched() {
		int pairCount = 0;
		
		for (int index = 0; index < CARD_COUNT - 1; index++)
			if (cardRanks.get(index) == cardRanks.get(index + 1))
				pairCount++;
		
		return pairCount == 2;
	}

}
