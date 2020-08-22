package com.org.hightechstudy;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;

public class ParentActivity extends Activity {


    public void onCreate(@Nullable Bundle savedInstanceState,int layout) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(layout);
    }
}
