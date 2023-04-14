package sketch;

import sketch.Networking.WSClient;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.net.URISyntaxException;

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws URISyntaxException {
        WSClient c = WSClient.init();
        c.connect();

        System.out.println("test");
        TestFrame temp = new TestFrame();
        temp.setVisible(true);
    }
}

class TestFrame extends JFrame {
    Canvas canvas;

    public TestFrame() {
        super( "test" );
        Container contents = getContentPane();
        setSize(800, 600);
        setResizable(false);
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
