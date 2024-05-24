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

        TextView teamName = convertView.findViewById(R.id.teamName);
        TextView matchDate = convertView.findViewById(R.id.matchDate);

        assert match != null;
        teamName.setText(String.format("%s-%s", match.getHomeTeamName(), match.getAwayTeamName()));
        matchDate.setText(match.getMatchDate().toLocalDate().toString());

        return convertView;
    }
}