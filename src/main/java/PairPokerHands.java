

public class PairPokerHands extends AbstractPairPokerHands {

	public PairPokerHands(String cards, AbstractPokerHands next) {
		super(cards, PokerHandsType.PAIR, next);
	}

	@Override
	protected boolean isMatched() {
		return getPairCount() == 1;
	}

}
