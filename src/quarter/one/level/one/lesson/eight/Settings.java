package quarter.one.level.one.lesson.eight;

import javax.swing.*;
import java.awt.*;

public class Settings extends JFrame {
    static final int MIN_FIELD_SIZE = 3;
    static final int MAX_FIELD_SIZE = 10;

    private final GameWindow gameWindow;

    public Settings(GameWindow gameWindow, int positionX, int positionY) {
        this.gameWindow = gameWindow;
        setTitle("Settings");
        setBounds(positionX + 50, positionY + 50, Style.WINDOW_WIDTH, Style.WINDOW_HEIGHT);
        getContentPane().setBackground(Style.BACKGROUND_COLOR);

        JSlider sliderDotsToWin = new JSlider(MIN_FIELD_SIZE, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderDotsToWin.setMajorTickSpacing(1);
        sliderDotsToWin.setPaintTicks(true);
        sliderDotsToWin.setPaintLabels(true);
        sliderDotsToWin.setBackground(Style.BACKGROUND_COLOR);

        JSlider sliderFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        sliderFieldSize.setMajorTickSpacing(1);
        sliderFieldSize.setPaintTicks(true);
        sliderFieldSize.setPaintLabels(true);
        sliderFieldSize.setBackground(Style.BACKGROUND_COLOR);
        sliderFieldSize.addChangeListener(e -> sliderDotsToWin.setMaximum(sliderFieldSize.getValue()));

        JButton buttonStart = new JButton("Start");
        buttonStart.setBackground(Style.BUTTON_COLOR);
        buttonStart.addActionListener(e -> {
            this.gameWindow.startNewGame(sliderFieldSize.getValue(), sliderDotsToWin.getValue());
            setVisible(false);
        });

        JButton buttonCancel = new JButton("Cancel");
        buttonCancel.setBackground(Style.BUTTON_COLOR);
        buttonCancel.addActionListener(e -> setVisible(false));

        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(buttonStart);
        panel.add(buttonCancel);

        setLayout(new GridLayout(5, 1));
        add(new Label("Field size:"));
        add(sliderFieldSize);
        add(new Label("Dots to win:"));
        add(sliderDotsToWin);
        add(panel);
        setVisible(false);
    }
}
