package io.delr3ves.sunshine.app.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import io.delr3ves.sunshine.app.R;
import io.delr3ves.sunshine.app.model.DailyWeatherInfo;
import io.delr3ves.sunshine.app.task.FetchWeatherTask;
import io.delr3ves.sunshine.app.ui.ForecastDetailActivity;
import io.delr3ves.sunshine.app.ui.adapter.ForecastInformationListAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class ForecastFragment extends Fragment {

    private ArrayAdapter<DailyWeatherInfo> mForecastAdapter;

    public ForecastFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.forecastfragment, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_fetch_weather) {
            fetchWeather();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initializeForecastAdapter();
        ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
        listView.setAdapter(mForecastAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DailyWeatherInfo forecast = (DailyWeatherInfo) parent.getItemAtPosition(position);
                Intent showDetailIntent = new Intent(getActivity(), ForecastDetailActivity.class);
                showDetailIntent.putExtra(ForecastDetailFragment.FORECAST_INFORMATION, forecast);
                startActivity(showDetailIntent);
            }
        });
        fetchWeather();
        return rootView;
    }

    private void initializeForecastAdapter() {
        mForecastAdapter = new ForecastInformationListAdapter(getActivity(), R.layout.list_item_forecast,
                R.id.list_item_forecast_textview);
    }

    private void fetchWeather() {
        FetchWeatherTask fetchWeatherTask = new FetchWeatherTask(mForecastAdapter);
        fetchWeatherTask.execute("Madrid");
    }
}