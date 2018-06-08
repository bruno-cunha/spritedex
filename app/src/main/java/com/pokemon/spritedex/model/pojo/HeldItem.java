
package com.pokemon.spritedex.model.pojo;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HeldItem implements Parcelable
{

    @SerializedName("item")
    @Expose
    private Item item;
    @SerializedName("version_details")
    @Expose
    private List<VersionDetail> versionDetails = new ArrayList<VersionDetail>();
    public final static Parcelable.Creator<HeldItem> CREATOR = new Creator<HeldItem>() {


        @SuppressWarnings({
            "unchecked"
        })
        public HeldItem createFromParcel(Parcel in) {
            HeldItem instance = new HeldItem();
            instance.item = ((Item) in.readValue((Item.class.getClassLoader())));
            in.readList(instance.versionDetails, (VersionDetail.class.getClassLoader()));
            return instance;
        }

        public HeldItem[] newArray(int size) {
            return (new HeldItem[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The item
     */
    public Item getItem() {
        return item;
    }

    /**
     * 
     * @param item
     *     The item
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * 
     * @return
     *     The versionDetails
     */
    public List<VersionDetail> getVersionDetails() {
        return versionDetails;
    }

    /**
     * 
     * @param versionDetails
     *     The version_details
     */
    public void setVersionDetails(List<VersionDetail> versionDetails) {
        this.versionDetails = versionDetails;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(item);
        dest.writeList(versionDetails);
    }

    public int describeContents() {
        return  0;
    }

}
