package hw12;

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
        return c;
    }

    @Override
    public boolean deleteFamily(Family family) {
        boolean r = false;
        if (families.contains(family)){
            families.remove(family);
            r = true;
        }
        return false;
    }

    @Override
    public void saveFamily(Family family) {
        families.add(family);
    }

}
