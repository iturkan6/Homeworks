package hw09;

import java.util.List;
import java.util.Optional;

public interface FamilyDAO<Family> {
//    Family family = new Family();
    List<Family> getAllFamilies();
    Optional<Family> getFamilyByIndex(int index);
    boolean deleteFamily (int index);
    boolean deleteFamily (Family family);
    void saveFamily (Family family);
//    public int
}
