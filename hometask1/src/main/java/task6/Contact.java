package task6;

/**
 * Class Contact ia template for a contact that the user of a notebook is able to add
 */

class Contact {

    private String name;
    private String lastName;
    private String phoneNumber;
    private String email;

    Contact(String name,
            String lastName,
            String phoneNumber,
            String email) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    String getName() {
        return name;
    }

    String getLastName() {
        return lastName;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact contact = (Contact) o;

        return (getName() != null ? getName().equals(contact.getName()) : contact.getName() == null)
                && (getLastName() != null ? getLastName().equals(contact.getLastName()) : contact.getLastName() == null)
                && (getPhoneNumber() != null ? getPhoneNumber().equals(contact.getPhoneNumber()) : contact.getPhoneNumber() == null)
                && (getEmail() != null ? getEmail().equals(contact.getEmail()) : contact.getEmail() == null);
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getPhoneNumber() != null ? getPhoneNumber().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        return result;
    }
}
