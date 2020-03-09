package hw06;


import java.util.Arrays;
import java.util.Objects;

public class Family {

    private Human mother;
    private Human father;
    private Human[] children = new Human[0];
    private Pet PET;

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

    public void addChild(Human child) {
        this.children = Arrays.copyOf(this.children, this.children.length+1);
        this.children[children.length-1] = child;
        child.setFamily(this);
    }

    public boolean deleteChild(int index) {
        boolean c = false;
        if(index < this.children.length){
        for ( ; index < this.children.length-1; index++) {
            this.children[index] = this.children[++index];
        }
            this.children = Arrays.copyOf(this.children, this.children.length - 1);
            c = true;
        }
        return c;
    }

    public boolean deleteChild(Human child){
        boolean r = false;
        for (int i = 0; i <this.children.length; i++) {
            if (child.equals(children[i])){
                for (int j = i; j < children.length-1; j++) {
                    this.children[j] = this.children[++j];
                    }
                r = true;
                this.children = Arrays.copyOf(this.children, this.children.length-1);
            }
        }
        return r;
    }

    public int countFamily(){
        return 2 + children.length;
    }
    public boolean equal(Human chh1, Human chh2){
        return chh1.equals(chh2);
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return mother.equals(family.mother) &&
                father.equals(family.father) &&
                Arrays.equals(children, family.children) &&
                Objects.equals(PET, family.PET);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mother, father, PET);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }
}
