package com.anghelita.proiect_pso.Activities.List_Activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.anghelita.proiect_pso.Entity.Item;
import com.anghelita.proiect_pso.Entity.User;
import com.anghelita.proiect_pso.R;
import com.anghelita.proiect_pso.Repository.BackgroundTask;
import com.anghelita.proiect_pso.Repository.MyLambda;
import com.anghelita.proiect_pso.Repository.URL_Stuff;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ListActivity extends Activity {

    Context ctx;
    private List<Item> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ctx = this;
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

        @SuppressLint({"SetTextI18n", "ViewHolder", "InflateParams"})
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customlayout, null);

            TextView Title = view.findViewById(R.id.textView_Title);
            TextView Comment = view.findViewById(R.id.textView_Commnet);
            TextView Professor = view.findViewById(R.id.textView_Professor);

            Title.setText(list.get(i).getName());
            Comment.setText(list.get(i).getDate());
            Professor.setText(list.get(i).getProfessorFirstName() + " " + list.get(i).getProfessorLastName());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    String state = Environment.getExternalStorageState();
                    if (Environment.MEDIA_MOUNTED.equals(state)) {

                        File Root = Environment.getExternalStorageDirectory();
                        File Dir = new File(Root.getAbsolutePath());

                        if (!Dir.exists()) {
                            Dir.mkdir();
                        }

                        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), list.get(i).getName());
                        try {
                            file.createNewFile();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            BackgroundTask backgroundTask = new BackgroundTask(ctx);

                            User.setIDDownload(list.get(i).getID());
                            MyLambda login = () -> URL_Stuff.download(ctx);
                            backgroundTask.execute(login);

                            String s = backgroundTask.get();
                            Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();

                            String content = URL_Stuff.download;

                            fileOutputStream.write(content.getBytes());
                            fileOutputStream.close();


                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

            return view;
        }
    }

}
