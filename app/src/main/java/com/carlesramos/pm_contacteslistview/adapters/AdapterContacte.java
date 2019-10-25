package com.carlesramos.pm_contacteslistview.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.carlesramos.pm_contacteslistview.R;
import com.carlesramos.pm_contacteslistview.modelo.Contacte;

public class AdapterContacte extends ArrayAdapter<Contacte> {
    private Contacte[] contactes;
    public AdapterContacte(@NonNull Context context, @NonNull Contacte[] objects) {
        super(context, R.layout.fragment_listado, objects);
        contactes = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item = convertView;
        ViewHolder holder;
        if (item == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(R.layout.listitem_contactos, null);
            holder = new ViewHolder();
            holder.tvNombreList = item.findViewById(R.id.tvNombreList);
            holder.tvTelefonoList = item.findViewById(R.id.tvTelefonoList);
            item.setTag(holder);
        }
        else{
            holder = (ViewHolder) item.getTag();
        }
        holder.tvNombreList.setText(contactes[position].getNombre());
        holder.tvTelefonoList.setText(contactes[position].getTelefono1());
        return item;
    }
    static class ViewHolder{
        TextView tvNombreList;
        TextView tvTelefonoList;
    }
}
