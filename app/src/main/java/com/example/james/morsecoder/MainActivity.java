package com.example.james.morsecoder;

import android.content.Context;
import android.media.AudioAttributes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.media.SoundPool;
import android.media.AudioManager;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TextView morseText;
    TextView plainText;
    boolean recordSound;
    boolean delete;

 //   SoundPool soundPool;
 //   AudioAttributes attributes;
 //   HashMap<Integer, Integer> soundPoolMap;
 //   int soundID_dit = 1;
  //  int soundID_dah = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        morseText = (TextView) findViewById(R.id.editTextMorse);
        plainText = (TextView) findViewById(R.id.editTextPlain);


        // IT IS BORKED!SoundPool.Builder()
    //    soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 100);
     //   SoundPool.Builder()
        //soundPoolMap = new HashMap<>();
        //soundPoolMap.put(soundID_dit, soundPool.load(this, R.raw.dit, 1));
      //  soundPoolMap.put(soundID_dah, soundPool.load(this, R.raw.dah, 1));
        //






        plainText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (delete){
                    delete = false;
                    return;
                }
                morseText.setText(UpdateText(plainText.getText().toString()));
            }
        });

        final ToggleButton toggleRecord = (ToggleButton) findViewById(R.id.toggle_record);
        toggleRecord.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    recordSound = true;
                    startRecord(toggleRecord);

                } else {
                    recordSound = false;
                    stopRecord(toggleRecord);
                }
            }
        });




    }
    public void startRecord(View view) {
        //TODO Actually make it record
    }
    public void stopRecord(View view){
        //TODO Actually make it stop recording
    }

    public void PlayMorse(View view){

    }
/*
    public class SoundRunnable implements Runnable{

        @Override
        public void run(){
            android.os.Process.setThreadPriority(android.os.Process.THREAD_PRIORITY_BACKGROUND);

            String textToPlay = morseText.toString();

            AudioManager audioManager = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
            float curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
            float maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
            float leftVolume = curVolume/maxVolume;
            float rightVolume = curVolume/maxVolume;
            int priority = 1;
            int no_loop = 0;
            float normal_playback_rate = 1f;


            for(int i = 0; i< textToPlay.length(); i++){
                char c = textToPlay.charAt(i);
                switch (c){
                    case '.':

                        soundPool.play(soundID_dit, leftVolume, rightVolume, priority, no_loop, normal_playback_rate);
                        break;
                    case '-':

                        soundPool.play(soundID_dah, leftVolume, rightVolume, priority, no_loop, normal_playback_rate);
                        break;
                    case ' ':
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    default:
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            }
        }

    }

    public void PlayMorse(View view){
       SoundRunnable playSound = new SoundRunnable();
        playSound.run();
    }
*/

    public void PlaceDot(View view){
        morseText.setText(morseText.getText() + ".");
      //  plainText.setText("");
        delete = true;
        plainText.setText(UpdateMorse(morseText.getText().toString()));
    }
    public void PlaceDah(View view){
        morseText.setText(morseText.getText() + "-");
      //  plainText.setText("");
        delete = true;
        plainText.setText(UpdateMorse(morseText.getText().toString()));
    }
    public void PlaceSpace(View view){
        morseText.setText(morseText.getText() + " ");
      //  plainText.setText("");
        delete = true;
        plainText.setText(UpdateMorse(morseText.getText().toString()));

    }
    public void PlaceBack(View view){
        String text = morseText.getText().toString();
        if (!text.isEmpty()){
        //    if (text.length()>2){
               delete = true;
                text = text.substring(0, morseText.length() - 1);
                morseText.setText(text);

                plainText.setText(UpdateMorse(morseText.getText().toString()));
            }
        }


    public String UpdateText(String text){
        String temp;
        temp = text.toUpperCase();
   //     if(delete) {
            temp = temp.replace("H", "....");
            temp = temp.replace("C", "-.-.");
            temp = temp.replace("J", ".---");
            temp = temp.replace("L", ".-..");
            temp = temp.replace("P", ".--.");
            temp = temp.replace("Q", "--.-");
            temp = temp.replace("V", "...-");
            temp = temp.replace("Y", "-.--");
            temp = temp.replace("X", "-..-");
            temp = temp.replace("Z", "--..");
            temp = temp.replace("B", "-...");
            temp = temp.replace("F", "..-.");
            temp = temp.replace("O", "---");
         //   delete = false;
  //      }
  /*      else {
            temp = temp.replace("H", ".... ");
            temp = temp.replace("C", "-.-. ");
            temp = temp.replace("J", ".--- ");
            temp = temp.replace("L", ".-.. ");
            temp = temp.replace("P", ".--. ");
            temp = temp.replace("Q", "--.- ");
            temp = temp.replace("V", "...- ");
            temp = temp.replace("Y", "-.-- ");
            temp = temp.replace("X", "-..- ");
            temp = temp.replace("Z", "--.. ");
            temp = temp.replace("B", "-... ");
            temp = temp.replace("F", "..-. ");
            temp = temp.replace("O", "--- ");
        } */
        temp = temp.replace("K", "-.-");
        temp = temp.replace("D", "-..");
        temp = temp.replace("G", "--.");
        temp = temp.replace("R", ".-.");
        temp = temp.replace("S", "...");
        temp = temp.replace("U", "..-");
        temp = temp.replace("W", ".--");

        temp = temp.replace("M", "--");
        temp = temp.replace("N", "-.");
        temp = temp.replace("I", "..");
        temp = temp.replace("A", ".-");

        temp = temp.replace("E", ".");
        temp = temp.replace("T", "-");

        return temp;
    }

    public String UpdateMorse(String text){
        String temp = text;
        temp = temp.replace(".... ", "H");
        temp = temp.replace("-.-. ", "C");
        temp = temp.replace(".--- ", "J");
        temp = temp.replace(".-.. ", "L");
        temp = temp.replace(".--. ", "P");
        temp = temp.replace("--.- ", "Q");
        temp = temp.replace("..-. ", "F");
        temp = temp.replace("...- ", "V");
        temp = temp.replace("-.-- ", "Y");
        temp = temp.replace("-..- ", "X");
        temp = temp.replace("--.. ", "Z");
        temp = temp.replace("-... ", "B");


        temp = temp.replace("-.- ", "K");
        temp = temp.replace(".-. ", "R");
        temp = temp.replace("--. ", "G");
        temp = temp.replace("..- ", "U");
        temp = temp.replace(".-- ", "W");
        temp = temp.replace("-.. ", "D");
        temp = temp.replace("--- ", "O");
        temp = temp.replace("... ", "S");


        temp = temp.replace("-- ", "M");
        temp = temp.replace(".. ", "I");
        temp = temp.replace(".- ", "A");
        temp = temp.replace("-. ", "N");


        temp = temp.replace("- ", "T");
        temp = temp.replace(". ", "E");
        temp = temp.replace("  ", " ");

//        THIS FUCKS IT UP FOR SOME REASON
        /*
        temp = temp.replace("....", "H");
        temp = temp.replace("-.-.", "C");
        temp = temp.replace(".---", "J");
        temp = temp.replace(".-..", "L");
        temp = temp.replace(".--.", "P");
        temp = temp.replace("--.-", "Q");
        temp = temp.replace("..-.", "F");
        temp = temp.replace("...-", "V");
        temp = temp.replace("-..-", "X");
        temp = temp.replace("-.--", "Y");
        temp = temp.replace("--..", "Z");
        temp = temp.replace("-...", "B");

        temp = temp.replace("-..", "D");
        temp = temp.replace("--.", "G");
        temp = temp.replace("-.-", "K");
        temp = temp.replace("---", "O");
        temp = temp.replace(".-.", "R");
        temp = temp.replace("...", "S");
        temp = temp.replace("..-", "U");
        temp = temp.replace(".--", "W");


        temp = temp.replace(".-", "A");
        temp = temp.replace("..", "I");
        temp = temp.replace("--", "M");
        temp = temp.replace("-.", "N");


        temp = temp.replace("-", "T");
        temp = temp.replace(".", "E");
        */

        return temp;
    }
}

