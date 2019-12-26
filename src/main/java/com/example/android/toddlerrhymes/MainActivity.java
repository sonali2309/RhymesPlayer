package com.example.android.toddlerrhymes;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;


import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    GridLayout maingrid;

    MediaPlayer song1, song2, song3, song4, song5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        maingrid =(GridLayout)findViewById(R.id.maingrid);
        setToggleEvent(maingrid);



        song1 = MediaPlayer.create(MainActivity.this, R.raw.monkey);
        song2 = MediaPlayer.create(MainActivity.this, R.raw.fish);
        song3 = MediaPlayer.create(MainActivity.this, R.raw.twinkle);
        song4 = MediaPlayer.create(MainActivity.this, R.raw.itsybitsyspider);
        song5 = MediaPlayer.create(MainActivity.this, R.raw.humpty);
    }

    private void setToggleEvent(GridLayout maingrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < maingrid.getChildCount(); i++) {
            final CardView cardView = (CardView) maingrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //condition for 1st audio
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        cardView.setCardBackgroundColor(Color.parseColor("#FF6F00"));
                        Toast.makeText(MainActivity.this, "Tap again to stop", Toast.LENGTH_SHORT).show();

                        if (finalI == 0) {
                            song1.start();
                        }
                        else if(finalI == 1) {
                            song2.start();
                        }

                        else if(finalI == 2) {
                            song3.start();
                        }

                        else if(finalI == 3) {
                            song4.start();
                        }

                        else if(finalI == 4) {
                            song5.start();
                        }
                    }

                    else {
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(MainActivity.this, "stopped song "+(finalI+1), Toast.LENGTH_SHORT).show();

                        if(finalI==0) {
                            song1.stop();
                            try {
                                song1.prepare();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        else if(finalI==1) {
                            song2.stop();
                            try {
                                song2.prepare();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        else if(finalI==2) {
                            song3.stop();
                            try {
                                song3.prepare();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        else if(finalI==3) {
                            song4.stop();
                            try {
                                song4.prepare();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        else if(finalI==4) {
                            song5.stop();
                            try {
                                song5.prepare();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        song1.release();
        song2.release();
        song3.release();
        song4.release();
        song5.release();
    }
}


