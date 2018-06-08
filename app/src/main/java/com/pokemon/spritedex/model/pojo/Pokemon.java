
package com.pokemon.spritedex.model.pojo;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pokemon implements Parcelable
{

    @SerializedName("forms")
    @Expose
    private List<Form> forms = new ArrayList<Form>();
    @SerializedName("abilities")
    @Expose
    private List<Ability> abilities = new ArrayList<Ability>();
    @SerializedName("stats")
    @Expose
    private List<Stat> stats = new ArrayList<Stat>();
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("weight")
    @Expose
    private int weight;
    @SerializedName("moves")
    @Expose
    private List<Move> moves = new ArrayList<Move>();
    @SerializedName("sprites")
    @Expose
    private Sprites sprites;
    @SerializedName("held_items")
    @Expose
    private List<HeldItem> heldItems = new ArrayList<HeldItem>();
    @SerializedName("location_area_encounters")
    @Expose
    private String locationAreaEncounters;
    @SerializedName("height")
    @Expose
    private int height;
    @SerializedName("is_default")
    @Expose
    private boolean isDefault;
    @SerializedName("species")
    @Expose
    private Species species;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("order")
    @Expose
    private int order;
    @SerializedName("game_indices")
    @Expose
    private List<GameIndex> gameIndices = new ArrayList<GameIndex>();
    @SerializedName("base_experience")
    @Expose
    private int baseExperience;
    @SerializedName("types")
    @Expose
    private List<Type> types = new ArrayList<Type>();
    public final static Parcelable.Creator<Pokemon> CREATOR = new Creator<Pokemon>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Pokemon createFromParcel(Parcel in) {
            Pokemon instance = new Pokemon();
            in.readList(instance.forms, (Form.class.getClassLoader()));
            in.readList(instance.abilities, (Ability.class.getClassLoader()));
            in.readList(instance.stats, (Stat.class.getClassLoader()));
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            instance.weight = ((int) in.readValue((int.class.getClassLoader())));
            in.readList(instance.moves, (Move.class.getClassLoader()));
            instance.sprites = ((Sprites) in.readValue((Sprites.class.getClassLoader())));
            in.readList(instance.heldItems, (HeldItem.class.getClassLoader()));
            instance.locationAreaEncounters = ((String) in.readValue((String.class.getClassLoader())));
            instance.height = ((int) in.readValue((int.class.getClassLoader())));
            instance.isDefault = ((boolean) in.readValue((boolean.class.getClassLoader())));
            instance.species = ((Species) in.readValue((Species.class.getClassLoader())));
            instance.id = ((int) in.readValue((int.class.getClassLoader())));
            instance.order = ((int) in.readValue((int.class.getClassLoader())));
            in.readList(instance.gameIndices, (GameIndex.class.getClassLoader()));
            instance.baseExperience = ((int) in.readValue((int.class.getClassLoader())));
            in.readList(instance.types, (Type.class.getClassLoader()));
            return instance;
        }

        public Pokemon[] newArray(int size) {
            return (new Pokemon[size]);
        }

    }
    ;

    /**
     * 
     * @return
     *     The forms
     */
    public List<Form> getForms() {
        return forms;
    }

    /**
     * 
     * @param forms
     *     The forms
     */
    public void setForms(List<Form> forms) {
        this.forms = forms;
    }

    /**
     * 
     * @return
     *     The abilities
     */
    public List<Ability> getAbilities() {
        return abilities;
    }

    /**
     * 
     * @param abilities
     *     The abilities
     */
    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    /**
     * 
     * @return
     *     The stats
     */
    public List<Stat> getStats() {
        return stats;
    }

    /**
     * 
     * @param stats
     *     The stats
     */
    public void setStats(List<Stat> stats) {
        this.stats = stats;
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

    /**
     * 
     * @return
     *     The weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * 
     * @param weight
     *     The weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * 
     * @return
     *     The moves
     */
    public List<Move> getMoves() {
        return moves;
    }

    /**
     * 
     * @param moves
     *     The moves
     */
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    /**
     * 
     * @return
     *     The sprites
     */
    public Sprites getSprites() {
        return sprites;
    }

    /**
     * 
     * @param sprites
     *     The sprites
     */
    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    /**
     * 
     * @return
     *     The heldItems
     */
    public List<HeldItem> getHeldItems() {
        return heldItems;
    }

    /**
     * 
     * @param heldItems
     *     The held_items
     */
    public void setHeldItems(List<HeldItem> heldItems) {
        this.heldItems = heldItems;
    }

    /**
     * 
     * @return
     *     The locationAreaEncounters
     */
    public String getLocationAreaEncounters() {
        return locationAreaEncounters;
    }

    /**
     * 
     * @param locationAreaEncounters
     *     The location_area_encounters
     */
    public void setLocationAreaEncounters(String locationAreaEncounters) {
        this.locationAreaEncounters = locationAreaEncounters;
    }

    /**
     * 
     * @return
     *     The height
     */
    public int getHeight() {
        return height;
    }

    /**
     * 
     * @param height
     *     The height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * 
     * @return
     *     The isDefault
     */
    public boolean isIsDefault() {
        return isDefault;
    }

    /**
     * 
     * @param isDefault
     *     The is_default
     */
    public void setIsDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }

    /**
     * 
     * @return
     *     The species
     */
    public Species getSpecies() {
        return species;
    }

    /**
     * 
     * @param species
     *     The species
     */
    public void setSpecies(Species species) {
        this.species = species;
    }

    /**
     * 
     * @return
     *     The id
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The order
     */
    public int getOrder() {
        return order;
    }

    /**
     * 
     * @param order
     *     The order
     */
    public void setOrder(int order) {
        this.order = order;
    }

    /**
     * 
     * @return
     *     The gameIndices
     */
    public List<GameIndex> getGameIndices() {
        return gameIndices;
    }

    /**
     * 
     * @param gameIndices
     *     The game_indices
     */
    public void setGameIndices(List<GameIndex> gameIndices) {
        this.gameIndices = gameIndices;
    }

    /**
     * 
     * @return
     *     The baseExperience
     */
    public int getBaseExperience() {
        return baseExperience;
    }

    /**
     * 
     * @param baseExperience
     *     The base_experience
     */
    public void setBaseExperience(int baseExperience) {
        this.baseExperience = baseExperience;
    }

    /**
     * 
     * @return
     *     The types
     */
    public List<Type> getTypes() {
        return types;
    }

    /**
     * 
     * @param types
     *     The types
     */
    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(forms);
        dest.writeList(abilities);
        dest.writeList(stats);
        dest.writeValue(name);
        dest.writeValue(weight);
        dest.writeList(moves);
        dest.writeValue(sprites);
        dest.writeList(heldItems);
        dest.writeValue(locationAreaEncounters);
        dest.writeValue(height);
        dest.writeValue(isDefault);
        dest.writeValue(species);
        dest.writeValue(id);
        dest.writeValue(order);
        dest.writeList(gameIndices);
        dest.writeValue(baseExperience);
        dest.writeList(types);
    }

    public int describeContents() {
        return  0;
    }

}
