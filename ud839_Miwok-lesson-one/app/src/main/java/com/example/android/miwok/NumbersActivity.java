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
package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        //String[] words = new String[10];
        //ArrayList<String> words = new ArrayList<String>();
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("One","Lutti"));
        words.add(new Word("Two","Lutti"));
        words.add(new Word("three","Lutti"));
        words.add(new Word("Four","Lutti"));
        words.add(new Word("Five","Lutti"));
        words.add(new Word("Six","Lutti"));
        words.add(new Word("Seven","Lutti"));
        words.add(new Word("Eight","Lutti"));
        words.add(new Word("Nine","Lutti"));
        words.add(new Word("Ten","Lutti"));
        words.add(new Word("Eleven","Lutti"));
        words.add(new Word("Twelve","Lutti"));
        words.add(new Word("Thirteen","Lutti"));
        words.add(new Word("Fourteen","Lutti"));
        words.add(new Word("Fiveteen","Lutti"));
        words.add(new Word("Sixteen","Lutti"));
        /*words.add("Two");
        words.add("three");
        words.add("Four");
        words.add("Five");
        words.add("Six");
        words.add("Seven");
        words.add("Eight");
        words.add("Nive");
        words.add("Ten");
        words.add("Eleven");
        words.add("Twelve");
        words.add("Thirteen");
        words.add("Fourteen");
        words.add("Fiveteen");
        words.add("Sixteen");
        words.add("Seventeen");
        words.add("Eighteen");
        words.add("Nineteen");
        words.add("Twenty");*/
        /*
        int n = 0;
        while (n < words.size()) {
            Log.v("NumbersActivity", "Word at index " + n + ": " + words.get(n));
            n++;
        }
        LinearLayout rootView = (LinearLayout) findViewById(R.id.rootView);

        for(int index = 0; index < words.size(); index++) {
            TextView wordView = new TextView(this);
            wordView.setText(words.get(index));
            rootView.addView(wordView);
        }*/
        WordAdapter adapter = new WordAdapter(this,words);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        //GridView gridView = (GridView) findViewById(R.id.gridview);
        //gridView.setAdapter(itemsAdapter);
    }
}
