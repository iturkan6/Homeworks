package hw05;

import java.util.Arrays;

public class Family {
    private Human mother;
    private Human father;
    private Human [] children = new Human[1];
    private int count = 0;
    Human human;

    public Family(Human mother, Human father, Human [] children){

        this.father = father;
        count++;
        this.mother = mother;
        count++;
        this.children = children;
        count++;
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
        this.count++;
    }
    public boolean deleteChild() {
        int c = this.children.length;
        this.children = Arrays.copyOf(this.children, c - 1);
        this.count--;
        return (this.children.length < c);

    }

}
