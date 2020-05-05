package com.example.sarau_ete_2019;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LocalizacaoActivity extends AppCompatActivity {

    //private Spinner spinner1, spinner2;
    private Spinner spinner2;
    //private int position1 = 0, position2 = 0;
    private int position2;
    private ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizacao);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão adicional da TooBar
        getSupportActionBar().setHomeButtonEnabled(true); //Tornando o botão adicional da TooBar clicável

        //spinner1 = (Spinner) findViewById(R.id.spinner_local_atual);
        spinner2 = (Spinner) findViewById(R.id.spinner_destino);

        /*spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position1 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });*/

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position2 = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        loadAll();
    }

    private String getDateSystem(){
        String formato_pt_br = "dd/MM/yyyy";
        String textDate = new SimpleDateFormat(formato_pt_br).format(new Date());
        return textDate;
    }
    private String getHourSystem(){
        String formato_pt_br = "HH:mm:ss";
        String hour = new SimpleDateFormat(formato_pt_br).format(new Date());
        return hour;
    }

    public void buscar(View v){
        if(adapter.getItem(position2).toString().equals("Quadra") && getDateSystem().equals("12/09/2019")){
            new MapaActivity().setDadosTrajeto(adapter.getItem(position2).toString());
            startActivity(new Intent(getApplicationContext(), MapaActivity.class));
            finishAffinity();
        }else if(adapter.getItem(position2).toString().equals("Quadra") && !getDateSystem().equals("12/09/2019")) {
            new SaidaDeTexto().showAlert(this, "Desculpe", "Esta programação encontra-se indisponível no momento! Escolha outro destino!", R.drawable.emoji_triste);

        }else if(!adapter.getItem(position2).toString().equals("Quadra")){
            if(adapter.getItem(position2).toString().equals("Sala - 04")){
                new SaidaDeTexto().showAlert(this, "Atenção","Esta sala não possui eventos!", R.drawable.alerte);
            }else{
                new MapaActivity().setDadosTrajeto(adapter.getItem(position2).toString());
                startActivity(new Intent(getApplicationContext(), MapaActivity.class));
                finishAffinity();
            }
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finishAffinity();
    }

    private void loadAll(){
        //loadSpinner1();
        loadSpinner2();
    }
    /*
    private void loadSpinner1(){
        spinner1.setAdapter(createAdapters());
    }*/

    private void loadSpinner2(){
        spinner2.setAdapter(createAdapters());
    }

    private ArrayAdapter createAdapters(){
        adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.lugares, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        return adapter;
    }
}
