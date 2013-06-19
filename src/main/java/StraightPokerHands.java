import java.util.List;


public class StraightPokerHands extends AbstractPokerHands {

	public StraightPokerHands(String cards, AbstractPokerHands next) {
		super(cards, PokerHandsType.STRAIGHT, next);
	}

	@Override
	protected boolean isMatched() {
		boolean result = true;
		for (int index = 0; index < CARD_COUNT - 1; index++)
			result &= cardRanks.get(index) - 1 == cardRanks.get(index + 1);
		return result;
	}

	@Override
	protected int compare(List<Integer> cardRanks,
			List<Integer> anotherCardRanks) {
		// TODO Auto-generated method stub
		return 0;
	}

}
