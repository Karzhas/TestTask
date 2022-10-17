package skytec.games.service.domain;

import skytec.games.model.Clan;

import java.util.concurrent.CompletableFuture;

public interface ClanService {
    CompletableFuture<Clan> getClan(long clanId);
    CompletableFuture<Void> addGold(long clanId, int deltaGold);
}
