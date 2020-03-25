package hw12;

import java.util.List;

public interface FamilyDAO<A> {
//    Family family = new Family();
    List<A> getAllFamilies();
    Family getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family family);
    void saveFamily(Family family);
}
