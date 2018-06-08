
package com.pokemon.spritedex.model.pojo;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VersionDetail implements Parcelable
{

    @SerializedName("version")
    @Expose
    private Version version;
    @SerializedName("rarity")
    @Expose
    private int rarity;
    public final static Parcelable.Creator<VersionDetail> CREATOR = new Creator<VersionDetail>() {


        @SuppressWarnings({
            "unchecked"
        })
        public VersionDetail createFromParcel(Parcel in) {
            VersionDetail instance = new VersionDetail();
            instance.version = ((Version) in.readValue((Version.class.getClassLoader())));
            instance.rarity = ((int) in.readValue((int.class.getClassLoader())));
            return instance;
        }

        public VersionDetail[] newArray(int size) {
            return (new VersionDetail[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The version
     */
    public Version getVersion() {
        return version;
    }

    /**
     * 
     * @param version
     *     The version
     */
    public void setVersion(Version version) {
        this.version = version;
    }

    /**
     * 
     * @return
     *     The rarity
     */
    public int getRarity() {
        return rarity;
    }

    /**
     * 
     * @param rarity
     *     The rarity
     */
    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(version);
        dest.writeValue(rarity);
    }

    public int describeContents() {
        return  0;
    }

}
