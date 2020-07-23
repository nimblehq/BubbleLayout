package com.daasuu.bubblelayout;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;

import com.daasuu.bl.ArrowDirection;
import com.daasuu.bl.BubbleLayout;
import com.daasuu.bl.BubblePopupHelper;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.btn_popup);

        final BubbleLayout bubbleLayout = findViewById(R.id.bubbleLayout);
        bubbleLayout.measure(0, 0);
        final int bubbleWidth = bubbleLayout.getMeasuredWidth();
        ((LinearLayout) findViewById(R.id.root)).removeView(bubbleLayout);

        popupWindow = BubblePopupHelper.create(this, bubbleLayout);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bubbleLayout.setArrowPosition(button.getWidth() / 2f);
                popupWindow.showAsDropDown(button, button.getWidth() - bubbleWidth, 0);
            }
        });

    }

}
