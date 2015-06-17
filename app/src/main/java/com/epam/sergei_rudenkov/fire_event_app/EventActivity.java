package com.epam.sergei_rudenkov.fire_event_app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.krux.androidsdk.aggregator.KruxEventAggregator;


public class EventActivity extends Activity {

    private final String publisherConfigId = "IEl6lNSy";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Context context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        //trigger of pub request
        final TextView textResult = (TextView) findViewById(R.id.result);
        Button triggerPubRequest = (Button) findViewById(R.id.pub_button);
        triggerPubRequest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                KruxEventAggregator.initialize(context, publisherConfigId, true);
                PublisherAdRequest publisherAdRequest = KruxEventAggregator.getPublisherAdRequestWithKruxSegments();
                textResult.setText("Publisher Ad Request Triggered \n" +
                        "Location: " + publisherAdRequest.getLocation() + "\n" +
                        "Gender: " + publisherAdRequest.getGender() + "\n" +
                        "Keywords: " + publisherAdRequest.getKeywords());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
