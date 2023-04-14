package sketch;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import sketch.components.Coordinate;
import sketch.components.Drawable;
import sketch.components.Line;
import sketch.utils.FileGenerator;

public class Canvas extends JPanel implements MouseListener {
    private ArrayList<Drawable> drawables;
    private Coordinate firstPoint = null;
    private Coordinate prevPoint = null;

    public Canvas() {
        setBackground(Color.gray);
        this.drawables = new ArrayList<>();
        this.addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (Drawable d : drawables) {
            d.draw(g2d);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (this.drawables.size() > 3) {
            System.out.println(this.drawables.get(0).getEnd());
            FileGenerator.generate(this.drawables);
        }

        Coordinate clickPos = new Coordinate(e.getLocationOnScreen().getX(), e.getLocationOnScreen().y);
        System.out.println(clickPos);
        if (firstPoint == null) {
            this.firstPoint = clickPos;
            return;
        }

        if (prevPoint == null) {
            this.prevPoint = this.firstPoint;
        }

        this.drawables.add(new Line(this.prevPoint, clickPos));
        this.prevPoint = clickPos;
        this.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
