package com.assignment.paygoproject.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.assignment.paygoproject.object.Data;

import java.util.ArrayList;

public class DBUtils {

    private static db_manager db_manager;
    private static final String TAG = "DBUtils";

    public static boolean insert_data(Data data, Context mContext){
        boolean isSuccess = false;
        db_manager = new db_manager(mContext);
        try (SQLiteDatabase db = db_manager.getWritableDatabase()) {

            ContentValues cv = new ContentValues();
            cv.put(db_tables.DATA_NODE_ID, data.getNodeId());
            cv.put(db_tables.DATA_PARENT_ID, data.getParentId());
            cv.put(db_tables.DATA_UID_OBJECT_ID, data.getUIObjectId());
            cv.put(db_tables.DATA_SERVICE_ID, data.getServiceId());
            cv.put(db_tables.DATA_BACKGROUND, data.getBackground());
            cv.put(db_tables.DATA_CLASS_NAME, data.getClassName());
            cv.put(db_tables.DATA_ICON_NAME, data.getIconName());
            cv.put(db_tables.DATA_ROW_NUMBER, data.getRowNumber());
            cv.put(db_tables.DATA_SERVICE_NAME, data.getServiceName());
            cv.put(db_tables.DATA_VENDOR_ID, data.getVendorId());
            cv.put(db_tables.DATA_IS_SERVICE_ACTIVE, data.getIsServiceActive());
            cv.put(db_tables.DATA_PKG_ID, data.getPkgId());
            cv.put(db_tables.DATA_PLACE_HOLDER, data.getPlaceHolder());
            cv.put(db_tables.DATA_REG_EXP, data.getRegExp());
            cv.put(db_tables.DATA_CONTRACT_TYPE_ID, data.getContractTypeId());
            cv.put(db_tables.DATA_ORDER_INDEX, data.getOrderIndex());
            cv.put(db_tables.DATA_PAY_CHECK_TEMPLATE, data.getPayCheckTemplate());
            cv.put(db_tables.DATA_CHILD_COLUMNS_COUNT, data.getChildColumnsCount());
            cv.put(db_tables.DATA_SERVICE_DESCRIPTION, Data.getServiceDescription());
            cv.put(db_tables.DATA_ID_LABEL, Data.getIdLabel());
            cv.put(db_tables.DATA_PACKAGE_PRICE, Data.getPackagePrice());
            cv.put(db_tables.DATA_ENABLED_PROVIDERS, Data.getEnabledProviders());
            cv.put(db_tables.DATA_HINT_TEXT, Data.getHintText());
            cv.put(db_tables.DATA_TAGS, Data.getTags());
            cv.put(db_tables.DATA_DETAILS, Data.getDetails());
            cv.put(db_tables.DATA_KEYBOARD_TYPE, Data.getKeyboardType());

            try{
                long rowCount = db.insertOrThrow(db_tables.TABLE_NAME_DATA, null, cv);
                if (rowCount != -1){
                    Log.d(TAG, "insert_data " + " inserted "+ data.getParentId() + "  "+ data.getServiceName());
                    isSuccess = true;
                }else{
                    Log.e(TAG, "insert_data " + " insert failed");
                    isSuccess = false;
                }
            }catch (Exception e){
                try{
                    long rowCount = db.replaceOrThrow(db_tables.TABLE_NAME_DATA, null, cv);
                    if (rowCount != -1){
                        Log.d(TAG, "insert_data " + " replaced");
                        isSuccess = true;
                    }else{
                        Log.e(TAG, "insert_data " + " replaced failed");
                        isSuccess = false;
                    }
                }catch (Exception ie){
                    Log.e(TAG, "insert_data " + " inserted or replaced failed  :"+ ie.getMessage());
                    isSuccess = false;
                }
                isSuccess = false;
            }
        }
        return isSuccess;
    }

    public static ArrayList<Data> getDataByPrentID(Context mContext, String ParentID) {
        ArrayList<Data> dataArrayList = new ArrayList<>();
        db_manager = new db_manager(mContext);
        Cursor c;

        StringBuilder query = new StringBuilder("SELECT * FROM " + db_tables.TABLE_NAME_DATA
                + " where " + db_tables.DATA_PARENT_ID + "='" + ParentID +"'"
                + " ORDER BY " + db_tables.DATA_UID_OBJECT_ID + " ASC"
        );

        try (SQLiteDatabase db = db_manager.getWritableDatabase()) {
            c = db.rawQuery(query.toString(), null);
            if (c.moveToFirst()) {
                do {

                    Data data = new Data();
                    Data.setNodeId(c.getInt(c.getColumnIndexOrThrow(db_tables.DATA_NODE_ID)));
                    Data.setParentId(c.getInt(c.getColumnIndexOrThrow(db_tables.DATA_PARENT_ID)));
                    Data.setUIObjectId(c.getInt(c.getColumnIndexOrThrow(db_tables.DATA_UID_OBJECT_ID)));
                    Data.setServiceId(c.getInt(c.getColumnIndexOrThrow(db_tables.DATA_SERVICE_ID)));
                    Data.setBackground(c.getString(c.getColumnIndexOrThrow(db_tables.DATA_BACKGROUND)));
                    Data.setClassName(c.getString(c.getColumnIndexOrThrow(db_tables.DATA_CLASS_NAME)));
                    Data.setIconName(c.getString(c.getColumnIndexOrThrow(db_tables.DATA_ICON_NAME)));
                    Data.setRowNumber(c.getInt(c.getColumnIndexOrThrow(db_tables.DATA_ROW_NUMBER)));
                    Data.setServiceName(c.getString(c.getColumnIndexOrThrow(db_tables.DATA_SERVICE_NAME)));
                    Data.setVendorId(c.getInt(c.getColumnIndexOrThrow(db_tables.DATA_VENDOR_ID)));
                    Data.setIsServiceActive(Boolean.parseBoolean(c.getString(c.getColumnIndexOrThrow(db_tables.DATA_IS_SERVICE_ACTIVE))));
                    Data.setPkgId(c.getInt(c.getColumnIndexOrThrow(db_tables.DATA_PKG_ID)));
                    Data.setPlaceHolder(c.getString(c.getColumnIndexOrThrow(db_tables.DATA_PLACE_HOLDER)));
                    Data.setRegExp(c.getString(c.getColumnIndexOrThrow(db_tables.DATA_REG_EXP)));
                    Data.setContractTypeId(c.getInt(c.getColumnIndexOrThrow(db_tables.DATA_CONTRACT_TYPE_ID)));
                    Data.setOrderIndex(c.getInt(c.getColumnIndexOrThrow(db_tables.DATA_ORDER_INDEX)));
                    Data.setPayCheckTemplate(c.getString(c.getColumnIndexOrThrow(db_tables.DATA_PAY_CHECK_TEMPLATE)));
                    Data.setChildColumnsCount(c.getInt(c.getColumnIndexOrThrow(db_tables.DATA_CHILD_COLUMNS_COUNT)));
                    Data.setServiceDescription(c.getString(c.getColumnIndexOrThrow(db_tables.DATA_SERVICE_DESCRIPTION)));
                    Data.setIdLabel(c.getString(c.getColumnIndexOrThrow(db_tables.DATA_ID_LABEL)));
                    Data.setPackagePrice(c.getInt(c.getColumnIndexOrThrow(db_tables.DATA_PACKAGE_PRICE)));
                    Data.setEnabledProviders(c.getString(c.getColumnIndexOrThrow(db_tables.DATA_ENABLED_PROVIDERS)));
                    Data.setHintText(c.getString(c.getColumnIndexOrThrow(db_tables.DATA_HINT_TEXT)));
                    Data.setTags(c.getString(c.getColumnIndexOrThrow(db_tables.DATA_TAGS)));
                    Data.setDetails(c.getString(c.getColumnIndexOrThrow(db_tables.DATA_DETAILS)));
                    Data.setKeyboardType(c.getInt(c.getColumnIndexOrThrow(db_tables.DATA_KEYBOARD_TYPE)));

                    dataArrayList.add(data);
                    Log.e(TAG, "getDataByPrentID " + data.getServiceName() + " "+ data.getParentId());

                } while (c.moveToNext());
                Log.e(TAG, "dataArrayList " + dataArrayList.size());
            }
            return dataArrayList;
        } catch (Exception e) {
            Log.e(TAG, "getDataByPrentID " + e);
        }
        return dataArrayList;
    }


    public static void deleteAllData(Context context) {
        db_manager = new db_manager(context);
        SQLiteDatabase db = db_manager.getReadableDatabase();
        db.execSQL("delete from " + db_tables.TABLE_NAME_DATA);
    }


}
