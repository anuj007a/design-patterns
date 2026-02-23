package com.wraith.wallet.factory;

import com.wraith.wallet.storage.Storage;

public interface WalletEnvironmentFactory {
    Storage createStorage();
}