import java.util.ArrayList;
import java.util.List;



public abstract class AbstractPairPokerHands extends AbstractPokerHands {

	public AbstractPairPokerHands(String cards, PokerHandsType type,
			AbstractPokerHands next) {
		super(cards, type, next);
	}

	@Override
	protected int compare(List<Integer> cardRanks, List<Integer> anotherCardRanks) {
		List<Integer> pairsCardRanks = getPairCardRanks(cardRanks);
		List<Integer> anotherPairsCardRanks = getPairCardRanks(anotherCardRanks);
	
		for (int index = 0; index < pairsCardRanks.size(); index++)
			if (pairsCardRanks.get(index).compareTo(anotherPairsCardRanks.get(index)) != 0)
				return pairsCardRanks.get(index).compareTo(anotherPairsCardRanks.get(index));
	
		return compareHighCard(
				getRemainingHighCard(cardRanks, pairsCardRanks),
				getRemainingHighCard(anotherCardRanks, anotherPairsCardRanks));
	}

	private List<Integer> getPairCardRanks(List<Integer> cardRanks) {
		List<Integer> result = new ArrayList<>();
	
		for (int index = 0; index < CARD_COUNT - 1; index++)
			if (cardRanks.get(index) == cardRanks.get(index + 1))
				result.add(cardRanks.get(index));
	
		return result;
	}

	protected int getPairCount() {
		int pairCount = 0;
	
		for (int index = 0; index < CARD_COUNT - 1; index++)
			if (cardRanks.get(index) == cardRanks.get(index + 1))
				pairCount++;
		return pairCount;
	}

	private List<Integer> getRemainingHighCard(List<Integer> cardRanks, List<Integer> pairCardRanks) {
		List<Integer> remainingHighCard = new ArrayList<>(cardRanks);
		remainingHighCard.removeAll(pairCardRanks);
		return remainingHighCard;
	}

}
