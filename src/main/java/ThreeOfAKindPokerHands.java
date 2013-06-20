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

	@Override
	protected int compare(List<Integer> cardRanks, List<Integer> anotherCardRanks) {
		return getThreeOfAKindCardRank(cardRanks).compareTo(
			   getThreeOfAKindCardRank(anotherCardRanks));
	}

}
