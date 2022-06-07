package com.example.kursach;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity {

    private ChatViewModel chatViewModel;
    private final CompositeDisposable viewSubscriptions = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i  = getIntent();
        if ( i != null )
        {
            String name = ((Room)i.getParcelableExtra("room")).getRoomName();
            Toast.makeText(this,"Вы вошли в комнату " + name, Toast.LENGTH_LONG).show();
        }

        ChatApplication chatApplication = (ChatApplication) getApplication();
        chatApplication.onCreate();
        ChatModel chatModel = chatApplication.getChatModel();

        chatViewModel = new ChatViewModel(chatModel.getChatMessages());
        chatViewModel.subscribe();

        ListView listView = findViewById(R.id.list_view);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(arrayAdapter);

        viewSubscriptions.add(chatViewModel.getMessageList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> {
                    arrayAdapter.clear();
                    arrayAdapter.addAll(list);
                }));

        EditText editText = findViewById(R.id.edit_text);
        findViewById(R.id.send_button)
                .setOnClickListener(event ->
                    chatModel.sendMessage(editText.getText().toString()));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        chatViewModel.unsubscribe();
        viewSubscriptions.clear();
    }
}
