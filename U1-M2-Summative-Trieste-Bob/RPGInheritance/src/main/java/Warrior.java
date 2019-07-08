// sub class // derived
//used inside a sub-class method definition to call a method defined in the super class//

public class Warrior extends BaseClass  {


    private int shieldStrength;


    public Warrior(String name, int strength, int health, int stamina, int speed, int attackPower, int shieldStrength) {
        super("Perri", 75,100,100,50,10);
        this.shieldStrength = shieldStrength;


    }
    // now unique to Warrior

    public Warrior(int shieldStrength) {
        this.shieldStrength = 100;
    }

    public int shieldStrength() {
        return shieldStrength;
    }

    public void shieldStrength(int shieldStrength) {
        this.shieldStrength = shieldStrength;
    }


}
