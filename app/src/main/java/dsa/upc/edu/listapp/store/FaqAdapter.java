package dsa.upc.edu.listapp.store;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dsa.upc.edu.listapp.R;

public class FaqAdapter extends RecyclerView.Adapter<FaqAdapter.FaqViewHolder> {

    private List<Faq> faqs;

    public FaqAdapter(List<Faq> faqs) {
        this.faqs = faqs;
    }

    @NonNull
    @Override
    public FaqViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_faq, parent, false);
        return new FaqViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FaqViewHolder holder, int position) {
        Faq faq = faqs.get(position);
        holder.tvQuestion.setText(faq.getQuestion());
        holder.tvAnswer.setText(faq.getAnswer());
        holder.tvSenderDate.setText(faq.getSender() + " · " + faq.getDate());
    }

    @Override
    public int getItemCount() {
        return faqs.size();
    }

    public static class FaqViewHolder extends RecyclerView.ViewHolder {
        TextView tvQuestion, tvAnswer, tvSenderDate;

        public FaqViewHolder(@NonNull View itemView) {
            super(itemView);
            tvQuestion = itemView.findViewById(R.id.tvQuestion);
            tvAnswer = itemView.findViewById(R.id.tvAnswer);
            tvSenderDate = itemView.findViewById(R.id.tvSenderDate);
        }
    }
}
