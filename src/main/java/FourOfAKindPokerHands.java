import java.util.List;


public class FourOfAKindPokerHands extends AbstractPokerHands {

	public FourOfAKindPokerHands(String cards, AbstractPokerHands next) {
		super(cards, PokerHandsType.FOUROFAKIND, next);
	}

	@Override
	protected boolean isMatched() {
		return isFourNeighborCardRanksEquals(1, cardRanks) ||
			   isFourNeighborCardRanksEquals(0, cardRanks);
	}

	private boolean isFourNeighborCardRanksEquals(int index, List<Integer> cardRanks) {
		return cardRanks.get(index) == cardRanks.get(index + 1) &&
			   cardRanks.get(index) == cardRanks.get(index + 2) &&
			   cardRanks.get(index) == cardRanks.get(index + 3);
	}

	@Override
	protected int compare(List<Integer> cardRanks, List<Integer> anotherCardRanks) {
		return getFourOfAKindCardRank(cardRanks).compareTo(
			   getFourOfAKindCardRank(anotherCardRanks));
	}

	private Integer getFourOfAKindCardRank(List<Integer> cardRanks) {
		if (isFourNeighborCardRanksEquals(0, cardRanks))
			return cardRanks.get(0);
		else
			return cardRanks.get(1);
	}

}
