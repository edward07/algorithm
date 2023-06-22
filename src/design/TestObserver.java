package design;

import java.util.Observable;
import java.util.Observer;

public class TestObserver {

    public static void main(String[] args) {
        MyObservable observable = new MyObservable();
        Observer observer = new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                System.out.println("update=====" + o + ",arg = " + arg);
            }
        };

        observable.addObserver(observer);
        observable.change();
        observable.notifyObservers();
    }

}

class MyObservable extends Observable {
    public void change() {
        this.setChanged();
    }
}
