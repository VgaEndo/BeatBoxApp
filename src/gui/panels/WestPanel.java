package gui.panels;

import javax.swing.*;

public class WestPanel extends JPanel {

    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat",
            "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap",
            "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga",
            "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo",
            "Open Hi Conga"};

    public WestPanel(){
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        for(String el : instrumentNames){
            JLabel label = new JLabel(el);
            label.setBorder(BorderFactory.createEmptyBorder(5,1,4,1));
            this.add(label);
        }
    }
}
