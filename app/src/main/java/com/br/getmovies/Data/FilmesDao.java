package com.br.getmovies.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;

public class FilmesDao {

    private SQLiteDatabase db;
    private dbHelper banco;


    public FilmesDao(Context context){
        banco = new dbHelper(context);
    }

    public String save( Movie movie ){

        ContentValues valores;
        long resultado;
        db = banco.getWritableDatabase();

        try{
            valores = new ContentValues();
            valores.put( banco.TITLE, movie.getTitle().toString() );
            valores.put( banco.ID_MOVIE, movie.getId().toString() );
            valores.put( banco.RATE, movie.getVote_average().toString() );
            valores.put( banco.POP, movie.getPopularity().toString() );
            valores.put( banco.POSTER, movie.getPoster_path().toString() );
            resultado = db.insert( banco.TABELA,null, valores );
            System.out.printf("resultado insert: " + resultado);
            db.close();
            if ( resultado != -1 ) {
                return "Filme incluído ="+ movie.getTitle();
            }
        } catch ( SQLException e ) {
            Log.e( "ERRO - ", e.getMessage() );
        }
        return "Filme já cadastrado!";
    }

    public ArrayList<Movie> list() {
        ArrayList<Movie> lista = new ArrayList<>();
        Cursor cursor;
        String[] campos = { dbHelper.ID_MOVIE, dbHelper.TITLE, dbHelper.ID_MOVIE,dbHelper.RATE, dbHelper.POP, dbHelper.POSTER};
        db = banco.getReadableDatabase();
        cursor = db.query( dbHelper.TABELA, campos,null,null,null,null,null );
        if ( cursor.moveToFirst()  ) {
            do {
                String id = cursor.getString(0) ;
                String title = cursor.getString(1) ;
                String rate = cursor.getString(3) ;
                String id_movie = cursor.getString(2);
                String pop = cursor.getString(4);
                String poster = cursor.getString(5);
                Movie movie = new Movie(id, title, rate, id_movie, pop, poster);
                lista.add( movie );
            } while ( cursor.moveToNext());
            return lista;
        }
        return null;
    }
}


