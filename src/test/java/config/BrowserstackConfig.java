package config;


import org.aeonbits.owner.Config;
//! путь до места хранения переменных. Файл сгенерирует jenkins
@Config.Sources("classpath:config/browserstack.properties")
public interface BrowserstackConfig extends Config{
    @Key("username")
    String username();

    @Key("key")
    String key();

    @Key("app")
    String app();
}
