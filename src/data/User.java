package data;

public class User {
    private final String name, email, number, pin, password;

    public User(String name, String email, String number, String pin, String password) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.pin = pin;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public String getPin() {
        return pin;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", number='" + number + '\'' +
                ", pin='" + pin + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
