package sketch;

import java.awt.*;

import javax.swing.JFrame;

import sketch.components.Line;

public class App {
    public static void main(String[] args) {
        System.out.println("test");
        Canvas canvas = new Canvas();
        TestFrame temp = new TestFrame();
        temp.setVisible(true);
    }
}

class TestFrame extends JFrame {
    Canvas canvas;
    public TestFrame() {
        super( "test" );
        Container contents = getContentPane();
        setSize(1000, 1000);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLayout(new GridLayout(1, 1));
        this.canvas = new Canvas();
        contents.add(canvas);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
