package automation.dev.serverest.api.setupenv;

public class Environment {
    private static String baseUrl;

    public static String getBaseUrl() {

        if (Config.get("app.base.url.hom") == null) {
            baseUrl = System.getenv("APP_BASE_URL");
        } else {
            baseUrl = Config.get("app.base.url.hom");
        }
        return baseUrl;
    }
}