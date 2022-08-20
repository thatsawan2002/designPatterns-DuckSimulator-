package adapter;

import designPatterns.Goose;
import designPatterns.Quackable;
public class GooseAdapter implements Quackable {

    private Goose goose;

    public GooseAdapter(Goose goose){
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }
}
