package hw05;

import java.util.Arrays;

public class Family {
    private Human mother;
    private Human father;
    private Human [] children;
    int count = 0;
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
                mother, father, Arrays.toString(children), count);
    }

    public void addChild(Human a){

//        for (int i = 0; i <2 ; i++) {
//            children[i] = a;
//        }
////        System.out.println(Arrays.toString(children));
    }
    public void deleteChild(){

    }
}
