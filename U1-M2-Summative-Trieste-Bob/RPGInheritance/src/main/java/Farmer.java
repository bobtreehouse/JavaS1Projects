// sub class // derived
//used inside a sub-class method definition to call a method defined in the super class//

public class Farmer extends BaseClass {



    private boolean harvest;
    private boolean plow;

    public Farmer(String name, int strength, int health, int stamina, int speed, int attackPower) {
        super("bob", 75,100,75,10, 1);
        this.plow = plow;
        this.harvest = harvest;
    }


    // unique to farmer //

    public boolean isHarvest() {
        return harvest;
    }

    public void setHarvest(boolean harvest) {
        this.harvest = true;
    }

    public boolean isPlow() {
        return plow;
    }

    public void setPlow(boolean plow) {
        this.plow = true;
    }



    @Override
    public void runRun() {

    }

    @Override
    public void attackAttack() {

    }

    @Override
    public void decreaseHealth() {

    }

    @Override
    public void increaseStamina() {

    }

    @Override
    public void decreaseStamina() {

    }
}
