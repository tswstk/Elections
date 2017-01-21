package pl.pwr.elections;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class MyCandidatRecyclerViewAdapter extends RecyclerView.Adapter<MyCandidatRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<Candidate> mValues;
    private final CandidateFragment.OnListFragmentInteractionListener mListener;

    public MyCandidatRecyclerViewAdapter(ArrayList<Candidate> items, CandidateFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_candidat, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mNameView.setText(String.valueOf(mValues.get(position).name));
        holder.mPositionView.setText(mValues.get(position).position);
        holder.mAvatarView.setImageResource(mValues.get(position).imgId);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mNameView;
        public final TextView mPositionView;
        public final ImageView mAvatarView;
        public Candidate mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mNameView = (TextView) view.findViewById(R.id.name);
            mPositionView = (TextView) view.findViewById(R.id.position);
            mAvatarView = (ImageView) view.findViewById(R.id.avatar);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mPositionView.getText() + "'";
        }
    }
}
