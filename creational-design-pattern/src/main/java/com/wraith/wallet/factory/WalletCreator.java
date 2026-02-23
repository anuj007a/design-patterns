package com.wraith.wallet.factory;

import com.wraith.wallet.api.Wallet;
import com.wraith.wallet.config.WalletConfig;
import com.wraith.wallet.storage.Storage;

public abstract class WalletCreator {
    public abstract Wallet createWallet(
            WalletConfig config,
            Storage storage
    );
}