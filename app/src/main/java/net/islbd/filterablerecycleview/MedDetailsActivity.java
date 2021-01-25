package net.islbd.filterablerecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MedDetailsActivity extends AppCompatActivity {

    GroupDataModel groupDataModel;
    TextView medicineName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_details);
        medicineName = findViewById(R.id.tvMedicineName);

        int groupId = 1; //getIntent().getStringExtra("groupid");

        Toast.makeText(this, groupId+"", Toast.LENGTH_LONG).show();

        Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();
        DataServices services = retrofit.create(DataServices.class);
        Call<GroupDataModel> medicineDataList = services.getMedicineDetails(groupId);
        medicineDataList.enqueue(new Callback<GroupDataModel>() {
            @Override
            public void onResponse(Call<GroupDataModel> call, Response<GroupDataModel> response) {
                if (response.isSuccessful()) {
                    groupDataModel = response.body();
                    medicineName.setText(groupDataModel.getMedicinedata().getGroupName());
                    /*recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                    adapter = new CustomAdapter(medicineDatum);

                    recyclerView.setAdapter(adapter);*/
                   // Toast.makeText(MainActivity.this, "Data Found", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<GroupDataModel> call, Throwable t) {
                Log.d("Data", "not Found");
            }
        });
    }
}
