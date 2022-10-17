package skytec.games.controller;

import skytec.games.model.ResponseEntity;
import skytec.games.service.domain.BattleService;
import skytec.games.util.Log;

import java.util.concurrent.CompletableFuture;

public class BattleController {
    private final BattleService battleService;

    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }

    public CompletableFuture<ResponseEntity<Void>> battle(){
        Log.d(String.format("request for battle, user-agent: %s, user: %s", "console", "someUser") );
        return battleService
                .battleAtArena()
                .thenApply(Void -> {
                    Log.d(String.format("return response from battle() for user: %s: , clan: %s", "someUser", "someUser"));
                    return new ResponseEntity<Void>("..");
                })
                .exceptionally(ex -> {
                    Log.d("failed to process battle request");
                    return new ResponseEntity<>(null,new RuntimeException(ex));
                });
    }
}
