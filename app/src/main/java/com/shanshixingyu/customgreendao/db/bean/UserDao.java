package com.shanshixingyu.customgreendao.db.bean;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.shanshixingyu.customgreendao.db.bean.User;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table USER.
*/
public class UserDao extends AbstractDao<User, Long> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "ID");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Age = new Property(2, Integer.class, "age", false, "AGE");
    };


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'USER' (" + //
                "'ID' INTEGER PRIMARY KEY ," + // 0: id
                "'NAME' TEXT NOT NULL ," + // 1: name
                "'AGE' INTEGER);"); // 2: age
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'USER'";
        db.execSQL(sql);
    }
    
    /** ALTER database table. */
    public static void upgradeTable(SQLiteDatabase db, boolean ifExists) {
    	Cursor c=null;
	    int count=0;
        String constraint = "";
        String sql = "SELECT COUNT(*) as count FROM sqlite_master WHERE TYPE='table' AND NAME='USER'";
        count=0;
        try {
			c=db.rawQuery(sql,null);
	    	if(null != c && c.moveToFirst()){
	    		count=c.getInt(c.getColumnIndex("count"));
	    	}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(c!=null){
				c.close();
				c = null;
			}
		}
		if(count == 0){
			createTable(db, ifExists);
			return;
		}
		
    	
	    
	    db.beginTransaction();
	    boolean errorTag = false;
	    try{
	    String querySql = null;
	    String alertSql = null;
	    	count=0;
	    	if(!errorTag){
		    	querySql="SELECT COUNT(*) as count FROM sqlite_master WHERE tbl_name='USER' AND [sql] LIKE '%''ID''%' ";
		    	Cursor cID = null;
		    	try{
			    	cID = db.rawQuery(querySql,null);
			    	if(cID.moveToFirst()){
			    		count=cID.getInt(cID.getColumnIndex("count"));
			    	}
			    	if(count == 0){
						alertSql = "ALTER TABLE "+constraint +"USER ADD COLUMN 'ID' INTEGER";
			        	db.execSQL(alertSql);
					}
		    	}catch (Exception e) {
					e.printStackTrace();
					errorTag = true;
				}finally{
					if(cID!=null){
						cID.close();
						cID = null;
					}
				}
				
	    	}
	    	count=0;
	    	if(!errorTag){
		    	querySql="SELECT COUNT(*) as count FROM sqlite_master WHERE tbl_name='USER' AND [sql] LIKE '%''NAME''%' ";
		    	Cursor cNAME = null;
		    	try{
			    	cNAME = db.rawQuery(querySql,null);
			    	if(cNAME.moveToFirst()){
			    		count=cNAME.getInt(cNAME.getColumnIndex("count"));
			    	}
			    	if(count == 0){
						alertSql = "ALTER TABLE "+constraint +"USER ADD COLUMN 'NAME' TEXT";
			        	db.execSQL(alertSql);
					}
		    	}catch (Exception e) {
					e.printStackTrace();
					errorTag = true;
				}finally{
					if(cNAME!=null){
						cNAME.close();
						cNAME = null;
					}
				}
				
	    	}
	    	count=0;
	    	if(!errorTag){
		    	querySql="SELECT COUNT(*) as count FROM sqlite_master WHERE tbl_name='USER' AND [sql] LIKE '%''AGE''%' ";
		    	Cursor cAGE = null;
		    	try{
			    	cAGE = db.rawQuery(querySql,null);
			    	if(cAGE.moveToFirst()){
			    		count=cAGE.getInt(cAGE.getColumnIndex("count"));
			    	}
			    	if(count == 0){
						alertSql = "ALTER TABLE "+constraint +"USER ADD COLUMN 'AGE' INTEGER";
			        	db.execSQL(alertSql);
					}
		    	}catch (Exception e) {
					e.printStackTrace();
					errorTag = true;
				}finally{
					if(cAGE!=null){
						cAGE.close();
						cAGE = null;
					}
				}
				
	    	}
            db.setTransactionSuccessful();
        }catch (Exception e) {
	    	e.printStackTrace();
	    	errorTag = true;
		}finally{
			db.endTransaction();
			if(errorTag){
				dropTable(db,ifExists);
				createTable(db, ifExists);
			}
		}
		
		
        
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
 
        Integer age = entity.getAge();
        if (age != null) {
            stmt.bindLong(3, age);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2) // age
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setAge(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(User entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(User entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}