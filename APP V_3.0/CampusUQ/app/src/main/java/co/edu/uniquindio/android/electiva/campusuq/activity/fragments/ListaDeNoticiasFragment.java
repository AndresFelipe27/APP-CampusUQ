/**
 * Este paquete contiene el fragmento ListaDeNoticiasFragment
 */
package co.edu.uniquindio.android.electiva.campusuq.activity.fragments;

/**
 * Importaciones para cargar los paquetes, clases y librerias necesarias para la clase.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import co.edu.uniquindio.android.electiva.campusuq.R;
import co.edu.uniquindio.android.electiva.campusuq.activity.activity.NoticiasActualesActivity;
import co.edu.uniquindio.android.electiva.campusuq.activity.util.AdaptadorDeNoticia;
import co.edu.uniquindio.android.electiva.campusuq.activity.util.Utilidades;
import co.edu.uniquindio.android.electiva.campusuq.activity.vo.Noticia;

import java.util.ArrayList;

/**
 * Universidad del Quindio(Armenia - Quindio) Ingenieria de Sistemas y Computacion
 * Desarrollo de aplicaciones para dispositivos Moviles - Electiva Profesional III
 *
 * @author Andres Felipe Perdomo Forero - Juan Jose Perdomo Forero
 * @version 06/05/2016
 * Clase ListaDeNoticiasFragment que representa la logica del fragmento con la lista
 * de noticias a mostrar
 */

/**
 * A simple {@link Fragment} subclass.
 */

public class ListaDeNoticiasFragment extends Fragment implements AdaptadorDeNoticia.OnClickAdaptadorDeNoticia{


    /**
     * Atributo listadoDenoticias que representa un RecyclerView "contenedor de elementos en forma de lista"
     */
    private RecyclerView listadoDeNoticias ;

    /**
     * Atributo peliculas que representa la lista de noticias
     */
    private ArrayList<Noticia> noticias;

    /**
     * Atributo adaptador que representa el adaptador usado para agregar la información en el RecyclerView
     */
    private AdaptadorDeNoticia adaptador;

    /**
     * Atributo para escuchar cuando se selecciona una pelicula
     */
    private OnPeliculaSeleccionadaListener listener;

    /**
     * Metodo constructor del fragmento
     */
    public ListaDeNoticiasFragment() {
        // Required empty public constructor
    }
    /**
     * Metodo que permite obtener las noticiass de la lista
     * @return las noticias del arraylist
     */
    public ArrayList<Noticia> getPeliculas() {
        return noticias;
    }

    /**
     * Metodo que permite modificar las noticias de la lista
     * @param noticias, arraylist de noticias a introducir en la lista
     */
    public void setPeliculas(ArrayList<Noticia> noticias) {
        this.noticias = noticias;
    }

    /**
     * Metodo que nos permite realizar las inicializaciones de los componentes de la actividad
     * @param savedInstanceState, objeto de tipo Bundle que nos permite compartir datos entre activiades
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Metodo que nos permite la inicializacion de los elementos que van a ser agregados al reciclerView
     * @param savedInstanceState, objeto de tipo Bundle que nos permite compartir datos entre activiades
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        noticias = new ArrayList();
        noticias.add(new Noticia("Interestelar", "2015"));
        noticias.add(new Noticia("El Padrino", "2015"));
        noticias.add(new Noticia("Regreso al futuro", "2015"));
        noticias.add(new Noticia("Titanic", "2014"));
        noticias.add(new Noticia("Star Wars", "2014"));
        noticias.add(new Noticia("El bueno, el malo y el feo", "2014"));
        noticias.add(new Noticia("La Pantera Rosa", "2015"));
        noticias.add(new Noticia("Interestelar", "2015"));
        noticias.add(new Noticia("El Padrino", "2015"));
        noticias.add(new Noticia("Regreso al futuro", "2015"));
        noticias.add(new Noticia("Titanic", "2014"));
        noticias.add(new Noticia("Star Wars", "2014"));
        noticias.add(new Noticia("El bueno, el malo y el feo", "2014"));
        noticias.add(new Noticia("La Pantera Rosa", "2015"));
        listadoDeNoticias= (RecyclerView) getView().findViewById(R.id.RecView);

        adaptador = new AdaptadorDeNoticia(noticias,this);

        listadoDeNoticias.setAdapter(adaptador);
        listadoDeNoticias.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }

    /**
     * Metodo que nos permite asociar el fragmento con un layout
     * @param inflater, el layout para inflar el fragmento
     * @param container, es la vista padre que contiene el fragmento.
     * @param savedInstanceState, bundle que nos permite guar estados.
     * @return el fragmento inflado con el layout
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_de_noticias, container, false);
    }
    /**
     * Metodo que nos permite asociar el fragmento a una actividad
     * @param context, el contexto del fragmento
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity;

        if(context instanceof Activity){
            activity = (Activity) context;

            try {
                listener= (OnPeliculaSeleccionadaListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " debe implementar la interfaz OnPeliculaSeleccionadaListener");
            }
        }

    }

    /**
     * Metodo utlizado para identificar la noticia seleccionada
     * @param pos, la posicion presionada
     */
    @Override
    public void onClickPosition(int pos) {
        listener.onPeliculaSeleccionada(pos);
    }

    /**
     * Metodo utlizado para identificar la pelicula seleccionada
     */

    public interface OnPeliculaSeleccionadaListener {
        void onPeliculaSeleccionada(int position);
    }

}
