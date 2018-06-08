
package com.pokemon.spritedex.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Stat implements Parcelable
{

    @SerializedName("stat")
    @Expose
    private Stat_ stat;
    @SerializedName("effort")
    @Expose
    private int effort;
    @SerializedName("base_stat")
    @Expose
    private int baseStat;
    public final static Parcelable.Creator<Stat> CREATOR = new Creator<Stat>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Stat createFromParcel(Parcel in) {
            Stat instance = new Stat();
            instance.stat = ((Stat_) in.readValue((Stat_.class.getClassLoader())));
            instance.effort = ((int) in.readValue((int.class.getClassLoader())));
            instance.baseStat = ((int) in.readValue((int.class.getClassLoader())));
            return instance;
        }

        public Stat[] newArray(int size) {
            return (new Stat[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The stat
     */
    public Stat_ getStat() {
        return stat;
    }

    /**
     * 
     * @param stat
     *     The stat
     */
    public void setStat(Stat_ stat) {
        this.stat = stat;
    }

    /**
     * 
     * @return
     *     The effort
     */
    public int getEffort() {
        return effort;
    }

    /**
     * 
     * @param effort
     *     The effort
     */
    public void setEffort(int effort) {
        this.effort = effort;
    }

    /**
     * 
     * @return
     *     The baseStat
     */
    public int getBaseStat() {
        return baseStat;
    }

    /**
     * 
     * @param baseStat
     *     The base_stat
     */
    public void setBaseStat(int baseStat) {
        this.baseStat = baseStat;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(stat);
        dest.writeValue(effort);
        dest.writeValue(baseStat);
    }

    public int describeContents() {
        return  0;
    }

}
