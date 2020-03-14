package zad4;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Maybe <T> {

    T c;

    public Maybe(T c) {
        super();
        this.c = c;
    }

    public Maybe() {
        super();
    }

    public static <T> Maybe<T> of(T s) {
        return new Maybe<T>(s);
    }

    public void ifPresent(Consumer<T> cons) {
        if(isPresent()){
            cons.accept(c);
        }
    }

    public boolean isPresent() {
        if(c != null){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {

        if(!isPresent()) {

            return "Maybe is empty";
        }else {
            try {
                this.get();
            }catch(NoSuchElementException e) {
                System.out.print(" :maybe is empty");
            }
        }

        return "Maybe has value " + c;
    }
    Exception e;
    public T get() {
        if(!isPresent()){
            throw new NoSuchElementException();
        }
        return c;
    }

    public <R> Maybe<R> map(Function<T, R> func) {
        if(isPresent()){
            R x = func.apply(c);
            return new Maybe<R>(x);
        }
        return new Maybe<R>();
    }

    public T orElse (T defVal) {
        if(isPresent()){
            return c;
        }

        return (T) defVal;
    }

    public Maybe<T> filter(Predicate<T> pred) {
        if(isPresent()) {
            if(pred.test(c)){
                return this;
            }
        }
        return this;
    }


}
