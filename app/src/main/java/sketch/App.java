package sketch;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

import sketch.components.Line;

public class App {
    public static void main(String[] args) {
        System.out.println("test");
        TestFrame temp = new TestFrame();
        temp.setVisible(true);
    }
}

class TestFrame extends JFrame {
    public TestFrame() {
        super( "test" );
        setSize(1000, 1000);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }

    @Override
    public void paint(Graphics g) {
        Line temp = new Line(10.0f, 20.0f, 1000.0f, 1000.0f);
        Graphics2D g2d = (Graphics2D) g;
        super.paint(g);
        temp.draw(g2d);
    }

}
