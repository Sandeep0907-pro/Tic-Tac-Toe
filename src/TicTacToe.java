import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class TicTacToe implements ActionListener{
	Random ran = new Random();
	JFrame frame  = new JFrame();
	JPanel title = new JPanel();
	JPanel buttons = new JPanel();
	JLabel text = new JLabel();
	JButton[] but = new JButton[9];
	boolean player1_turn;
	public TicTacToe() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		text.setBackground(Color.cyan);
		text.setForeground(Color.black);
		text.setFont(new Font("Ink Free",Font.BOLD,75));
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setText("TIC-TAC-TOE");
		text.setOpaque(true);
		title.setLayout(new BorderLayout());
		title.setBounds(0,0,800,100);
		buttons.setLayout(new GridLayout(3,3));
		buttons.setBackground(new Color(125,125,125));
		for(int i = 0 ;i<9;i++) {
			but[i] = new JButton();
			buttons.add(but[i]);
			but[i].setFont(new Font("MV Boli",Font.BOLD,120));
			but[i].setFocusable(false);
			but[i].addActionListener(this);
		}
		title.add(text);
		frame.add(title,BorderLayout.NORTH);
		frame.add(buttons);
		firstTurn();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<9;i++) {
			if(e.getSource()==but[i]) {
				if(player1_turn) {
					if(but[i].getText()=="") {
						but[i].setForeground(new Color(255,0,0));
						but[i].setText("X");
						player1_turn=false;
						text.setText("O Turn");
						check();
					}
				}
				else {
					if(but[i].getText()=="") {
						but[i].setForeground(new Color(0,0,205));
						but[i].setText("O");
						player1_turn=true;
						text.setText("X Turn");
						check();
					}
				}
			}
		}
	}
	public void firstTurn() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(ran.nextInt(2)==0) {
			player1_turn=true;
			text.setText("X Turn");
		}
		else {
			player1_turn=false;
			text.setText("O Turn");
		}

	}
	public void check() {
		//check for X win combos
		if(		(but[0].getText()=="X")&&
				(but[1].getText()=="X")&&
				(but[2].getText()=="X")) {
			xWins(0,1,2);
		}
		if(		(but[3].getText()=="X")&&
				(but[4].getText()=="X")&&
				(but[5].getText()=="X")) {
			xWins(3,4,5);
		}
		if(		(but[6].getText()=="X")&&
				(but[7].getText()=="X")&&
				(but[8].getText()=="X")) {
			xWins(6,7,8);
		}
		if(		(but[0].getText()=="X")&&
				(but[3].getText()=="X")&&
				(but[6].getText()=="X")) {
			xWins(0,3,6);
		}
		if(		(but[1].getText()=="X")&&
				(but[4].getText()=="X")&&
				(but[7].getText()=="X")) {
			xWins(1,4,7);
		}
		if(		(but[2].getText()=="X")&&
				(but[5].getText()=="X")&&
				(but[8].getText()=="X")) {
			xWins(2,5,8);
		}
		if(		(but[0].getText()=="X")&&
				(but[4].getText()=="X")&&
				(but[8].getText()=="X")) {
			xWins(0,4,8);
		}
		if(		(but[2].getText()=="X")&&
				(but[4].getText()=="X")&&
				(but[6].getText()=="X")) {
			xWins(2,4,6);
		}
		//check for O win combos
		if(		(but[0].getText()=="O")&&
				(but[1].getText()=="O")&&
				(but[2].getText()=="O")) {
			oWins(0,1,2);
		}
		if(		(but[3].getText()=="O")&&
				(but[4].getText()=="O")&&
				(but[5].getText()=="O")) {
			oWins(3,4,5);
		}
		if(		(but[6].getText()=="O")&&
				(but[7].getText()=="O")&&
				(but[8].getText()=="O")) {
			oWins(6,7,8);
		}
		if(		(but[0].getText()=="O")&&
				(but[3].getText()=="O")&&
				(but[6].getText()=="O")) {
			oWins(0,3,6);
		}
		if(		(but[1].getText()=="O")&&
				(but[4].getText()=="O")&&
				(but[7].getText()=="O")) {
			oWins(1,4,7);
		}
		if(		(but[2].getText()=="O")&&
				(but[5].getText()=="O")&&
				(but[8].getText()=="O")) {
			oWins(2,5,8);
		}
		if(		(but[0].getText()=="O")&&
				(but[4].getText()=="O")&&
				(but[8].getText()=="O")) {
			oWins(0,4,8);
		}
		if(		(but[2].getText()=="O")&&
				(but[4].getText()=="O")&&
				(but[6].getText()=="O")) {
			oWins(2,4,6);
		}
	}
	public void xWins(int a,int b,int c) {
		but[a].setBackground(Color.GREEN);
		but[b].setBackground(Color.GREEN);
		but[c].setBackground(Color.GREEN);
		for(int i=0;i<9;i++) {
			but[i].setEnabled(false);
		}
		text.setText("X Won");
	}
	public void oWins(int a,int b,int c) {
		but[a].setBackground(Color.BLUE);
		but[b].setBackground(Color.BLUE);
		but[c].setBackground(Color.BLUE);
		for(int i=0;i<9;i++) {
			but[i].setEnabled(false);
		}
		text.setText("O Won");

	}
}
