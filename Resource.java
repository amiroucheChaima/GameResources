package resources;

public class Resource {

    private ResourceType type;
    private int amount;

    public Resource(ResourceType type, int amount) {
        this.type = type;
        this.amount = amount;
    }

    public ResourceType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public void add(int value) {
        if (value > 0) {
            amount += value;
        }
    }

    public boolean consume(int value) {
        if (value <= amount) {
            amount -= value;
            return true;
        }
        return false;
    }
}

