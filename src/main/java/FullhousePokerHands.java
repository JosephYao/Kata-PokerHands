import java.util.List;


public class FullhousePokerHands extends AbstractPokerHands {

	public FullhousePokerHands(String cards, AbstractPokerHands next) {
		super(cards, PokerHandsType.FULLHOUSE, next);
	}

	@Override
	protected boolean isMatched() {
		return isFullHouse(0, 2) || isFullHouse(3, 0);
	}

	private boolean isFullHouse(int pairCardIndex, int threeOfAKindCardIndex) {
		return isTwoNeighborCardRanksEquals(pairCardIndex, cardRanks) &&
			   isThreeNeighborCardRanksEquals(threeOfAKindCardIndex, cardRanks);
	}

	@Override
	protected int compare(List<Integer> cardRanks, List<Integer> anotherCardRanks) {
		return getThreeOfAKindCardRank(cardRanks).compareTo(
			   getThreeOfAKindCardRank(anotherCardRanks));
	}

}
