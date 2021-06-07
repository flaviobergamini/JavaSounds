/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasounds;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/**
 *
 * @author fhmbe
 */
public class MelodiasSemMonitor {
    
    private int melodia[];
    
    public void play(int melodia [], String nome) throws LineUnavailableException{
        this.melodia = melodia;
        JavaSoundScreen.txtSoundsController(("Musica: "+nome+" iniciada!"));
        byte[] buf = new byte[ 1 ];
        AudioFormat af = new AudioFormat( (float )44100, 8, 1, true, false );
        SourceDataLine sdl = AudioSystem.getSourceDataLine( af );
        sdl.open();
        sdl.start();
        
        for(int nota : melodia){
            for( int i = 0; i < 22050; i++ ) {
                double angle = i / ( (float )44100 / nota ) * 2.0 * Math.PI;
                buf[ 0 ] = (byte )( Math.sin( angle ) * 100 );
                sdl.write( buf, 0, 1 );
          
            }
        }
        sdl.drain();
        sdl.stop();
    }
}
