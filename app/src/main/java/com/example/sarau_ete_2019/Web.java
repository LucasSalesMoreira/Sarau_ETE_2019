package com.example.sarau_ete_2019;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class Web extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão adicional da TooBar
        getSupportActionBar().setHomeButtonEnabled(true); //Tornando o botão adicional da TooBar clicável


        buscarURL();
    }

    private void buscarURL(){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try{
                    WebView webView = (WebView) findViewById(R.id.web);
                    WebSettings settings = webView.getSettings();
                    settings.setJavaScriptEnabled(true);
                    String url = "https://sarauetemb2019.000webhostapp.com/indexmobile.html";
                    webView.loadUrl(url);
                }catch(Exception error){
                    exibirErro(error.getMessage());
                }
            }
        };
        new Handler().postDelayed(runnable, 500);
    }

    private void exibirErro(String e){
        Toast.makeText(getApplicationContext(), "Verifique sua conexao!\nError: "+e, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onBackPressed(){ //Botão BACK padrão do android
        startActivity(new Intent(getApplicationContext(), HomenageadoActivity.class));
        finishAffinity();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(getApplicationContext(), HomenageadoActivity.class));
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:
                break;
        }
        return true;
    }

}
