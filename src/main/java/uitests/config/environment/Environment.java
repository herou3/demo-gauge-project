package uitests.config.environment;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Environment {
    PROD("https://www.saucedemo.com/");

    @Getter
    @NonNull
    private String url;

    @Getter
    private static final Environment currentEnvironment = resolveEnvironment();

    private static Environment resolveEnvironment() {
        String env = (String) System.getProperties().get("environment");
        return env == null ? PROD : Environment.valueOf(env.toUpperCase());
    }
}