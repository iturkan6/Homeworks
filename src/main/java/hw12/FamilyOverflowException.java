package hw12;

public class FamilyOverflowException extends RuntimeException {
    private int count;

    public int getCount() {
        return count;
    }
    public FamilyOverflowException(String message, int num){
        super(message);
        count = num;
    }
}
