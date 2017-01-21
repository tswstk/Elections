package pl.pwr.elections;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;

public class CandidateFragment extends Fragment {

    private OnListFragmentInteractionListener mListener;
    private ArrayList<Candidate> mCandidates;

    public CandidateFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mCandidates = createCandidates();
    }

    private ArrayList<Candidate> createCandidates() {

        ArrayList<Candidate> candidates = new ArrayList<>();
        candidates.add(new Candidate("Jan Kowalski", "Dziekan", R.drawable.prof1));
        candidates.add(new Candidate("Adam Nowak", "Dziekan", R.drawable.prof1));
        candidates.add(new Candidate("Aneta Kowalczyk", "Dziekan", R.drawable.prof2));
        candidates.add(new Candidate("Marta Lewandowska", "Dziekan", R.drawable.prof2));
        candidates.add(new Candidate("Marcin Wawrzyniak", "Dziekan", R.drawable.prof1));
        candidates.add(new Candidate("Katarzyna Grosicka", "Dziekan", R.drawable.prof2));
        candidates.add(new Candidate("Adrianna Boruc", "Dziekan", R.drawable.prof2));
        candidates.add(new Candidate("Zygmunt Fabiański", "Dziekan", R.drawable.prof1));
        return candidates;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_candidat_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
            recyclerView.setAdapter(new MyCandidatRecyclerViewAdapter(getCandidates(), mListener));
        }

//        Dialog dialog = new AlertDialog.Builder(getActivity())
//                .setView(R.layout.loading_dialog).create();
//        dialog.show();
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public ArrayList<Candidate> getCandidates() {
        return mCandidates;
    }


    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Candidate item);
    }
}
