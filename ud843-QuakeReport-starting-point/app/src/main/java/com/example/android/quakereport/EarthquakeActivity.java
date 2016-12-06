/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        ArrayList<Earthquake> earthquakes = new ArrayList<>();
        earthquakes.add(new Earthquake("7.2","San Francisco","02/12/16"));
        earthquakes.add(new Earthquake("4.7","London","03/12/16"));
        earthquakes.add(new Earthquake("5.5","Tokyo","01/12/16"));
        earthquakes.add(new Earthquake("8.1","Mexico City","28/11/16"));
        earthquakes.add(new Earthquake("6.8","Moswcow","02/12/16"));
        earthquakes.add(new Earthquake("2.2","Rio de Janeiro","20/11/16"));
        earthquakes.add(new Earthquake("3.9","Paris","02/12/16"));

        EarthquakeAdapter adapter = new EarthquakeAdapter(this,earthquakes);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

    }
}