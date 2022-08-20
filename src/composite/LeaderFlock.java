package composite;

public class LeaderFlock extends Flock{
    public void quack(){
        for (int i = 0; i < quackers.size(); ++i){
            if(i == 0){
                quackers.get(i).quack();
                quackers.get(i).quack();
                quackers.get(i).quack();
            }
            else {
                quackers.get(i).quack();
            }
        }
    }
}
