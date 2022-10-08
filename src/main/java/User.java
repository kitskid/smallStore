public class User {
    private int id;
    private String login;
    private String email;
    private String phoneNumber;
    private String password;

    private Roles roles;

    public User(int id, String login, String email, String phoneNumber, String password, Roles roles) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }



    public Roles getRoles() {
        return roles;
    }

    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
