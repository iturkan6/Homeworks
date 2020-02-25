package hw05;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human [] children = new Human[1];
    private int count = 2;

    public Family(Human mother, Human father, Human [] children){
        this.father = father;
        this.mother = mother;
        this.children = children;
    }

    Family(){}


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
        return String.format("Family{mother=%s, father=%s, children=%s, count=%d}",
                mother, father, Arrays.toString(children), this.count);
    }

    public void addChild(Human a) {
        this.children = Arrays.copyOf(this.children, this.children.length+1);
        this.children[children.length-1] = a;
        this.count += this.children.length;
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
        for ( ; index < this.children.length-1; index++) {
            this.children [index] = this.children[++index];
        }
        int c = this.children.length;
        this.children = Arrays.copyOf(this.children,  c - 1);
        this.count--;
        return (this.children.length < c);

    }

}
