package net.islbd.filterablerecycleview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MedicineGroupdata {

    @SerializedName("groupid")
    @Expose
    private String groupid;
    @SerializedName("group_name")
    @Expose
    private String groupName;
    @SerializedName("indication")
    @Expose
    private String indication;
    @SerializedName("dosage")
    @Expose
    private String dosage;
    @SerializedName("side_effect")
    @Expose
    private String sideEffect;
    @SerializedName("pregnancy_lactation")
    @Expose
    private String pregnancyLactation;

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getSideEffect() {
        return sideEffect;
    }

    public void setSideEffect(String sideEffect) {
        this.sideEffect = sideEffect;
    }

    public String getPregnancyLactation() {
        return pregnancyLactation;
    }

    public void setPregnancyLactation(String pregnancyLactation) {
        this.pregnancyLactation = pregnancyLactation;
    }

}
