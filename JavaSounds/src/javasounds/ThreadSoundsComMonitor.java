/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasounds;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author fhmbe
 */
public class ThreadSoundsComMonitor implements Runnable{
    public String nome;
    public int melodia[];
    private static MelodiasComMonitor m = new MelodiasComMonitor();
    
    public ThreadSoundsComMonitor(String nome, int melodia[]) {
        this.nome = nome;
        this.melodia = melodia;
    }

    @Override
    public void run() {
        try {
            m.play(melodia, nome);
            JavaSoundScreen.txtSoundsController(("Musica "+nome+" finalizada!"));
        } catch (LineUnavailableException ex) {
            JavaSoundScreen.txtSoundsController(("Erro ao executar a musica "+nome));
        }
    }
}
