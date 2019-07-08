// sub class // derived
//used inside a sub-class method definition to call a method defined in the super class//

public class Constable extends BaseClass    {


    private boolean jusrisdiction;

    public Constable(String name, int i, int i1, int i2, int i3, int i4, boolean jusrisdiction) {
        super("Bill", 60, 100, 60, 20, 5 );
        if (jusrisdiction) this.jusrisdiction = true;
        else {
            this.jusrisdiction = false;
        }

    }


    //Unique to Constable
    public boolean isJusrisdiction() {
        return jusrisdiction;
    }

    public void setJusrisdiction(boolean jusrisdiction) {
        this.jusrisdiction = true;
    }


}
