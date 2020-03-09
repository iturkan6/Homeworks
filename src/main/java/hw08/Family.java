package hw08;


import java.util.*;

public class Family {
    private Human mother;
    private Human father;
    //private Human [] children = new Human[1];
    private int count = 2;
    private HashSet<Pet> PET = new HashSet<Pet>();
    private ArrayList<Human> children = new ArrayList<Human>();
    private boolean b = false;


    public Family(Human mother, Human father,  ArrayList <Human> children, HashSet<Pet> PET){
        this.father = father;
        this.mother = mother;
        this.mother.setFamily(this);
        this.father.setFamily(this);
        this.children = children;
        this.PET = PET;
    }

    Family(){}


    public Set<Pet> getPET() {
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setChildren(ArrayList<Human> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return String.format("Family{mother = %s, father = %s, children = %s, Pet = %s}",
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

    public int countFamily(){
        return count = 2 + children.size();
    }

}
