package dsa.upc.edu.listapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dsa.upc.edu.listapp.auth.ApiClient;
import dsa.upc.edu.listapp.store.StoreAPI;
import dsa.upc.edu.listapp.store.Faq;
import dsa.upc.edu.listapp.store.FaqAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FaqsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FaqAdapter adapter;
    private List<Faq> faqs = new ArrayList<>();
    private ProgressBar progressBar;
    private StoreAPI api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs);

        recyclerView = findViewById(R.id.recyclerViewFaqs);
        progressBar = findViewById(R.id.progressBarFaqs);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FaqAdapter(faqs);
        recyclerView.setAdapter(adapter);

        api = ApiClient.getClient(this).create(StoreAPI.class);
        cargarFaqs();
    }

    private void cargarFaqs() {
        progressBar.setVisibility(View.VISIBLE);
        api.getFaqs().enqueue(new Callback<List<Faq>>() {
            @Override
            public void onResponse(Call<List<Faq>> call, Response<List<Faq>> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    faqs.clear();
                    faqs.addAll(response.body());
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(FaqsActivity.this, "Error al cargar FAQs", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Faq>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(FaqsActivity.this, "Error de red", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
