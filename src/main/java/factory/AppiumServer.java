package factory;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServer {

    private static final AppiumServiceBuilder builder = new AppiumServiceBuilder();

    public static AppiumDriverLocalService getService() {
        builder.usingAnyFreePort();
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.RELAXED_SECURITY);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
        return AppiumDriverLocalService.buildService(builder);
    }
}
