package t.test.justrecycle;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> mTextList = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> mTextList, Context mContext) {
        this.mTextList = mTextList;
        this.mContext = mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        RecyclerView.ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        ((ViewHolder)holder).textView.setText(mTextList.get(position));
        ((ViewHolder)holder).parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked " + mTextList.get(position));
                Toast.makeText(mContext, mTextList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTextList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ConstraintLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textview);
            parentLayout = itemView.findViewById(R.id.parentlayout);
        }
    }
}
