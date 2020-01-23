package ug.edu.pl.react;

public interface Subscription<T>
{
    public void request(long n);
    public void cancel();
}