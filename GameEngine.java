package engine;


import player.Player;

/**
 * GameEngine is responsible for controlling the flow of the game.
 * It manages turns, checks win/lose conditions, and switches between players.
 */
public class GameEngine {

    // The main player (human)
    private Player player;

    // The enemy player (AI or opponent)
    private Player enemy;

    // Current turn number
    private int turnNumber;

    // True if it is the player's turn, false if it is the enemy's turn
    private boolean playerTurn;

    // Indicates whether the game has ended
    private boolean gameOver;

    /**
     * Constructor of the GameEngine.
     * Initializes the game with a player and an enemy.
     */
    public GameEngine(Player player, Player enemy) {
        this.player = player;
        this.enemy = enemy;
        this.turnNumber = 1;
        this.playerTurn = true; // The player starts first
        this.gameOver = false;
    }

    /**
     * Starts the current turn.
     * Depending on whose turn it is, player or enemy actions are executed.
     */
    public void startTurn() {
        if (gameOver) return;

        if (playerTurn) {
            System.out.println("Player turn");
            // Player actions are triggered from the UI
        } else {
            System.out.println("Enemy turn");
            enemyAction();
        }
    }

    /**
     * Ends the current turn and switches to the next one.
     * Also checks the game state (win or lose).
     */
    public void endTurn() {
        if (gameOver) return;

        checkGameState();          // Check if the game has ended
        playerTurn = !playerTurn;  // Switch turn

        // Increase turn number when the player starts again
        if (playerTurn) {
            turnNumber++;
        }

        startTurn(); // Start the next turn
    }

    /**
     * Defines a simple enemy action.
     * This can be improved later with more complex AI logic.
     */
    private void enemyAction() {
        System.out.println("Enemy plays...");
        // Example: enemy could move or attack
    }

    /**
     * Checks whether the player or the enemy is dead
     * and updates the gameOver status.
     */
    private void checkGameState() {
        if (player.isDead()) {
            gameOver = true;
            System.out.println("Game Over - You Lose");
        } 
        else if (enemy.isDead()) {
            gameOver = true;
            System.out.println("Victory - You Win");
        }
    }

    // Returns the current turn number
    public int getTurnNumber() {
        return turnNumber;
    }

    // Returns true if it is the player's turn
    public boolean isPlayerTurn() {
        return playerTurn;
    }

    // Returns true if the game has ended
    public boolean isGameOver() {
        return gameOver;
    }
}