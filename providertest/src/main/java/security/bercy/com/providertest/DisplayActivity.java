package security.bercy.com.providertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

public class DisplayActivity extends AppCompatActivity {

    private static final String TAG = "Book" ;
    private List<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Bundle bundle = getIntent().getExtras();
        bookList = bundle.getParcelableArrayList("myList");

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        BookAdapter adapter = new BookAdapter(bookList);
        recyclerView.setAdapter(adapter);

    }
}
