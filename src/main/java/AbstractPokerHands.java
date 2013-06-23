import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public abstract class AbstractPokerHands implements Comparable<AbstractPokerHands> {

	protected final List<Integer> cardRanks;
	private final AbstractPokerHands next;
	private final PokerHandsType type;
	private final String cards;
	private static final int CARD_INDEX_STEP = 3;
	protected static final int CARD_COUNT = 5;

	protected enum PokerHandsType {
		HIGH_CARD,
		PAIR,
		TWO_PAIRS, 
		THREE_OF_A_KIND, 
		STRAIGHT, 
		FLUSH, 
		FULLHOUSE, 
		FOUROFAKIND, 
		STRAIGHT_FLUSH;
	}
	
	public AbstractPokerHands(String cards, PokerHandsType type, AbstractPokerHands next) {
		cardRanks = initializeCardRanks(cards);
		this.next = next;
		this.type = type;
		this.cards = cards;
	}
	
	private List<Integer> initializeCardRanks(String cards) {
		List<Integer> result = new ArrayList<>();
		for (int cardIndex = 0; cardIndex < CARD_COUNT; cardIndex++)
			result.add(getCardRank(cardIndex, cards));
		Collections.sort(result, Collections.reverseOrder());
		return result;
	}

	private Integer getCardRank(int cardIndex, String cards) {
		return CARD_RANK_SYMBOLS.indexOf(cards.charAt(cardIndex * CARD_INDEX_STEP));
	}

	private final static List<Character> CARD_RANK_SYMBOLS = Arrays.asList(new Character[]{
			'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'
	});	

	abstract protected boolean isMatched();
	
	abstract protected int compare(List<Integer> cardRanks, List<Integer> anotherCardRanks);
	
	@Override
	public int compareTo(AbstractPokerHands another) {
		if (getType().compareTo(another.getType()) != 0)
			return getType().compareTo(another.getType());
		
		if (isMatched())
			return compare(cardRanks, another.cardRanks);
		else
			return next.compareTo(another);
	}

	private PokerHandsType getType() {
		if (isMatched())
			return type;
		else
			return next.getType();
	}
	
	protected int compareHighCard(List<Integer> cardRanks, List<Integer> anotherCardRanks) {
		for (int cardIndex = 0; cardIndex < CARD_COUNT; cardIndex++)
			if (cardRanks.get(cardIndex).compareTo(anotherCardRanks.get(cardIndex)) != 0)
				return cardRanks.get(cardIndex).compareTo(anotherCardRanks.get(cardIndex));
		
		return 0;
	}
	
	protected boolean isThreeNeighborCardRanksEquals(int index, List<Integer> cardRanks) {
		return cardRanks.get(index) == cardRanks.get(index + 1) &&
			   cardRanks.get(index) == cardRanks.get(index + 2);
	}

	protected boolean isTwoNeighborCardRanksEquals(int index, List<Integer> cardRanks) {
		return cardRanks.get(index) == cardRanks.get(index + 1);
	}

	protected Integer getThreeOfAKindCardRank(List<Integer> cardRanks) {
		for (int index = 0; index < CARD_COUNT - 2; index++)
			if (isThreeNeighborCardRanksEquals(index, cardRanks))
				return cardRanks.get(index);
		
		throw new IllegalStateException();
	}

	protected boolean isFlush() {
		boolean result = true;
		for (int cardIndex = 0; cardIndex < CARD_COUNT - 1; cardIndex++)
			result &= cards.charAt(getCardSuitIndex(cardIndex)) == 
					  cards.charAt(getCardSuitIndex(cardIndex + 1));
		return result;
	}

	private int getCardSuitIndex(int cardIndex) {
		return cardIndex * CARD_INDEX_STEP + 1;
	}

	protected boolean isStraight() {
		boolean result = true;
		for (int index = 0; index < CARD_COUNT - 1; index++)
			result &= cardRanks.get(index) - 1 == cardRanks.get(index + 1);
		return result;
	}

}
