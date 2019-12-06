package com.example.goodHair.fragments;

import android.util.Log;

import com.example.goodHair.Post;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

public class ProfileFragment extends FeedFragment {
    @Override
    protected void queryPosts() {

        ParseQuery<Post> postQuery = new ParseQuery<Post>(Post.class);
        postQuery.include(Post.KEY_AUTHOR);
        postQuery.setLimit(20);
        postQuery.whereEqualTo(Post.KEY_AUTHOR, ParseUser.getCurrentUser());
        postQuery.addDescendingOrder(Post.KEY_CREATED_AT);
        postQuery.findInBackground(new FindCallback<Post>() {
            @Override
            public void done(List<Post> posts, ParseException e) {
                if (e != null){
                    Log.e(ERROR, "Error with Query");
                    e.printStackTrace();
                    return;
                }
                mPosts.addAll(posts);
                adapter.notifyDataSetChanged();
                for (int i=0; i<posts.size(); i++) {
                    Post post = posts.get(i);
                    Log.d(POST, "Post: " + post.getCaption() + ", Username: " + post.getAuthor().getUsername());
                }
            }
        });
    }
}
