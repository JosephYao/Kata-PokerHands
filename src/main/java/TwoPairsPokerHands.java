import java.util.ArrayList;
import java.util.List;


public class TwoPairsPokerHands extends AbstractPokerHands {

	public TwoPairsPokerHands(String cards, AbstractPokerHands next) {
		super(cards, PokerHandsType.TWO_PAIRS, next);
	}

	@Override
	protected int compare(List<Integer> cardRanks, List<Integer> anotherCardRanks) {
		List<Integer> twoPairsCardRanks = getTwoPairsCardRanks(cardRanks);
		List<Integer> anotherTwoPairsCardRanks = getTwoPairsCardRanks(anotherCardRanks);
		
		if (twoPairsCardRanks.get(0).compareTo(anotherTwoPairsCardRanks.get(0)) != 0)
			return twoPairsCardRanks.get(0).compareTo(anotherTwoPairsCardRanks.get(0));
		else
			return twoPairsCardRanks.get(1).compareTo(anotherTwoPairsCardRanks.get(1)); 
	}

	private List<Integer> getTwoPairsCardRanks(List<Integer> cardRanks) {
		List<Integer> result = new ArrayList<>();
		
		for (int index = 0; index < CARD_COUNT - 1; index++)
			if (cardRanks.get(index) == cardRanks.get(index + 1))
				result.add(cardRanks.get(index));
		
		return result;
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
