package com.awwhome.contentproviderdemo;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {


        // cotent:// 访问内容提供者的协议
        Uri uri = Uri.parse("content://com.awwhome.contentproviderdemo/query");

        // 第一个参数，访问内容提供者的uri
        // 第二个参数，要查询的字段
        // 第三个参数，查询条件
        // 第四个参数，查询参数
        // 第五个参数，排序
        Cursor cursor = getContentResolver().query(uri, new String[]{"name", "age"}, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(0);
                String age = cursor.getString(1);
                Log.d(TAG, "click: 查询到的内容提供者提供的数据为：name:" + name + ",age:" + age);
            }

        }
    }
}
