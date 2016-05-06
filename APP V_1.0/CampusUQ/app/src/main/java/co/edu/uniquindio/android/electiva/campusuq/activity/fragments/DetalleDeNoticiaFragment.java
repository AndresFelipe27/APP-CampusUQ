package co.edu.uniquindio.android.electiva.campusuq.activity.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import co.edu.uniquindio.android.electiva.campusuq.R;
import co.edu.uniquindio.android.electiva.campusuq.activity.vo.Noticia;

/**
 * Universidad del Quindio
 * @author Julian Alberto cardona
 * @author Jhon Fredy Bedoya
 * @author Willian David Meza
 * @since  2015-04-24
 *
 * Actividad que implementa el detalle de peliculas de tipo fragmento
 */
public class DetalleDeNoticiaFragment extends Fragment {

    private TextView titulo;

    private Noticia noticia;



    public DetalleDeNoticiaFragment() {
        // Required empty public constructor
    }

    /**
     * Metodo que nos permite asociar el fragmento con un layout
     * @param inflater, el layout para inflar el fragmento
     * @param container, es la vista padre que contiene el fragmento.
     * @param savedInstanceState, bundle que nos permite guar estados.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_de_noticia, container, false);
    }
    /**
     * Metodo que nos permite ver los detaller de una pelicula
     * @param noticia, la pelicula que se requiere ver los detalles
     */
    public void showDetail(Noticia noticia) {
        this.noticia= noticia;
        noticia.getTitulo();
        titulo = (TextView) getView().findViewById(R.id.titulo_de_detalle_pelicula);
        titulo.setText(noticia.getTitulo());
    }



}
