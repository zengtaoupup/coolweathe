package com.example.coolweather.util;

import android.text.TextUtils;

import com.example.coolweather.db.City;
import com.example.coolweather.db.Country;
import com.example.coolweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2018/12/4 0004.
 */

public class Utility {
    public static boolean handleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allProvinces=new JSONArray(response);
                for(int i=0;i<allProvinces.length();i++){
                    JSONObject provinceObject=allProvinces.getJSONObject(i);
                    Province province=new Province();
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.setProvinceName(provinceObject.getString("name"));
                    province.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    public static boolean handleCityResponse(String response,int provinceID){
        if(!TextUtils.isEmpty(response)){
            try{
                JSONArray allCities=new JSONArray(response);
                for(int i=0;i<allCities.length();i++){
                    JSONObject cityObject=allCities.getJSONObject(i);
                    City city=new City();
                    city.setCityCode(cityObject.getInt("id"));
                    city.setCityName(cityObject.getString("name"));
                    city.setProvinceId(provinceID);
                    city.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    public static boolean handleCountryResponse(String response,int cityid){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounties =new JSONArray(response);
                for(int i=0;i<allCounties.length();i++){
                    JSONObject countryObject=allCounties.getJSONObject(i);
                    Country country=new Country();
                    country.setCityId(cityid);
                    country.setCountyName(countryObject.getString("name"));
                    country.setWeatherId(countryObject.getString("weather_id"));
                    country.save();

                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
}
