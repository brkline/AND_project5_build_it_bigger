package app.brkline.androiddisplayjokelib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayJokeActivity extends AppCompatActivity {

    public static final String EXTRA_JOKE_DATA = "extra_joke_data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        String joke = getIntent().getStringExtra(EXTRA_JOKE_DATA);
        TextView displayJokeTextView = findViewById(R.id.display_joke_tv);
        displayJokeTextView.setText(joke);
    }
}