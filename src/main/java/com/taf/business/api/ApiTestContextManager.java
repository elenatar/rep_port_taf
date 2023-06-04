package com.taf.business.api;

import java.util.Objects;

public class ApiTestContextManager {

    private static ApiTestContextManager instance;
    private final ThreadLocal<ApiTestContext> contextContainer = ThreadLocal.withInitial(() -> null);

    public static ApiTestContextManager getInstance() {
        if (instance == null) {
            instance = new ApiTestContextManager();
        }
        return instance;
    }

    public ApiTestContext getContext() {
        if (Objects.isNull(contextContainer.get())) {
            contextContainer.set(new ApiTestContext());
        }
        return contextContainer.get();
    }

    public void clear() {
        contextContainer.remove();
    }
}
