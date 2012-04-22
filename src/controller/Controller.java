
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Model;
import view.MainFrame;

public class Controller {
        private MainFrame mf;
    private Model  model;

    public Controller(MainFrame mf, Model model) {
        this.mf = mf;
        this.model = model;
        mf.addBtnsListeners(initButtonsListeners());
    }

    private ActionListener[] initButtonsListeners() {
        ActionListener l1 = new ActionListener() {
          @Override
            public void actionPerformed(ActionEvent e) {
                model.initMass();
                mf.refreshMass();
            }
        };
        ActionListener l2 = null;

        return new ActionListener[]{l1,l2}; 
    }
    
}
