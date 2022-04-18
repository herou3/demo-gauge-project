package uitests.config.browser;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Browser {
    GH("chrome"),
    FF("firefox");

    @Getter
    @NonNull
    private String name;

    @Getter
    private static final Browser currentBrowser = resolveEnvironment();

    private static Browser resolveEnvironment() {
        String env = (String) System.getProperties().get("browser");
        return env == null ? GH : Browser.valueOf(env.toUpperCase());
    }
}