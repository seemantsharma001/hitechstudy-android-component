package com.org.hightechstudy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.org.hightechstudy.adapter.LeaderBoardAdapter;
import com.org.hightechstudy.databinding.ActivityParentBinding;

public class ParentActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityParentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityParentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnDownload.setOnClickListener(this);
        binding.btnRecSecure.setOnClickListener(this);
        binding.btnUpload.setOnClickListener(this);
        binding.btnLeadersBoard.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == binding.btnDownload.getId()) {
            Intent i = new Intent(ParentActivity.this, DownloadActivity.class);
            startActivity(i);
        } else if (view.getId() == binding.btnRecSecure.getId()) {
            Toast.makeText(this, "screen recording disabled", Toast.LENGTH_SHORT).show();
        } else if (view.getId() == binding.btnUpload.getId()) {
            Intent i = new Intent(ParentActivity.this, UploadActivity.class);
            startActivity(i);
        } else if (view.getId() == binding.btnLeadersBoard.getId()) {
            Intent i = new Intent(ParentActivity.this, LeadersBoardActivity.class);
            startActivity(i);
        }
    }
}