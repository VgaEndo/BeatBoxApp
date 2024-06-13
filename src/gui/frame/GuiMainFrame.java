package gui.frame;

import javax.swing.*;

public class GuiMainFrame extends JFrame {

    public GuiMainFrame(){
        this.setSize(600,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setResizable(false);
    }
}
