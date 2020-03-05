package hw06;


import java.util.Arrays;
import java.util.Objects;

public class Family {

    private Human mother;
    private Human father;
    private Human[] children = new Human[0];
    private int count = 2;
    private Pet PET;
   private boolean c = false;
    private int index;

    public Family(Human mother, Human father, Human []children, Pet PET){
        this.father = father;
        father.setFamily(this);
        this.mother = mother;
        mother.setFamily(this);
        this.PET = PET;
        this.children = children;
    }

    Family(){}

    public Pet getPET() {
        return PET;
    }

    public void setPET(Pet PET) {
        this.PET = PET;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return String.format("Family{mother = %s, father = %s, children = %s, pet = %s}",
                mother, father, Arrays.toString(children), PET);
    }

    public void addChild(Human a) {
        this.children = Arrays.copyOf(this.children, this.children.length+1);
        a.setFamily(this);
        this.children[children.length-1] = a;
    }


    public boolean deleteChild(int index) {
        if(index < this.children.length){
        for ( ; index < this.children.length-1; index++) {
            this.children[index] = this.children[++index];
        }
            this.children = Arrays.copyOf(this.children, this.children.length - 1);
            c = true;
        }
//        int c = this.children.length;

        return c;
    }

    public int countFamily(){
        return count = 2 + children.length;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return mother.equals(family.mother) &&
                father.equals(family.father);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
