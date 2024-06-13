package gui.panels;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CenterPanel extends JPanel {
    private List<JCheckBox> boxes = new ArrayList<>();
    public CenterPanel(){
        GridLayout gridLayout = new GridLayout(16,16);
        gridLayout.setHgap(2);
        gridLayout.setVgap(1);
        this.setLayout(gridLayout);

        for(int i = 0; i < 256; i++){

            JCheckBox box = new JCheckBox();
            boxes.add(box);
            this.add(box);
        }
    }

    public List<JCheckBox> getBoxes() {
        return boxes;
    }
}
