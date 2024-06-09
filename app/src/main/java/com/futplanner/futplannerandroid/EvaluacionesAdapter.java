package com.futplanner.futplannerandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.futplanner.futplannerandroid.models.Match;
import com.futplanner.futplannerandroid.models.Player;
import com.futplanner.futplannerandroid.models.Team;

import java.util.List;

public class EvaluacionesAdapter extends ArrayAdapter<Player> {
    public EvaluacionesAdapter(Context context, List<Player> players) {
        super(context, 0, players);
    }
    @NonNull //Para evitar que este vacia la lista
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Player player = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_match, parent, false);
        }

        TextView playerName = convertView.findViewById(R.id.teamName);
        TextView playerLastName = convertView.findViewById(R.id.matchDate);

        assert player != null;
        playerName.setText(player.getFirstName());
        playerLastName.setText(player.getLastName());

        return convertView;
    }
}
