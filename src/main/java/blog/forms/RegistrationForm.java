package blog.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegistrationForm {

    @Size(min = 2, max = 30, message = "Username size should be in the renge [2...30]")
    private String username;

    @NotNull
    @Size(min = 1, max = 50, message = "Error!")
    private String password;

    @Size(min = 2, max = 30, message = "Fullname size should be in the renge [2...30]")
    private String fullname;

    public String getUsername() {
        return username;
    }

    @NotNull
    public String getPassword() {
        return password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(@NotNull String password) {
        this.password = password;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
