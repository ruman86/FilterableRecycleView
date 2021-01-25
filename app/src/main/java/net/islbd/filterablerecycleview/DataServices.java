package net.islbd.filterablerecycleview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DataServices {
    @GET("MedicineSearch")
    Call<MedicineData> getAllMedicine();

    @GET("medicineDetailsSearch")
    Call<GroupDataModel> getMedicineDetails(@Query("grpid") int grpid);

    @GET("kotha/api/getContent.php")
    Call<List<ContentModel>> getAllContent(@Query("tipscat") String tipscat);
}


