package ui;

import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Image;

import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class SwingImageDisplay extends JPanel implements ImageDisplay {
    private Image currentImage;

    private BufferedImage imageOf(Image image) {
        try {
            return ImageIO.read(image.stream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void paint(Graphics g) {
        if (currentImage == null)
            return;

        BufferedImage img = imageOf(currentImage);

        int original_width = img.getWidth();
        int original_height = img.getHeight();
        int bound_width = this.getWidth();
        int bound_height = this.getHeight();
        int new_width = original_width;
        int new_height = original_height;

        // first check if we need to scale width

        new_width = bound_width;
        new_height = (new_width * original_height) / original_width;

        if (new_height > bound_height) {
            new_height = bound_height;
            new_width = (new_height * original_width) / original_height;
        }

        java.awt.Image image = img.getScaledInstance(new_width, new_height, ABORT);

        g.drawImage(image,
                (this.getWidth() - image.getWidth(null)) / 2,
                (this.getHeight() - image.getHeight(null)) / 2,
                null);

    }

    @Override
    public void show(Image image) {
        this.currentImage = image;
        this.repaint();
    }

    @Override
    public Image current() {

        return currentImage;
    }
}
