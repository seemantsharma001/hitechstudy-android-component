package com.org.hightechstudy.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import com.org.hightechstudy.R;
import com.org.hightechstudy.adapter.LeaderBoardAdapter;

public class LeadersBoardActivity extends AppCompatActivity {

    private RecyclerView rvBoard;
    private LeaderBoardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaders_board);
        rvBoard = findViewById(R.id.rvList);
        rvBoard.setLayoutManager(new LinearLayoutManager(this));
        rvBoard.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                outRect.top = 18;
                outRect.bottom = 18;
            }
        });
        rvBoard.setHasFixedSize(true);
        adapter = new LeaderBoardAdapter(this);
        rvBoard.setAdapter(adapter);
    }
}