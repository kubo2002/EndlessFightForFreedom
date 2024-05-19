package characters;
import room.Tile;

/**
 * Trieda reprezentujuca Skeletona v hre.
 *
 * @author Jakub Gubány
 *
 */
public class Skeleton extends Enemy {

    /**
     * Konstruktor triedy Skeleton.
     *
     * @param target ciel na ktorý Skeleton pocas jeho zivotneho cyklu utoci (Hrac).
     *
     */
    public Skeleton(Player target) {
        super(TypeOfPerson.SKELETON, target);
    }

    /**
     *
     * Hybe postavou po hracej ploche.
     *
     * Skeleton sa hybe to vsetkych smerov vratane diagonal.
     *
     */
    @Override
    public void move() {
        if (super.getState()) {
            this.findTarget();
            if (super.getPositionX() < super.getTarget().getPositionX() && super.getPositionY() < super.getTarget().getPositionY()) {
                super.direction(1, 1);
            } else if (super.getPositionX() < super.getTarget().getPositionX() && super.getPositionY() > super.getTarget().getPositionY()) {
                super.direction(1, -1);
            } else if (super.getPositionX() > super.getTarget().getPositionX() && super.getPositionY() < super.getTarget().getPositionY()) {
                super.direction(-1, 1);
            } else if (super.getPositionX() > super.getTarget().getPositionX() && super.getPositionY() > super.getTarget().getPositionY()) {
                super.direction(-1, -1);
            } else if (super.getPositionX() < super.getTarget().getPositionX() && super.getPositionY() == super.getTarget().getPositionY()) {
                super.direction(-1, 0);
            } else if (super.getPositionX() > super.getTarget().getPositionX() && super.getPositionY() == super.getTarget().getPositionY()) {
                super.direction(-1, 0);
            } else if (super.getPositionX() == super.getTarget().getPositionX() && super.getPositionY() < super.getTarget().getPositionY()) {
                super.direction(0, 1);
            } else if (super.getPositionX() == super.getTarget().getPositionX() && super.getPositionY() > super.getTarget().getPositionY()) {
                super.direction(0, -1);
            }
        }
    }

    /**
     *
     * Hlada v pravidelnych casovych intervaloch na ktory ciel sa ma premiestnit.
     *
     */
    private void findTarget() {
        for (Tile tile : super.getCurrentRoom().getSurroundings(this.getPositionX(), this.getPositionY())) {
            if (tile.getCharacter().isPresent()) {
                this.performAttack(tile.getCharacter().get());
            }
        }
    }

    /**
     *
     * Zrealizuje utok na oponenta.
     *
     * @param person oponent
     */
    @Override
    public void performAttack(Actions person) {
        super.performAttack(person);
    }

    /**
     * Prijme poskodenie od oponenta
     *
     * @param damage utocna sila oponenta.
     */
    @Override
    public void receiveAttack(double damage) {
        super.receiveAttack(damage);
    }
}
