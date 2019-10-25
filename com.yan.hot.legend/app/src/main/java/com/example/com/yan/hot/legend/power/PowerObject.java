package com.example.com.yan.hot.legend.power;

import com.example.com.yan.hot.legend.AccountManager;
import com.zsctc.remote.touch.bytes.ClickTool;

/**
 * Created by on 2018/9/29.
 */
public class PowerObject {
    private String name;
    //日期
    private long date;
    //战力
    private int value;
    //转生
    private int reincarn;

    private ClickTool.ClientType clientType;

    public PowerObject() {
    }

    public PowerObject(String name, long date, int value, int reincarn, ClickTool.ClientType clientType) {
        this.name = name;
        this.date = date;
        this.value = value;
        this.reincarn = reincarn;
        this.clientType = clientType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getReincarn() {
        return reincarn;
    }

    public void setReincarn(int reincarn) {
        this.reincarn = reincarn;
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
    public String toString() {
        return "PowerObject{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", value=" + value +
                ", reincarn=" + reincarn +
                ", clientType=" + clientType +
                '}';
    }
}
