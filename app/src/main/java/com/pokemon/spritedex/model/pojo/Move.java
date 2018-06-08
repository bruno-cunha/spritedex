
package com.pokemon.spritedex.model.pojo;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Move implements Parcelable
{

    @SerializedName("version_group_details")
    @Expose
    private List<VersionGroupDetail> versionGroupDetails = new ArrayList<VersionGroupDetail>();
    @SerializedName("move")
    @Expose
    private Move_ move;
    public final static Parcelable.Creator<Move> CREATOR = new Creator<Move>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Move createFromParcel(Parcel in) {
            Move instance = new Move();
            in.readList(instance.versionGroupDetails, (VersionGroupDetail.class.getClassLoader()));
            instance.move = ((Move_) in.readValue((Move_.class.getClassLoader())));
            return instance;
        }

        public Move[] newArray(int size) {
            return (new Move[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The versionGroupDetails
     */
    public List<VersionGroupDetail> getVersionGroupDetails() {
        return versionGroupDetails;
    }

    /**
     * 
     * @param versionGroupDetails
     *     The version_group_details
     */
    public void setVersionGroupDetails(List<VersionGroupDetail> versionGroupDetails) {
        this.versionGroupDetails = versionGroupDetails;
    }

    /**
     * 
     * @return
     *     The move
     */
    public Move_ getMove() {
        return move;
    }

    /**
     * 
     * @param move
     *     The move
     */
    public void setMove(Move_ move) {
        this.move = move;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(versionGroupDetails);
        dest.writeValue(move);
    }

    public int describeContents() {
        return  0;
    }

}
