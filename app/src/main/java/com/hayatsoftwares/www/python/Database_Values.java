package com.hayatsoftwares.www.python;

public class Database_Values {
    String username;
    String mailId;
    int learn;
    int program;

    public Database_Values(){
    }
    public Database_Values(String username, String mailId, int learn,int program){
        this.username=username;
        this.learn=learn;
        this.mailId=mailId;
        this.program=program;
    }
    public String getMailId(){
        return mailId;
    }
    public String getUsername(){
        return username;
    }
    public int getLearn(){
        return learn;
    }
    public int getProgram(){
        return program;
    }

}
