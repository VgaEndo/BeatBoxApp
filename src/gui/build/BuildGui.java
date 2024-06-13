package gui.build;

import gui.frame.GuiMainFrame;
import gui.panels.CenterPanel;
import gui.panels.east.EastPanelButtons;
import gui.panels.MainPanel;
import gui.panels.WestPanel;
import gui.panels.east.EastPanelMain;
import gui.panels.east.EastPanelMessage;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BuildGui {

    private CenterPanel centerPanel;
    private EastPanelButtons eastPanelButtons;
    private EastPanelMessage eastPanelMessage;
    public void build(){
        GuiMainFrame frame = new GuiMainFrame();
        MainPanel mainPanel = new MainPanel();
        WestPanel westPanel = new WestPanel();
        centerPanel = new CenterPanel();
        eastPanelButtons = new EastPanelButtons();
        EastPanelMain eastPanelMain = new EastPanelMain();
        eastPanelMain.add(eastPanelButtons);
        eastPanelMessage = new EastPanelMessage();
        eastPanelMain.add(eastPanelMessage);
        frame.getContentPane().add(mainPanel);


        mainPanel.add(BorderLayout.WEST,westPanel);
        mainPanel.add(BorderLayout.CENTER,centerPanel);
        mainPanel.add(BorderLayout.EAST,eastPanelMain);

        frame.pack();
    }

    public List<JCheckBox> getCentralPanelBoxes(){
        return centerPanel.getBoxes();
    }

    public EastPanelButtons getEastPanel() {
        return eastPanelButtons;
    }

    public EastPanelMessage getEastPanelMessage() {
        return eastPanelMessage;
    }
}
