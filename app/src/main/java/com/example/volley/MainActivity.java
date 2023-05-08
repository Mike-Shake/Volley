package com.example.volley;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    TextView textView;
    ImageView imageView;
    NetworkImageView networkImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn);
        //textView=findViewById(R.id.textView);
        //imageView = findViewById(R.id.textView);
        networkImageView=findViewById(R.id.net_imageview);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn) {
            RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());

            ImageLoader imageLoader=new ImageLoader(mQueue,new BitmapCache());
            networkImageView.setDefaultImageResId(R.drawable.icon_513);
            networkImageView.setErrorImageResId(R.drawable.icon_102);
            networkImageView.setImageUrl("https://images.unsplash.com/photo-1680208281019-8642d20405f9?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwzNjAzNTV8MHwxfGFsbHwxOXx8fHx8fDJ8fDE2ODAyNjIyNzQ&ixlib=rb-4.0.3&q=80&w=1080);,%20rgba(255,%20255,%20255,%201)",imageLoader);




            /**ImageLoader 的 用法

//            ImageLoader imageLoader=new ImageLoader(mQueue, new ImageLoader.ImageCache() {
//                @Nullable
//                @Override
//                public Bitmap getBitmap(String url) {
//                    return null;
//                }
//
//                @Override
//                public void putBitmap(String url, Bitmap bitmap) {
//
//                }
//            });
            ImageLoader imageLoader=new ImageLoader(mQueue,new BitmapCache());
            ImageLoader.ImageListener listener = ImageLoader.getImageListener(imageView,
                    R.drawable.icon_513, R.drawable.icon_102);
            //第一个参数url地址，第二个参数ImageListener对象
            imageLoader.get("https://images.unsplash.com/photo-1680208281019-8642d20405f9?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwzNjAzNTV8MHwxfGFsbHwxOXx8fHx8fDJ8fDE2ODAyNjIyNzQ&ixlib=rb-4.0.3&q=80&w=1080);,%20rgba(255,%20255,%20255,%201)", listener);
             *
             */


            /**ImageRequest 的 用法
            ImageRequest imageRequest = new ImageRequest(
                    "https://images.unsplash.com/photo-1680208281019-8642d20405f9?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=MnwzNjAzNTV8MHwxfGFsbHwxOXx8fHx8fDJ8fDE2ODAyNjIyNzQ&ixlib=rb-4.0.3&q=80&w=1080);,%20rgba(255,%20255,%20255,%201)", new Response.Listener<Bitmap>() {
                @Override
                public void onResponse(Bitmap response) {
                    Log.d("gao", "onResponse: yes");
                    imageView.setImageBitmap(response);
                }
            }, 0, 0, Bitmap.Config.RGB_565, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("gao", "onErrorResponse: " + error.getMessage(), error);
                    imageView.setImageResource(R.drawable.icon_513);
                }
            });
            mQueue.add(imageRequest);
             *
             */

            /** JsonRequest 的 用法
             JsonObjectRequest jsonObjectRequest=new JsonObjectRequest("https://zj.v.api.aa1.cn/api/wenan-gaoxiao/?type=json", null, new Response.Listener<JSONObject>() {
            @Override public void onResponse(JSONObject response) {
            bean beans=new Gson().fromJson(response.toString(),bean.class);
            String s ;
            if(beans!=null){
            s=beans.getMsg();
            Log.d("gao", "hh:"+s);
            runOnUiThread(new Runnable() {
            @Override public void run() {
            textView.setText(s);
            }
            });
            }
            }
            }, new Response.ErrorListener() {
            @Override public void onErrorResponse(VolleyError error) {
            Log.e("gao", error.getMessage(),error);
            }
            });
             //添加到队列
             mQueue.add(jsonObjectRequest);
             */


            /**
             * StringQueue 的 使用

             StringRequest stringRequest=new StringRequest(Request.Method.GET, "https://www.baidu.com",
             new Response.Listener<String>() {
            @Override public void onResponse(String response) {
            Log.d("gao", response);
            runOnUiThread(new Runnable() {
            @Override public void run() {
            textView.setText(response);
            }
            });
            }
            }, new Response.ErrorListener() {
            @Override public void onErrorResponse(VolleyError error) {
            Log.e("gao", error.getMessage(),error);
            }
            });
             //添加请求
             mQueue.add(stringRequest);
             */

        }
    }
}