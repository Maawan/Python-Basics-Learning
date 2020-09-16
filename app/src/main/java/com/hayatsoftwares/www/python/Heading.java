package com.hayatsoftwares.www.python;

public class Heading {
    private String mTitle;
    private int mRn;
    private String murl;
    public Heading(String title, int Rn,String url){
        mTitle=title;
        mRn=Rn;
        murl=url;
    }
    public String getmTitle(){
        return  mTitle;
    }
    public int getInt(){return mRn;}
    public String getMurl()
    {return murl;}


}
