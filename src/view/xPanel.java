
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import model.Model;

public class xPanel extends JPanel{
    private int[] a;
    private int khRect;
    private int wRect;
    private final Model model;

    public xPanel(Model model) {
        super(new FlowLayout());
        this.model = model;
        setBounds(0, 0, 300, 70);
        setPreferredSize(new Dimension(300, 65));
        setBorder(BorderFactory.createBevelBorder(1));
    }
    public void initMass()
    {
        this.a = model.getMass();
        khRect = getHeight()/model.getH();        
        wRect = getWidth()/a.length;
        
        repaint();
        
    }
    
    public void getMass()
    {
        this.a = model.getMass();
        repaint();
        
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        for (int i = 0; i < a.length; i++) {
            g.setColor(Color.green);
            g.fillRect(i*wRect, getHeight()-khRect*a[i], wRect, khRect*a[i]);
            g.setColor(Color.black);
            g.drawRect(i*wRect, getHeight()-khRect*a[i], wRect, khRect*a[i]);
        }
    }
}
