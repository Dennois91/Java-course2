package assignment_5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

public class RockPaperScissor extends JFrame implements ActionListener {

    int playerScore = 0;
    int pcScore = 0;

    JPanel basePlate = new JPanel();
    JPanel northGrid = new JPanel();
    JPanel playerWestGrid = new JPanel();
    JPanel scoreGrid = new JPanel();
    JPanel playFieldCenterGrid = new JPanel();
    JPanel pcEastGrid = new JPanel();

    JPanel announcementGrid = new JPanel();

    JLabel announcement = new JLabel("  PLAYER                 VS              COMPUTER");
    JLabel playerTag = new JLabel("      PLAYER");
    JLabel pcTag = new JLabel("  COMPUTER");

    JLabel playerScoreShow = new JLabel("              " + playerScore);
    JLabel scoreBoard = new JLabel("       SCORE ");
    JLabel pcScoreShow = new JLabel("             " + pcScore);

    JLabel playerMove = new JLabel(" ");
    JLabel pcMove = new JLabel(" ");

    JButton playerRock = new JButton("ROCK");
    JButton playerPaper = new JButton("PAPER");
    JButton playerScissor = new JButton("SCISSOR");

    JButton pcRock = new JButton("ROCK");
    JButton pcPaper = new JButton("PAPER");
    JButton pcScissor = new JButton("SCISSOR");

    public RockPaperScissor() {
        add(basePlate);
        basePlate.setLayout(new BorderLayout());
        basePlate.add(northGrid, BorderLayout.NORTH);
        basePlate.add(playerWestGrid, BorderLayout.WEST);
        basePlate.add(playFieldCenterGrid, BorderLayout.CENTER);
        basePlate.add(pcEastGrid, BorderLayout.EAST);
        basePlate.add(announcementGrid, BorderLayout.SOUTH);

        northGrid.setLayout(new GridLayout(1, 1));
        northGrid.add(scoreGrid);


        scoreGrid.setLayout(new GridLayout(1, 3));
        scoreGrid.setBackground(Color.ORANGE);
        scoreGrid.add(playerScoreShow);
        scoreGrid.add(scoreBoard);
        scoreGrid.add(pcScoreShow);

        playerWestGrid.setLayout(new GridLayout(3, 1));
        playerWestGrid.add(playerRock);
        playerWestGrid.add(playerPaper);
        playerWestGrid.add(playerScissor);

        playFieldCenterGrid.setLayout(new GridLayout(4, 1));
        playFieldCenterGrid.add(playerTag);
        playFieldCenterGrid.add(playerMove);
        playFieldCenterGrid.add(pcTag);
        playFieldCenterGrid.add(pcMove);

        pcEastGrid.setLayout(new GridLayout(3, 1));
        pcEastGrid.add(pcRock);
        pcEastGrid.add(pcPaper);
        pcEastGrid.add(pcScissor);

        announcementGrid.add(announcement);
        announcementGrid.setBackground(Color.CYAN);

        playerRock.addActionListener(this);
        playerPaper.addActionListener(this);
        playerScissor.addActionListener(this);

        setSize(270, 160);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == playerRock) {
            playerMove.setText("        ROCK");
            npcBrain();
        }
        if (e.getSource() == playerPaper) {
            playerMove.setText("       PAPER");
            npcBrain();
        }
        if (e.getSource() == playerScissor) {
            playerMove.setText("     SCISSOR");
            npcBrain();
        }
    }
    public void npcBrain() {
        int rd = ThreadLocalRandom.current().nextInt(1, 4);
        switch (rd) {
            case 1 -> {
                pcMove.setText("        ROCK");
                pcRock.setBackground(Color.GREEN);
                pcPaper.setBackground(null);
                pcScissor.setBackground(null);
                if (playerMove.getText().equals("        ROCK")) {
                    announcement.setText("It's a draw!");
                } else if (playerMove.getText().equals("       PAPER")) {
                    playerScore++;
                    playerScoreShow.setText("              " + playerScore);
                    announcement.setText("Player wins!");
                } else {
                    pcScore++;
                    pcScoreShow.setText("             " + pcScore);
                    announcement.setText("Computer wins!");
                }
            }
            case 2 -> {
                pcMove.setText("       PAPER");
                pcRock.setBackground(null);
                pcPaper.setBackground(Color.GREEN);
                pcScissor.setBackground(null);
                if (playerMove.getText().equals("        ROCK")) {
                    pcScore++;
                    pcScoreShow.setText("             " + pcScore);
                    announcement.setText("Computer wins!");
                } else if (playerMove.getText().equals("       PAPER")) {
                    announcement.setText("It's a draw!");
                } else {
                    playerScore++;
                    playerScoreShow.setText("              " + playerScore);
                    announcement.setText("Player wins!");
                }
            }
            case 3 -> {
                pcMove.setText("     SCISSOR");
                pcRock.setBackground(null);
                pcPaper.setBackground(null);
                pcScissor.setBackground(Color.GREEN);

                if (playerMove.getText().equals("        ROCK")) {
                    playerScore++;
                    playerScoreShow.setText("              " + playerScore);
                    announcement.setText("Player wins!");
                } else if (playerMove.getText().equals("       PAPER")) {
                    pcScore++;
                    pcScoreShow.setText("             " + pcScore);
                    announcement.setText("Computer wins!");
                } else {
                    announcement.setText("It's a draw!");
                }
            }
        }
    }
}
