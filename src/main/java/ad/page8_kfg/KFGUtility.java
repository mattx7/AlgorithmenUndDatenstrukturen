package ad.page8_kfg;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/**
 * Created by MattX7 on 16.11.2016.
 */
class KFGUtility {

    private static List<Terminal> lambda = Arrays.asList(new Terminal("#"), new Terminal("?"));

    @NotNull
    public static Boolean isLambda(Terminal terminal) {
        return lambda.contains(terminal);
    }

    @NotNull
    public static KFG deleteLambdas(KFG kfg) {
        // TODO deleteLambdas()
        return null;
    }

    @NotNull
    public static KFG createChomskyNormalform(KFG kfg) {
        // TODO createChomskyNormalform()
        return null;
    }
}
