class TimeMap {

    class Value {
        int timestamp;
        String value;

        Value(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    Map<String, List<Value>> timeMap;

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!timeMap.containsKey(key)) {
            timeMap.put(key, new ArrayList<>());
        }
        timeMap.get(key).add(new Value(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!timeMap.containsKey(key)) {
            return "";
        }

        return search(timeMap.get(key), timestamp);
    }

    private String search(List<Value> values, int timestamp) {
        int low = 0, high = values.size() - 1;
        String result = "";

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(values.get(mid).timestamp == timestamp) {
                return values.get(mid).value;
            } else if(values.get(mid).timestamp > timestamp) {
                high = mid - 1;
            } else {
                result = values.get(mid).value;
                low = mid + 1;
            }
        }

        return result; 
    }
}
