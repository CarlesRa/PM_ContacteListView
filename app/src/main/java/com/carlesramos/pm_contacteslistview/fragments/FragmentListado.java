package com.carlesramos.pm_contacteslistview.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.carlesramos.pm_contacteslistview.R;
import com.carlesramos.pm_contacteslistview.adapters.AdapterContacte;
import com.carlesramos.pm_contacteslistview.interficies.IContacteListener;
import com.carlesramos.pm_contacteslistview.modelo.Contacte;
import com.carlesramos.pm_contacteslistview.parsers.ParserContacte;

public class FragmentListado extends Fragment {

    private IContacteListener listener;
    private ListView lvListado;
    private Contacte[] contactes;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_listado,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lvListado = getView().findViewById(R.id.lstListado);
        ParserContacte parser = new ParserContacte(getActivity());
        parser.parse();
        contactes = parser.getContactes();
        lvListado.setAdapter(new AdapterContacte(getActivity(),contactes));
        lvListado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onContacteSeleccionado((Contacte) lvListado.getAdapter().getItem(position));
            }
        });

    }

    public void setContactesListener(IContacteListener listener){

        this.listener = listener;
    }

    public ListView getLvListado() {
        return lvListado;
    }

    public Contacte[] getContactes() {
        return contactes;
    }
}
