package com.example.usjtads3anmcabusca_fila_resultado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ChamadoArrayAdapter extends ArrayAdapter<Chamado> {
    public ChamadoArrayAdapter (Context context, List<Chamado> chamados){
        super (context, -1, chamados);
    }
    @Override
    public View getView(int position,View convertView, ViewGroup
            parent) {
        Chamado chamadoDaVez = getItem(position);
        Fila filaDaVez = chamadoDaVez.getFila();
        LayoutInflater inflater = LayoutInflater.from(getContext());
        if (convertView == null){
            convertView = inflater.inflate(R.layout.list_item, parent,
                    false);
        }
        ImageView filaIconImageView =
                convertView.findViewById(R.id.filaIconImageView);
        TextView descricaoChamadoNaFilaTextView = convertView.findViewById(R.id.descricaoChamadoNaFilaTextView);
        TextView statusChamadoNaFilaTextView =

                convertView.findViewById(R.id.statusChamadoNaFilaTextView);
        TextView dataAberturaChamadoNaFilaTextView =

                convertView.findViewById(R.id.dataAberturaChamadoNaFilaTextView);
        TextView dataFechamentoChamadoNaFilaTextView = convertView.findViewById(R.id.dataFechamentoChamadoNaFilaTextView);
        filaIconImageView.setImageResource(filaDaVez.getIconId());

        descricaoChamadoNaFilaTextView.setText(chamadoDaVez.getDescricao());
        statusChamadoNaFilaTextView.setText(chamadoDaVez.getStatus());

        dataAberturaChamadoNaFilaTextView.setText(DateHelper.format(chamadoDaVez.getDataAbertura()));
        if (chamadoDaVez.getDataFechamento() != null){

            dataFechamentoChamadoNaFilaTextView.setText(DateHelper.format(chamadoDaVez.getDataFechamento()));
        }
        return convertView;
    }
}
