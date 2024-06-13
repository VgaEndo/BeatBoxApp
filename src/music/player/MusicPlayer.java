package music.player;

import javax.sound.midi.*;
import javax.swing.*;
import java.util.List;

public class MusicPlayer {

    int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};
    private int tempo = 120;
    private List<JCheckBox> boxList;

    private Sequencer player;

    public MusicPlayer(List<JCheckBox> boxList) {
        this.boxList = boxList;
    }

    public MidiEvent buildMidiEvent(int ms, int channel, int note, int thick, int duration) throws InvalidMidiDataException {
        ShortMessage msg = new ShortMessage();
        msg.setMessage(ms,channel,note,thick);

        return new MidiEvent(msg,duration);


    }

    public void buildTrack(Track track) throws InvalidMidiDataException {


        for(JCheckBox el:boxList) {

            if(el.isSelected()){
                int index = boxList.indexOf(el);

                int beatNumber = index % 16;
                int col = index / 16;

                int note = instruments[col];

                track.add(buildMidiEvent(144,1,note,100,beatNumber));
                track.add(buildMidiEvent(128,1,note,100,beatNumber+1));

            }
        }
    }

    public void buildTrackAndStart(){

        try {
            player = MidiSystem.getSequencer();
            player.open();

            Sequence sequence =new Sequence(Sequence.PPQ,4);
            Track track = sequence.createTrack();
            buildTrack(track);
            player.setSequence(sequence);
            player.setTempoInBPM(tempo);
            player.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
            player.start();
        } catch (MidiUnavailableException | InvalidMidiDataException e) {
            throw new RuntimeException(e);
        }


    }

    public void stop(){

        player.stop();
    }

    public void tempoUp(){
        this.tempo+=3;
        player.setTempoInBPM(tempo);
    }

    public void tempoDown(){
        this.tempo-=3;
        player.setTempoInBPM(tempo);
    }



}
