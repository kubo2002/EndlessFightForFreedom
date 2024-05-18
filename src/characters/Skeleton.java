package characters;
import room.Tile;
public class Skeleton extends Enemy {

    public Skeleton(Player target) {
        super(TypeOfPerson.SKELETON, target);
    }

    @Override
    public void move() {
        if (super.getState()) {
            this.findTarget();
            if (super.getPositionX() < super.getTarget().getPositionX() && super.getPositionY() < super.getTarget().getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() + 1, super.getPositionY() + 1)) {
                super.direction(1, 1);
            } else if (super.getPositionX() < super.getTarget().getPositionX() && super.getPositionY() > super.getTarget().getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() + 1, super.getPositionY() - 1)) {
                super.direction(1, -1);
            } else if (super.getPositionX() > super.getTarget().getPositionX() && super.getPositionY() < super.getTarget().getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() - 1, super.getPositionY() + 1)) {
                super.direction(-1, 1);
            } else if (super.getPositionX() > super.getTarget().getPositionX() && super.getPositionY() > super.getTarget().getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() - 1, super.getPositionY() - 1)) {
                super.direction(-1, -1);
            } else if (super.getPositionX() < super.getTarget().getPositionX() && super.getPositionY() == super.getTarget().getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() + 1, super.getPositionY())) {
                super.direction(-1, 0);
            } else if (super.getPositionX() > super.getTarget().getPositionX() && super.getPositionY() == super.getTarget().getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX() - 1, super.getPositionY())) {
                super.direction(-1, 0);
            } else if (super.getPositionX() == super.getTarget().getPositionX() && super.getPositionY() < super.getTarget().getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX(), super.getPositionY() + 1)) {
                super.direction(0, 1);
            } else if (super.getPositionX() == super.getTarget().getPositionX() && super.getPositionY() > super.getTarget().getPositionY() && super.getCurrentRoom().isAbleToMove(super.getPositionX(), super.getPositionY() - 1)) {
                super.direction(0, -1);
            }
        }
    }
    private void findTarget() {
        for (Tile tile : super.getCurrentRoom().getSurroundings(this.getPositionX(), this.getPositionY())) {
            if (tile.getCharacter().isPresent()) {
                this.performAttack(tile.getCharacter().get());
            }
        }
    }
    @Override
    public void performAttack(Actions person) {
        super.performAttack(person);
    }
    @Override
    public void receiveAttack(double damage) {
        super.receiveAttack(damage);
    }
}
