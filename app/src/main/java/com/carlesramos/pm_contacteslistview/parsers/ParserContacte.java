package com.carlesramos.pm_contacteslistview.parsers;

import android.content.Context;
import android.util.JsonToken;

import com.carlesramos.pm_contacteslistview.R;
import com.carlesramos.pm_contacteslistview.modelo.Contacte;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;

public class ParserContacte {
    private Contacte[]contactes;
    private byte[] buffer;
    private InputStream contactesInput;
    private String json;

    public ParserContacte(Context context) {
        contactesInput = context.getResources().openRawResource(R.raw.contacts);
    }

    public boolean parse(){
        boolean parsed = false;
        try {
            buffer = new byte[contactesInput.available()];
            contactesInput.read(buffer);
            json = new String(buffer,"UTF-8");
            JSONTokener tokener = new JSONTokener(json);
            JSONArray jsonArray = new JSONArray(tokener);
            contactes = new Contacte[jsonArray.length()];

            for (int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String nombre = jsonObject.getString("name");
                String apellido1 = jsonObject.getString("firstSurname");
                String apellido2 = jsonObject.getString("secondSurname");
                String direccion = jsonObject.getString("address");
                String compañia = jsonObject.getString("company");
                String fechaNac = jsonObject.getString("birth");
                String telefono1 = jsonObject.getString("phone1");
                String telefono2 = jsonObject.getString("phone2");
                String email = jsonObject.getString("email");
                contactes[i] = new Contacte(id,nombre,apellido1,apellido2,direccion,compañia,fechaNac,telefono1,telefono2,email);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return parsed;
    }

    public Contacte[]getContactes(){
        return contactes;
    }
}
