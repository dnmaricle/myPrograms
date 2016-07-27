package bp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
  /**The board layout of the current board in play.
   * 
   */
  private Square[] boardLayout = new Square[9];
  /**Boolean value if it is X's turn.
   * 
   */
  private boolean xturn = true;
  /**The value of the human player.
   * 
   */
  private Square playerValue = Square.O;
  /**The value of the winner (either X or O).
   * 
   */
  private String winner = "";
  /**The level of difficulty for the user. (Set throughout game)
   * 
   */
  public static int level = 0;
  /**The squares to check for array manipulation.
   * 
   */
  private int[] squaresToCheck = { 0, 1, 2, 3, 6 };
  /**The index value the computer will play.
   * 
   */
  private int getAiMoveIndex = 0;
  /**The value of the computer (either X or O).
   * 
   */
  private Square aiPlayerValue;
  /**The value of the human playing (either X or O).
   * 
   */
  private Square humanPlayerValue;
  /**The number of squares that are in play.
   * 
   */
  private static final int NUMBER_OF_SQUARES = 9;
  /**The index value that we're playing with to check the best move.
   * 
   */
  private int pseuodoTokenIndex = -1;

    /**
     * For each square in the board layout, set it as unselected. This is to
     * ensure that the user has a fresh board whenever we create an instance of
     * a class.
     */
  public Board() {
    for (int n = 0; n < boardLayout.length; ++n) {
      boardLayout[n] = Square.Unselected;
    }
  }

    /**
     * Getting the board layout for the current board. This will return the
     * board layout for the current instance of this class.
     * 
     * @return boardLayout The layout of the board
     */
  public Square[] getBoardLayout() {
    return boardLayout;
  }

    /**
     * Setting the layout of the board given an array.
     * 
     * @param pboardLayout
     *            The given layout of the board
     */
  public void setBoardLayout(Square[] pboardLayout) {
    boardLayout = pboardLayout;
  }

    /**
     * Setting the board given an index value and a value to set.
     * 
     * @param psquareIndex
     *            The index value of the square to set a value for.
     * @param pvalueToSet
     *            The value that we are setting this square to.
     */
  public void setBoardSquare(int psquareIndex, Square pvalueToSet) {
    boardLayout[psquareIndex] = pvalueToSet;
    xturn = !xturn;
  }

    /**
     * Retrieving the layout of the board.
     * 
     * @param psquareIndex
     *            The index of the square we are returning
     * @return boardLayout The layout of the specified square
     */
  public Square getBoardSquare(int psquareIndex) {
    return boardLayout[psquareIndex];
  }

    /**
     * Checking if a square is occupied at any given index value. This is
     * checked by seeing if a square has not been set to the enum "Unselected".
     * 
     * @param psquareIndex
     *            The index of the square we're checking
     * @return True if the square is occupied, false if the square isn't
     */
  public boolean isOccupied(int psquareIndex) {
    return boardLayout[psquareIndex] != Square.Unselected;
  }

    /**
     * Checking to see if it is X's turn. This is done by looking at the
     * boolean, and what the value is currently set to. Since this boolean is
     * set every move, this provides an accurate way to describe whose turn it
     * is.
     * 
     * @return True is it is X's turn, false if it is not
     */
  public boolean isXTurn() {
    return xturn;
  }

    /**
     * Getting the text to display for each square. This is basically matching
     * up what the enum for each square already is to what is actually being
     * displayed.
     * 
     * @param value
     *            The index value of the square we're getting text for.
     * @return X/O/Unselected The square's value at the specified index.
     */
  private String getDisplayText(Square value) {
    switch (value) {
      case X:
        return "X";
      case O:
        return "O";
      case Unselected:
        return "";
      default:
        return "";
    }
  }
  /**Checking to see if the board is currently empty
   * 
   * @return Boolean True if the board is empty, false otherwise
   */
  public boolean isBoardEmpty() {
      for (int i = 0; i < NUMBER_OF_SQUARES; i++) {
          if (!boardLayout[i].equals(Square.Unselected)) {
              return false;
          }
      }
      //If we survive above, then all squares are empty
      return true;
  }

    /**
     * Checking if the game is tied. Automatically set the tie true, unless we
     * can find a spot that is not occupied. In which case, we don't have a tie
     * since the game has not even finished. If we can't find a square that
     * isn't occupied, then we'll return this to be a tie if this is a tie, and
     * the game has not been won.
     * 
     * @return True if the game is tied, false otherwise
     */
    // Inspired by Darrin's code
  public boolean isTieGame() {
    boolean tie = true;
    for (int i = 0; i < 9; i++) {
      if (!isOccupied(i)) {
        tie = false;
      }
    }
    return tie && !isGameWon();
  }

    /**
     * Setting the "xturn" value based on what is passed in.
     * 
     * For this boolean, if it's true, that means that it is X's turn. If it's
     * false, that means it's O's turn.
     * 
     * @param pxTurn
     *            Boolean value if it is X's turn
     */
  public void setXTurn(boolean pxTurn) {
    xturn = pxTurn;
  }

    /**
     * Getting the player's value. This is done by returning the "playerValue"
     * String, which was set at the beginning of the game.
     * 
     * @return "O" if the player is "O", "X" if the player is "X"
     */
  public Square getPlayerValue() {
    return playerValue;
  }

    /**
     * Setting the value of the player. This is setting the String "playerValue"
     * to describe if the player is X or O.
     * 
     * @param pplayerValue
     *            "X" if the player is "X", "O" if the player is "O"
     */
  public void setPlayerValue(Square pplayerValue) {
    playerValue = pplayerValue;
  }

    /**
     * Getting the winner of the game. This is done by retrieving the "winner"
     * String, which is set when we have a winner to a particular game.
     * 
     * @return X/O Depending on who won
     */
  public String getWinner() {
    return winner;
  }

    /**
     * Setting the winner of the game. Setting the String "winner" to describe
     * who won the game.
     * 
     * @param pwinner
     *            The winner of the game
     */
  public void setWinner(String pwinner) {
    winner = pwinner;
  }

    /**
     * Setting the level of difficulty for the game. This is done by setting the
     * static integer "level" to let every class know which level of difficulty
     * the user is on.
     * 
     * @param plevel
     *            The difficult level for the game
     */
  public void setLevel(int plevel) {
    level = plevel;
  }

    /**
     * Getting the level of difficulty of the current game. We do this by
     * retrieving the static integer "level" from the Board class.
     * 
     * @return level The level of difficulty of the game
     */
  public int getLevel() {
    return level;
  }

    /**
     * Figuring if the current game has been won or not. This is an overloaded
     * method that refers to the "isGameWon" boolean method to figure this out.
     * 
     * @return True if the game has been won, false if it hasn't.
     */
  public boolean isGameWon() {
    return isGameWon(boardLayout);
  }

    /**
     * Checking to see if the game has been won. This is done by checking half
     * of the perimeter of the board and using array manipulation to check if
     * the column, rows, or diagonals all match in value and are non-empty.
     * 
     * @param boardToCheck
     *            The board that is currently in play
     * @return A boolean value contingent upon if the game has been won
     */
    // Inspired by David Camp
  public boolean isGameWon(Square[] boardToCheck) {
    for (int i = 0; i < squaresToCheck.length; i++) {
            // Checking to see if any of the diagonals are a win!
      if (squaresToCheck[i] == 0 || squaresToCheck[i] == 2) {
        if (boardToCheck[squaresToCheck[i]] == boardToCheck[4]
                        && boardToCheck[4] == boardToCheck[8 - squaresToCheck[i]]
                        && getDisplayText(boardToCheck[squaresToCheck[i]]) != "") {
          if (getDisplayText(boardToCheck[squaresToCheck[i]]) == "O") {
            winner = "O";
          } else {
            winner = "X";
          }
          return true;
        }

      }
            // Checking to see if any of the rows are a win!
      if (squaresToCheck[i] % 3 == 0) {
        if (boardToCheck[squaresToCheck[i]] == boardToCheck[squaresToCheck[i] + 1]
                        && boardToCheck[squaresToCheck[i] + 1] 
                                == boardToCheck[squaresToCheck[i] + 2]
                        && getDisplayText(boardToCheck[squaresToCheck[i]]) != "") {
          if (getDisplayText(boardToCheck[squaresToCheck[i]]) == "O") {
            winner = "O";
          } else {
            winner = "X";
          }
          return true;
        }

      }
            // Checking to see if any of the columns are a win!
      if (squaresToCheck[i] <= 2) {
        if (boardToCheck[squaresToCheck[i]] == boardToCheck[squaresToCheck[i] + 3]
                        && boardToCheck[squaresToCheck[i] + 3] 
                                == boardToCheck[squaresToCheck[i] + 6]
                        && getDisplayText(boardToCheck[squaresToCheck[i]]) != "") {
          if (getDisplayText(boardToCheck[squaresToCheck[i]]) == "O") {
            winner = "O";
          } else {
            winner = "X";
          }
          return true;
        }
      }
    }
        // If survived above, there's no winning combination
    return false;
  }

    /**
     * Generating a random number. This is done by figuring the difference
     * between the maximum and minimum, adding one, and summing this with the
     * minimum value.
     * 
     * @param min
     *            The minimum value to choose from
     * @param max
     *            The maximum value to choose from
     * @return The value that we've randomly picked from
     */
    // Code from browxy.com
  public static int randomNum(int min, int max) {
    Random rand = new Random();
    int randomNum = rand.nextInt((max - min) + 1) + min;
    return randomNum;
  }

    /**
     * Getting the computer's move depending on the current level of difficulty.
     * For level 0, we pick random index value for the computer to play. For
     * level 1, we see if we can win and place our index there, otherwise, we
     * pick random values. For level 2, we see if we can win. If we can't, we
     * look if the user can win. If the user can win, we block them by setting
     * out index value to that position.
     * 
     * @param level
     *            The current level of difficulty
     * @return The index value of the computer's move
     */
  public int getAiMove(int level) {
    switch (level) {
      case 0:
        getAiMoveIndex = randomNum(0, 8);
        while (isOccupied(getAiMoveIndex)) {
          getAiMoveIndex = randomNum(0, 8);
        }
        break;
      case 1:
        getAiMoveIndex = getImmediateWinningMoveIndexForCurrentTurn(boardLayout);
        if (getAiMoveIndex == -1) {
          getAiMoveIndex = randomNum(0, 8);
          while (isOccupied(getAiMoveIndex)) {
            getAiMoveIndex = randomNum(0, 8);
          }
        }
        break;
      case 2:
            // Let's see if there's a winning move
        getAiMoveIndex = getImmediateWinningMoveIndexForCurrentTurn(boardLayout);
        if (getAiMoveIndex == -1) {
                // If we can't win, let's try to block
          getAiMoveIndex = getUserWinningMoveIndexForCurrentTurn(boardLayout);
                // If we can't block, pick at random
          if (getAiMoveIndex == -1) {
            getAiMoveIndex = randomNum(0, 8);
            while (isOccupied(getAiMoveIndex)) {
              getAiMoveIndex = randomNum(0, 8);
            }
          }
        }
        break;
      case 3:
        int[] data = miniMax(getNumberOfEmptySquares(), getAiPlayerValue(),
                    Integer.MIN_VALUE, Integer.MAX_VALUE);
        getAiMoveIndex = data[1];
        break;

      default:
        getAiMoveIndex = 0;
        break;
    }
    return getAiMoveIndex;
  }
/**Getting the number of empty squares at any given time.
 * 
 * @return numOfEmp The number of empty squares on the board
 */
  public final int getNumberOfEmptySquares() {
    int numOfEmp = 0;
    for (int i = 0; i < NUMBER_OF_SQUARES; ++i) {
      if (boardLayout[i].equals(Square.Unselected)) {
        numOfEmp++;
      }
    }
    return numOfEmp;
  }
/**Getting the index values of all the empty squares at any given time.
 * 
 * @return emptySquare The array of index values corresponding to the squares that are empty.
 */
  public final ArrayList<Integer> getEmptySquareIndices() {
    ArrayList<Integer> emptySquare = new ArrayList<Integer>();

    if (isGameWon() || isTieGame()) {
      return emptySquare;
    }
    for (int n = 0; n < NUMBER_OF_SQUARES; ++n) {
      if (boardLayout[n].equals(Square.Unselected)) {
        emptySquare.add(n);
      }
    }
    return emptySquare;
  }

    /**
     * Getting the user's winning move for our opponent. This is done by
     * theoretically placing an "X" or an "O" (whichever our opponent is
     * playing) and calling our "isGameWon" method to determine if our opponent
     * could win at that given index value we placed our pseudo "X" or "O" in.
     * 
     * If we can find such an index value such that this is the case, return
     * that index value...because the user can play that position and win in
     * their next turn. Otherwise, return -1.
     * 
     * @param boardToCheck
     *            The board that the user is currently playing
     * @return The index value for our opponent to win
     */
  public int getUserWinningMoveIndexForCurrentTurn(Square[] boardToCheck) {
    Square userLetter = Square.X;

        // If it's X's turn, we know the AI is X...and we wanna check for
        // winning O positions
    if (isXTurn()) {
      userLetter = Square.O;
    }
    for (int i = 0; i < boardToCheck.length; ++i) {
      if (boardToCheck[i] == Square.Unselected) {
        boardToCheck[i] = userLetter;
        if (isGameWon()) {
          boardToCheck[i] = Square.Unselected;
          return i;
        }
        boardToCheck[i] = Square.Unselected;
      }
    }
        // If we survived above, no winning position yet
    return -1;
  }
   
  /**Checking to see if it is the computer's turn.
   * 
   * @return boolean True if is it the computer's turn, false otherwise
   */
  public boolean isAiTurn() {
    if ((isXTurn() && getPlayerValue().equals(Square.O)) 
                || (!isXTurn() && getPlayerValue().equals(Square.X))) {
      return true;
    } else {
      return false;
    }
  }

    /**
     * Retrieving the winning move for the current turn we're on. This is done
     * by theoretically placing an "X" or an "O" (whichever the current turn is
     * on) and calling out "isGameWon" method to check if we could win at that
     * position.
     * 
     * If we can find such an index value, return that index. Otherwise, return
     * -1.
     * 
     * @param boardToCheck
     *            The board that we're currently playing
     * @return The index value for us to play to win
     */
  public int getImmediateWinningMoveIndexForCurrentTurn(Square[] boardToCheck) {
    Square aiLetter = Square.X;
    if (!isXTurn()) {
      aiLetter = Square.O;
    }
    for (int i = 0; i < boardToCheck.length; ++i) {
      if (boardToCheck[i] == Square.Unselected) {
        boardToCheck[i] = aiLetter;
        if (isGameWon()) {
          boardToCheck[i] = Square.Unselected;
          return i;
        }
        boardToCheck[i] = Square.Unselected;
      }
    }
        // If we survived above, no winning position yet
    return -1;
  }
/**This algorithm recursively goes through each move a player could make, 
 * calculates the potential score for each move, and returns with the 
 * best move for the computer. This algorithm has alpha-beta pruning, cutting
 * off potential moves that are not possibly a win move. 
 * Help from: https://www3.ntu.edu.sg/home/ehchua/programming/java/JavaGame_TicTacToe_AI.html#zz-1.5
 * 
 * @param pdepth The number of empty spaces that we currently have in play
 * @param pplayerValue The value of the player being considered
 * @param palpha The best (max) score
 * @param pbeta The worst (min) score
 * @return Score (the score of the current move considered), Index (the location of our token)
 */
  private int[] miniMax(int pdepth, Square pplayerValue, int palpha, int pbeta) {
    ArrayList<Integer> potentialMoves = getEmptySquareIndices();
    int score = 0;
    int alpha = palpha;
    int beta = pbeta;
    int squareIndex = -1;
        // If there's no moves left
    if (potentialMoves.isEmpty() || pdepth == 0) {
      score = sumScore();
      return new int[] {score, squareIndex };
    } else {
            // Go through all potential moves
      for (int i = 0; i < potentialMoves.size(); i++) {
        int squareIterator = potentialMoves.get(i);
        if (pplayerValue.equals(Square.O)) {
          boardLayout[squareIterator] = Square.O;
        } else {
          boardLayout[squareIterator] = Square.X;
        }

                /*
                 * If this is the AI's turn, we want to find the maximum score
                 * and store this in alpha.
                 */
        if (pplayerValue.equals(getAiPlayerValue())) {
                    // Depth is -1 since we are traveling down the tree.
                    // Therefore, we want to subtract from depth
          score = miniMax(pdepth - 1, getHumanPlayerValue(), alpha, beta)[0];

                    /*
                     * Alpha is for maximization. So, if the score is higher
                     * than alpha, set alpha = score, b/c we want alpha to be
                     * the highest
                     */
          if (score > alpha) {
            alpha = score;
                        //pseuodoTokenIndex = potentialMoves.get(i);
            squareIndex = squareIterator;
          }
        } else {
          score = miniMax(pdepth - 1, getAiPlayerValue(), alpha, beta)[0];

          if (score < beta) {
            beta = score;
                        //pseuodoTokenIndex = potentialMoves.get(i);
            squareIndex = squareIterator;
          }
        }
                // Reset the pseudo token..we actually haven't made a move yet
        boardLayout[potentialMoves.get(i)] = Square.Unselected;

                /*
                 * Alpha-beta pruning seeks to reduce the number of nodes that
                 * needs to be evaluated in the search tree by the minimax
                 * algorithm. Since we're trimming off unnecessary checks, and
                 * alpha is supposed to be larger than beta, we can stop
                 * recursively going through this.
                 */
        if (alpha >= beta) {
          break;
        }
      }
      if (pplayerValue.equals(getAiPlayerValue())) {
                // Return the best move, since we're the computer
        return new int[] { alpha, squareIndex };
      } else {
                // Return the worst score, since this is the human theoretically
        return new int[] { beta, squareIndex };
      }

    }
  }
    /**Summing the score for each row/column/diagonal.
     * Thank you to: https://www3.ntu.edu.sg/home/ehchua/programming/java/
     * JavaGame_TicTacToe_AI.html#zz-1.5
     * 
     * @return score The score that is associated with the entire current board.
     */
  private int sumScore() {
    int score = 0;
    score += fitnessFunction(0, 1, 2); // row 0
    score += fitnessFunction(3, 4, 5); // row 1
    score += fitnessFunction(6, 7, 8); // row 2
    score += fitnessFunction(0, 3, 6); // column 0
    score += fitnessFunction(1, 4, 7); // column 1
    score += fitnessFunction(2, 5, 8); // column 2
    score += fitnessFunction(0, 4, 8); // diagonal 1
    score += fitnessFunction(2, 4, 6); // diagonal 2
    return score;
  }
/**The function assigns point values for each position on the board.
 * Given three cells, it will be able to see the "fitness" of a particular move
 * within the given column/diagonal/row
 * Help from: https://www3.ntu.edu.sg/home/ehchua/programming/java/JavaGame_TicTacToe_AI.html#zz-1.5
 * 
 * @param pos1 The first position
 * @param pos2 The second position
 * @param pos3 The third position
 * @return score The numeric value associated with the functions "fitness" 
 *+/- 1(one token), 10(two in a row), 100 (win)
 */
  private int fitnessFunction(int pos1, int pos2, int pos3) {
    int score = 0;

        // checking first cell
    if (boardLayout[pos1].equals(getAiPlayerValue())) {
      score = 1;
    } else if (boardLayout[pos1].equals(getHumanPlayerValue())) {
      score = -1;
    }

        // Checking the second cell
    if (boardLayout[pos2].equals(getAiPlayerValue())) {
      if (score == 1) {
        score = 10;
      } else if (score == -1) {
            // Don't need to consider this one...
        return 0;
      } else {
        // Other cell was empty...score of one!
        score = 1;
      }
    } else if (boardLayout[pos2].equals(getHumanPlayerValue())) {
      if (score == -1) {
        score = -10;
      } else if (score == 1) {
        return 0;
      } else {
        score = -1; // First cell is empty
      }
    }

        // Checking the third cell
    if (boardLayout[pos3].equals(getAiPlayerValue())) {
      if (score > 0) {
        score *= 10;
      } else if (score < 0) {
        return 0; // Either the first or second slot is already taken by
                  // opponent
      } else { // First and second cell are empty
        score = 1;
      }
    } else if (boardLayout[pos3].equals(getHumanPlayerValue())) {
      if (score < 0) {
        score *= 10;
      } else if (score > 1) { // AI has already taken the first or second
                                // slot
        return 0;
      } else {
        score = -1; // First or second cell is empty
      }
    }
    return score;
  }
/**Getting the AI's player value.
 * 
 * @return aiPlayerValue Either X/O, depending on what the computer is
 */
  public Square getAiPlayerValue() {
    return aiPlayerValue;
  }
/**Setting the computer's value.
 * 
 * @param aiPlayerValue Either X/O, depending on what the computer is
 */
  public void setAiPlayerValue(Square aiPlayerValue) {
    this.aiPlayerValue = aiPlayerValue;
  }
/**Retrieving the value (either X/O) of what the human token is.
 * 
 * @return humanPlayerValue The value of the human token
 */
  public Square getHumanPlayerValue() {
    return humanPlayerValue;
  }
/**Setting the value of the human token.
 * 
 * @param humanPlayerValue The value of the human token (X/O)
 */
  public void setHumanPlayerValue(Square humanPlayerValue) {
    this.humanPlayerValue = humanPlayerValue;
  }

}
