package co.edu.uniquindio.android.electiva.campusuq.activity.util;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import co.edu.uniquindio.android.electiva.campusuq.activity.fragments.ListaDeNoticiasFragment;
import co.edu.uniquindio.android.electiva.campusuq.activity.vo.Noticia;
import co.edu.uniquindio.android.electiva.campusuq.R;

/**
 * Created by Usuario on 05/05/2016.
 */
public class AdaptadorDeNoticia extends RecyclerView.Adapter<AdaptadorDeNoticia.NoticiaViewHolder> {

    private ArrayList<Noticia> noticias;

    private static OnClickAdaptadorDeNoticia listener;
    /**
     * Metodo contructor de la clase adaptadorPelicula
     * @param noticias, el arreglo de peliculas a mostrar
     * @param listaDeNoticiasFragment, los fagmentos de las peliculas
     */
    public AdaptadorDeNoticia(ArrayList<Noticia>noticias, ListaDeNoticiasFragment listaDeNoticiasFragment) {
        this.noticias= noticias;
        listener= (OnClickAdaptadorDeNoticia) listaDeNoticiasFragment;
    }
    /**
     * Metodo que permite crear una vista de tipo pelicula para el reciclerView
     * @param parent, El ViewGroup en la que se añadirá la nueva vista
     * @param viewType, El tipo de vista de la nueva vista.
     */
    @Override
    public NoticiaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.resumen_de_noticia, parent, false);
        NoticiaViewHolder noticiaVH = new NoticiaViewHolder(itemView);
        return noticiaVH;
    }
    /**
     * Metodo que visualizar los datos en la posicion especifica
     * @param holder, la vista a ser visualizada
     * @param position, la posicion de la vista.
     */
    @Override
    public void onBindViewHolder(NoticiaViewHolder holder, int position) {
        Noticia pelicula = noticias.get(position);
        holder.binPelicual(pelicula);

    }
    /**
     * Metodo que permite contar los elemmentos de la lista
     * @return el tamaño de la lista
     */
    @Override
    public int getItemCount() {
        return noticias.size();
    }

    public static class NoticiaViewHolder
            extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txtTitulo;

        /**
         * Metodo contructor de la vista de tipo pelicula
         * @param itemView, el item de la lista
         */
        public NoticiaViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            txtTitulo = (TextView) itemView.findViewById(R.id.titulo);


        }
        /**
         * Metodo que permite modificar los atributos de la pelicula
         * @param p, la pelicula
         */
        public void binPelicual(Noticia p) {
            txtTitulo.setText(p.getTitulo());

        }
        /**
         * Metodo que permite identificar el item de la vista presionado
         * @param v, la vista del evento
         */
        @Override
        public void onClick(View v) {
            listener.onClickPosition(getAdapterPosition());
            Log.d("TAG", "Element " + getAdapterPosition() + " clicked. " + txtTitulo.getText());

        }
    }

    public interface OnClickAdaptadorDeNoticia{
        public void onClickPosition(int pos);
    }



}
