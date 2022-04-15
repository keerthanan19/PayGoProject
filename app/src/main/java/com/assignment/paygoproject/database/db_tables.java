package com.assignment.paygoproject.database;

public class db_tables {

    static final String TABLE_NAME_DATA = "Data";

    public  static final  String DATA_ID                = "_id";
    static  final  String DATA_NODE_ID                  = "node_nd";
    static  final  String DATA_PARENT_ID                = "parent_id";
    static  final  String DATA_UID_OBJECT_ID            = "ui_object_id";
    static  final  String DATA_SERVICE_ID               = "service_id";
    static  final  String DATA_BACKGROUND               = "background";
    static  final  String DATA_CLASS_NAME               = "class_name";
    static  final  String DATA_ICON_NAME                = "icon_name";
    static  final  String DATA_ROW_NUMBER               = "row_number";
    static  final  String DATA_SERVICE_NAME             = "service_name";
    static  final  String DATA_VENDOR_ID                = "vendor_id";
    static  final  String DATA_IS_SERVICE_ACTIVE        = "is_service_active";
    static  final  String DATA_PKG_ID                   = "pkg_id";
    static  final  String DATA_PLACE_HOLDER             = "place_holder";
    static  final  String DATA_REG_EXP                  = "reg_exp";
    static  final  String DATA_CONTRACT_TYPE_ID         = "contract_type_id";
    static  final  String DATA_ORDER_INDEX              = "order_index";
    static  final  String DATA_PAY_CHECK_TEMPLATE       = "pay_check_template";
    static  final  String DATA_CHILD_COLUMNS_COUNT      = "_child_columns_count";
    static  final  String DATA_SERVICE_DESCRIPTION      = "service_description";
    static  final  String DATA_ID_LABEL                 = "id_label";
    static  final  String DATA_PACKAGE_PRICE            = "package_price";
    static  final  String DATA_ENABLED_PROVIDERS        = "enabled_providers";
    static  final  String DATA_HINT_TEXT                = "hint_text";
    static  final  String DATA_TAGS                     = "tags";
    static  final  String DATA_DETAILS                  = "details";
    static  final  String DATA_KEYBOARD_TYPE            = "keyboard_type";

    static final String CREATE_TABLE_DATA = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME_DATA
            + " ( " +
            DATA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            DATA_NODE_ID + " INTEGER, " +
            DATA_PARENT_ID + " INTEGER, " +
            DATA_UID_OBJECT_ID + " INTEGER, " +
            DATA_SERVICE_ID + " INTEGER, " +
            DATA_BACKGROUND + " TEXT, " +
            DATA_CLASS_NAME + " TEXT, " +
            DATA_ICON_NAME + " TEXT, " +
            DATA_ROW_NUMBER + " INTEGER, " +
            DATA_SERVICE_NAME + " TEXT, " +
            DATA_VENDOR_ID + " INTEGER, " +
            DATA_IS_SERVICE_ACTIVE + " TEXT, " +
            DATA_PKG_ID + " INTEGER, " +
            DATA_PLACE_HOLDER + " TEXT, " +
            DATA_REG_EXP + " TEXT, " +
            DATA_CONTRACT_TYPE_ID + " INTEGER, " +
            DATA_ORDER_INDEX + " INTEGER, " +
            DATA_PAY_CHECK_TEMPLATE + " TEXT, " +
            DATA_CHILD_COLUMNS_COUNT + " INTEGER, " +
            DATA_SERVICE_DESCRIPTION + " TEXT, " +
            DATA_ID_LABEL + " TEX, " +
            DATA_PACKAGE_PRICE + " INTEGER, " +
            DATA_ENABLED_PROVIDERS + " TEXT, " +
            DATA_HINT_TEXT + " TEXT, " +
            DATA_TAGS + " TEXT, " +
            DATA_DETAILS + " TEXT, " +
            DATA_KEYBOARD_TYPE + " INTEGER" +
            ");";


}
