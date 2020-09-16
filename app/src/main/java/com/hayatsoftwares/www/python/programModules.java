package com.hayatsoftwares.www.python;

public class programModules { private String mTitle , mDesc ;
    private String[] urls;
    private String identifer;
    private int cLass;
    private String[] questions;

    public programModules(){
    }
    public programModules(String title,String desc,String[] questions, String[] URLs , String identifer, int cLass){
        mTitle = title;
        mDesc = desc;
        urls = URLs;
        this.questions = questions;
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
    public String[] getQuestions(){ return questions; }
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
