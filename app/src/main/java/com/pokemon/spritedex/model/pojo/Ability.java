
package com.pokemon.spritedex.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Ability implements Parcelable
{

    @SerializedName("slot")
    @Expose
    private int slot;
    @SerializedName("is_hidden")
    @Expose
    private boolean isHidden;
    @SerializedName("ability")
    @Expose
    private Ability_ ability;
    public final static Parcelable.Creator<Ability> CREATOR = new Creator<Ability>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Ability createFromParcel(Parcel in) {
            Ability instance = new Ability();
            instance.slot = ((int) in.readValue((int.class.getClassLoader())));
            instance.isHidden = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.ability = ((Ability_) in.readValue((Ability_.class.getClassLoader())));
            return instance;
        }

        public Ability[] newArray(int size) {
            return (new Ability[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The slot
     */
    public int getSlot() {
        return slot;
    }

    /**
     * 
     * @param slot
     *     The slot
     */
    public void setSlot(int slot) {
        this.slot = slot;
    }

    /**
     * 
     * @return
     *     The isHidden
     */
    public boolean isIsHidden() {
        return isHidden;
    }

    /**
     * 
     * @param isHidden
     *     The is_hidden
     */
    public void setIsHidden(boolean isHidden) {
        this.isHidden = isHidden;
    }

    /**
     * 
     * @return
     *     The ability
     */
    public Ability_ getAbility() {
        return ability;
    }

    /**
     * 
     * @param ability
     *     The ability
     */
    public void setAbility(Ability_ ability) {
        this.ability = ability;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(slot);
        dest.writeValue(isHidden);
        dest.writeValue(ability);
    }

    public int describeContents() {
        return  0;
    }

}
