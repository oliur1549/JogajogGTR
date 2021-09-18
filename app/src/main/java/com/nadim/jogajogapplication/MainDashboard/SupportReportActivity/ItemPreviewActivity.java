package com.nadim.jogajogapplication.MainDashboard.SupportReportActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.nadim.jogajogapplication.R;

public class ItemPreviewActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    /*ItemsModel itemsModel;*/
    ItemNewModel itemsModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_preview);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        Intent intent = getIntent();
        if(intent.getExtras() != null){
            itemsModel = (ItemNewModel) intent.getSerializableExtra("items");
            /*imageView.setImageResource(itemsModel.getImages());*/
            textView.setText(itemsModel.getName());
        }
    }
}