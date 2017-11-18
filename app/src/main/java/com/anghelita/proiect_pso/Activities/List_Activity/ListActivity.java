package com.anghelita.proiect_pso.Activities.List_Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.anghelita.proiect_pso.R;

public class ListActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListContent.listOfItems.add(new ListContentItem("Pula", "07pizda"));
        ListContent.listOfItems.add(new ListContentItem("P1la", "07puta"));
        ListContent.listOfItems.add(new ListContentItem("Cyka", "07noidoi"));
        ListContent.listOfItems.add(new ListContentItem("Ruski", "0mlyyyaa"));
        ListView listView = findViewById(R.id.qqmor);

    }
}
