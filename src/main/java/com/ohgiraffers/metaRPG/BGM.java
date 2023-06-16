package com.ohgiraffers.metaRPG;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class BGM extends Thread{
    @Override
    public void run() {
        while (true) {
            File wav = new File("src/main/resources/metaRPG/bgm/metaRpgBgm.wav");
            AudioInputStream radio = null;
            try {
                radio = AudioSystem.getAudioInputStream(wav);
            } catch (UnsupportedAudioFileException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Clip clip = null;
            try {
                clip = AudioSystem.getClip();
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            }
            try {
                clip.open(radio);
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
            try {
                Thread.sleep(clip.getMicrosecondLength() / 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
