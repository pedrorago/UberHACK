package com.uber.uberhack.view.word;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.uber.uberhack.R;
import com.uber.uberhack.service.SpeechRecognitionService;

public class RecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        final BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                // Caso chegue, redirecionar para resultado
                startActivity(new Intent(RecordActivity.this, WordFinishActivity.class));
                finish();
            }
        };

        // Registrar broacast caso chegue algum resultado
        IntentFilter filter = new IntentFilter();
        filter.addAction("TIRARFOTO");
        registerReceiver(receiver, filter);
        startService(new Intent(this, SpeechRecognitionService.class));
    }
}
