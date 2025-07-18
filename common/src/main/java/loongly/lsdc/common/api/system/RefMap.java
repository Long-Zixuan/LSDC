package loongly.lsdc.common.api.system;

import java.util.Map;

public class RefMap<K,V>
{
    public Map<K,V> map;

    public boolean containsKey(String key)
    {
        return map.containsKey(key);
    }

    public V get(String key)
    {
        return map.get(key);
    }
}
