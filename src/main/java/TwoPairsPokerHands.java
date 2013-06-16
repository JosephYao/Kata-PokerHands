
public class TwoPairsPokerHands extends AbstractPairPokerHands {

	public TwoPairsPokerHands(String cards, AbstractPokerHands next) {
		super(cards, PokerHandsType.TWO_PAIRS, next);
	}

	@Override
	protected boolean isMatched() {
		return getPairCount() == 2;
	}

}
