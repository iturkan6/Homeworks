package hw13;

import java.util.List;

public interface FamilyDAO<A> {
    List<A> getAllFamilies();
    Family getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family family);
    void saveFamily(Family family);

}
