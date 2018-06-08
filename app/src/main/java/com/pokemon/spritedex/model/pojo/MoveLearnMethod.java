
package com.pokemon.spritedex.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class MoveLearnMethod implements Parcelable
{

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("name")
    @Expose
    private String name;
    public final static Parcelable.Creator<MoveLearnMethod> CREATOR = new Creator<MoveLearnMethod>() {


        @SuppressWarnings({
            "unchecked"
        })
        public MoveLearnMethod createFromParcel(Parcel in) {
            MoveLearnMethod instance = new MoveLearnMethod();
            instance.url = ((String) in.readValue((String.class.getClassLoader())));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public MoveLearnMethod[] newArray(int size) {
            return (new MoveLearnMethod[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 
     * @param url
     *     The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(url);
        dest.writeValue(name);
    }

    public int describeContents() {
        return  0;
    }

}
