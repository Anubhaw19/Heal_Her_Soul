package com.example.healhersoul;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class adapter_faq extends RecyclerView.Adapter<adapter_faq.ViewHolderClass> {

    ArrayList<String> user;
    ArrayList<String> message;
    String currentUsername;
    private static final int VIEW_TYPE_MESSAGE_SENT = 1;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;

    public adapter_faq(ArrayList<String> user, ArrayList<String> message,String currentUsername) {
        this.user = user;
        this.message = message;
        this.currentUsername=currentUsername;
    }

    @Override
    public int getItemViewType(int position) {
        Log.d("MyTag",currentUsername+"     "+user.get(position));
        if (user.get(position).equals(currentUsername)){
            Log.d("MyTag", "Current USER TRUE ");
            return VIEW_TYPE_MESSAGE_SENT;
        }
        else{
            Log.d("MyTag", "Current USER False ");
            return VIEW_TYPE_MESSAGE_RECEIVED;
        }
    }

    @NonNull
    @Override
    public ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//execution order 2
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;

        if (viewType==VIEW_TYPE_MESSAGE_SENT){
            view = inflater.inflate(R.layout.list_item_msg_send, parent, false);
        }
        else{
            view = inflater.inflate(R.layout.list_item_message_recv, parent, false);
        }

        return new ViewHolderClass(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position) {//execution order 4
        String content_user = user.get(position);
        String content_message = message.get(position);
//        holder.textView_username.setText(content_user);
        holder.textView_message.setText(content_message);

    }

    @Override
    public int getItemCount() {//execution order 1
        //Log.d("MyTag", "getItemCount: ");

        return user.size();
    }

    protected class ViewHolderClass extends RecyclerView.ViewHolder {
        TextView textView_message;
        TextView textView_username;

        public ViewHolderClass(@NonNull View itemView) {//execution order 3
            super(itemView);
            //Log.d("MyTag", "ProgramingViewHolder: ");
//            textView_username = itemView.findViewById(R.id.message_user);
            textView_message = itemView.findViewById(R.id.text_message);
        }

    }


}
