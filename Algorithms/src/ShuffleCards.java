import java.util.Arrays;

public class ShuffleCards {

	ShuffleCards()
	{
		int[] cards = {1, 2, 3, 4, 5};
		shuffle(cards);
		System.out.println(Arrays.toString(cards));
	}
	
	int rand(int lower, int higher)
	{
		return lower + (int)Math.random()*(higher - lower + 1);
	}
	
	void shuffle(int[] cards)
	{
		for (int i = 0; i < cards.length; i++) { 
			int k = rand(0, i);
			int temp = cards[k];
			cards[k] = cards[i];
			cards[i] = temp;
		} 
	}
	
	
}
