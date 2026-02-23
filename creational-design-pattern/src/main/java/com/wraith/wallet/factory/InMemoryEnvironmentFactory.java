package com.wraith.wallet.factory;

import com.wraith.wallet.storage.InMemoryStorage;
import com.wraith.wallet.storage.Storage;

public class InMemoryEnvironmentFactory
        implements WalletEnvironmentFactory {

    @Override
    public Storage createStorage() {
        return new InMemoryStorage();
    }
}