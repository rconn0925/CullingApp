package com.connacher.cullingguideandtools.models;

/**
 * Created by Ross on 5/27/2017.
 */

public class Streamer {
    private String game;
    private int id;
    private int viewers;
    private String name;
    private String title;
    private String previewImageUrl;
    private String logoImageUrl;
    private String channelUrl;


    public Streamer(String name, int id, String game,String title, int viewers,String logoImageUrl, String previewImageUrl,String channelUrl ){
        this.name = name;
        this.id = id;
        this.game = game;
        this.title = title;
        this.viewers = viewers;
        this.logoImageUrl = logoImageUrl;
        this.previewImageUrl = previewImageUrl;
        this.channelUrl = channelUrl;
    }

    public String getName(){
        return name;
    }
    public String getGame(){
        return game;
    }
    public String getTitle(){
        return title;
    }
    public String getPreviewImageUrl(){
        return previewImageUrl;
    }
    public String getLogoImageUrl(){
        return logoImageUrl;
    }
    public String getChannelUrl(){
        return channelUrl;
    }
    public int getId(){
        return id;
    }
    public int getViewers(){
        return viewers;
    }
}
