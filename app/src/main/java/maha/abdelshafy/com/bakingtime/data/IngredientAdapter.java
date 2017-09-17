package maha.abdelshafy.com.bakingtime.data;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import maha.abdelshafy.com.bakingtime.R;
import maha.abdelshafy.com.bakingtime.extras.Ingredient;

/**
 * Created by 007 on 17/07/2017.
 */
public class IngredientAdapter extends RecyclerView.Adapter<IngredientAdapter.ViewHolder> {
    private final ArrayList<Ingredient> ingredientArrayList;

    public IngredientAdapter(ArrayList<Ingredient> ingredientArrayList) {
        this.ingredientArrayList = ingredientArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.ingredient_card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.ingredientName.setText(ingredientArrayList.get(position).getIngredients());
        String measure = ingredientArrayList.get(position).getQuantity() + "    " + ingredientArrayList.get(position).getMeasure();
        holder.ingredient_quantity_measure.setText(measure);
    }

    @Override
    public int getItemCount() {
        return ingredientArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView ingredientName;
        final TextView ingredient_quantity_measure;

        public ViewHolder(View view) {
            super(view);
            ingredientName = (TextView) view.findViewById(R.id.ingredient_name);
            ingredient_quantity_measure = (TextView) view.findViewById(R.id.ingredient_quantity);

        }

//        public void bind(int position) {
//            ingredientName.setText(ingredientArrayList.get(position).getIngredients());
//            String measure = ingredientArrayList.get(position).getQuantity()+ "    "+ ingredientArrayList.get(position).getMeasure();
//
//            ingredient_quantity_measure.setText(measure);
//        }
    }
}
