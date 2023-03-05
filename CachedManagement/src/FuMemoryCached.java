import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class FuMemoryCached {
    public HashMap<String, FuCached> cached;
    public static FuMemoryCached instance = new FuMemoryCached();

    public FuMemoryCached() {
        cached = new HashMap<>();
    }

    public static synchronized boolean putObject(String key, Object object, int timeToLive) {
        if (instance.cached.containsKey(key)) {
            System.out.println("[Error] The inputted key exists!");
            return false;
        }

        if (timeToLive <= 0)
            return false;

        Date date = new Date();
        date.setTime(date.getTime() + timeToLive * 1000);
        FuCached cache = new FuCached(object, date);

        instance.cached.put(key, cache);
        Thread thread = new Thread(() -> {
            while (date.getTime() > System.currentTimeMillis()) {

            }
            FuMemoryCached.instance.cached.remove(key, cache);
        });
        thread.start();
        return true;
    }

    public static Object getObject(String key) {
        if (!instance.cached.containsKey(key)) {
            System.out.println("[Error] The cache does not exist or was expired!");
            return null;
        }
        FuCached cached = instance.cached.get(key);
        if (cached == null)
            return null;
        return cached.getObject();
    }

    public static boolean clean(String key) {
        if (!instance.cached.containsKey(key))
            return false;
        instance.cached.remove(key);
        return true;
    }

    public static boolean cleanAll() {
        if (instance.cached.size() == 0)
            return false;
        for (String key : new ArrayList<String>(instance.cached.keySet()))
            instance.cached.remove(key);
        return true;
    }
}
