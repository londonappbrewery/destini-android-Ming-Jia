package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mButtonTop;
    private Button mButtonBottom;
    Story[] storyBoard;
    int mCurrentStoryIndex;
    boolean mT3Story;
    boolean mT2Story;
    boolean start;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);
        mCurrentStoryIndex = 1;

        mT2Story = false;
        mT3Story = false;
        start = true;

        storyBoard = new Story[] {
                new Story(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
                new Story(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
                new Story(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
        };


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateStory(1);
                Log.i("Button Top", "It works" + mCurrentStoryIndex);
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateStory(2);
                Log.i("Button Bottom", "It works" + mCurrentStoryIndex);
            }
        });

    }

    public void updateStory(int n){
        mCurrentStoryIndex = mCurrentStoryIndex + n;

        if (mT3Story){
            if (mCurrentStoryIndex == 3){
                mStoryTextView.setText(R.string.T6_End);
            } else {
                mStoryTextView.setText(R.string.T5_End);
            }
            mButtonTop.setVisibility(View.INVISIBLE);
            mButtonBottom.setVisibility(View.INVISIBLE);
        }

        if (mT2Story){
            if (mCurrentStoryIndex == 4){
                mStoryTextView.setText(R.string.T3_Story);
                mButtonTop.setText(R.string.T3_Ans1);
                mButtonBottom.setText(R.string.T3_Ans2);
                mT3Story = true;
            } else{
                if (mCurrentStoryIndex == 5 && mT3Story) {
                    mStoryTextView.setText(R.string.T6_End);
                } else if (mCurrentStoryIndex == 6){
                    mStoryTextView.setText(R.string.T5_End);
                } else if (mCurrentStoryIndex == 5){
                    mStoryTextView.setText(R.string.T4_End);
                }
                mButtonTop.setVisibility(View.INVISIBLE);
                mButtonBottom.setVisibility(View.INVISIBLE);
            }
        }

        if (start){
            if (mCurrentStoryIndex == 2){
                mT3Story = true;
                mStoryTextView.setText(R.string.T3_Story);
                mButtonTop.setText(R.string.T3_Ans1);
                mButtonBottom.setText(R.string.T3_Ans2);
            } else if (mCurrentStoryIndex == 3){
                mT2Story = true;
                mStoryTextView.setText(R.string.T2_Story);
                mButtonTop.setText(R.string.T2_Ans1);
                mButtonBottom.setText(R.string.T2_Ans2);
            }
            start = false;
        }

    }
}
