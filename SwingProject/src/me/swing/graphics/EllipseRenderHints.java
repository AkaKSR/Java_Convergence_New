package me.swing.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class EllipseRenderHints extends JFrame {
  public static void main(String[] args) {
    new EllipseRenderHints();
  }

  public EllipseRenderHints() {
    this.setSize(300, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.add(new PaintSurface(), BorderLayout.CENTER);
    this.setVisible(true);
  }
}
class PaintSurface extends JComponent {
  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;

    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    Shape s = new Ellipse2D.Float(20, 50, 250, 150);
    g2.setPaint(Color.BLACK);
    g2.draw(s);
  }
}