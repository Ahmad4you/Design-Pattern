package templateMethod;

//Abstract class defining the template method
abstract class GameLoop {
	protected final int maxScore;

	public GameLoop(int maxScore) {
		this.maxScore = maxScore;
	}

	public final void run() {
		initializeGame();
		int score = 0;
		while (!isGameOver(score)) {
			score += playNextLevel();
		}
		displayScore(score);
	}

	// Template methods with default implementations
	protected void initializeGame() {
		System.out.println("Initializing game...");
	}

	protected boolean isGameOver(int score) {
		return score >= maxScore;
	}

	protected void displayScore(int score) {
		System.out.println("Your final score is: " + score);
	}

	// Abstract method to be implemented by subclasses
	protected abstract int playNextLevel();
}

//Concrete subclass for a simple game
class SimpleGame extends GameLoop {
	public SimpleGame(int maxScore) {
		super(maxScore);
	}

	@Override
	protected int playNextLevel() {
		System.out.println("Playing next level...");
		// Game logic for the next level
		return 10; // Assuming a fixed score for each level
	}
}

//Concrete subclass for a more complex game
class ComplexGame extends GameLoop {
	public ComplexGame(int maxScore) {
		super(maxScore);
	}

	@Override
	protected int playNextLevel() {
		System.out.println("Playing next level...");
		// Complex game logic for the next level
		return (int) (Math.random() * 20) + 10; // Random score for each level
	}
}

public class TemplateMethodeDemo {
	public static void main(String[] args) {
		
		// Create a simple game instance
		GameLoop simpleGame = new SimpleGame(100);
		simpleGame.run(); // Run the simple game
		
		// Create a complex game instance
		GameLoop complexGame = new ComplexGame(200);
		complexGame.run(); // Run the complex game
	}
}
