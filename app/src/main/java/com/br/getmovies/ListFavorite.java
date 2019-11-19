package com.br.getmovies;

import android.content.Context;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.content.Intent;

import java.util.ArrayList;

import com.br.getmovies.Data.FilmesAdapter;
import com.br.getmovies.Data.FilmesDao;
import com.br.getmovies.Data.Movie;

public class ListFavorite extends AppCompatActivity {
    public FilmesAdapter adapter;
    ArrayList<Movie> listaFilmes;
    Context context;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        getSupportActionBar().hide(); //esconde actionBar com nome do projeto

        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_list_favorite );

        listaFilmes = new ArrayList<>();

        final FilmesDao filmesDao = new FilmesDao( getApplicationContext() );
        listaFilmes = filmesDao.list();

        adapter = new FilmesAdapter( this, listaFilmes );
        ListView list = findViewById( R.id.listaFilmes);
        list.setAdapter( adapter );

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int po, long l) {
                context = view.getContext();
                Intent i = new Intent(view.getContext(), MoviesDetailActivity.class);
                Movie movie = listaFilmes.get(po);
                i.putExtra("movie", movie);
                context.startActivity(i);

            }
        });
    }

}
