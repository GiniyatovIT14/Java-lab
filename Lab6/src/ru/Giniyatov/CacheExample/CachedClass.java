package ru.Giniyatov.CacheExample;

import ru.Giniyatov.annotations.Cache;

/**
 * Тестовый класс для демонстрации работы аннотации @Cache.
 */
@Cache({"users", "orders", "products"})
public class CachedClass {
    private String data;

    /**
     * Конструктор по умолчанию.
     */
    public CachedClass() {
        this.data = "cached data";
    }
}

