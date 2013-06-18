import java.util.List;


public class ThreeOfAKindPokerHands extends AbstractPokerHands {

	public ThreeOfAKindPokerHands(String cards, AbstractPokerHands next) {
		super(cards, PokerHandsType.THREE_OF_A_KIND, next);
	}

	@Override
	protected boolean isMatched() {
		return isThreeNeighborCardRanksEquals(2, cardRanks) || 
			   isThreeNeighborCardRanksEquals(1, cardRanks) ||
			   isThreeNeighborCardRanksEquals(0, cardRanks);
	}

	private boolean isThreeNeighborCardRanksEquals(int index, List<Integer> cardRanks) {
		return cardRanks.get(index) == cardRanks.get(index + 1) &&
			   cardRanks.get(index) == cardRanks.get(index + 2);
	}

	@Override
	protected int compare(List<Integer> cardRanks, List<Integer> anotherCardRanks) {
		return getThreeOfAKindCardRank(cardRanks).compareTo(
			   getThreeOfAKindCardRank(anotherCardRanks));
	}

	private Integer getThreeOfAKindCardRank(List<Integer> cardRanks) {
		for (int index = 0; index < CARD_COUNT - 2; index++)
			if (isThreeNeighborCardRanksEquals(index, cardRanks))
				return cardRanks.get(index);
		
		throw new IllegalStateException();
	}

}
