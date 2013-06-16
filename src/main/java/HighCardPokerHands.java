import java.util.List;



public class HighCardPokerHands extends AbstractPokerHands {

	public HighCardPokerHands(String cards) {
		super(cards, PokerHandsType.HIGH_CARD, null);
	}
	
	@Override
	protected int compare(List<Integer> cardRanks, List<Integer> anotherCardRanks) {
		return compareHighCard(cardRanks, anotherCardRanks);
	}

	@Override
	protected boolean isMatched() {
		return true;
	}
}
