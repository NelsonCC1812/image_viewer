package controller;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Image;
import ui.ImageDisplay;
import ui.SwingImageDisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private ImageDisplay imageDisplay;

    public MainFrame() {
        this.setTitle("Image viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imageDisplay());
        this.getContentPane().add(toolBar(), BorderLayout.SOUTH);
        this.setVisible(true);
    }

    private JPanel toolBar() {
        JPanel panel = new JPanel();
        panel.add(prevButton());
        panel.add(nextButton());
        return panel;
    }

    private JButton prevButton() {
        JButton button = new JButton("<");
        button.addActionListener(prevImage());
        return button;
    }

    private ActionListener prevImage() {
        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                imageDisplay.show(imageDisplay.current().prev());
            }

        };
    }

    private JButton nextButton() {
        JButton button = new JButton(">");
        button.addActionListener(nextImage());
        return button;
    }

    private ActionListener nextImage() {

        return new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                imageDisplay.show(imageDisplay.current().next());
            }

        };
    }

    private JPanel imageDisplay() {

        SwingImageDisplay sid = new SwingImageDisplay();
        this.imageDisplay = sid;
        return sid;
    }

    public ImageDisplay getImageDisplay() {

        return imageDisplay;
    }
}
