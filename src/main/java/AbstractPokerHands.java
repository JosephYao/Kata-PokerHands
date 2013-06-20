import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public abstract class AbstractPokerHands implements Comparable<AbstractPokerHands> {

	protected final List<Integer> cardRanks;
	protected final AbstractPokerHands next;
	private final PokerHandsType type;
	private final static List<Character> CARD_RANK_SYMBOLS = Arrays.asList(new Character[]{
			'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'
	});	
	protected static final int CARD_INDEX_STEP = 3;
	protected static final int CARD_COUNT = 5;

	protected enum PokerHandsType {
		HIGH_CARD(0),
		PAIR(1),
		TWO_PAIRS(2), 
		THREE_OF_A_KIND(3), 
		STRAIGHT(4), 
		FLUSH(5), 
		FULLHOUSE(6);
		
		private final int rank;

		PokerHandsType(int rank) {
			this.rank = rank;
		}
		
		Integer getRank() {
			return rank;
		}
	}
	
	public AbstractPokerHands(String cards, PokerHandsType type, AbstractPokerHands next) {
		cardRanks = initializeCardRanks(cards);
		this.next = next;
		this.type = type;
	}
	
	private PokerHandsType getType() {
		if (isMatched())
			return type;
		else
			return next.getType();
	}
	
	abstract protected boolean isMatched();

	abstract protected int compare(List<Integer> cardRanks, List<Integer> anotherCardRanks);
	
	private List<Integer> initializeCardRanks(String cards) {
		List<Integer> cardRanks = new ArrayList<>();
		for (int cardIndex = 0; cardIndex < CARD_COUNT; cardIndex++)
			cardRanks.add(getCardRank(cardIndex, cards));
		Collections.sort(cardRanks, Collections.reverseOrder());
		return cardRanks;
	}

	private Integer getCardRank(int cardIndex, String cards) {
		return CARD_RANK_SYMBOLS.indexOf(cards.charAt(cardIndex * CARD_INDEX_STEP));
	}

	protected int compareHighCard(List<Integer> cardRanks, List<Integer> anotherCardRanks) {
		for (int cardIndex = 0; cardIndex < CARD_COUNT; cardIndex++)
			if (cardRanks.get(cardIndex).compareTo(anotherCardRanks.get(cardIndex)) != 0)
				return cardRanks.get(cardIndex).compareTo(anotherCardRanks.get(cardIndex));
		
		return 0;
	}

	@Override
	public int compareTo(AbstractPokerHands another) {
		if (getType().getRank().compareTo(another.getType().getRank()) != 0)
			return getType().getRank().compareTo(another.getType().getRank());
		
		if (isMatched())
			return compare(cardRanks, another.cardRanks);
		else
			return next.compareTo(another);
	}

	protected boolean isThreeNeighborCardRanksEquals(int index, List<Integer> cardRanks) {
		return cardRanks.get(index) == cardRanks.get(index + 1) &&
			   cardRanks.get(index) == cardRanks.get(index + 2);
	}

	protected boolean isTwoNeighborCardRanksEquals(int pairCardIndex, List<Integer> cardRanks) {
		return cardRanks.get(pairCardIndex) == cardRanks.get(pairCardIndex + 1);
	}

}
