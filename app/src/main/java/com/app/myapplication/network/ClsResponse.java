package com.app.myapplication.network;


import java.util.HashMap;

public class ClsResponse {

    private String url;
    private String request;
    private String resultString;
    private int requestCode;
    private int responseCode;
    private boolean success;
    private boolean networkConneted;
    private Object object;
    private String dispMessage;
    private HashMap<String, String> dispMsgHashMap = new HashMap<>();
    private long pkId = -1;
    private String filePath;
    private String filePathKey;
    private boolean isUnAuthorize = false;
    private boolean isServerMaintenance = false;

    public boolean isUnAuthorize() {
        return isUnAuthorize;
    }

    public void setUnAuthorize(boolean unAuthorize) {
        isUnAuthorize = unAuthorize;
    }

    public boolean isServerMaintenance() {
        return isServerMaintenance;
    }

    public void setServerMaintenance(boolean serverMaintenance) {
        isServerMaintenance = serverMaintenance;
    }

    public void setResultString(String resultString) {
        this.resultString = resultString;
    }

    public String getResultString() {
        return resultString;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(int requestCode) {
        this.requestCode = requestCode;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getDispMessage() {
        return dispMessage;
    }

    public void setDispMessage(String dispMessage) {
        this.dispMessage = dispMessage;
    }

    public boolean isNetworkConneted() {
        return networkConneted;
    }

    public void setNetworkConneted(boolean networkConneted) {
        this.networkConneted = networkConneted;
    }

    public long getPkId() {
        return pkId;
    }

    public void setPkId(long pkId) {
        this.pkId = pkId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }


    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePathKey() {
        return filePathKey;
    }

    public void setFilePathKey(String filePathKey) {
        this.filePathKey = filePathKey;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public HashMap<String, String> getDispMsgHashMap() {
        return dispMsgHashMap;
    }

    public void setDispMsgHashMap(HashMap<String, String> errorMsgHashMap) {
        this.dispMsgHashMap = errorMsgHashMap;
    }
}
