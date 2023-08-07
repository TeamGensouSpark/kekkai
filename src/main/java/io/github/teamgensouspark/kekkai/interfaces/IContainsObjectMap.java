package io.github.teamgensouspark.kekkai.interfaces;

import java.util.Map;

public interface IContainsObjectMap {
    public abstract Map<String,Object> getMap();
    public abstract void writeKeyIntoMap(String key,Object value);
    public abstract Object getValueFromMap(String key);
}
