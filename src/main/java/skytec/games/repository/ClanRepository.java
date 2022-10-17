package skytec.games.repository;

import skytec.games.model.Clan;

import java.util.concurrent.CompletableFuture;

public interface ClanRepository {
    CompletableFuture<Clan> findById(long id);


}
