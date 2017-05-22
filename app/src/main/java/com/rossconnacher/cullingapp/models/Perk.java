package com.rossconnacher.cullingapp.models;

/**
 * Created by Ross on 5/20/2017.
 */

public class Perk {

    private String Catagory;
    private String PerkName;
    private String PerkText;
    public Perk(String PerkName, String Catagory, String  PerkText){
        this.PerkName = PerkName;
        this.PerkText = PerkText;
        this.Catagory = Catagory;
    }


    //public static Perk getRandom() {
    //    return Perk.values()[(int) (Math.random()*Perk.values().length)];
    //}

    public String getCatagory() {
        return Catagory;
    }

    public String getPerkName() {
        return PerkName;
    }

    public String getPerkText() {
        return PerkText;
    }
}


