package ru.Giniyatov.CacheExample;

import ru.Giniyatov.annotations.Cache;

/**
 * Тестовый класс с пустым массивом кешируемых областей.
 */
@Cache
public class EmptyCacheClass {
    private String data;

    /**
     * Конструктор по умолчанию.
     */
    public EmptyCacheClass() {
        this.data = "empty cache";
    }
}

