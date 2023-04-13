package sketch;

import sketch.components.Coordinate;
import sketch.components.Drawable;
import sketch.components.Line;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Canvas extends JPanel implements MouseListener {
    private ArrayList<Drawable> drawables;
    private Coordinate firstPoint = null;

    public Canvas() {
        setBackground(Color.gray);
        this.drawables = new ArrayList<>();
        this.addMouseListener(this);
    }


    @Override
    protected void paintComponent(Graphics g) {
        System.out.println("Ran");
        Graphics2D g2d = (Graphics2D) g;
        for (Drawable d : drawables) {
            d.draw(g2d);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("ran");
        Coordinate clickPos = new Coordinate(e.getLocationOnScreen().getX(), e.getLocationOnScreen().y);
        if (firstPoint == null) {
            this.firstPoint = clickPos;
            return;
        }
        System.out.println(firstPoint);
        System.out.println(clickPos);
        drawables.add(new Line(firstPoint, clickPos));
        firstPoint = null;
        repaint();
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