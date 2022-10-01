package edu.utec.tareasemana4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {

    private final TextView txtNombre;
    private final TextView txtApellido;
    private final TextView txtRol;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        txtNombre = itemView.findViewById(R.id.txtNombre);
        txtApellido = itemView.findViewById(R.id.txtApellido);
        txtRol = itemView.findViewById(R.id.txtRol);
    }

    public void bind(String nombre, String apellido, String rol) {
        txtNombre.setText(nombre);
        txtApellido.setText(apellido);
        txtRol.setText(rol);
    }

    static UserViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }
}
