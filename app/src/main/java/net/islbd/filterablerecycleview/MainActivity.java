package net.islbd.filterablerecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    EditText editTextSearch;
    ArrayList<String> names;
    List<Medicinedatum> medicineDatum;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();
        DataServices services = retrofit.create(DataServices.class);
        Call<MedicineData> medicineDataList = services.getAllMedicine();
        editTextSearch = (EditText) findViewById(R.id.editTextSearch);
        medicineDataList.enqueue(new Callback<MedicineData>() {
            @Override
            public void onResponse(Call<MedicineData> call, Response<MedicineData> response) {
                if (response.isSuccessful()) {
                    medicineDatum = response.body().getMedicinedata();
                    recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                    adapter = new CustomAdapter(medicineDatum);

                    recyclerView.setAdapter(adapter);
                    Toast.makeText(MainActivity.this, "Data Found", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<MedicineData> call, Throwable t) {
                Log.d("Data", "not Found");
            }
        });
       editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                filter(editable.toString());
            }
        });

    }

    private void filter(String text) {
        //ArrayList<MedicineData> filteredList = new ArrayList<>();
        List<Medicinedatum> medicineDatumList = new ArrayList<>();

        for (Medicinedatum item : medicineDatum) {
            if (item.getBrandName().toLowerCase().contains(text.toLowerCase())) {
                medicineDatumList.add(item);
            }
        }

        adapter.filterList(medicineDatumList);
    }
}
