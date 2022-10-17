package skytec.games.model;

public class Clan {
    private long id;
    private String name;
    private int gold;

    public Clan(){}

    public Clan(long id){
        this.id = id;
    }

    public Clan(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public String toString() {
        return "Clan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gold=" + gold +
                '}';
    }
}
