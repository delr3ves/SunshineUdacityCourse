package io.delr3ves.sunshine.app.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import io.delr3ves.sunshine.app.R;

/**
 * @author Sergio Arroyo - @delr3ves
 */
public class ForecastDetailFragment extends Fragment {

    public ForecastDetailFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_forecast_detail, container, false);
        return rootView;
    }
}
