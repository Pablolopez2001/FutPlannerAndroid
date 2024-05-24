package com.futplanner.futplannerandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.futplanner.futplannerandroid.models.Match;

import java.util.List;

public class MatchAdapter extends ArrayAdapter<Match> {

    public MatchAdapter(Context context, List<Match> matches) {
        super(context, 0, matches);
    }

    @NonNull //Para evitar que este vacia la lista
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Match match = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_match, parent, false);
        }

        TextView homeTeamName = convertView.findViewById(R.id.homeTeamName);
        TextView awayTeamName = convertView.findViewById(R.id.awayTeamName);

        assert match != null;
        homeTeamName.setText(match.getHomeTeamName());
        awayTeamName.setText(match.getAwayTeamName());

        return convertView;
    }
}