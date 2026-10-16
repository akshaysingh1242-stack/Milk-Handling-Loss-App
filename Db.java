package in.milkhandlingloss.app;

import android.content.*;
import android.database.Cursor;
import android.database.sqlite.*;
import java.util.*;

public class Db extends SQLiteOpenHelper {
  public Db(Context c){ super(c,"milk_handling_loss.db",null,1); }
  @Override public void onCreate(SQLiteDatabase d){
    d.execSQL("CREATE TABLE sent(id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT NOT NULL, challan TEXT, particular TEXT, milk REAL, fat_pct REAL, snf_pct REAL, fat_kg REAL, snf_kg REAL)");
    d.execSQL("CREATE TABLE received(id INTEGER PRIMARY KEY AUTOINCREMENT, date TEXT NOT NULL, shift TEXT NOT NULL, milk REAL, fat_pct REAL, snf_pct REAL, fat_kg REAL, snf_kg REAL)");
    d.execSQL("CREATE TABLE balance(id INTEGER PRIMARY KEY AUTOINCREMENT, month TEXT UNIQUE NOT NULL, opening_milk REAL, opening_fat_pct REAL, opening_snf_pct REAL, opening_fat_kg REAL, opening_snf_kg REAL, closing_milk REAL, closing_fat_pct REAL, closing_snf_pct REAL, closing_fat_kg REAL, closing_snf_kg REAL)");
    d.execSQL("CREATE TABLE settings(k TEXT PRIMARY KEY, v TEXT)");
  }
  @Override public void onUpgrade(SQLiteDatabase d,int oldV,int newV){}
  public long insert(String table, ContentValues v){ return getWritableDatabase().insert(table,null,v); }
  public int update(String table,long id,ContentValues v){return getWritableDatabase().update(table,v,"id=?",new String[]{String.valueOf(id)});}
  public int delete(String table,long id){return getWritableDatabase().delete(table,"id=?",new String[]{String.valueOf(id)});}
  public Cursor all(String table){return getReadableDatabase().rawQuery("SELECT * FROM "+table+" ORDER BY date DESC, id DESC",null);}
  public Cursor monthBalance(String month){return getReadableDatabase().rawQuery("SELECT * FROM balance WHERE month=?",new String[]{month});}
  public void putSetting(String k,String v){ContentValues c=new ContentValues();c.put("k",k);c.put("v",v);getWritableDatabase().insertWithOnConflict("settings",null,c,SQLiteDatabase.CONFLICT_REPLACE);}
  public String setting(String k,String def){Cursor c=getReadableDatabase().rawQuery("SELECT v FROM settings WHERE k=?",new String[]{k});try{return c.moveToFirst()?c.getString(0):def;}finally{c.close();}}
}
