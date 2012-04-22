
package view;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import model.Model;

public class MainFrame extends JFrame{
    private Model model;
    private JPanel jpFace;
    public static final int DEFAULT_WIDTH=400;
    public static final int DEFAULT_HEIGHT=600;
    private JButton btInit, btStart;
    
    public MainFrame(Model model){
        //Create and set up the window.
        super("DiffSorters");
        //Register model
        this.model = model;
        //setLocationRelativeTo(this);
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        //Create and set up the content pane.
        addContentPane(getContentPane());
        
    }
    public void refreshMass(){
        JPanel grid = (JPanel) jpFace.getComponent(0);
        for(Component comp: grid.getComponents()) {
             if(comp instanceof xPanel) {   
                ((xPanel)comp).getMass();              
            }
        }
    }
    
    public void addBtnsListeners(ActionListener[] actnListeners)
    {
        btInit.addActionListener(actnListeners[0]);
        btStart.addActionListener(actnListeners[1]);
    }
    
    private void addContentPane(Container contentPane) {
        contentPane.setLayout(new BorderLayout());
        
        JPanel grid = new JPanel( new GridLayout(10, 0, 0, 10) );
        model.initMass();
        for (int i = 0; i < 7; i++) {
            xPanel xpanel = new xPanel(i,model);
            xpanel.initMass();
            
            grid.add(xpanel);
             
        }
       
        
        jpFace = new JPanel();
        jpFace.add(grid);
         
        // Init buttons
        btInit  = new JButton("Init ");
        btStart = new JButton("Start");
        // выравнивания размеров кнопок
        grid = new JPanel( new GridLayout(1, 2, 5, 0) );
        // добавляем компоненты
        grid.add( btInit );
        grid.add( btStart);
        // помещаем полученное в панель с последовательным
        // расположением, выравненным по правому краю
        JPanel jpDnButtons = new JPanel( new FlowLayout() );
        jpDnButtons.add(grid);
        
        
        
        contentPane.add(jpFace, BorderLayout.CENTER);
        // помещаем строку кнопок вниз окна
        contentPane.add(jpDnButtons, BorderLayout.SOUTH);
    }
    
}
