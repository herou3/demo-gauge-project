package uitests.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
public enum User {
    STANDARD_USER("standard_user", "secret_sauce"),
    LOCKED_OUT_USER("locked_out_user", "secret_sauce"),
    PROBLEM_USER("problem_user", "secret_sauce"),
    EMPTY_PASSWORD_USER("standard_user", ""),
    EMPTY_LOGIN_USER("", "secret_sauce"),
    EMPTY_USER("", "");

    @Getter
    @NonNull
    private String name;

    @Getter
    @NonNull
    private String password;

    @Getter
    static User currentUser;

    public static User getUser(String userName) {
        switch (userName.toUpperCase()) {
            case "USER": {
                currentUser = User.STANDARD_USER;
                break;
            }
            case "LOCKED_USER": {
                currentUser = User.LOCKED_OUT_USER;
                break;
            }
            case "PROBLEM_USER": {
                currentUser = User.PROBLEM_USER;
                break;
            }
            case "EMPTY_PASSWORD_USER": {
                currentUser = User.EMPTY_PASSWORD_USER;
                break;
            }
            case "EMPTY_LOGIN_USER": {
                currentUser = User.EMPTY_LOGIN_USER;
                break;
            }
            case "EMPTY_USER": {
                currentUser = User.EMPTY_USER;
                break;
            }
        }
        return currentUser == null ? User.EMPTY_USER : User.STANDARD_USER;
    }
}
