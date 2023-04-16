package sketch.uicomponents;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import sketch.MainFrame;
import sketch.utils.FileGenerator;

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
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("select where to export");
                int selection = fileChooser.showSaveDialog(exportButton);

                if (selection == JFileChooser.APPROVE_OPTION) {
                    File save = fileChooser.getSelectedFile();
                    main.canvas.exportGS(save.getAbsolutePath());
                    System.out.println("saved to " + save.getAbsolutePath());
                }
            }
        });
        this.add(exportButton);

        JButton importButton = new JButton("import");
        importButton.setSize(50, 40);
        importButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("select import file");
                int selection = fileChooser.showSaveDialog(exportButton);

                if (selection == JFileChooser.APPROVE_OPTION) {
                    File save = fileChooser.getSelectedFile();
                    if (!new File(save.getAbsolutePath()).exists()) {
                        System.out.println("file does not exist");
                        return;
                    }

                    main.canvas.importGS(save.getAbsolutePath());
                    System.out.println("trying to prase file " + save.getName());
                }
            }
        });
        this.add(importButton);

        JButton uploadButton = new JButton("upload");
        uploadButton.setSize(50, 40);
        uploadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String exportString = FileGenerator.exportString(main.canvas.drawables);
                main.client.sendMessage(1, exportString);
            }
        });
        this.add(uploadButton);

        this.setLayout(new FlowLayout());
    }

}

