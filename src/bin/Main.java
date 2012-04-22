
package bin;

import controller.Controller;
import javax.swing.JFrame;
import model.Model;
import view.MainFrame;

public class Main {

    public static void main(String[] args) {
       Model md = new Model();
       MainFrame mf = new MainFrame(md);
       Controller controller = new Controller(mf, md);
       mf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       mf.setVisible(true);
    }
}
