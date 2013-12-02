/*
 * Here we make a class which is named CropImage. We use extend frame to have
 *all functionality of frame in this class. We have implemented various mouse
 *listener because we want to know when user starts to drag an image and from
 *which point. drag_status variable is for knowing when dragging started and
 *c1,c2,c3,c4 are used for storing coordinates. We define a main method and then
 *we call a method start from main which we will define later...
 *
 *Read more:
 *http://mrbool.com/how-to-crop-an-image-using-java/25272#ixzz2lh5q49fW
 */

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class CropImage extends JFrame implements MouseListener, MouseMotionListener {

    int drag_status = 0, c1, c2, c3, c4;

    public static void main(String args[]) {
        new CropImage().start();
    }

    public void start() {
        ImagePanel im = new ImagePanel("F:\\Wallpaper\\wallpapers\\1.jpg");
        add(im);
        setSize(400, 400);
        setVisible(true);
        addMouseListener(this);
        addMouseMotionListener(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void draggedScreen() throws Exception {
        int w = c1 - c3;
        int h = c2 - c4;
        w = w * -1;
        h = h * -1;
        Robot robot = new Robot();
        BufferedImage img = robot.createScreenCapture(new Rectangle(c1, c2, w, h));
        File save_path = new File("screen1.jpg");
        ImageIO.write(img, "JPG", save_path);
        System.out.println("Cropped image saved successfully.");
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        repaint();
        c1 = arg0.getX();
        c2 = arg0.getY();
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        repaint();
        if (drag_status == 1) {
            c3 = arg0.getX();
            c4 = arg0.getY();
            try {
                draggedScreen();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void mouseDragged(MouseEvent arg0) {
        repaint();
        drag_status = 1;
        c3 = arg0.getX();
        c4 = arg0.getY();
    }

    @Override
    public void mouseMoved(MouseEvent arg0) {

    }

    public void paint(Graphics g) {
        super.paint(g);
        int w = c1 - c3;
        int h = c2 - c4;
        w = w * -1;
        h = h * -1;
        if (w < 0) {
            w = w * -1;
        }
        g.drawRect(c1, c2, w, h);
    }
}