import java.util.List;


public class FourOfAKindPokerHands extends AbstractPokerHands {

	public FourOfAKindPokerHands(String cards, AbstractPokerHands next) {
		super(cards, PokerHandsType.FOUROFAKIND, next);
	}

	@Override
	protected boolean isMatched() {
		return isFourNeighborCardRanksEquals(1) ||
			   isFourNeighborCardRanksEquals(0);
	}

	private boolean isFourNeighborCardRanksEquals(int index) {
		return cardRanks.get(index) == cardRanks.get(index + 1) &&
			   cardRanks.get(index) == cardRanks.get(index + 2) &&
			   cardRanks.get(index) == cardRanks.get(index + 3);
	}

	@Override
	protected int compare(List<Integer> cardRanks,
			List<Integer> anotherCardRanks) {
		return 0;
	}

}
