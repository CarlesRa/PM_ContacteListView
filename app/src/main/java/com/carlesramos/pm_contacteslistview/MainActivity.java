package com.carlesramos.pm_contacteslistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.carlesramos.pm_contacteslistview.fragments.FragmentDetalle;
import com.carlesramos.pm_contacteslistview.fragments.FragmentListado;
import com.carlesramos.pm_contacteslistview.interficies.IContacteListener;
import com.carlesramos.pm_contacteslistview.modelo.Contacte;

public class MainActivity extends AppCompatActivity implements IContacteListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentListado frgListado = (FragmentListado)getSupportFragmentManager().findFragmentById(R.id.frgListado);
        frgListado.setContactesListener(this);
    }

    @Override
    public void onContacteSeleccionado(Contacte c) {
        boolean hayDetalle = (getSupportFragmentManager().findFragmentById(R.id.frgDetalle)) != null;
        if (hayDetalle){
            ((FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.frgDetalle)).mostrarDetalle(c);
        }
        else{
            Intent i = new Intent(this, DetalleActivity.class);
            i.putExtra(DetalleActivity.EXTRATEXTO,c);
            startActivity(i);
        }
    }
}
