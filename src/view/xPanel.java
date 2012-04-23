
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
    private int wRect, khRect, h;
    private int type;
    private Model model;
    public xPanel(int type, Model model) {
        super(new FlowLayout());
        this.type  = type;
        this.model = model;
        initMass();
        setBounds(0, 0, 500, 70);
        setPreferredSize(new Dimension(500, 70));
       
        setBorder(BorderFactory.createBevelBorder(1));
    }
    public void initMass()
    {
        a = model.getMass().clone();
        khRect = getHeight()/model.getH();        
        wRect = getWidth()/a.length;
        
        repaint();
        
    }
    
    public int[] getMass()
    {
        return a;     
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

    public void refresh() {
        repaint();
    }

    public int getType() {
        return type;
    }
    
}
