import java.util.List;


public class FlushPokerHands extends AbstractPokerHands {

	public FlushPokerHands(String cards, AbstractPokerHands next) {
		super(cards, PokerHandsType.FLUSH, next);
	}

	@Override
	protected boolean isMatched() {
		return isFlush();
	}

	@Override
	protected int compare(List<Integer> cardRanks, List<Integer> anotherCardRanks) {
		return compareHighCard(cardRanks, anotherCardRanks);
	}

}
