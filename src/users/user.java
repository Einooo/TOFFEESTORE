package users;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * The type User.
 */
public abstract class user {
    /**
     * The Name.
     */
    protected String name;
    /**
     * The Email.
     */
    protected String email;
    /**
     * The Password.
     */
    protected String password;
    /**
     * The Phone.
     */
    protected String phone;
    /**
     * The Address.
     */
    protected String address;
    /**
     * The Role.
     */
    protected Role role;

    /**
     * Instantiates a new User.
     *
     * @param name     the name
     * @param email    the email
     * @param password the password
     * @param phone    the phone
     * @param address  the address
     * @param role     the role
     */
    public user(String name, String email, String password, String phone, String address, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.role = role;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone.
     *
     * @param phone the phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(String address) {
        this.address = address;
    }
}