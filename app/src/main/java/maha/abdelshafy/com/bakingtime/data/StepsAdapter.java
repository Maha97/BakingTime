package maha.abdelshafy.com.bakingtime.data;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import maha.abdelshafy.com.bakingtime.R;
import maha.abdelshafy.com.bakingtime.extras.Step;

/**
 * Created by 007 on 17/07/2017.
 */
public class StepsAdapter extends RecyclerView.Adapter<StepsAdapter.ViewHolder> {

    private ArrayList<Step> stepsArrayList;
    private StepClickHandler stepsOnClickListener;

    public StepsAdapter(ArrayList<Step> stepsArrayList, StepClickHandler stepsOnClickListener) {
        this.stepsArrayList = stepsArrayList;
        this.stepsOnClickListener = stepsOnClickListener;
    }

    @Override
    public StepsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.step_card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return stepsArrayList.size();
    }

    public interface StepClickHandler {
        void onStepClickHandler(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView stepShortDescription;

        public ViewHolder(View view) {
            super(view);
            stepShortDescription = (TextView) view.findViewById(R.id.step_short_description);
            stepShortDescription.setOnClickListener(this);
        }

        public void bind(int position) {
            stepShortDescription.setText(stepsArrayList.get(position).getShortDescription());
        }

        @Override
        public void onClick(View v) {
            stepsOnClickListener.onStepClickHandler(getAdapterPosition());
            Log.v("Steps Adapter", "Clicked");
        }
    }
}
