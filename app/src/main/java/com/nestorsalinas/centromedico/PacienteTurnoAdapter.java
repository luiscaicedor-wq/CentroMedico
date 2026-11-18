package com.nestorsalinas.centromedico;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PacienteTurnoAdapter extends RecyclerView.Adapter<PacienteTurnoAdapter.ViewHolder> {

    private final List<String> pacientes;

    public PacienteTurnoAdapter(List<String> pacientes) {
        this.pacientes = pacientes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_paciente_turno, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String paciente = pacientes.get(position);
        holder.tvNombre.setText(paciente);

        if (holder.btnAccion != null) {
            holder.btnAccion.setOnClickListener(v -> {
                Intent intent = new Intent(v.getContext(), SignosVitalesActivity.class);
                intent.putExtra("nombre_paciente", paciente);
                v.getContext().startActivity(intent);
            });
        }
    }

    @Override
    public int getItemCount() {
        return pacientes != null ? pacientes.size() : 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombre;
        Button btnAccion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombrePacienteTurno);
            btnAccion = itemView.findViewById(R.id.btnAccionTurno);
        }
    }
}