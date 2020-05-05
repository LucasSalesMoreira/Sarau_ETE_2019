package com.example.sarau_ete_2019;

import android.content.Intent;
import android.os.Bundle;
//import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomMenuButton;
import pl.droidsonroids.gif.GifImageView;
import uk.co.senab.photoview.PhotoViewAttacher;

public class MapaActivity extends AppCompatActivity {

    private static String destino;
    private TextView temaSala;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão adicional da TooBar
        getSupportActionBar().setHomeButtonEnabled(true); //Tornando o botão adicional da TooBar clicável

        criarTrajeto(destino);
        criarMenu();
    }

    private void criarMenu(){
        temaSala = (TextView) findViewById(R.id.temaSala);
        BoomMenuButton bmb1 = (BoomMenuButton) findViewById(R.id.bmb1);

        for (int i = 0; i < bmb1.getPiecePlaceEnum().pieceNumber(); i++) {
            HamButton.Builder builder = new HamButton.Builder();
            builder.textSize(18);

            if(destino.equals("Biblioteca")){
                temaSala.setText(R.string.temaBiblioteca);
                if(i == 0){
                    builder.normalTextRes(R.string.bibliotecaButton1);
                }
                if(i == 1){
                    builder.normalTextRes(R.string.bibliotecaButton2);
                }
                if(i == 2){
                    builder.normalTextRes(R.string.bibliotecaButton3);
                }
            }
            if(destino.equals("Auditório")){
                temaSala.setText(R.string.temaAuditorio);
                if(i == 0){
                    builder.normalTextRes(R.string.auditorioButton1);
                }
                if(i == 1){
                    builder.normalTextRes(R.string.auditorioButton2);
                }
                if(i == 2){
                    builder.normalTextRes(R.string.auditorioButton3);
                }
            }
            if(destino.equals("Sala - 01")){
                temaSala.setText(R.string.temaSala01);
                if(i == 0){
                    builder.normalTextRes(R.string.sala01Button1);
                }
                if(i == 1){
                    builder.normalTextRes(R.string.sala01Button2);
                }
                if(i == 2){
                    builder.normalTextRes(R.string.sala01Button3);
                }
            }
            if(destino.equals("Sala - 02")){
                temaSala.setText(R.string.temaSala02);
                if(i == 0){
                    builder.normalTextRes(R.string.sala02Button1);
                }
                if(i == 1){
                    builder.normalTextRes(R.string.sala02Button2);
                }
                if(i == 2){
                    builder.normalTextRes(R.string.sala02Button3);
                }
            }
            if(destino.equals("Sala - 03")){
                temaSala.setText(R.string.temaSala03);
                if(i == 0){
                    builder.normalTextRes(R.string.sala03Button1);
                }
                if(i == 1){
                    builder.normalTextRes(R.string.sala03Button2);
                }
                if(i == 2){
                    builder.normalTextRes(R.string.sala03Button3);
                }
            }
            if(destino.equals("Sala - 04")){
                temaSala.setText(R.string.temaSala04);
                if(i == 0){
                    builder.normalText("Sem eventos!");
                }
                if(i == 1){
                    builder.normalText("Sem eventos!");
                }
                if(i == 2){
                    builder.normalText("Sem eventos!");
                }
            }
            if(destino.equals("Sala - 05")){
                temaSala.setText(R.string.temaSala05);
                if(i == 0){
                    builder.normalTextRes(R.string.sala05Button1);
                }
                if(i == 1){
                    builder.normalTextRes(R.string.sala05Button2);
                }
                if(i == 2){
                    builder.normalTextRes(R.string.sala05Button3);
                }
            }
            if(destino.equals("Sala - 06")){
                temaSala.setText(R.string.temaSala06);
                if(i == 0){
                    builder.normalTextRes(R.string.sala06Button1);
                }
                if(i == 1){
                    builder.normalTextRes(R.string.sala06Button2);
                }
                if(i == 2){
                    builder.normalTextRes(R.string.sala06Button3);
                }
            }
            if(destino.equals("Sala - 07")){
                temaSala.setText(R.string.temaSala07);
                if(i == 0){
                    builder.normalTextRes(R.string.sala07Button1);
                }
                if(i == 1){
                    builder.normalTextRes(R.string.sala07Button2);
                }
                if(i == 2){
                    builder.normalTextRes(R.string.sala07Button3);
                }
            }
            if(destino.equals("Sala - 09")){
                temaSala.setText(R.string.temaSala09);
                if(i == 0){
                    builder.normalTextRes(R.string.sala09Button1);
                }
                if(i == 1){
                    builder.normalTextRes(R.string.sala09Button2);
                }
                if(i == 2){
                    builder.normalTextRes(R.string.sala09Button3);
                }
            }
            if(destino.equals("Sala - 10")){
                temaSala.setText(R.string.temaSala10);
                if(i == 0){
                    builder.normalTextRes(R.string.sala10Button1);
                }
                if(i == 1){
                    builder.normalTextRes(R.string.sala10Button2);
                }
                if(i == 2){
                    builder.normalTextRes(R.string.sala10Button3);
                }
            }
            if(destino.equals("Sala - 11")){
                temaSala.setText(R.string.temaSala11);
                if(i == 0){
                    builder.normalTextRes(R.string.sala11Button1);
                }
                if(i == 1){
                    builder.normalTextRes(R.string.sala11Button2);
                }
                if(i == 2){
                    builder.normalTextRes(R.string.sala11Button3);
                }
            }
            if(destino.equals("Sala - 12")){
                temaSala.setText(R.string.temaSala12);
                if(i == 0){
                    builder.normalTextRes(R.string.sala12Button1);
                }
                if(i == 1){
                    builder.normalTextRes(R.string.sala12Button2);
                }
                if(i == 2){
                    builder.normalTextRes(R.string.sala12Button3);
                }
            }
            if(destino.equals("Quadra")){
                temaSala.setText(R.string.temaQuadra);
                if(i == 0){
                    builder.normalTextRes(R.string.quadraAbetura);
                }
                if(i == 1){
                    builder.normalTextRes(R.string.quadraDanca);
                }
                if(i == 2){
                    builder.normalTextRes(R.string.quadraMusica);
                }
            }

            bmb1.addBuilder(builder);
        }
    }

    public void setDadosTrajeto(String destino){
        this.destino = destino;
    }

    private void criarTrajeto(String positionDestino){

        GifImageView gifImageView = findViewById(R.id.imageViewMapa);

        if(positionDestino.equals("Biblioteca")){
            gifImageView.setImageResource(R.drawable.biblioteca);
            //setFrames(R.drawable.sala_6_sem_alerta, R.drawable.sala_6_com_alerta);
        }
        if(positionDestino.equals("Auditório")){
            gifImageView.setImageResource(R.drawable.auditorio);
            //setFrames(R.drawable.sala_6_sem_alerta, R.drawable.sala_6_com_alerta);
        }
        if(positionDestino.equals("Sala - 01")){
            gifImageView.setImageResource(R.drawable.sala_01);
            //setFrames(R.drawable.sala_6_sem_alerta, R.drawable.sala_6_com_alerta);
        }
        if(positionDestino.equals("Sala - 02")){
            gifImageView.setImageResource(R.drawable.sala_02);
            //setFrames(R.drawable.sala_6_sem_alerta, R.drawable.sala_6_com_alerta);
        }
        if(positionDestino.equals("Sala - 03")){
            gifImageView.setImageResource(R.drawable.sala_03);
            //setFrames(R.drawable.sala_6_sem_alerta, R.drawable.sala_6_com_alerta);
        }
        if(positionDestino.equals("Sala - 04")){
            gifImageView.setImageResource(R.drawable.sala_04);
            new SaidaDeTexto().showAlert(this, "Atenção","Esta sala não possui eventos!", R.drawable.alerte);
            //setFrames(R.drawable.sala_6_sem_alerta, R.drawable.sala_6_com_alerta);
        }
        if(positionDestino.equals("Sala - 05")){
            gifImageView.setImageResource(R.drawable.sala_05);
            //setFrames(R.drawable.sala_6_sem_alerta, R.drawable.sala_6_com_alerta);
        }
        if(positionDestino.equals("Sala - 06")){
            gifImageView.setImageResource(R.drawable.sala_06);
            //setFrames(R.drawable.sala_6_sem_alerta, R.drawable.sala_6_com_alerta);
        }
        if(positionDestino.equals("Sala - 07")){
            gifImageView.setImageResource(R.drawable.sala_07);
            //setFrames(R.drawable.sala_6_sem_alerta, R.drawable.sala_6_com_alerta);
        }
        if(positionDestino.equals("Sala - 09")){
            gifImageView.setImageResource(R.drawable.sala_09);
            //setFrames(R.drawable.sala_6_sem_alerta, R.drawable.sala_6_com_alerta);
        }
        if(positionDestino.equals("Sala - 10")){
            gifImageView.setImageResource(R.drawable.sala_10);
            //setFrames(R.drawable.sala_6_sem_alerta, R.drawable.sala_6_com_alerta);
        }
        if(positionDestino.equals("Sala - 11")){
            gifImageView.setImageResource(R.drawable.sala_11);
            //setFrames(R.drawable.sala_6_sem_alerta, R.drawable.sala_6_com_alerta);
        }
        if(positionDestino.equals("Sala - 12")){
            gifImageView.setImageResource(R.drawable.sala_12);
            //setFrames(R.drawable.sala_6_sem_alerta, R.drawable.sala_6_com_alerta);
        }
        if(positionDestino.equals("Quadra")){
            gifImageView.setImageResource(R.drawable.quadra);
        }

        PhotoViewAttacher attacher = new PhotoViewAttacher(gifImageView); // API pra zoom

    }
    /*
    private boolean controle = true;

    private void setFrames(final int frame1, final int frame2){

        final GifImageView gifImageView = findViewById(R.id.imageViewMapa);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if(controle){
                    gifImageView.setImageResource(frame1);
                    controle = false;
                }else{
                    gifImageView.setImageResource(frame2);
                    controle = true;
                }
                setFrames(frame1, frame2); // loop
            }
        };
        //PhotoViewAttacher attacher = new PhotoViewAttacher(gifImageView);
        new Handler().postDelayed(runnable, 400);
    }
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(getApplicationContext(), LocalizacaoActivity.class));
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(getApplicationContext(), LocalizacaoActivity.class));
        finishAffinity();
    }

}
