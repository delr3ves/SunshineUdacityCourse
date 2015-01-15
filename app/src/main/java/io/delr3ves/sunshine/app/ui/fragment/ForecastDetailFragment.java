package io.delr3ves.sunshine.app.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import io.delr3ves.sunshine.app.R;
import io.delr3ves.sunshine.app.model.DailyWeatherInfo;

/**
 * @author Sergio Arroyo - @delr3ves
 */
public class ForecastDetailFragment extends Fragment {

    public static final String FORECAST_INFORMATION = "forecastInformation";

    public ForecastDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle extras = getActivity().getIntent().getExtras();
        DailyWeatherInfo forecastInformation = (DailyWeatherInfo) extras.get(FORECAST_INFORMATION);
        View rootView = inflater.inflate(R.layout.fragment_forecast_detail, container, false);
        ((TextView)rootView.findViewById(R.id.day)).setText(forecastInformation.getDay());
        ((TextView)rootView.findViewById(R.id.date)).setText(forecastInformation.getDate());

        ((TextView)rootView.findViewById(R.id.maximum)).setText(forecastInformation.getTemp().getMax() + "º");
        ((TextView)rootView.findViewById(R.id.minimum)).setText(forecastInformation.getTemp().getMin() + "º");

        return rootView;
    }
}
