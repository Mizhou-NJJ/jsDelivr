package me.conf;

import java.util.HashMap;

public class R {
    public R(){
        
    }
    private boolean isSuccess;
    private HashMap<String,String> confs;

    public HashMap<String, String> getConfs() {
        return confs;
    }

    public void setConfs(HashMap<String, String> confs) {
        this.confs = confs;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
