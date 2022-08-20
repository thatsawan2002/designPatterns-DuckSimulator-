package composite;

import designPatterns.Quackable;

import java.util.ArrayList;

public class Flock implements Quackable {
    ArrayList<Quackable> quackers = new ArrayList<>();

    public Flock(){
        quackers = new ArrayList<>();
    }

    public void add(Quackable quacker) {
        quackers.add(quacker);
    }
    @Override
    public void quack() {
        for(Quackable duck : quackers){
            duck.quack();
        }
    }
}
