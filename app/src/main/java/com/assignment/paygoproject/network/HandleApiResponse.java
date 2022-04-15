package com.assignment.paygoproject.network;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.assignment.paygoproject.database.DBUtils;
import com.assignment.paygoproject.object.Data;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HandleApiResponse {

    private IpService mClient = null;
    List<Data> dataArrayList = new ArrayList<>();
    int count = 0;
    Context mContext;

    public HandleApiResponse(Context context, String url) {
        mContext = context;
        init(context,url);
    }

    private void init(Context context,String url) {
        mClient = new RetrofitClient().getClient(context,url).create(IpService.class);
    }

    public interface CallBackDataDelegate {
        void onResponseSuccess(List<Data> dataList);
        void onFailure(String error);
    }

    Data filterData(JSONArray jsonArray,String check,CallBackDataDelegate delegate) throws JSONException {
        for(int i=0;i<jsonArray.length(); i++){
            count+=1;
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Log.e("ccccccccccc ","loop "+jsonObject.toString());

            Data data = new Data();
            if(!jsonObject.isNull("NodeId")){
                Data.setNodeId(jsonObject.getInt("NodeId"));
            }else {
                Data.setNodeId(0);
            }
            if(!jsonObject.isNull("ParentId")){
                Data.setParentId(jsonObject.getInt("ParentId"));
            }else {
                Data.setParentId(0);
            }
            if(!jsonObject.isNull("UIObjectId")){
                Data.setUIObjectId(jsonObject.getInt("UIObjectId"));
            }else {
                Data.setUIObjectId(0);
            }
            if(!jsonObject.isNull("ServiceId")){
                Data.setServiceId(jsonObject.getInt("ServiceId"));
            }else {
                Data.setServiceId(0);
            }
            if(!jsonObject.isNull("Background")){
                Data.setBackground(jsonObject.getString("Background"));
            }else {
                Data.setBackground("");
            }
            if(!jsonObject.isNull("ClassName")){
                Data.setClassName(jsonObject.getString("ClassName"));
            }else {
                Data.setClassName("");
            }
            if(!jsonObject.isNull("IconName")){
                Data.setIconName(jsonObject.getString("IconName"));
            }else {
                Data.setIconName("");
            }
            if(!jsonObject.isNull("RowNumber")){
                Data.setRowNumber(jsonObject.getInt("RowNumber"));
            }else {
                Data.setRowNumber(0);
            }
            if(!jsonObject.isNull("ServiceName")){
                Data.setServiceName(jsonObject.getString("ServiceName"));
            }else {
                Data.setServiceName("");
            }
            if(!jsonObject.isNull("VendorId")){
                Data.setVendorId(jsonObject.getInt("VendorId"));
            }else {
                Data.setVendorId(0);
            }
            if(!jsonObject.isNull("IsServiceActive")){
                Data.setIsServiceActive(jsonObject.getBoolean("IsServiceActive"));
            }else {
                Data.setIsServiceActive(false);
            }
            if(!jsonObject.isNull("PkgId")){
                Data.setPkgId(jsonObject.getInt("PkgId"));
            }else {
                Data.setPkgId(0);
            }
            if(!jsonObject.isNull("PlaceHolder")){
                Data.setPlaceHolder(jsonObject.getString("PlaceHolder"));
            }else {
                Data.setPlaceHolder("");
            }
            if(!jsonObject.isNull("RegExp")){
                Data.setRegExp(jsonObject.getString("RegExp"));
            }else {
                Data.setRegExp("");
            }
            if(!jsonObject.isNull("ContractTypeId")){
                Data.setContractTypeId(jsonObject.getInt("ContractTypeId"));
            }else {
                Data.setContractTypeId(0);
            }
            if(!jsonObject.isNull("OrderIndex")){
                Data.setOrderIndex(jsonObject.getInt("OrderIndex"));
            }else {
                Data.setOrderIndex(0);
            }
            if(!jsonObject.isNull("PayCheckTemplate")){
                Data.setPayCheckTemplate(jsonObject.getString("PayCheckTemplate"));
            }else {
                Data.setPayCheckTemplate("");
            }
            if(!jsonObject.isNull("ChildColumnsCount")){
                Data.setChildColumnsCount(jsonObject.getInt("ChildColumnsCount"));
            }else {
                Data.setChildColumnsCount(0);
            }
            if(!jsonObject.isNull("ServiceDescription")){
                Data.setServiceDescription(jsonObject.getString("ServiceDescription"));
            }else {
                Data.setServiceDescription("");
            }
            if(!jsonObject.isNull("IdLabel")){
                Data.setIdLabel(jsonObject.getString("IdLabel"));
            }else {
                Data.setIdLabel("");
            }
            if(!jsonObject.isNull("PackagePrice")){
                Data.setPackagePrice(jsonObject.getInt("PackagePrice"));
            }else {
                Data.setPackagePrice(0);
            }
            if(!jsonObject.isNull("EnabledProviders")){
                Data.setEnabledProviders(jsonObject.getString("EnabledProviders"));
            }else {
                Data.setEnabledProviders("");
            }
            if(!jsonObject.isNull("HintText")){
                Data.setHintText(jsonObject.getString("HintText"));
            }else {
                Data.setHintText("");
            }
            if(!jsonObject.isNull("Tags")){
                Data.setTags(jsonObject.getString("Tags"));
            }else {
                Data.setTags("");
            }
            if(!jsonObject.isNull("Details")){
                Data.setDetails(jsonObject.getString("Details"));
            }else {
                Data.setDetails("");
            }
            if(!jsonObject.isNull("KeyboardType")){
                Data.setKeyboardType(jsonObject.getInt("KeyboardType"));
            }else {
                Data.setKeyboardType(0);
            }

            DBUtils.insert_data(data,mContext);
            dataArrayList.add(data);

            Log.e("filterData ","loop "+check + "  "+data.getIconName());

            JSONArray jsonArrayChildObject = jsonObject.getJSONArray("ChildObjects");
            filterData(jsonArrayChildObject,"check2222",delegate);
        }

        delegate.onResponseSuccess(dataArrayList);
        Log.e("filterData ","LIST SIZE "+dataArrayList.size() + " Count "+ count);


        return null;
    }


    public void getAllData(CallBackDataDelegate delegate){
        mClient.getAllData().enqueue(new Callback<JsonArray>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                if (response.code() == 200 ) {
                    try {
                        JSONArray jsonArray = new JSONArray(String.valueOf(response.body()));
                        filterData(jsonArray,"check111",delegate);
                      //  delegate.onResponseSuccess(dataArrayList);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Log.e("getAllData", "SOMETHING WENT WRONG");
                    try {
                        Log.e("getAllData", "response "+response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Log.e("getAllData", "onFailure: " + t);
                delegate.onFailure(t.toString());
            }
        });
    }


}
