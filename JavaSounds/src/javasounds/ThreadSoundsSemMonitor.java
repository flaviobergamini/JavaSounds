/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasounds;

import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author fhmbe
 */
public class ThreadSoundsSemMonitor  implements Runnable{
    public String nome;
    public int melodia[];
    private static MelodiasSemMonitor m = new MelodiasSemMonitor();
    
    public ThreadSoundsSemMonitor(String nome, int melodia[]) {
        this.nome = nome;
        this.melodia = melodia;
    }

    @Override
    public void run() {
        JavaSoundScreen.txtSoundsController(("Musica: "+nome+" Iniciada!"));
        try {
            m.play(melodia);
        } catch (LineUnavailableException ex) {
            JavaSoundScreen.txtSoundsController(("Erro ao executar a musica "+nome));
        }
        JavaSoundScreen.txtSoundsController(("Musica "+nome+" finalizada"));
    }
}