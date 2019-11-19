package com.br.getmovies.Data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.br.getmovies.R;
import java.util.List;


public class FilmesAdapter extends ArrayAdapter{
    public FilmesAdapter(Context context, List<Movie> objetcts) {
        super(context, 0, objetcts);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;

        if(listItemView==null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_list_favoritos, parent, false);
        }

        Movie current = (Movie) getItem(position);
        TextView title =  (TextView) listItemView.findViewById(R.id.txtTitle);
        TextView id =  (TextView) listItemView.findViewById(R.id.txtId);
        TextView rate =  (TextView) listItemView.findViewById(R.id.txtRate);
        TextView pop = (TextView) listItemView.findViewById(R.id.txtPop) ;
        title.setText( current.getTitle().toString() );
        id.setText( current.getId().toString() );
        rate.setText( current.getVote_average().toString() );
        //pop.setText(current.getPopularity().toString());
        return  listItemView;
    }

}
