package com.example.usjtads3anmcabusca_fila_resultado;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetalhesChamadoActivity extends AppCompatActivity {
    private TextView nomeFilaTextView;
    private TextView descricaoChamadoTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_chamado);
        nomeFilaTextView = findViewById(R.id.nomeFilaTextView);
        descricaoChamadoTextView = findViewById(R.id.descricaoChamadoTextView);
        Intent origemIntent= getIntent();
        String chamadoSelecionado = origemIntent.getStringExtra("chamado_selecionado");
        String [] partes = chamadoSelecionado.split(":");
        String nomeFila = partes[0];
        String descricaoChamado = partes[1];
        nomeFilaTextView.setText(nomeFila);
        descricaoChamadoTextView.setText(descricaoChamado);
    }
}
