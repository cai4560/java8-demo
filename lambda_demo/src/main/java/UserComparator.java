import java.util.Comparator;

public class UserComparator implements Comparator<User> {

    @Override
    public int compare(User firstUser, User secondUser) {
        return firstUser.getAge().compareTo(secondUser.getAge());
    }
}
