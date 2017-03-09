package com.awwhome.contentproviderdemo.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * 内容提供者
 * Created by awwho on 2017/3/9.
 */
public class ContentProviderTest extends ContentProvider {

    private static final String TAG = "ContentProviderTest";

    // 定义一个uri匹配器
    private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    private static final int QUERYSCCESS = 0;

    // 静态代码块，类被创建的时候就执行
    static {

        // 第一个参数，和清单文件里配置的一样  android:authorities="com.awwhome.contentproviderdemo"
        // 第二个参数，访问的路径
        // 第三个参数，匹配码
        // 其他进程的应用访问该方法时的uri地址为：com.awwhome.contentproviderdemo/query
        sURIMatcher.addURI("com.awwhome.contentproviderdemo", "query", QUERYSCCESS);

    }

    private MySQLiteOpenHelper mySQLiteOpenHelper;

    // 当内容提供者初始化执行此方法
    @Override
    public boolean onCreate() {

        // 实例化MySQLiteOpenHelper对象
        mySQLiteOpenHelper = new MySQLiteOpenHelper(getContext());

        return false;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    /**
     * 定义一个自己的数据库操作类
     */
    class MySQLiteOpenHelper extends SQLiteOpenHelper {

        // SQLiteOpenHelper默认没有构造方法
        public MySQLiteOpenHelper(Context context) {
            super(context, "providerdemo.db", null, 1);
        }

        // 此方法做表结构的初始化
        @Override
        public void onCreate(SQLiteDatabase db) {

            getReadableDatabase();

            db.execSQL("");


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}
