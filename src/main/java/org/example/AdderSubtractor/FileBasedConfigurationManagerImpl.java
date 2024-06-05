package org.example.AdderSubtractor;



import java.util.Optional;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {

    private static volatile FileBasedConfigurationManagerImpl instance = null;

    private FileBasedConfigurationManagerImpl() {
        super();
    }


    public static FileBasedConfigurationManager getInstance() {
        if (instance == null) {
            synchronized (FileBasedConfigurationManagerImpl.class) {
                if (instance == null) {
                    instance = new FileBasedConfigurationManagerImpl();
                }

            }
        }
        return instance;
    }

    public static void resetInstance() {
        instance = null;
    }

    @Override
    public String getConfiguration(String key) {
        return getProperties().getProperty(key);
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        String value = getConfiguration(key);
        return Optional.ofNullable(value).map(v -> convert(value, type)).orElse(null);
    }

    @Override
    public void setConfiguration(String key, String value) {
        getProperties().setProperty(key, value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        setConfiguration(key, value.toString());
    }

    @Override
    public void removeConfiguration(String key) {
        getProperties().remove(key);
    }

    @Override
    public void clear() {
        getProperties().clear();
    }

}
