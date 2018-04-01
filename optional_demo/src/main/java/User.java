import java.util.Optional;

public class User {
    public static final long DEFAULT_PHONE = -1L;
    public static final String DEFAULT_EMAIL = "default@mail.com";

    private String name;
    private int age;
    private Long phone;
    private String email;

    User(String name, int age, Long phone, String email) {
        this.name = name;
        this.age = age;
        this.phone = Optional.ofNullable(phone).orElse(DEFAULT_PHONE);
        this.email = Optional.ofNullable(email).orElse(DEFAULT_EMAIL);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Long  getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}