package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import bp.Board;
import bp.Square;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class Main {

    // Level 0 --> Thinking zero levels ahead
    // Level 1 --> Mostly random, but it determines if it can take a spot to win
    // Level 2 --> All the above, and it will try to block. It will think ahead
    // and block anything, and then play to win if it can

  private JFrame frmTicTacToe;
  private bp.Board game = new bp.Board();
  private JLabel lbl0;
  private JLabel lbl1;
  private JLabel lbl2;
  private JLabel lbl3;
  private JLabel lbl4;
  private JLabel lbl5;
  private JLabel lbl6;
  private JLabel lbl7;
  private JLabel lbl8;
  private JMenuBar menuBar;
  private JComboBox<String> cboxLevel;
  private JButton btnNewGame;
  private JButton btnExitGame;
  private static int NUMBER_Of_SQUARES = 9;
  private String playerName = "Tara";

    /**
     * Launch the application.
     */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Main window = new Main();
          window.frmTicTacToe.setVisible(true);
            } catch (Exception e) {
            e.printStackTrace();
          }
      }
        });
  }

  /**Setting a square to the value of the current player.
   * Method also checks if the game has won, if it's the 
   * players turn, and if the game has tied.
   * @param index The specified position(index) to set.
   */
  private void setSquare(int index) {
    if (!game.isGameWon() && !game.isTieGame()) {
      if (!game.isOccupied(index)) {
        if (game.isXTurn()) {
          game.setBoardSquare(index, Square.X);
        } else {
          game.setBoardSquare(index, Square.O);
        }
      } else {
        JOptionPane.showMessageDialog(null,
                    "Sorry, that spot is already taken!");
      }
    }
    syncBoard();
  }

  /**Displaying the text that each square has been set to.
   * 
   */
  private void syncBoard() {
    if (((String) cboxLevel.getSelectedItem()).equals("Easy")) {
      game.setLevel(0);
    } else if (((String) cboxLevel.getSelectedItem()).equals("Medium")) {
      game.setLevel(1);
    } else if (((String) cboxLevel.getSelectedItem()).equals("Hard")) {
      game.setLevel(2);
    } else {
      game.setLevel(3);
    }
    lbl0.setText(getDisplayText(game.getBoardLayout()[0]));
    lbl1.setText(getDisplayText(game.getBoardLayout()[1]));
    lbl2.setText(getDisplayText(game.getBoardLayout()[2]));
    lbl3.setText(getDisplayText(game.getBoardLayout()[3]));
    lbl4.setText(getDisplayText(game.getBoardLayout()[4]));
    lbl5.setText(getDisplayText(game.getBoardLayout()[5]));
    lbl6.setText(getDisplayText(game.getBoardLayout()[6]));
    lbl7.setText(getDisplayText(game.getBoardLayout()[7]));
    lbl8.setText(getDisplayText(game.getBoardLayout()[8]));
    if (game.isGameWon()) {
        Object[] options = {"Yes", "No"};
      int doWeContinue = JOptionPane.showOptionDialog(frmTicTacToe, game.getWinner() + " wins! " + playerName +", would you like to play again?",
              game.getWinner() +" won", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
              null, options, options[1]);
      switch (doWeContinue) {
      case JOptionPane.YES_OPTION:
          clearBoard();
          startGame();
          break;
      case JOptionPane.NO_OPTION:
          System.exit(0);
          break;
      default:
          System.exit(0);
      }
    } else if (game.isTieGame()) {
      Object[] options = {"Yes", "No"};
      int doWeContinue = JOptionPane.showOptionDialog(frmTicTacToe, "You tied "+ playerName +" , would you like to play again?",
              "Tied Game", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
              null, options, options[1]);
      switch (doWeContinue) {
      case JOptionPane.YES_OPTION:
          clearBoard();
          startGame();
          break;
      case JOptionPane.NO_OPTION:
          System.exit(0);
          break;
      default:
          System.exit(0);
      }
            // If the player is X, and it's not X's turn, let the computer make
            // a move
    } else if (game.isAiTurn()) {
      setSquare(game.getAiMove(bp.Board.level));
    } 
    for (int i = 0; i < game.getBoardLayout().length; ++i) {
      displayColorText(i);
    }
  }

  /**Changing the text's color depending on what character it is.
   * 
   * @param plabelNum The number of the index value of the square piece 
   *     we're changing the color to
   */
  private void displayColorText(int plabelNum) {
    switch (plabelNum) {
      case 0:
        if (getDisplayText(game.getBoardSquare(0)).equals("X")) {
          lbl0.setForeground(Color.RED);
        } else {
          lbl0.setForeground(Color.BLUE);
        }
        break;
      case 1:
        if (getDisplayText(game.getBoardSquare(1)).equals("X")) {
          lbl1.setForeground(Color.RED);
        } else {
          lbl1.setForeground(Color.BLUE);
        }
        break;
      case 2:
        if (getDisplayText(game.getBoardSquare(2)).equals("X")) {
          lbl2.setForeground(Color.RED);
        } else {
          lbl2.setForeground(Color.BLUE);
        }
        break;
      case 3:
        if (getDisplayText(game.getBoardSquare(3)).equals("X")) {
          lbl3.setForeground(Color.RED);
        } else {
          lbl3.setForeground(Color.BLUE);
        }
        break;
      case 4:
        if (getDisplayText(game.getBoardSquare(4)).equals("X")) {
          lbl4.setForeground(Color.RED);
        } else {
          lbl4.setForeground(Color.BLUE);
        }
        break;
      case 5:
        if (getDisplayText(game.getBoardSquare(5)).equals("X")) {
          lbl5.setForeground(Color.RED);
        } else {
          lbl5.setForeground(Color.BLUE);
        }
        break;
      case 6:
        if (getDisplayText(game.getBoardSquare(6)).equals("X")) {
          lbl6.setForeground(Color.RED);
        } else {
          lbl6.setForeground(Color.BLUE);
        }
        break;
      case 7:
        if (getDisplayText(game.getBoardSquare(7)).equals("X")) {
          lbl7.setForeground(Color.RED);
        } else {
          lbl7.setForeground(Color.BLUE);
        }
        break;
      case 8:
        if (getDisplayText(game.getBoardSquare(8)).equals("X")) {
          lbl8.setForeground(Color.RED);
        } else {
          lbl8.setForeground(Color.BLUE);
        }
        break;
      default:
        break;
    }
  }
  
  private void startGame() {
      Object[] options = {"X", "O", "Quit"};
      int tokenChoice = JOptionPane.showOptionDialog(frmTicTacToe, "Thanks for playing again" + playerName + ". Please pick a token!", 
              "Tic Tac Toe", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
      switch (tokenChoice) {
        case JOptionPane.NO_OPTION:
              // Might be better to use an enum?
          game.setHumanPlayerValue(Square.O);
          game.setAiPlayerValue(Square.X);
          game.setPlayerValue(Square.O);
          game.setXTurn(true);
          break;
        case JOptionPane.YES_OPTION:
          game.setHumanPlayerValue(Square.X);
          game.setAiPlayerValue(Square.O);
          game.setPlayerValue(Square.X);
          game.setXTurn(true);
          break;
        default:
          System.exit(0);
      }
      syncBoard();
  }

  private void clearBoard() {
      for (int i = 0; i < NUMBER_Of_SQUARES; i++) {
      game.setBoardSquare(i, Square.Unselected);
      }
      
      lbl0.setText("");
      lbl1.setText("");
      lbl2.setText("");
      lbl3.setText("");
      lbl4.setText("");
      lbl5.setText("");
      lbl6.setText("");
      lbl7.setText("");
      lbl8.setText("");
  }
  /**Retrieving the text to display to the user.
   * This is based off of what the player picks, and
   * what the player is (either an X or an O).
   * @param value Either X, O, or Unselected, these are the options for the text.
   * @return X/O/Unselected. The value of the square
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

    /**
     * Create the application.
     */
  public Main() {
   /* int answer = JOptionPane.showConfirmDialog(null,
                "Would you like to be X?", "Start Game",
                JOptionPane.YES_NO_OPTION);*/
    Object[] options = {"X", "O", "Quit"};
    int tokenChoice = JOptionPane.showOptionDialog(frmTicTacToe, "Welcome " +playerName+ ". Please pick a token!", 
            "Tic Tac Toe", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
    switch (tokenChoice) {
      case JOptionPane.NO_OPTION:
            // Might be better to use an enum?
        game.setHumanPlayerValue(Square.O);
        game.setAiPlayerValue(Square.X);
        game.setPlayerValue(Square.O);
        break;
      case JOptionPane.YES_OPTION:
        game.setHumanPlayerValue(Square.X);
        game.setAiPlayerValue(Square.O);
        game.setPlayerValue(Square.X);
        break;
      default:
        System.exit(0);
    }

    initialize();
    syncBoard();
  }

    /**
     * Initialize the contents of the frame.
     */
  private void initialize() {
    frmTicTacToe = new JFrame();
    frmTicTacToe.setTitle("Tic Tac Toe Challenge");
    frmTicTacToe.setBounds(100, 100, 455, 393);
    frmTicTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmTicTacToe.getContentPane().setLayout(new GridLayout(0, 3, 0, 0));

    lbl0 = new JLabel("X");
    lbl0.setBorder(new LineBorder(new Color(0, 0, 0), 3));
    lbl0.addMouseListener(new Lbl0MouseListener());
    lbl0.setVerticalAlignment(SwingConstants.TOP);
    lbl0.setFont(new Font("Tahoma", Font.PLAIN, 60));
    lbl0.setHorizontalAlignment(SwingConstants.CENTER);
    frmTicTacToe.getContentPane().add(lbl0);

    lbl1 = new JLabel("X");
    lbl1.addMouseListener(new Lbl1MouseListener());
    lbl1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
    lbl1.setVerticalAlignment(SwingConstants.TOP);
    lbl1.setHorizontalAlignment(SwingConstants.CENTER);
    lbl1.setFont(new Font("Dialog", Font.PLAIN, 60));
    lbl1.setEnabled(true);
    frmTicTacToe.getContentPane().add(lbl1);

    lbl2 = new JLabel("X");
    lbl2.addMouseListener(new Lbl2MouseListener());
    lbl2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
    lbl2.setVerticalAlignment(SwingConstants.TOP);
    lbl2.setHorizontalAlignment(SwingConstants.CENTER);
    lbl2.setFont(new Font("Dialog", Font.PLAIN, 60));
    lbl2.setEnabled(true);
    frmTicTacToe.getContentPane().add(lbl2);

    lbl3 = new JLabel("X");
    lbl3.addMouseListener(new Lbl3MouseListener());
    lbl3.setBorder(new LineBorder(new Color(0, 0, 0), 3));
    lbl3.setVerticalAlignment(SwingConstants.TOP);
    lbl3.setHorizontalAlignment(SwingConstants.CENTER);
    lbl3.setFont(new Font("Dialog", Font.PLAIN, 60));
    lbl3.setEnabled(true);
    frmTicTacToe.getContentPane().add(lbl3);

    lbl4 = new JLabel("X");
    lbl4.addMouseListener(new Lbl4MouseListener());
    lbl4.setBorder(new LineBorder(new Color(0, 0, 0), 3));
    lbl4.setVerticalAlignment(SwingConstants.TOP);
    lbl4.setHorizontalAlignment(SwingConstants.CENTER);
    lbl4.setFont(new Font("Dialog", Font.PLAIN, 60));
    lbl4.setEnabled(true);
    frmTicTacToe.getContentPane().add(lbl4);

    lbl5 = new JLabel("X");
    lbl5.addMouseListener(new Lbl5MouseListener());
    lbl5.setBorder(new LineBorder(new Color(0, 0, 0), 3));
    lbl5.setVerticalAlignment(SwingConstants.TOP);
    lbl5.setHorizontalAlignment(SwingConstants.CENTER);
    lbl5.setFont(new Font("Dialog", Font.PLAIN, 60));
    lbl5.setEnabled(true);
    frmTicTacToe.getContentPane().add(lbl5);

    lbl6 = new JLabel("X");
    lbl6.addMouseListener(new Lbl6MouseListener());
    lbl6.setBorder(new LineBorder(new Color(0, 0, 0), 3));
    lbl6.setVerticalAlignment(SwingConstants.TOP);
    lbl6.setHorizontalAlignment(SwingConstants.CENTER);
    lbl6.setFont(new Font("Dialog", Font.PLAIN, 60));
    lbl6.setEnabled(true);
    frmTicTacToe.getContentPane().add(lbl6);

    lbl7 = new JLabel("X");
    lbl7.addMouseListener(new Lbl7MouseListener());
    lbl7.setBorder(new LineBorder(new Color(0, 0, 0), 3));
    lbl7.setVerticalAlignment(SwingConstants.TOP);
    lbl7.setHorizontalAlignment(SwingConstants.CENTER);
    lbl7.setFont(new Font("Dialog", Font.PLAIN, 60));
    lbl7.setEnabled(true);
    frmTicTacToe.getContentPane().add(lbl7);

    lbl8 = new JLabel("X");
    lbl8.addMouseListener(new Lbl8MouseListener());
    lbl8.setBorder(new LineBorder(new Color(0, 0, 0), 3));
    lbl8.setVerticalAlignment(SwingConstants.TOP);
    lbl8.setHorizontalAlignment(SwingConstants.CENTER);
    lbl8.setFont(new Font("Dialog", Font.PLAIN, 60));
    lbl8.setEnabled(true);
    frmTicTacToe.getContentPane().add(lbl8);

    menuBar = new JMenuBar();
    frmTicTacToe.setJMenuBar(menuBar);

    cboxLevel = new JComboBox<String>();
    cboxLevel.addItem("Easy");
    cboxLevel.addItem("Medium");
    cboxLevel.addItem("Hard");
    cboxLevel.addItem("Expert");
    menuBar.add(cboxLevel);

    btnNewGame = new JButton("New Game");
    btnNewGame.addMouseListener(new BtnNewGameMouseListener());
    menuBar.add(btnNewGame);

    btnExitGame = new JButton("Quit");
    btnExitGame.addMouseListener(new BtnExitGameMouseListener());
    menuBar.add(btnExitGame);
  }

  /** When the user clicks on the first box, we set the square.
   *
   * @author David
   */
  private class Lbl0MouseListener extends MouseAdapter {
    @Override
        public void mouseClicked(MouseEvent arg0) {
      if ((game.getPlayerValue().equals(Square.X) && game.isXTurn())
                    || (game.getPlayerValue().equals(Square.O) && !game.isXTurn())) {
        setSquare(0);
      }
    }
  }

  /** When the user clicks on the second box, we set the square.
   *
   * @author David
   */
  private class Lbl1MouseListener extends MouseAdapter {
    @Override
        public void mouseClicked(MouseEvent arg0) {
      if ((game.getPlayerValue().equals(Square.X) && game.isXTurn())
                    || (game.getPlayerValue().equals(Square.O) && !game.isXTurn())) {
        setSquare(1);
      }
    }
  }

  /** When the user clicks on the third box, we set the square.
   *
   * @author David
   */
  private class Lbl2MouseListener extends MouseAdapter {
    @Override
        public void mouseClicked(MouseEvent arg0) {
      if ((game.getPlayerValue().equals(Square.X) && game.isXTurn())
                    || (game.getPlayerValue().equals(Square.O) && !game.isXTurn())) {
        setSquare(2);
      }
    }
  }

  /** When the user clicks on the fourth box, we set the square.
   *
   * @author David
   */
  private class Lbl3MouseListener extends MouseAdapter {
    @Override
        public void mouseClicked(MouseEvent arg0) {
      if ((game.getPlayerValue().equals(Square.X) && game.isXTurn())
                    || (game.getPlayerValue().equals(Square.O) && !game.isXTurn())) {
        setSquare(3);
      }
    }
  }

  /**  When the user clicks on the fifth box, we set the square.
   *
   * @author David
   */
  private class Lbl4MouseListener extends MouseAdapter {
    @Override
        public void mouseClicked(MouseEvent arg0) {
      if ((game.getPlayerValue().equals(Square.X) && game.isXTurn())
                    || (game.getPlayerValue().equals(Square.O) && !game.isXTurn())) {
        setSquare(4);
      }
    }
  }

  /**  When the user clicks on the sixth box, we set the square.
   *
   * @author David
   */
  private class Lbl5MouseListener extends MouseAdapter {
    @Override
        public void mouseClicked(MouseEvent arg0) {
      if ((game.getPlayerValue().equals(Square.X) && game.isXTurn())
                    || (game.getPlayerValue().equals(Square.O) && !game.isXTurn())) {
        setSquare(5);
      }
    }
  }

  /** When the user clicks on the seventh box, we set the square.
   *
   * @author David
   */
  private class Lbl6MouseListener extends MouseAdapter {
    @Override
        public void mouseClicked(MouseEvent arg0) {
      if ((game.getPlayerValue().equals(Square.X) && game.isXTurn())
                    || (game.getPlayerValue().equals(Square.O) && !game.isXTurn())) {
        setSquare(6);
      }
    }
  }

  /**  When the user clicks on the eighth box, we set the square.
   * 
   * @author David
   *
   */
  private class Lbl7MouseListener extends MouseAdapter {
    @Override
        public void mouseClicked(MouseEvent arg0) {
      if ((game.getPlayerValue().equals(Square.X) && game.isXTurn())
                    || (game.getPlayerValue().equals(Square.O) && !game.isXTurn())) {
        setSquare(7);
      }
    }
  }

  /**  When the user clicks on the ninth box, we set the square.
   * 
   * @author David
   *
   */
  private class Lbl8MouseListener extends MouseAdapter {
    @Override
        public void mouseClicked(MouseEvent arg0) {
      if ((game.getPlayerValue().equals(Square.X) && game.isXTurn())
                    || (game.getPlayerValue().equals(Square.O) && !game.isXTurn())) {
        setSquare(8);
      }
    }
  }

  /** When the user selects the "NewGame" button, restart the program.
   * We do this by throwing away the old frame, and creating a new frame.
   * 
   * @author David
   *
   */
    // Getting a new game!
  private class BtnNewGameMouseListener extends MouseAdapter {
    @Override
        public void mouseClicked(MouseEvent arg0) {
      clearBoard();
      startGame();
    }
  }

  /** Exiting the game when the uses selected "exit.
   *  We do this by disposing of the frame.
   * @author David
   *
   */
  private class BtnExitGameMouseListener extends MouseAdapter {
    @Override
        public void mouseClicked(MouseEvent myMouse) {
      frmTicTacToe.dispose();
      Runtime.getRuntime().halt(0);
    }
  }
}
