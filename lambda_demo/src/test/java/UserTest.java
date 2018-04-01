import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {
    private List<User> users;

    @Before
    public void setUp() {
        users = prepareUserData();
    }

    @Test
    public void should_sort_by_age_asc_with_user_comparator() {
        Collections.sort(users, new UserComparator());
        assertUserOrder();
    }

    @Test
    public void should_sort_by_age_desc_with_new_comparator() {
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User firstUser, User secondUser) {
                return firstUser.getAge().compareTo(secondUser.getAge());
            }
        });
        assertUserOrder();
    }

    @Test
    public void should_sort_by_age_desc_with_new_lambda() {
        users.sort(Comparator.comparing(User::getAge));
        assertUserOrder();
    }

    private List<User> prepareUserData() {
        List<User> prepareUsers = new ArrayList<>();

        prepareUsers.add(new User("Bob", 15));
        prepareUsers.add(new User("Tom", 18));
        prepareUsers.add(new User("Lucy", 16));
        prepareUsers.add(new User("Linda", 14));

        return prepareUsers;
    }

    private void assertUserOrder() {
        assertThat(users.get(0).getName(), is("Linda"));
        assertThat(users.get(1).getName(), is("Bob"));
        assertThat(users.get(2).getName(), is("Lucy"));
        assertThat(users.get(3).getName(), is("Tom"));
    }
}