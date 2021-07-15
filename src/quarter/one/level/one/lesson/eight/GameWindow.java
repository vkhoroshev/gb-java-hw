package quarter.one.level.one.lesson.eight;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private final BattleMap battleMap;
    private final Settings settings;

    public GameWindow() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int positionX = (int) ((dimension.getWidth() - Style.WINDOW_WIDTH) / 2);
        int positionY = (int) ((dimension.getHeight() - Style.WINDOW_HEIGHT) / 2);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setBounds(positionX, positionY, Style.WINDOW_WIDTH, Style.WINDOW_HEIGHT);
        getContentPane().setBackground(Style.BACKGROUND_COLOR);

        battleMap = new BattleMap(this);
        settings = new Settings(this, positionX, positionY);

        JButton buttonStart = new JButton("Start");
        buttonStart.setBackground(Style.BUTTON_COLOR);
        buttonStart.addActionListener(e -> settings.setVisible(true));

        JButton buttonExit = new JButton("Exit");
        buttonExit.setBackground(Style.BUTTON_COLOR);
        buttonExit.addActionListener(e -> System.exit(0));

        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(buttonStart);
        panel.add(buttonExit);

        add(battleMap, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        setVisible(true);
    }

    void startNewGame(int fieldSize, int dotsToWin) {
        battleMap.startNewGame(fieldSize, dotsToWin);
    }
}
