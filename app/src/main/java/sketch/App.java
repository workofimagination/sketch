package sketch;

import sketch.Networking.WSClient;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.*;

import java.net.URISyntaxException;

import javax.lang.model.util.AbstractAnnotationValueVisitor6;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;

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
        this.canvas = new Canvas();
        this.add(canvas);

        JButton undoButton = new JButton("undo");
        undoButton.setSize(30, 50);
        undoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                canvas.undo();
            }
        });
        this.add(undoButton);

        JButton redoButton = new JButton("redo");
        redoButton.setSize(50, 30);
        redoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                canvas.redo();
            }
        });
        this.add(redoButton);

        JButton exportButton = new JButton("export");
        exportButton.setSize(50, 40);
        exportButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                canvas.export();
            }
        });
        this.add(exportButton);

        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 1));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }
}
