package net.islbd.filterablerecycleview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MedicineData {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("medicinedata")
    @Expose
    private List<Medicinedatum> medicinedata = null;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Medicinedatum> getMedicinedata() {
        return medicinedata;
    }

    public void setMedicinedata(List<Medicinedatum> medicinedata) {
        this.medicinedata = medicinedata;
    }

}

