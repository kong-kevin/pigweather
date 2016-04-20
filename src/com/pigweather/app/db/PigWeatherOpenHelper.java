package com.pigweather.app.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class PigWeatherOpenHelper extends SQLiteOpenHelper{
	/**
	 * Province�������
	 *
	 */
	public static final String CREATE_PROVINCE="create table Province ("
	        +"id integer primary key autoincrement,"
			+"province_name text,"
	        +"province_code text)";
	/**
	 * City�������
	 *
	 */
	public static final String CREATE_CITY="create table Province ("
	        +"id integer primary key autoincrement,"
			+"province_name text,"
	        +"province_code text,"
			+"province_id integer)";
	/**
	 * County�������
	 *
	 */
	public static final String CREATE_COUNTY="create table Province ("
	        +"id integer primary key autoincrement,"
			+"province_name text,"
	        +"province_code text,"
			+"city_id integer)";
	
	public PigWeatherOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_PROVINCE);//����Province��
		db.execSQL(CREATE_CITY);//����city��
		db.execSQL(CREATE_COUNTY);//����county��
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

}
