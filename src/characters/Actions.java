package characters;

public interface Actions {
    void performAttack(Actions person);
    void receiveAttack(double damage);
    int getPositionX();
    int getPositionY();
    void die();


}

