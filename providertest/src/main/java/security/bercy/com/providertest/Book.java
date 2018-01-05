package security.bercy.com.providertest;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Bercy on 1/4/18.
 */

public class Book implements Parcelable{

    String name;
    String author;
    int pages;
    double price;

    public Book(String name, String author, int pages, double price) {
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.price = price;
    }

    public Book() {

    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", pages=" + pages +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(author);
        parcel.writeInt(pages);
        parcel.writeDouble(price);
    }
    public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {

        @Override
        public Book createFromParcel(Parcel parcel) {
            Book book = new Book();
            book.name = parcel.readString();
            book.author = parcel.readString();
            book.pages = parcel.readInt();
            book.price = parcel.readDouble();
            return book;
        }

        @Override
        public Book[] newArray(int i) {
            return new Book[i];
        }
    };
}
