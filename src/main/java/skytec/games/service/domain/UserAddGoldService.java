package skytec.games.service.domain;


import java.util.concurrent.CompletableFuture;

public interface UserAddGoldService {
    CompletableFuture<Void> addGoldToClan(long userId, long clanId, int deltaGold);
}
