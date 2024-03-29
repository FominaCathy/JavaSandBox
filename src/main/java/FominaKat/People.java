package FominaKat;

import java.util.Objects;

public class People {
    private final String firstName;
    private final String lastName;


    public People(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() != this.getClass()) {
            return false;
        } else {
            return (this.firstName.equals(((People) o).getFirstName())
                    && this.lastName.equals(((People) o).getLastName()));
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + ' ' + lastName;
    }
}
