package skytec.games.controller;

import skytec.games.model.Clan;
import skytec.games.model.ResponseEntity;
import skytec.games.service.domain.ClanService;
import skytec.games.util.Log;

import java.util.concurrent.CompletableFuture;

public class ClanController {
    private final ClanService clanService;

    public ClanController(ClanService clanService) {
        this.clanService = clanService;
    }

    public CompletableFuture<ResponseEntity<Clan>> getClan(long clanId) {
        Log.d(String.format("request for getClan(%d), user-agent: %s, user: %s", clanId, "console", "someUser") );
        return clanService
                .getClan(clanId)
                .thenApply(clan -> {
                    Log.d(String.format("return response from getClan() for user: %s: , clan: %s", "someUser", clan));
                    return new ResponseEntity<>(clan);
                })
                .exceptionally(ex -> {
                    // return 404 for example
                    Log.d("failed to process getClan request");
                    return new ResponseEntity<>(null,new RuntimeException(ex));
                });
    }
}
