package com.example.goodHair.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goodHair.Post;
import com.example.goodHair.PostsAdapter;
import com.example.goodHair.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

public class FeedFragment extends Fragment {

    private RecyclerView rviewPosts;
    protected final String POST = "Post Fragment";
    protected final String ERROR = "ERROR";
    protected PostsAdapter adapter;
    protected List<Post> mPosts;

    // The onCreateView method is called when Fragment should create its View object hierarchy,
    // either dynamically or via XML layout inflation.
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_feed, container, false);

    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        rviewPosts = view.findViewById(R.id.rviewPosts);


        //create data source
        mPosts = new ArrayList<>();
        //create adapter
        adapter = new PostsAdapter(getContext(), mPosts);
        //set adapter on the recycler view
        rviewPosts.setAdapter(adapter);
        //set the layout manger on the recycler view
        rviewPosts.setLayoutManager(new LinearLayoutManager(getContext()));

        queryPosts();
    }

    protected void queryPosts() {

        ParseQuery<Post> postQuery = new ParseQuery<Post>(Post.class);
        postQuery.include(Post.KEY_AUTHOR);
        postQuery.setLimit(20);
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
