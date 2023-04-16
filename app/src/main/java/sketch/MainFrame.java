package sketch;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;

import sketch.networking.WSClient;
import sketch.uicomponents.TopBar;

public class MainFrame extends JFrame {
    public Canvas canvas;
    public WSClient client;

    public MainFrame(WSClient client) {
        super( "test" );
        this.client = client;
        setSize(1000, 1000);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contents = getContentPane();

        TopBar topBar = new TopBar(this);
        contents.add(topBar, BorderLayout.NORTH);

        this.canvas = new Canvas();
        contents.add(canvas, BorderLayout.CENTER);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
