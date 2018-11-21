package blog.forms;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreatePostForm {

    @NotNull
    @Size(min = 5, max = 300, message = "Required field!")
    public String title;


    @NotNull
    @Size(min = 5, max = 3000, message = "Required field!")
   public String body;

    @NotNull
    public String getTitle() {
        return title;
    }

    @NotNull
    public String getBody() {
        return body;
    }

    public void setTitle(@NotNull String title) {
        this.title = title;
    }

    public void setBody(@NotNull String body) {
        this.body = body;
    }
}
