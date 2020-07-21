package restclass;

public class OfferInternet {
    private int id;
    private float pack;
    private float cost;

    public OfferInternet(int id) {
        this.id = id;
    }
    public OfferInternet(int id, float pack, float cost) {
        this.id = id;
        this.pack = pack;
        this.cost = cost;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getPack() {
        return pack;
    }

    public void setPack(float pack) {
        this.pack = pack;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
