package com.londonappbrewery.destini;

public class Story {
    private int mStoryBoard;
    private int mTopAns;
    private int mBottomAns;

    public Story(int storyBoard, int topAns, int bottomAns){
        mStoryBoard = storyBoard;
        mTopAns = topAns;
        mBottomAns = bottomAns;
    }

    public int getStoryBoard() {
        return mStoryBoard;
    }

    public void setStoryBoard(int storyBoard) {
        mStoryBoard = storyBoard;
    }

    public int getTopAns() {
        return mTopAns;
    }

    public void setTopAns(int topAns) {
        mTopAns = topAns;
    }

    public int getBottomAns() {
        return mBottomAns;
    }

    public void setBottomAns(int bottomAns) {
        mBottomAns = bottomAns;
    }
}
