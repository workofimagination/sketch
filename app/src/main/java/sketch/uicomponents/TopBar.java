package sketch.uicomponents;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import sketch.MainFrame;

public class TopBar extends JPanel {
    public TopBar(MainFrame main) {
        JButton undoButton = new JButton("undo");
        undoButton.setSize(30, 50);
        undoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.canvas.undo();
            }
        });
        this.add(undoButton);

        JButton redoButton = new JButton("redo");
        redoButton.setSize(50, 30);
        redoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                main.canvas.redo();
            }
        });
        this.add(redoButton);

        JButton exportButton = new JButton("export");
        exportButton.setSize(50, 40);
        exportButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                main.canvas.export();
            }
        });
        this.add(exportButton);

        this.setLayout(new FlowLayout());
    }

}

