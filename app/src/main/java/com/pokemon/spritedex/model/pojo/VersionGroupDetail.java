
package com.pokemon.spritedex.model.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class VersionGroupDetail implements Parcelable
{

    @SerializedName("move_learn_method")
    @Expose
    private MoveLearnMethod moveLearnMethod;
    @SerializedName("level_learned_at")
    @Expose
    private int levelLearnedAt;
    @SerializedName("version_group")
    @Expose
    private VersionGroup versionGroup;
    public final static Parcelable.Creator<VersionGroupDetail> CREATOR = new Creator<VersionGroupDetail>() {


        @SuppressWarnings({
            "unchecked"
        })
        public VersionGroupDetail createFromParcel(Parcel in) {
            VersionGroupDetail instance = new VersionGroupDetail();
            instance.moveLearnMethod = ((MoveLearnMethod) in.readValue((MoveLearnMethod.class.getClassLoader())));
            instance.levelLearnedAt = ((int) in.readValue((int.class.getClassLoader())));
            instance.versionGroup = ((VersionGroup) in.readValue((VersionGroup.class.getClassLoader())));
            return instance;
        }

        public VersionGroupDetail[] newArray(int size) {
            return (new VersionGroupDetail[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The moveLearnMethod
     */
    public MoveLearnMethod getMoveLearnMethod() {
        return moveLearnMethod;
    }

    /**
     * 
     * @param moveLearnMethod
     *     The move_learn_method
     */
    public void setMoveLearnMethod(MoveLearnMethod moveLearnMethod) {
        this.moveLearnMethod = moveLearnMethod;
    }

    /**
     * 
     * @return
     *     The levelLearnedAt
     */
    public int getLevelLearnedAt() {
        return levelLearnedAt;
    }

    /**
     * 
     * @param levelLearnedAt
     *     The level_learned_at
     */
    public void setLevelLearnedAt(int levelLearnedAt) {
        this.levelLearnedAt = levelLearnedAt;
    }

    /**
     * 
     * @return
     *     The versionGroup
     */
    public VersionGroup getVersionGroup() {
        return versionGroup;
    }

    /**
     * 
     * @param versionGroup
     *     The version_group
     */
    public void setVersionGroup(VersionGroup versionGroup) {
        this.versionGroup = versionGroup;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(moveLearnMethod);
        dest.writeValue(levelLearnedAt);
        dest.writeValue(versionGroup);
    }

    public int describeContents() {
        return  0;
    }

}
