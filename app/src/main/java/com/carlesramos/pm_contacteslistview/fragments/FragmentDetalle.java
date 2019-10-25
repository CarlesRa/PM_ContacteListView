package com.carlesramos.pm_contacteslistview.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.carlesramos.pm_contacteslistview.R;
import com.carlesramos.pm_contacteslistview.modelo.Contacte;

public class FragmentDetalle extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detalle,container,false);
    }


    public void mostrarDetalle(Contacte c){

        TextView tvNOmbre = getView().findViewById(R.id.tvNombre);
        TextView tvApellido = getView().findViewById(R.id.tvApellido);
        TextView tvDireccion = getView().findViewById(R.id.tvDireccion);
        TextView tvEmpresa = getView().findViewById(R.id.tvEmpresa);
        TextView tvFecha = getView().findViewById(R.id.tvFechaNac);
        TextView tvTelefono1 = getView().findViewById(R.id.tvTelefono1);
        TextView tvTelefono2 = getView().findViewById(R.id.tvTelefono2);
        TextView tvEmail = getView().findViewById(R.id.tvEmail);

        tvNOmbre.setText(c.getNombre());
        tvApellido.setText(c.getApellido1() + " " +c.getApellido2());
        tvDireccion.setText(c.getDireccion());
        tvEmpresa.setText(c.getEmpresa());
        tvFecha.setText(c.getFechaNac());
        tvTelefono1.setText(c.getTelefono1());
        tvTelefono2.setText(c.getTelefono2());
        tvEmail.setText(c.getEmail());
    }

}
