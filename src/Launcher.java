import client.Client;
import client.DataTransfer;
import gui.build.BuildGui;
import gui.panels.east.EastPanelButtons;
import gui.panels.east.EastPanelMessage;
import music.player.MusicPlayer;

public class Launcher {

    public void launch(String userName){
        BuildGui buildGui = new BuildGui();
        buildGui.build();
        MusicPlayer player = new MusicPlayer(buildGui.getCentralPanelBoxes());
        EastPanelButtons panel = buildGui.getEastPanel();
        EastPanelMessage panelMessage = buildGui.getEastPanelMessage();
        DataTransfer dataTransfer = new DataTransfer(panelMessage.getTextField()
                ,panelMessage.getTextArea(),panelMessage.getSend()
                ,userName,buildGui.getCentralPanelBoxes(),panelMessage.getMessages(),panelMessage.getMessageData());

        Client client = new Client(dataTransfer);

        panel.addStartListener(e -> player.buildTrackAndStart());
        panel.addStopListener(e-> player.stop());
        panel.addTempoDownListener(e-> player.tempoDown());
        panel.addTempoUpListener(e-> player.tempoUp());
    }
}
