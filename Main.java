import java.io.File;

import controller.MainFrame;
import model.Image;
import persistence.FileImageLoader;

public class Main {
    public static void main(String[] args) {
        File file = new File("images");
        FileImageLoader imageLoader = new FileImageLoader(file);
        Image image = imageLoader.load();

        MainFrame mainFrame = new MainFrame();
        mainFrame.getImageDisplay().show(image);
    }
}
