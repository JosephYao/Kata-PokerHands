import java.util.List;


public class ThreeOfAKindPokerHands extends AbstractPokerHands {

	public ThreeOfAKindPokerHands(String cards, AbstractPokerHands next) {
		super(cards, PokerHandsType.THREE_OF_A_KIND, next);
	}

	@Override
	protected boolean isMatched() {
		return isThreeNeighborCardRanksEquals(2) || 
			   isThreeNeighborCardRanksEquals(1) ||
			   isThreeNeighborCardRanksEquals(0);
	}

	private boolean isThreeNeighborCardRanksEquals(int index) {
		return cardRanks.get(index) == cardRanks.get(index + 1) &&
			   cardRanks.get(index) == cardRanks.get(index + 2);
	}

	@Override
	protected int compare(List<Integer> cardRanks,
			List<Integer> anotherCardRanks) {
		return 0;
	}

}
