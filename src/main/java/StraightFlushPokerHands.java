import java.util.List;


public class StraightFlushPokerHands extends AbstractPokerHands {

	public StraightFlushPokerHands(String cards, AbstractPokerHands next) {
		super(cards, PokerHandsType.STRAIGHT_FLUSH, next);
	}

	@Override
	protected boolean isMatched() {
		return isStraight() && isFlush();
	}

	@Override
	protected int compare(List<Integer> cardRanks, List<Integer> anotherCardRanks) {
		return compareHighCard(cardRanks, anotherCardRanks);
	}

}
