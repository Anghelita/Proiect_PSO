package com.anghelita.proiect_pso.Activities.List_Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.anghelita.proiect_pso.Entity.Item;
import com.anghelita.proiect_pso.R;
import com.anghelita.proiect_pso.Repository.BackgroundTask;
import com.anghelita.proiect_pso.Repository.MyLambda;
import com.anghelita.proiect_pso.Repository.URL_Stuff;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class ListActivity extends AppCompatActivity{


    private List<Item> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {
            super.onCreate(savedInstanceState);
            BackgroundTask backgroundTask = new BackgroundTask(this);
            MyLambda getList = () -> URL_Stuff.getList(this);
            backgroundTask.execute(getList);
            String s = backgroundTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        list = URL_Stuff.list;

        setContentView(R.layout.activity_list);

        ListView listView = findViewById(R.id.listView);

        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);

    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customlayout, null);

            TextView Title = view.findViewById(R.id.textView_Title);
            TextView Comment = view.findViewById(R.id.textView_Commnet);
            TextView Professor = view.findViewById(R.id.textView_Professor);

            Title.setText(list.get(i).getName());
            Comment.setText(list.get(i).getDate());
            Professor.setText(list.get(i).getProfessorFirstName() + " " + list.get(i).getProfessorLastName());
            return view;
        }
    }

}
