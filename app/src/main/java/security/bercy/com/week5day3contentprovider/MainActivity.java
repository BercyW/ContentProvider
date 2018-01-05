package security.bercy.com.week5day3contentprovider;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDatabaseHelper = new MyDatabaseHelper(this,"BookStore.db",null,1);
        Button createDatabase = findViewById(R.id.btn_create_table);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDatabaseHelper.getWritableDatabase();
            }
        });

        Button addData = findViewById(R.id.btn_add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                for (int i = 0; i < 20 ; i++) {
                    contentValues.put("name","English Book "+i);
                    contentValues.put("author","Dan Brown "+i);
                    contentValues.put("pages","454 "+i);
                    contentValues.put("price","14.98 "+i);
                    db.insert("Book",null,contentValues);
                    contentValues.clear();
                }

            }
        });

    }
}
