package gui.panels.east;

import javax.swing.*;
import java.awt.event.ActionListener;

public class EastPanelButtons extends JPanel {
    private JButton start = new JButton("Start");
    private JButton stop = new JButton("Stop");
    private JButton tempoUp = new JButton("Tempo Up");
    private JButton tempoDown = new JButton("Tempo Down");

    public EastPanelButtons(){
        this.add(start);
        this.add(stop);
        this.add(tempoUp);
        this.add(tempoDown);


    }

    public void addStartListener(ActionListener listener){
        start.addActionListener(listener);
    }
    public void addStopListener(ActionListener listener){
        stop.addActionListener(listener);
    }
    public void addTempoUpListener(ActionListener listener){
        tempoUp.addActionListener(listener);
    }

    public void addTempoDownListener(ActionListener listener){
        tempoDown.addActionListener(listener);
    }

}
