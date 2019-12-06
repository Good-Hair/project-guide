package com.example.goodHair;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder>{

    private Context context;
    private List<Post> posts;

    public PostsAdapter(Context context, List<Post> posts){
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvAuthor;
        private TextView tvCaption;
        private ImageView ivImage;
        private ImageButton btn_Like;
        private ImageButton btn_Comment;
        private TextView cnt_comment;
        private TextView cnt_like;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvCaption = itemView.findViewById(R.id.tvCaption);
            ivImage = itemView.findViewById(R.id.ivImage);
            btn_Like = itemView.findViewById(R.id.btn_Like);
            btn_Comment = itemView.findViewById(R.id.btn_Comment);
            cnt_comment = itemView.findViewById(R.id.cnt_comment);
            cnt_like = itemView.findViewById(R.id.cnt_like);

            btn_Like.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

            btn_Comment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });

        }

        public void bind(Post post){

            tvAuthor.setText(post.getAuthor().getUsername());
            tvCaption.setText(post.getCaption());
            ParseFile image = post.getImage();
            if(image != null){
                Glide.with(context).load(image.getUrl()).into(ivImage);
            }
            //Log.d("COMMENT", "Comments: " + post.getCommentCount());
            cnt_like.setText(String.valueOf(post.getLikesCount()));
            cnt_comment.setText(String.valueOf(post.getCommentCount()));



        }

        public void updateLikes(Post post){
            int likeCount = post.getLikesCount();
            likeCount++;
            post.setLikesCount(likeCount);
        }
        public void updateComment(Post post){
            int commentCount = post.getCommentCount();
            commentCount++;
            post.setLikesCount(commentCount);
        }

    }
}
