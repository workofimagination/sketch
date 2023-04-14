package sketch;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JFrame;

import sketch.uicomponents.TopBar;

public class MainFrame extends JFrame {
    public Canvas canvas;

    public MainFrame() {
        super( "test" );
        Container contents = getContentPane();
        this.canvas = new Canvas();
        this.add(canvas);

        TopBar topBar = new TopBar(this);
        this.add(topBar);


        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout());
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
