package com.rossconnacher.cullingapp.models;

/**
 * Created by Ross on 5/20/2017.
 */

public class Airdrop {
    private String AirdropName;
    private String AirdropCatagory;
    private String[] AirdropContents;
    private int AirdropCost;

    public Airdrop(String AirdropName, String[] AirdropContents, int AirdropCost, String AirdropCatagory){
        this.AirdropName = AirdropName;
        this.AirdropContents = AirdropContents;
        this.AirdropCost = AirdropCost;
        this.AirdropCatagory = AirdropCatagory;
    }

    public String getAirdropName() {
        return AirdropName;
    }

    public String getAirdropCatagory() {
        return AirdropCatagory;
    }

    public String[] getAirdropContents() {
        return AirdropContents;
    }
    public int getAirdropCost() {
        return AirdropCost;
    }
}
