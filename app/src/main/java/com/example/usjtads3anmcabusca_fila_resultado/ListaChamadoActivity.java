package com.example.usjtads3anmcabusca_fila_resultado;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListaChamadoActivity extends AppCompatActivity {
    public static final String DESCRICAO =
            "br.usjt.deswebmob.servicedesk.descricao";
    ArrayList<String> lista;

    private ListView chamadosListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_chamado);
        chamadosListView = findViewById(R.id.chamadosListView);
        Intent origemIntent = getIntent();
        String nomeFila = origemIntent.getStringExtra("nome_fila");
        final List<Chamado> chamados = busca(nomeFila);
        ChamadoArrayAdapter adapter =
                new ChamadoArrayAdapter(this, chamados);
        chamadosListView.setAdapter(adapter);
        chamadosListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Chamado chamadoSelecionado = chamados.get(position);
                Intent intent = new Intent(ListaChamadoActivity.this, DetalhesChamadoActivity.class);
                intent.putExtra("chamado_selecionado", chamadoSelecionado);
                startActivity(intent);
            }
        });
    }

    public List<Chamado> busca (String nomeFila){
        List <Chamado> chamados = geraListaChamados();
        if (nomeFila == null || nomeFila.length() == 0)
            return chamados;
        List <Chamado> resultado = new ArrayList<>();
        for (Chamado chamado : chamados){
            if (chamado.getFila().getNome().
                    toLowerCase().contains(nomeFila.toLowerCase())){
                resultado.add(chamado);
            }
        }
        return resultado;
    }

    public List <Chamado> geraListaChamados(){
        List <Chamado> chamados = new ArrayList<>();
        chamados.add(new Chamado (
                new Fila ("Desktops",
                        R.drawable.ic_computer_black_24dp),
                "Computador da secretária quebrado.",
                new Date(),
                null,
                "Aberto"
        ));
        chamados.add(new Chamado (
                new Fila ("Telefonia",
                        R.drawable.ic_phone_in_talk_black_24dp),
                "Telefone não funciona.",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Redes",
                        R.drawable.ic_network_check_black_24dp),
                "Manutenção no proxy.",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Servidores", R.drawable.ic_poll_black_24dp),
                "Lentidão generalizada.",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Novos Projetos",
                        R.drawable.ic_new_releases_black_24dp),
                "CRM",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Novos Projetos",
                        R.drawable.ic_new_releases_black_24dp),
                "Gestão de Orçamento",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Redes",
                        R.drawable.ic_network_check_black_24dp),
                "Internet com lentidão",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Novos Projetos",
                        R.drawable.ic_new_releases_black_24dp),
                "Chatbot",
                new Date(),
                null,
                "Aberto")
        );
        chamados.add(new Chamado (
                new Fila ("Novos Projetos",
                        R.drawable.ic_new_releases_black_24dp),
                "Chatbot",
                new Date(),
                null,
                "Aberto")
        );
        return chamados;
    }
}
