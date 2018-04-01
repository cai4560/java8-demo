import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserTest {
    @Test
    public void should_return_phone_and_email_when_userdata_is_complete() {
        User user = new User("张三", 21, 123456789L, "test@mail.com");

        assertThat(user.getName(), is("张三"));
        assertThat(user.getAge(), is(21));
        assertThat(user.getPhone(), is(123456789L));
        assertThat(user.getEmail(), is("test@mail.com"));
    }

    @Test
    public void should_return_phone_and_email_when_userdata_is_not_complete() {
        User user = new User("李四", 18, null, null);

        assertThat(user.getName(), is("李四"));
        assertThat(user.getAge(), is(18));
        assertThat(user.getPhone(), is(User.DEFAULT_PHONE));
        assertThat(user.getEmail(), is(User.DEFAULT_EMAIL));
    }
}