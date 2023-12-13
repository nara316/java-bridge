package bridge.domain;

import java.util.Collections;
import java.util.List;

public class Bridge {

    private final BridgeSize bridgeSize;
    private final List<String> bridgeRoad;

    private Bridge(int size, List<String> bridgeRoad) {
        this.bridgeSize = BridgeSize.from(size);
        this.bridgeRoad = bridgeRoad;
    }

    public static Bridge of(int size, List<String> bridgeRoad) {
        return new Bridge(size, bridgeRoad);
    }

    public List<String> getBridgeRoad() {
        return Collections.unmodifiableList(bridgeRoad);
    }
}
