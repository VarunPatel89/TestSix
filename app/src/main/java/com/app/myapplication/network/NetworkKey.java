package com.app.myapplication.network;


public interface NetworkKey {

    // error_message
    public static final String ERROR_RESPONSE = "Server is busy, Please try again.";
    public static final String ERROR_UNSUPPORTED_ENCODING_EXCEPTION = "Encoding not supported";
    public static final String ERROR_CONN_TIMEOUT_EXCEPTION = "Connection timeout. Please try again later.";
    public static final String ERROR_CLIENT_PROTOCOL_EXCEPTION = "Client Protocol Exception";
    public static final String ERROR_IO_EXCEPTION = "Connection timeout. Please try again later.";
    public static final String ERROR_JSON_EXCEPTION = "Server is busy, Please try again.";

    public static final String STATUS = "Status";
    public static final String EXPIRED = "Expired";
    public static final String DATA = "Data";
    public static final String MESSAGE = "Message";
    public static final String MESSAGE_PHP = "message";

    //login
    public static final String EMAIL = "Email";
    public static final String WATCH = "Password";


    String AUTHORIZATION = "Authorization";
}
