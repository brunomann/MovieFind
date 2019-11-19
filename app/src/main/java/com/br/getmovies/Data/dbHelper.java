package com.br.getmovies.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.br.getmovies.R;

public class dbHelper extends SQLiteOpenHelper{

    public static final String NOME_BANCO ="AppMovie.db";
    public static final String TABELA ="Movies";
    public static final String ID ="_id";
    public static final String TITLE ="title";
    public static final String ID_MOVIE ="id_movie";
    public static final String RATE ="rate";
    public static final String POP ="pop";
    public static final String POSTER ="poster_path";
    public static final int VERSAO =1;

    public dbHelper( Context context ){
        super( context,NOME_BANCO,null, VERSAO );
    }

    @Override
    public void onCreate( SQLiteDatabase db ) {
        String sqlVersao1 = "CREATE TABLE " + TABELA + " (" +
                //ID + " INTEGER PRIMARY KEY," +
                ID_MOVIE + " TEXT PRIMARY KEY, " +
                TITLE + " TEXT NOT NULL, " +
                POP + " TEXT , " +
                POSTER + " TEXT , " +
                RATE + " TEXT )";
        db.execSQL( sqlVersao1 );
    }

    @Override
    public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion ) {
        db.execSQL( "Drop table if exists "+ TABELA );
        onCreate( db );
    }


}
