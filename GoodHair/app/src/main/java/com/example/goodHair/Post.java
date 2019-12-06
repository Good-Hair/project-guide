package com.example.goodHair;

import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.ParseClassName;

@ParseClassName("Post")
public class Post extends ParseObject {
    public static final String KEY_AUTHOR = "author";
    public static final String KEY_VIDEO = "video";
    public static final String KEY_IMAGE = "image";
    public static final String KEY_CAPTION = "caption";
    public static final String KEY_COMMENTSCOUNT = "commentCount";
    public static final String KEY_LIKESCOUNT = "likesCount";
    public static final String KEY_TAG = "tag";
    public static final String KEY_CREATED_AT = "createdAt";
    private static final Number commentCount = 0;
    private static final Number likesCount = 0;

    public Post() {super();}

    public ParseUser getAuthor() {
        return getParseUser(KEY_AUTHOR);
    }
    public void setAuthor(ParseUser author){
        put(KEY_AUTHOR, author);
    }

    public ParseFile getVideo() {
        return getParseFile(KEY_VIDEO);
    }
    public void setVideo(ParseFile video){
        put(KEY_VIDEO, video);
    }

    public ParseFile getImage() {
        return getParseFile(KEY_IMAGE);
    }
    public void setImage(ParseFile image){
        put(KEY_IMAGE, image);
    }

    public String getCaption() {
        return getString(KEY_CAPTION);
    }
    public void setCaption(String caption){
        put(KEY_CAPTION, caption);
    }

    public int getCommentCount() {
        return getInt(KEY_COMMENTSCOUNT);
    }
    public void setCommentCount(int commentCount){ put(KEY_COMMENTSCOUNT, commentCount); }

    public int getLikesCount() {
        return getInt(KEY_LIKESCOUNT);
    }
    public void setLikesCount(int likesCount){
        put(KEY_LIKESCOUNT, likesCount);
    }

    public String getTag() { return getString(KEY_TAG); }
    /*public void setTag(final String tag){

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Tag");
        query.getInBackground(tag);
                put(KEY_TAG, tag);
    }*/
}
