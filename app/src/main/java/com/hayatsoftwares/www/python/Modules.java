package com.hayatsoftwares.www.python;

public class Modules {
    private String mTitle , mDesc ;
    private String[] urls;
    private String identifer;
    private int cLass;

    public Modules(){
    }
    public Modules(String title,String desc, String[] URLs , String identifer, int cLass){
        mTitle = title;
        mDesc = desc;
        urls = URLs;
        this.identifer = identifer;
        this.cLass = cLass ;
    }

    public int getcLass() {
        return cLass;
    }
    public String[] getUrls(){
        return urls;
    }
    public String getmTitle(){
        return mTitle;
    }
    public String getmDesc(){
        return mDesc;
    }
    public String getIdentifer(){
        return identifer;
    }
    public void setmDesc(String temp){
        mDesc = temp;
    }
    public void setUrls(String[] URLs){
        urls = URLs;
    }
}
