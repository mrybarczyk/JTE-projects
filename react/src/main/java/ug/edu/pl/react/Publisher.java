package ug.edu.pl.react;

public interface Publisher<T>
{
    public void subscribe(Subscriber<? super T> s);
}