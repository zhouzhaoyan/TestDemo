package com.example.com.yan.hot.legend.devote;

import com.zsctc.remote.touch.bytes.ClickTool;

/**
 * Created by on 2018/9/29.
 */
public class DevoteObject {
    private String name;
    //日期
    private long date;
    //贡献值
    private int value;
    //累加值
    private int offset;

    private ClickTool.ClientType clientType;

    public DevoteObject() {
    }

    public DevoteObject(String name, long date, int value, int offset, ClickTool.ClientType clientType) {
        this.name = name;
        this.date = date;
        this.value = value;
        this.offset = offset;
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

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public ClickTool.ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClickTool.ClientType clientType) {
        this.clientType = clientType;
    }

    public String getAccountName(){
        return  DevoteManager.getAccountName(clientType);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof  DevoteObject){
            return ((DevoteObject)o).getName().equals(name);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "DevoteObject{" +
                "name='" + name + '\'' +
                ", date=" + date +
                ", value=" + value +
                ", offset=" + offset +
                ", clientType=" + clientType +
                '}';
    }
}
