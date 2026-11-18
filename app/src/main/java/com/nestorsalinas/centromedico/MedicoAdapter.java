package com.nestorsalinas.centromedico;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MedicoAdapter extends RecyclerView.Adapter<MedicoAdapter.MedicoViewHolder> {

    private List<Medico> listaMedicos;

    public MedicoAdapter(List<Medico> listaMedicos) {
        this.listaMedicos = listaMedicos;
    }

    @NonNull
    @Override
    public MedicoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_personal, parent, false);
        return new MedicoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MedicoViewHolder holder, int position) {
        Medico m = listaMedicos.get(position);
        if (m != null) {
            String ini = (m.nombres != null && !m.nombres.isEmpty()) ? String.valueOf(m.nombres.charAt(0)) : "M";
            holder.tvAvatar.setText(ini);
            holder.tvNombre.setText(m.nombres + " " + m.apellidos);
            holder.tvCargo.setText("Médico - " + m.getEspecialidad());
            holder.tvCodigo.setText(m.getNumeroColegiado());
        }
    }

    @Override
    public int getItemCount() {
        return listaMedicos != null ? listaMedicos.size() : 0;
    }

    static class MedicoViewHolder extends RecyclerView.ViewHolder {
        TextView tvAvatar, tvNombre, tvCargo, tvCodigo;

        public MedicoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAvatar = itemView.findViewById(R.id.tvAvatar);
            tvNombre = itemView.findViewById(R.id.tvNombrePersonal);
            tvCargo = itemView.findViewById(R.id.tvCargoPersonal);
            tvCodigo = itemView.findViewById(R.id.tvCodigoPersonal);
        }
    }
}