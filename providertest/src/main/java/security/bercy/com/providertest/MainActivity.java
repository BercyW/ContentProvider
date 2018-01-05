package security.bercy.com.providertest;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    List<Book> bookList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button queryButton = findViewById(R.id.btn_query_data);

        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri uri = Uri.parse("content://security.bercy.com.week5day3contentprovider/book");
                Cursor cursor = getContentResolver().query(uri,null,null,null,null);
                Log.d(TAG, "onClick: "+cursor);
                if(cursor!=null) {
                    while(cursor.moveToNext()) {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Book book = new Book(name,author,pages,price);
                        bookList.add(book);



                    }
                }
                Intent intent = new Intent(MainActivity.this,DisplayActivity.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("myList", (ArrayList<? extends Parcelable>) bookList);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}
