package com.carlesramos.pm_contacteslistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.carlesramos.pm_contacteslistview.fragments.FragmentDetalle;
import com.carlesramos.pm_contacteslistview.modelo.Contacte;

public class DetalleActivity extends AppCompatActivity {
    public static final String EXTRATEXTO = "com.carlesramoscontacte";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        FragmentDetalle frgDetalle = (FragmentDetalle)getSupportFragmentManager().findFragmentById(R.id.frgDetalle);
        frgDetalle.mostrarDetalle((Contacte)getIntent().getSerializableExtra(EXTRATEXTO));
    }
}
