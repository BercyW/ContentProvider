package security.bercy.com.week5day3contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

public class MyContentProvider extends ContentProvider {

    private static final String TAG = MyContentProvider.class.getSimpleName();
     MyDatabaseHelper dbHelper;
    static UriMatcher uriMatcher;
    public static final String AUTHORITY = "security.bercy.com.week5day3contentprovider";

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY,"book",1);

    }

    public MyContentProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
       return "vnd.android.cursor.dir/vnd.security.bercy.com.week5day3contentprovider.book";
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public boolean onCreate() {
      dbHelper = new MyDatabaseHelper(getContext(),"BookStore.db",null,2);
       return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        Cursor cursor = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Log.d(TAG, "query: " + uri);
        switch (uriMatcher.match(uri)) {
            case 1:

            cursor = db.query("Book",projection,selection,selectionArgs,null,null,sortOrder);
            break;
        }


        return cursor;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
