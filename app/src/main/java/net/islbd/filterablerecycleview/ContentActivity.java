package net.islbd.filterablerecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ContentActivity extends AppCompatActivity {

    List<ContentModel> contentModelList;
    RecyclerView recyclerView;
    ContentCustomAdapter contentCustomAdapter;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        context = getApplicationContext();

        Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();
        DataServices services = retrofit.create(DataServices.class);

        Call<List<ContentModel>> getAllContent = services.getAllContent("101,102,103,104");
        getAllContent.enqueue(new Callback<List<ContentModel>>() {
            @Override
            public void onResponse(Call<List<ContentModel>> call, Response<List<ContentModel>> response) {
                if (response.isSuccessful()) {
                    contentModelList = response.body();

                    recyclerView = (RecyclerView) findViewById(R.id.contentListRov);

                    recyclerView.setLayoutManager(new LinearLayoutManager(ContentActivity.this));
                    ContentCustomAdapter contentCustomAdapter = new ContentCustomAdapter(contentModelList, context);
                    recyclerView.setAdapter(contentCustomAdapter);
                }
            }
            @Override
            public void onFailure(Call<List<ContentModel>> call, Throwable t) {

            }
        });

    }
}