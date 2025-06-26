package com.click_countr;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.Objects;

public class AppForm extends JFrame {
    private JLabel text;
    private int count = 0;

    public AppForm () {
        super("Счетчик");
        super.setBounds(0, 0, 300, 300);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel grid = new JPanel();

        GridLayout layout = new GridLayout(3,1, 20, 20);
        grid.setLayout(layout);

        grid.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        ImageIcon img = new ImageIcon(Objects.requireNonNull(getClass().
                getResource("/com/click_countr/images/miniature-schnauzer.png")));
        Image scaledImage = img.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel label_img = new JLabel(scaledIcon);
        grid.add(label_img);

        text = new JLabel(String.valueOf(count), SwingConstants.CENTER);
        text.setOpaque(true); // делаем область текста непрозрачной
        text.setBackground(Color.ORANGE);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Aria", Font.BOLD, 22));
        text.setBorder(BorderFactory.createEtchedBorder());
        grid.add(text);

        JButton button = new JButton("Нажать");
        button.setBackground(Color.ORANGE);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Aria", Font.BOLD, 22));
        button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        grid.add(button);

        getContentPane().add(grid);
        setLocationRelativeTo(null);

        button.addActionListener(new ButtonAction());
    }

    class ButtonAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            count++;
            text.setText(String.valueOf(count));
        }
    }


}
