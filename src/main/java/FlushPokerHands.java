import java.util.List;


public class FlushPokerHands extends AbstractPokerHands {

	private final String cards;

	public FlushPokerHands(String cards, AbstractPokerHands next) {
		super(cards, PokerHandsType.FLUSH, next);
		this.cards = cards;
	}

	@Override
	protected boolean isMatched() {
		boolean result = true;
		for (int cardIndex = 0; cardIndex < CARD_COUNT - 1; cardIndex++)
			result &= cards.charAt(getCardSuitIndex(cardIndex)) == 
					  cards.charAt(getCardSuitIndex(cardIndex + 1));
		return result;
	}

	private int getCardSuitIndex(int cardIndex) {
		return cardIndex * CARD_INDEX_STEP + 1;
	}

	@Override
	protected int compare(List<Integer> cardRanks,
			List<Integer> anotherCardRanks) {
		return 0;
	}

}
