package com.futplanner.futplannerandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.futplanner.futplannerandroid.models.Player;
import com.futplanner.futplannerandroid.models.Report;

import java.util.List;

public class ReportesAdapter extends ArrayAdapter<Report> {
    public ReportesAdapter(Context context, List<Report> reports) {
        super(context, 0, reports);
    }
    @NonNull //Para evitar que este vacia la lista
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Report report = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_match, parent, false);
        }

        TextView playerName = convertView.findViewById(R.id.teamName);
        TextView playerLastName = convertView.findViewById(R.id.matchDate);

        assert report != null;
        playerName.setText(report.getGeneralPerformance());
        playerLastName.setText(report.getTacticalPerformance());

        return convertView;
    }
}
