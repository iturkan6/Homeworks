package hw13;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDAO implements FamilyDAO<Family> {
    public List<Family> families = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        try {
            return families.get(index);
        }catch (IndexOutOfBoundsException ex) {
            throw new RuntimeException("Index is wrong", ex);
        }
    }


    @Override
    public boolean deleteFamily(int index) {
        boolean c = false;
        if (index < families.size()){
            families.remove(index);
            c = true;
        }
        try {
            write();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return c;
    }

    @Override
    public boolean deleteFamily(Family family) {
        boolean r = false;
        if (families.contains(family)){
            families.remove(family);
            r = true;
        }
        try {
            write();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return r;
    }

    @Override
    public void saveFamily(Family family){
        int index = families.indexOf(family);
        if(index != -1){
            families.set(index, family);
        }else {
            families.add(family);
        }
        try {
            write();
        } catch (IOException e) {
            System.out.println("Fine not found");
        }
    }
    public void write() throws IOException {
        File file = new File("Families.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        String line;
        for (Family family : families){
            line = family.toDBFormat();
            bw.write(line);
        }
        bw.close();

    }

}
