
package com.pokemon.spritedex.model.pojo;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sprites implements Parcelable
{

    @SerializedName("back_female")
    @Expose
    private String backFemale;
    @SerializedName("back_shiny_female")
    @Expose
    private String backShinyFemale;
    @SerializedName("back_default")
    @Expose
    private String backDefault;
    @SerializedName("front_female")
    @Expose
    private String frontFemale;
    @SerializedName("front_shiny_female")
    @Expose
    private String frontShinyFemale;
    @SerializedName("back_shiny")
    @Expose
    private String backShiny;
    @SerializedName("front_default")
    @Expose
    private String frontDefault;
    @SerializedName("front_shiny")
    @Expose
    private String frontShiny;
    public final static Parcelable.Creator<Sprites> CREATOR = new Creator<Sprites>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Sprites createFromParcel(Parcel in) {
            Sprites instance = new Sprites();
            instance.backFemale = ((String) in.readValue((String.class.getClassLoader())));
            instance.backShinyFemale = ((String) in.readValue((String.class.getClassLoader())));
            instance.backDefault = ((String) in.readValue((String.class.getClassLoader())));
            instance.frontFemale = ((String) in.readValue((String.class.getClassLoader())));
            instance.frontShinyFemale = ((String) in.readValue((String.class.getClassLoader())));
            instance.backShiny = ((String) in.readValue((String.class.getClassLoader())));
            instance.frontDefault = ((String) in.readValue((String.class.getClassLoader())));
            instance.frontShiny = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Sprites[] newArray(int size) {
            return (new Sprites[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The backFemale
     */
    public String getBackFemale() {
        return backFemale;
    }

    /**
     * 
     * @param backFemale
     *     The back_female
     */
    public void setBackFemale(String backFemale) {
        this.backFemale = backFemale;
    }

    /**
     * 
     * @return
     *     The backShinyFemale
     */
    public String getBackShinyFemale() {
        return backShinyFemale;
    }

    /**
     * 
     * @param backShinyFemale
     *     The back_shiny_female
     */
    public void setBackShinyFemale(String backShinyFemale) {
        this.backShinyFemale = backShinyFemale;
    }

    /**
     * 
     * @return
     *     The backDefault
     */
    public String getBackDefault() {
        return backDefault;
    }

    /**
     * 
     * @param backDefault
     *     The back_default
     */
    public void setBackDefault(String backDefault) {
        this.backDefault = backDefault;
    }

    /**
     * 
     * @return
     *     The frontFemale
     */
    public String getFrontFemale() {
        return frontFemale;
    }

    /**
     * 
     * @param frontFemale
     *     The front_female
     */
    public void setFrontFemale(String frontFemale) {
        this.frontFemale = frontFemale;
    }

    /**
     * 
     * @return
     *     The frontShinyFemale
     */
    public String getFrontShinyFemale() {
        return frontShinyFemale;
    }

    /**
     * 
     * @param frontShinyFemale
     *     The front_shiny_female
     */
    public void setFrontShinyFemale(String frontShinyFemale) {
        this.frontShinyFemale = frontShinyFemale;
    }

    /**
     * 
     * @return
     *     The backShiny
     */
    public String getBackShiny() {
        return backShiny;
    }

    /**
     * 
     * @param backShiny
     *     The back_shiny
     */
    public void setBackShiny(String backShiny) {
        this.backShiny = backShiny;
    }

    /**
     * 
     * @return
     *     The frontDefault
     */
    public String getFrontDefault() {
        return frontDefault;
    }

    /**
     * 
     * @param frontDefault
     *     The front_default
     */
    public void setFrontDefault(String frontDefault) {
        this.frontDefault = frontDefault;
    }

    /**
     * 
     * @return
     *     The frontShiny
     */
    public String getFrontShiny() {
        return frontShiny;
    }

    /**
     * 
     * @param frontShiny
     *     The front_shiny
     */
    public void setFrontShiny(String frontShiny) {
        this.frontShiny = frontShiny;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(backFemale);
        dest.writeValue(backShinyFemale);
        dest.writeValue(backDefault);
        dest.writeValue(frontFemale);
        dest.writeValue(frontShinyFemale);
        dest.writeValue(backShiny);
        dest.writeValue(frontDefault);
        dest.writeValue(frontShiny);
    }

    public int describeContents() {
        return  0;
    }

}
