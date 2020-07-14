package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CC {
    public static void main(String[] args) {
        /*Feed f = new Feed();
        f.registerObserver(new NyTimes());
        f.registerObserver(new Guardian());
        f.notifyObservert("The queen said her favourite book is Java 8 in Action!");*/
        ConcurrentHashMap<String, String > syncMap = new ConcurrentHashMap<String, String >();
    }

    interface Observer{
        void notify(String tweet);
    }


    static class NyTimes implements Observer{

        @Override
        public void notify(String tweet) {
            if(tweet!=null && tweet.contains("money")){
                System.out.printf("Breaking news in NY!" + tweet);
            }
        }
    }

    static class Guardian implements Observer{

        @Override
        public void notify(String tweet) {
            if(tweet!=null && tweet.contains("queen")){
                System.out.printf("Yet another news in London... " + tweet);
            }
        }
    }

    interface Subject{
        void registerObserver(Observer o);
        void notifyObservert(String tweet);
    }

    static class Feed implements Subject{
        private final List<Observer> observers = new ArrayList<>();
        @Override
        public void registerObserver(Observer o) {
            this.observers.add(o);
        }

        @Override
        public void notifyObservert(String tweet) {
            observers.forEach(o -> o.notify(tweet));
        }
    }
}
