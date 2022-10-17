package skytec.games.service.domain;


import java.util.concurrent.CompletableFuture;

public interface BattleService {
    CompletableFuture<Void> battleAtArena();
}
