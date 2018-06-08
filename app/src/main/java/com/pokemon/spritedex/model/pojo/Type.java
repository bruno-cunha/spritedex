
package com.pokemon.spritedex.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Type implements Parcelable
{

    @SerializedName("slot")
    @Expose
    private int slot;
    @SerializedName("type")
    @Expose
    private Type_ type;
    public final static Parcelable.Creator<Type> CREATOR = new Creator<Type>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Type createFromParcel(Parcel in) {
            Type instance = new Type();
            instance.slot = ((int) in.readValue((int.class.getClassLoader())));
            instance.type = ((Type_) in.readValue((Type_.class.getClassLoader())));
            return instance;
        }

        public Type[] newArray(int size) {
            return (new Type[size]);
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
     *     The type
     */
    public Type_ getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(Type_ type) {
        this.type = type;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(slot);
        dest.writeValue(type);
    }

    public int describeContents() {
        return  0;
    }

}
