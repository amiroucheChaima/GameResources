package resources;

	import java.util.HashMap;
	import java.util.Map;

	public class ResourceManager {

	    private Map<ResourceType, Integer> resources;

	    public ResourceManager() {
	        resources = new HashMap<>();
	        for (ResourceType type : ResourceType.values()) {
	            resources.put(type, 0);
	        }
	    }

	    public int get(ResourceType type) {
	        return resources.get(type);
	    }

	    public void add(ResourceType type, int amount) {
	        resources.put(type, resources.get(type) + amount);
	    }

	    public boolean spend(ResourceType type, int amount) {
	        int current = resources.get(type);
	        if (current >= amount) {
	            resources.put(type, current - amount);
	            return true;
	        }
	        return false;
	    }

	    public boolean canAfford(Map<ResourceType, Integer> cost) {
	        for (Map.Entry<ResourceType, Integer> entry : cost.entrySet()) {
	            if (get(entry.getKey()) < entry.getValue()) {
	                return false;
	            }
	        }
	        return true;
	    }

	    public void spendAll(Map<ResourceType, Integer> cost) {
	        for (Map.Entry<ResourceType, Integer> entry : cost.entrySet()) {
	            spend(entry.getKey(), entry.getValue());
	        }
	    }
	}


