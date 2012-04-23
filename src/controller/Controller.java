
package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import model.Model;
import utils.*;
import view.MainFrame;
import view.xPanel;

public class Controller {
    private MainFrame mf;
    private Model  model;
    private FactorySorter factSorter = null;

    public Controller(MainFrame mf, Model model) {
        this.mf = mf;
        this.model = model;
        factSorter = new FactorySorter();
        mf.addBtnsListeners(initButtonsListeners());
    }

    private ActionListener[] initButtonsListeners() {
        ActionListener l1 = new ActionListener() {
          @Override
            public void actionPerformed(ActionEvent e) {
                model.initMass();
                 JPanel grid = (JPanel) mf.getJpFace().getComponent(0);
                for (int i = 0; i < grid.getComponentCount(); i++) 
                {   xPanel comp = (xPanel)grid.getComponent(i);
                    comp.initMass();
                }      
                
            }
        };
        ActionListener l2 = new ActionListener(){
           @Override
            public void actionPerformed(ActionEvent e) {
                JPanel grid = (JPanel) mf.getJpFace().getComponent(0);
                for (int i = 0; i < grid.getComponentCount(); i++) 
                {   xPanel comp = (xPanel)grid.getComponent(i);
                    Sorter srt = factSorter.getInstance(comp);
                    Thread t = new Thread(srt);
                    t.start();
                }  
            }
        };

        return new ActionListener[]{l1,l2}; 
    }
    
}
