package skytec.games.controller;

import skytec.games.model.ResponseEntity;
import skytec.games.service.domain.UserAddGoldService;
import skytec.games.util.Log;

import java.util.concurrent.CompletableFuture;

public class UserController {
    private final UserAddGoldService userAddGoldService;

    public UserController(UserAddGoldService userAddGoldService) {
        this.userAddGoldService = userAddGoldService;
    }

    public CompletableFuture<ResponseEntity<Void>> addGold(long userId, long clanId, int deltaGold){
        Log.d(String.format("request for addGold, user-agent: %s, user: %s", "console", "someUser") );
        return userAddGoldService
                .addGoldToClan(userId, clanId, deltaGold)
                .thenApply(Void -> {
                    Log.d(String.format("return response from addGold() for user: %s: , clan: %s", "someUser", "someUser"));
                    return new ResponseEntity<Void>("..");
                })
                .exceptionally(ex -> {
                    Log.d("failed to process addGold request");
                    return new ResponseEntity<>(null,new RuntimeException(ex));
                });
    }
}
