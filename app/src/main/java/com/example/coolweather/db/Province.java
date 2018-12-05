package com.example.coolweather.db;

import org.litepal.crud.LitePalSupport;

/**
 * Created by Administrator on 2018/12/4 0004.
 */

public class Province extends LitePalSupport{
    private int id;
    private String provinceName;
    private int provinceCode;
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getProvinceName(){
        return provinceName;
    }
    public void setProvinceName(String provinceName){
        this.provinceName=provinceName;
    }
    public void setProvinceCode(int provinceCode){
        this.provinceCode=provinceCode;
    }
    public int getProvinceCode(){
        return provinceCode;
    }

}
