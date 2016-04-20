package com.pigweather.app.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.pigweather.app.model.City;
import com.pigweather.app.model.County;
import com.pigweather.app.model.Province;


public class PigWeatherDB {
	/**
	 * 数据库名
	 */
    public static final String DB_NAME="pig_weather";
    /**
    * 数据库版本
    */
    public static final int VERSION=1;
    private static PigWeatherDB pigWeatherDB;
    private SQLiteDatabase db;
    /**
     * 将构造方法私有化
     */
    private PigWeatherDB(Context context){
    	PigWeatherOpenHelper dbhHelper = new PigWeatherOpenHelper(context, DB_NAME, null, VERSION);
    	db = dbhHelper.getWritableDatabase();
    }
    /**
     * 获取PigWeatherDB实例。
     */
    public synchronized static PigWeatherDB getInstance(Context context){
    	if (pigWeatherDB == null) {
    		pigWeatherDB = new PigWeatherDB(context);
			
		}
    	return pigWeatherDB;
    }
    /**
     * 将Province实例存储到数据库。
     */
    public void saveProvince(Province province){
    	if (province != null) {
    		ContentValues values = new ContentValues();
    		values.put("province_name", province.getProvinceName());
    		values.put("province_code", province.getProvinceCode());
    		db.insert("Province", null, values);
			
		}
    }
    /**
     * 从数据库读取所有省份信息
     */
    public List<Province> loadProvinces(){
    	List<Province> list = new ArrayList<Province>();
    	Cursor cursor = db.query("Province", null, null, null, null, null, null);
    	if (cursor.moveToFirst()) {
    		do {
    			Province province = new Province();
    			province.setId(cursor.getInt(cursor.getColumnIndex("id")));
    			province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
    			province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
				list.add(province);
			} while (cursor.moveToNext());
			
		}
    	return list;
    }
    /**
     * 将City实例存储到数据库。
     */
    public void saveCity(City city){
    	if (city != null) {
    		ContentValues values = new ContentValues();
    		values.put("province_name", city.getCityName());
    		values.put("province_code", city.getCityCode());
    		db.insert("City", null, values);
			
		}
    }
    /**
     * 从数据库读取某省下所有城市的信息
     */
    public List<City> loadCities(int provinceId){
    	List<City> list = new ArrayList<City>();
    	Cursor cursor = db.query("City", null, null, null, null, null, null);
    	if (cursor.moveToFirst()) {
    		do {
    			City city = new City();
    			city.setId(cursor.getInt(cursor.getColumnIndex("id")));
    			city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
    			city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
				list.add(city);
			} while (cursor.moveToNext());
			
		}
    	return list;
    }
    /**
     * 将County实例存储到数据库。
     */
    public void saveCounty(County county){
    	if (county != null) {
    		ContentValues values = new ContentValues();
    		values.put("county_name", county.getCountyName());
    		values.put("county_code", county.getCountyCode());
    		db.insert("county", null, values);
			
		}
    }
    /**
     * 从数据库读取某市下所有县的信息
     */
    public List<County> loadCounties(){
    	List<County> list = new ArrayList<County>();
    	Cursor cursor = db.query("County", null, null, null, null, null, null);
    	if (cursor.moveToFirst()) {
    		do {
    			County county = new County();
    			county.setId(cursor.getInt(cursor.getColumnIndex("id")));
    			county.setCountyName(cursor.getString(cursor.getColumnIndex("county_name")));
    			county.setCountyCode(cursor.getString(cursor.getColumnIndex("county_code")));
				list.add(county);
			} while (cursor.moveToNext());
			
		}
    	return list;
    }

}
