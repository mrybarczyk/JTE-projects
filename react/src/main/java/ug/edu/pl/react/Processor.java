package ug.edu.pl.react;

public interface Processor<T, R> extends Subscriber<T>, Publisher<R>
{
}