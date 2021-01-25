package net.islbd.filterablerecycleview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class ContentModel {

        @SerializedName("cid")
        @Expose
        private String cid;
        @SerializedName("cat_name")
        @Expose
        private String catName;
        @SerializedName("cat_id")
        @Expose
        private String catId;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("decontent")
        @Expose
        private String decontent;

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getCatName() {
            return catName;
        }

        public void setCatName(String catName) {
            this.catName = catName;
        }

        public String getCatId() {
            return catId;
        }

        public void setCatId(String catId) {
            this.catId = catId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDecontent() {
            return decontent;
        }

        public void setDecontent(String decontent) {
            this.decontent = decontent;
        }

    }

