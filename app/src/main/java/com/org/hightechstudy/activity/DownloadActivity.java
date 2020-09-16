package com.org.hightechstudy.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.Volley;
import com.org.hightechstudy.R;
import com.org.hightechstudy.utility.DownloadVideoRequest;

import java.io.File;
import java.io.FileOutputStream;

public class DownloadActivity extends AppCompatActivity {

    private VideoView videoView;

    String mUrl= "https://file-examples-com.github.io/uploads/2017/04/file_example_MP4_1920_18MG.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        videoView = findViewById(R.id.videoView);
        findViewById(R.id.btnDownload).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                download();
            }
        });
        findViewById(R.id.btnPlay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playVideo();
            }
        });

    }

    private void download() {
        DownloadVideoRequest request = new DownloadVideoRequest(Request.Method.GET, mUrl, new Response.Listener<byte[]>() {
            @Override
            public void onResponse(byte[] response) {
                try {
                    if (response!=null) {

                        FileOutputStream outputStream;
                        String name="testFile.mp4";
                        outputStream = openFileOutput(name, Context.MODE_PRIVATE);
                        outputStream.write(response);
                        outputStream.close();
                        Toast.makeText(DownloadActivity.this, "Download complete.", Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    Log.d("KEY_ERROR", "UNABLE TO DOWNLOAD FILE");
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        },null);

        RequestQueue mRequestQueue = Volley.newRequestQueue(getApplicationContext(), new HurlStack());
        mRequestQueue.add(request);
    }

    private void playVideo() {
        try {

            Uri mUri = FileProvider.getUriForFile(this,"com.org.hightechstudy.fileprovider",new File(getFilesDir()+"/testFile.mp4"));
            videoView.setVideoURI(mUri);
            videoView.start();
//            Intent sendIntent = new Intent(Intent.ACTION_SEND);
//            sendIntent.putExtra(Intent.EXTRA_STREAM, mUri);
//            sendIntent.setType("video/mp4");
//            sendIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//            startActivity(sendIntent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}