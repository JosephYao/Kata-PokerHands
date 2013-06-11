import java.util.List;



public class HighCardPokerHands extends AbstractPokerHands {

	public HighCardPokerHands(String cards, AbstractPokerHands next) {
		super(cards, next);
	}
	
	public HighCardPokerHands(String cards) {
		super(cards, null);
	}
	
	@Override
	public int compareTo(AbstractPokerHands another) {
		return compare(cardRanks, another.cardRanks);
	}

	@Override
	protected PokerHandsType getType() {
		return PokerHandsType.HIGH_CARD;
	}

	@Override
	protected int compare(List<Integer> cardRanks, List<Integer> anotherCardRanks) {
		return compareHighCard(cardRanks, anotherCardRanks);
	}

}
