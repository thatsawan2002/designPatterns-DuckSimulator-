import abstractFactory.AbstractDuckFactory;
import abstractFactory.CountAndEchoDuckFactory;
import abstractFactory.CountingDuckFactory;
import abstractFactory.DuckFactory;
import adapter.GooseAdapter;
import adapter.PigeonAdapter;
import composite.Flock;
import composite.LeaderFlock;
import decorator.QuackCounter;
import decorator.QuackEcho;
import designPatterns.*;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();
//        simulator.simulate(new DuckFactory());
//        simulator.simulateAdapterPattern();
//        simulator.simulateDecoratorPattern();
//        simulator.simulateDecoratorPattern2();
//        simulator.simulateAbstractFactoryPattern();
//        simulator.simulateCompositePattern();
        simulator.simulateCompositePattern2();
    }

    void simulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redheadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable goose = new GooseAdapter(new Goose());

        Flock flockOfDucks = new Flock();
        flockOfDucks.add(mallardDuck);
        flockOfDucks.add(redheadDuck);
        flockOfDucks.add(duckCall);
//        flockOfDucks.add(rubberDuck);
        flockOfDucks.add(goose);

        Flock flockOfRubberDuck = new Flock();
        flockOfRubberDuck.add(rubberDuck);
        flockOfRubberDuck.add(duckFactory.createRubberDuck());
        flockOfRubberDuck.add(duckFactory.createRubberDuck());

        flockOfDucks.add(flockOfRubberDuck);

        System.out.println("\nDuck Simulator: With Decorator");
        simulate(flockOfDucks);
//        simulate(mallardDuck);
//        simulate(redheadDuck);
//        simulate(duckCall);
//        simulate(rubberDuck);
//        simulate();

        System.out.println("The ducks quacked " +
                QuackCounter.getNumberOfQuacks() + " times");
    }
    void simulate(Quackable duck) {
        duck.quack();
    }

    void simulateAdapterPattern(){
        Quackable mallardDuck = new MallardDuck();
        Quackable redHeadDuck = new RedHeadDuck();
        Quackable duckCall = new DuckCall();
        Quackable rubberDuck = new RubberDuck();
        Quackable goose = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());

        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(goose);
        simulate(pigeon);
    }

    // 5 times
    void simulateDecoratorPattern(){
        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable redHeadDuck = new QuackCounter(new RedHeadDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        Quackable goose = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());

        Quackable duckCallDecorator = new QuackCounter(new QuackEcho(new DuckCall()));

        System.out.println("\nDuck Simulator with Decorator");

        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(goose);
        simulate(pigeon);
        simulate(duckCallDecorator);

        System.out.println("The ducks quacked " + QuackCounter.getNumberOfQuacks() + " times.");
    }

    // 6 times
    void simulateDecoratorPattern2(){
        Quackable mallardDuck = new QuackCounter(new MallardDuck());
        Quackable redHeadDuck = new QuackCounter(new RedHeadDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        Quackable goose = new GooseAdapter(new Goose());
        Quackable pigeon = new PigeonAdapter(new Pigeon());

        Quackable duckCallDecorator = new QuackEcho(new QuackCounter(new DuckCall()));

        System.out.println("\nDuck Simulator with Decorator");

        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(goose);
        simulate(pigeon);
        simulate(duckCallDecorator);

        System.out.println("The ducks quacked " + QuackCounter.getNumberOfQuacks() + " times.");
    }

    // 3 times
    void simulateAbstractFactoryPattern(){
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countingDuckFactory = new CountingDuckFactory();
        AbstractDuckFactory countAndEchoDuckFactory = new CountAndEchoDuckFactory();

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = countAndEchoDuckFactory.createRedheadDuck();
        Quackable duckCall = countAndEchoDuckFactory.createDuckCall();
        Quackable rubberDuck = countingDuckFactory.createRubberDuck();

        System.out.println("\nDuck Simulator with Abstract Factory");

        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(duckCall);
        simulate(rubberDuck);

        System.out.println("The ducks quacked " + QuackCounter.getNumberOfQuacks() + " times.");
    }

    //ผลลัพธ์ คือ Quack Quack Kwak Squeak ตามลำดับ
    void simulateCompositePattern(){
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countingDuckFactory = new CountingDuckFactory();

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = countingDuckFactory.createDuckCall();
        Quackable rubberDuck = countingDuckFactory.createRubberDuck();

        Flock flock = new Flock();
        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(duckCall);
        simulate(rubberDuck);

        flock.quack();
    }

    //ผลลัพธ์ คือ Quack Quack Kwak Squeak ตามลำดับ
    void simulateCompositePattern2(){
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countingDuckFactory = new CountingDuckFactory();

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = countingDuckFactory.createDuckCall();
        Quackable rubberDuck = countingDuckFactory.createRubberDuck();

        LeaderFlock flock = new LeaderFlock();
        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(duckCall);
        simulate(rubberDuck);

        flock.quack();
    }
}
