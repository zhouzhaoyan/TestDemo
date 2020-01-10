package com.example.com.yan.hot.legend.signin;

import com.example.com.yan.hot.legend.AccountManager;
import com.zsctc.remote.touch.bytes.ClickTool;

/**
 *
 */
public class SigninObject {
    private ClickTool.ClientType clientType;
    //日期
    private long date;
    private int index;

    public SigninObject() {
    }

    public SigninObject(ClickTool.ClientType clientType, long date, int index) {
        this.clientType = clientType;
        this.date = date;
        this.index = index;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ClickTool.ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClickTool.ClientType clientType) {
        this.clientType = clientType;
    }

    public String getAccountName(){
        return AccountManager.getAccountName(clientType);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof SigninObject){
            return ((SigninObject)o).getClientType() == clientType;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "SigninObject{" +
                "clientType=" + clientType +
                ", date=" + date +
                ", index=" + index +
                '}';
    }
}
