package com.project.motivation.Settings;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.project.motivation.R;

/**
 * Created by onuchin on 29.11.2016.
 */

public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
