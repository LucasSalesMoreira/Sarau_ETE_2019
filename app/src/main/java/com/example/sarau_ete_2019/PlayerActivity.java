package com.example.sarau_ete_2019;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.media.MediaPlayer;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;

public class PlayerActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> arrayNomes;
    //private TextView status;
    private MediaPlayer mediaPlayer = null;
    private SeekBar bar;
    private GifImageView gifImageView;

    private int musics[] = {R.raw.asa_preta, R.raw.c_o_s, R.raw.caso_de_amor_e_odio, R.raw.uma_bala_na_agulha};

    private ImageButton btPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão adicional da TooBar
        getSupportActionBar().setHomeButtonEnabled(true); //Tornando o botão adicional da TooBar clicável

        bar = (SeekBar) findViewById(R.id.seekBar);
        btPlay = (ImageButton) findViewById(R.id.bt_play);
        listView = (ListView) findViewById(R.id.playList);
        //status = (TextView) findViewById(R.id.status);
        gifImageView = (GifImageView) findViewById(R.id.imageViewlogo);
        loadListView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                controleBar = true;
                bar.setEnabled(true);
                controlarPlayer(position);
                ultimaMusica = position;
                btPlay.setImageResource(R.drawable.potao_stop_maior);
                gifImageView.setImageResource(R.drawable.gif_musica_500);
            }
        });
        bar.setEnabled(false);
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    if(mediaPlayer != null && mediaPlayer.isPlaying())
                        mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });
    }

    private boolean controle = false;

    private void controlarPlayer(int p){
        try{
            if(mediaPlayer != null){
                mediaPlayer.stop();
                mediaPlayer = null;
            }
            mediaPlayer = MediaPlayer.create(getApplicationContext(), musics[p]);
            mediaPlayer.start();
            bar.setMax(mediaPlayer.getDuration());
            updateBar();
            //status.setText("Reproduzindo "+arrayNomes.get(p)+"...");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void updateBar(){
        if(controleBar) {
            bar.setProgress(mediaPlayer.getCurrentPosition());
        }
        if(bar.getProgress() == bar.getMax()){
            bar.setProgress(0);
            bar.setEnabled(false);
            btPlay.setImageResource(R.drawable.bt_play_maior);
            gifImageView.setImageResource(R.drawable.logomusica);
        }
        //if(mediaPlayer.isPlaying()){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                updateBar();
            }
        };
        new Handler().postDelayed(runnable, 100);
        //}
    }

    private boolean controleBar = true;
    private int ultimaMusica = 0;
    private boolean primeiraExecucao = true;

    public void stop(View v){
        if(mediaPlayer != null){
            if(mediaPlayer.isPlaying()){
                mediaPlayer.stop();
                controleBar = false;
                bar.setProgress(0);
                bar.setEnabled(false);
                gifImageView.setImageResource(R.drawable.logomusica);
                btPlay.setImageResource(R.drawable.bt_play_maior);
            }else{
                btPlay.setImageResource(R.drawable.potao_stop_maior);
                gifImageView.setImageResource(R.drawable.gif_musica_500);
                controleBar = true;
                bar.setEnabled(true);
                controlarPlayer(ultimaMusica);
            }
        }else{
            if(primeiraExecucao){
                gifImageView.setImageResource(R.drawable.gif_musica_500);
                bar.setEnabled(true);
                btPlay.setImageResource(R.drawable.potao_stop_maior);
                controlarPlayer(ultimaMusica);
                primeiraExecucao = false;
            }
            Toast.makeText(getApplicationContext(), "Nenhuma música foi escolhida!", Toast.LENGTH_SHORT).show();
        }
    }

    public void stop(){
        if(mediaPlayer != null){
            mediaPlayer.stop();
            btPlay.setImageResource(R.drawable.bt_play_maior);
        }
    }

    private void loadListView(){
        arrayNomes = new ArrayList<>();
        arrayNomes.add("Asa preta");
        arrayNomes.add("C.O.S");
        arrayNomes.add("Caso de amor e ódio");
        arrayNomes.add("Uma bala na agulha");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arrayNomes);
        listView.setAdapter(adapter);

    }

    @Override
    public void onBackPressed(){ //Botão BACK padrão do android
        stop();
        startActivity(new Intent(getApplicationContext(), HomenageadoActivity.class));
        finishAffinity();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                stop();
                startActivity(new Intent(getApplicationContext(), HomenageadoActivity.class));
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:
                break;
        }
        return true;
    }

}
