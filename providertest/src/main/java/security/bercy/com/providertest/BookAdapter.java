package security.bercy.com.providertest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Bercy on 1/4/18.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder>  {
    private List<Book> myBookList;
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_showItem;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_showItem = itemView.findViewById(R.id.tv_showItem);

        }
    }

    public BookAdapter(List<Book> myBookList) {
        this.myBookList = myBookList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Book book = myBookList.get(position);
        holder.tv_showItem.setText(String.format("%s,%s,%s,%s", book.getName(), book.getAuthor(), String.valueOf(book.getPages()), String.valueOf(book.getPrice())));

    }

    @Override
    public int getItemCount() {
        return myBookList.size();
    }


}
