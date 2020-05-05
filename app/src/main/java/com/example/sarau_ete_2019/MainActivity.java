package com.example.sarau_ete_2019;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomMenuButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    BoomMenuButton bmb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        criarBoomMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            finishAffinity();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void criarBoomMenu(){
        bmb = (BoomMenuButton) findViewById(R.id.bmb);
        int cor[] = sortearCor();

        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            HamButton.Builder builder = new HamButton.Builder();
            builder.textSize(20);

            if(i == 0){
                builder.normalText("Localize-se");
                builder.subNormalText("Encontre-se em nosso colégio.");
                builder.normalColorRes(cor[i]);
                builder.normalImageRes(R.drawable.mapa);
            }

            if(i == 1){
                builder.normalText("Programação");
                builder.subNormalText("Saiba tudo que vai rolar.");
                builder.normalColorRes(cor[i]);
                builder.normalImageRes(R.drawable.atracao);
            }

            if(i == 2){
                builder.normalText("Homenageado");
                builder.subNormalText("Conheça o homenageado desse ano.");
                builder.normalColorRes(cor[i]);
                builder.normalImageRes(R.drawable.music_icon);
            }

            if(i == 3){
                builder.normalText("Sobre");
                builder.subNormalText("Um pouco sobre esse App.");
                builder.normalColorRes(cor[i]);
                builder.normalImageRes(R.drawable.sobre);
            }

            builder.listener(new OnBMClickListener() {
                @Override
                public void onBoomButtonClick(int index) {
                    // When the boom-button corresponding this builder is clicked.
                    if(index == 0) {
                        executeLocalizacao();
                    }

                    if(index == 1){
                        executeEventos();
                    }

                    if(index == 2){
                        executeHomenageado();
                    }

                    if(index == 3){
                        executeSobre();
                    }
                }
            });
            bmb.addBuilder(builder);
        }
    }

    private int[] sortearCor(){

        int sorte = new Random().nextInt(4);

        int vetorColor1[]={R.color.colorButton1, R.color.colorButton2, R.color.colorButton3, R.color.colorButton4};
        int vetorColor2[]={R.color.colorButton4, R.color.colorButton3, R.color.colorButton2, R.color.colorButton1};
        int vetorColor3[]={R.color.colorButton2, R.color.colorButton4, R.color.colorButton3, R.color.colorButton1};
        int vetorColor4[]={R.color.colorButton3, R.color.colorButton4, R.color.colorButton2, R.color.colorButton1};

        if(sorte == 0){
            return vetorColor1;
        }else if(sorte == 1){
            return vetorColor2;
        }else if(sorte == 2){
            return vetorColor3;
        }else if(sorte == 3){
            return vetorColor4;
        }else{
            return null;
        }

    }

    private void executeLocalizacao(){
        startActivity(new Intent(getApplicationContext(), LocalizacaoActivity.class));
        finishAffinity();
    }

    private void executeHomenageado(){
        startActivity(new Intent(getApplicationContext(), HomenageadoActivity.class));
        finishAffinity();
    }

    private void executeEventos(){
        startActivity(new Intent(getApplicationContext(), EventosActivity.class));
        finishAffinity();
    }

    private void executeSobre(){
        startActivity(new Intent(getApplicationContext(), SobreActivity.class));
        finishAffinity();
    }
}
