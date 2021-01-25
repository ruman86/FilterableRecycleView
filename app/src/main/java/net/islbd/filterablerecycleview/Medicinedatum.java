package net.islbd.filterablerecycleview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Medicinedatum {
    @SerializedName("med_id")
    @Expose
    private String medId;
    @SerializedName("brand_name")
    @Expose
    private String brandName;
    @SerializedName("company_name")
    @Expose
    private String companyName;
    @SerializedName("med_power")
    @Expose
    private String medPower;
    @SerializedName("size_price")
    @Expose
    private String sizePrice;
    @SerializedName("group_id")
    @Expose
    private String groupId;

    public String getMedId() {
        return medId;
    }

    public void setMedId(String medId) {
        this.medId = medId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMedPower() {
        return medPower;
    }

    public void setMedPower(String medPower) {
        this.medPower = medPower;
    }

    public String getSizePrice() {
        return sizePrice;
    }

    public void setSizePrice(String sizePrice) {
        this.sizePrice = sizePrice;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

}
