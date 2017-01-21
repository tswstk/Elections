package pl.pwr.elections;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements CandidateFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListFragmentInteraction(Candidate item) {
        Intent intent = new Intent(this, CandidateActivity.class);
        intent.putExtra("item", item);
        startActivity(intent);
    }
}
