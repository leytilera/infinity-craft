package anvil.infinity.capabilities;

import java.util.concurrent.Callable;

public class Factory implements Callable<ICapabilityPlayerData> {

    @Override
    public ICapabilityPlayerData call() throws Exception {
        return new CapabilityPlayerData();
    }
}
