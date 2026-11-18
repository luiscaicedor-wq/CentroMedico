package com.nestorsalinas.centromedico;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CitaAdapter extends RecyclerView.Adapter<CitaAdapter.CitaViewHolder> {

    private final List<String> listaCitas;

    public CitaAdapter(List<String> listaCitas) {
        this.listaCitas = listaCitas;
    }

    @NonNull
    @Override
    public CitaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cita, parent, false);
        return new CitaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CitaViewHolder holder, int position) {
        String info = listaCitas.get(position);
        holder.tvDia.setText(position == 0 ? "10" : "12");
        holder.tvMes.setText("SET");
        holder.tvPacienteDoctor.setText(info);
        holder.tvSedeEspecialidad.setText("Sede Central • Cardiología");
        holder.tvHorario.setText(position == 0 ? "10:00 AM - 11:00 AM" : "02:00 PM - 03:00 PM");

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), DetalleConsulta.class);
            intent.putExtra("datos_medico", "Detalle de Consulta Médica:\nPaciente / Cita: " + info + "\nEspecialidad: Cardiología\nEstado: Pendiente / En Curso");
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listaCitas != null ? listaCitas.size() : 0;
    }

    static class CitaViewHolder extends RecyclerView.ViewHolder {
        TextView tvDia, tvMes, tvPacienteDoctor, tvSedeEspecialidad, tvHorario;

        public CitaViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDia = itemView.findViewById(R.id.tvDiaCita);
            tvMes = itemView.findViewById(R.id.tvMesCita);
            tvPacienteDoctor = itemView.findViewById(R.id.tvPacienteDoctorCita);
            tvSedeEspecialidad = itemView.findViewById(R.id.tvSedeEspecialidadCita);
            tvHorario = itemView.findViewById(R.id.tvHorarioCita);
        }
    }
}