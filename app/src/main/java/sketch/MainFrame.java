package sketch;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;

import sketch.uicomponents.TopBar;

public class MainFrame extends JFrame {
    public Canvas canvas;

    public MainFrame() {
        super( "test" );
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contents = getContentPane();
        this.canvas = new Canvas();
        contents.add(canvas, BorderLayout.CENTER);

        TopBar topBar = new TopBar(this);
        contents.add(topBar, BorderLayout.NORTH);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
