package io.delr3ves.sunshine.app.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import io.delr3ves.sunshine.app.R;
import io.delr3ves.sunshine.app.model.DailyWeatherInfo;

/**
 * @author Sergio Arroyo - @delr3ves
 */
public class ForecastInformationListAdapter extends ArrayAdapter<DailyWeatherInfo> {

    public ForecastInformationListAdapter(Context context, int resource, int textViewResourceId) {
        super(context, resource, textViewResourceId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = vi.inflate(R.layout.list_item_forecast, null);
        }
        DailyWeatherInfo weatherInfo = getItem(position);
        ((TextView) view).setText(weatherInfo.toString());
        return view;
    }
}
