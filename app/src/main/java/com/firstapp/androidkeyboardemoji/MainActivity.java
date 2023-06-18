package com.firstapp.androidkeyboardemoji;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.vanniktech.emoji.EmojiPopup;
import com.vanniktech.emoji.EmojiTextView;

public class MainActivity extends AppCompatActivity {

    ImageView emojiBtn, sendBtn;
    EditText editText;
    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emojiBtn = findViewById(R.id.emoji_Id);
        sendBtn = findViewById(R.id.send_Id);
        editText = findViewById(R.id.edit_emoji);
        layout = findViewById(R.id.Linear_Layout);

        EmojiPopup popup = EmojiPopup.Builder.fromRootView(
                findViewById(R.id.root_view)
        ).build(editText);

        emojiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popup.toggle();
            }
        });

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EmojiTextView emojiTextView = (EmojiTextView) LayoutInflater
                        .from(view.getContext())
                        .inflate(R.layout.emoji_text_view,layout,false);
                emojiTextView.setText(editText.getText().toString());

                layout.addView(emojiTextView);

                editText.getText().clear();
            }
        });

    }
}