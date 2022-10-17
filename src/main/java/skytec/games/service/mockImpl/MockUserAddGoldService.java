package skytec.games.service.mockImpl;

import skytec.games.service.domain.ClanService;
import skytec.games.service.domain.UserAddGoldService;
import skytec.games.util.Log;

import java.util.concurrent.CompletableFuture;

public class MockUserAddGoldService implements UserAddGoldService {

    private final ClanService clanService;

    public MockUserAddGoldService(ClanService clanService) {
        this.clanService = clanService;
    }

    @Override
    public CompletableFuture<Void> addGoldToClan(long userId, long clanId, int deltaGold) {
        Log.d("Starting add gold to clan directly from user");
        // some additional information can be added, for example user info, bank info or whatever
        // ..
        // ..
        // ..
        return clanService
                .addGold(clanId, deltaGold)
                .thenAccept(clan -> {
                    Log.d("SUCCESS: addGoldToClan completed");
                })
                .exceptionally(ex -> {
                    Log.d("FAILED: addGoldToClan");
                    return null;
                });


    }
}
