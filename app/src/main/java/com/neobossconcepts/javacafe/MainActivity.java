package com.neobossconcepts.javacafe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    CardView startersCard;
    CardView mainCard;
    CardView dessertCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        startersCard = findViewById(R.id.card_view_starters);
        mainCard = findViewById(R.id.card_view_main);
        dessertCard = findViewById(R.id.card_view_dessert);



        startersCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startersActivityIntent = new Intent(MainActivity.this, StarterActivity.class);
                startActivity(startersActivityIntent);
            }
        });
        mainCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainCoursesActivityIntent = new Intent(MainActivity.this, MainCoursesActivity.class);
                startActivity(mainCoursesActivityIntent);
            }
        });
        dessertCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dessertActivityIntent = new Intent(MainActivity.this, DessertActivity.class);
                startActivity(dessertActivityIntent);
            }
        });


        TextView emailAddressTextView = findViewById(R.id.text_view_email_address);
        emailAddressTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:davythedeveloper@neoboss.com"));
                startActivity(emailIntent);

            }
        });
    }


}