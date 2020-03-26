package hw13;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private HashSet<Pet> PET = new HashSet<>();
    private ArrayList<Human> children = new ArrayList<>();
    private boolean b = false;
    private int count = 2;

    public Family(Human mother, Human father, ArrayList <Human> children, HashSet<Pet> pet){
        this.father = father;
        this.mother = mother;
        this.mother.setFamily(this);
        this.father.setFamily(this);
        this.children = children;
        this.PET = pet;
    }
    public Family (Human mother, Human father){
        this.father = father;
        this.mother = mother;
    }
    public Family (Human mother, Human father, ArrayList<Human> children){
        this.father = father;
        this.mother = mother;
        this.children = children;
        this.mother.setFamily(this);
        this.father.setFamily(this);
    }

    Family(){}

    public HashSet<Pet> getPet() {
        return PET;
    }

    public void setPET(HashSet<Pet> PET) {
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

    public ArrayList<Human> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Human> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return String.format("Family{mother = %s, father = %s, children = %s, Pet = %s}\n",
                mother, father, children, PET);
    }

    public void addChild(Human a) {
        this.children.add(a);
        a.setFamily(this);
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

    public boolean deleteChild(int index) {
        if (index < getChildren().size()) {
            children.remove(index);
            b = true;
        }
        return b;
    }

    public boolean deleteChild(Human child){
       boolean r = false;
        if(child.equals(children)){
            children.remove(child);
            r = true;
        }
        return r;
    }

    public int countFamily(){
        return count = 2 + children.size();
    }

    public void addPet(Pet pet){
        getPet().add(pet);
    }

    public String prettyFormat(){
        StringBuilder sb = new StringBuilder();
        for (Human child : children){
            sb.append("\t\t\t");
            sb.append(child.prettyFormat());
            sb.append("\n");
        }
        return String.format("Family:\n    mother: %s,\n    father: %s,\n    children:\n%s    pet: %s}\n",
                mother.prettyFormat(), father.prettyFormat(), sb, PET);
    }

    public String toDBFormat(){
        StringBuilder sb = new StringBuilder();
        for (Human child : children){
            sb.append(child.toDBFormat());
            sb.append("~child~");
        }
        StringBuilder sb1 = new StringBuilder();
        for (Pet pet : PET){
            sb1.append(pet.toDBFormat());
            sb1.append("~P~");
        }
        return String.format("%s%s~M~%s~M~%s\n",
                mother.toDBFormat(), father.toDBFormat(), sb, sb1);
    }
}
