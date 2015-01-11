package io.delr3ves.sunshine.app.ui;

import android.app.Activity;
import android.os.Bundle;
import io.delr3ves.sunshine.app.R;
import io.delr3ves.sunshine.app.ui.fragment.SettingsFragment;

public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new SettingsFragment())
                    .commit();
        }
    }
}
