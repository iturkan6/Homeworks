package hw09;

import java.util.List;
import java.util.Optional;

public interface FamilyDAO<A> {
//    Family family = new Family();
    List<A> getAllFamilies();
    Family getFamilyByIndex(int index);
    boolean deleteFamily (int index);
    boolean deleteFamily (Family family);
    void saveFamily (Family family);
}
