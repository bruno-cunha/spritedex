
package com.pokemon.spritedex.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GameIndex implements Parcelable
{

    @SerializedName("version")
    @Expose
    private Version_ version;
    @SerializedName("game_index")
    @Expose
    private int gameIndex;
    public final static Parcelable.Creator<GameIndex> CREATOR = new Creator<GameIndex>() {


        @SuppressWarnings({
            "unchecked"
        })
        public GameIndex createFromParcel(Parcel in) {
            GameIndex instance = new GameIndex();
            instance.version = ((Version_) in.readValue((Version_.class.getClassLoader())));
            instance.gameIndex = ((int) in.readValue((int.class.getClassLoader())));
            return instance;
        }

        public GameIndex[] newArray(int size) {
            return (new GameIndex[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The version
     */
    public Version_ getVersion() {
        return version;
    }

    /**
     * 
     * @param version
     *     The version
     */
    public void setVersion(Version_ version) {
        this.version = version;
    }

    /**
     * 
     * @return
     *     The gameIndex
     */
    public int getGameIndex() {
        return gameIndex;
    }

    /**
     * 
     * @param gameIndex
     *     The game_index
     */
    public void setGameIndex(int gameIndex) {
        this.gameIndex = gameIndex;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(version);
        dest.writeValue(gameIndex);
    }

    public int describeContents() {
        return  0;
    }

}
