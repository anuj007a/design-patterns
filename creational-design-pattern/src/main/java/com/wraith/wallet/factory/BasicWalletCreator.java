package com.wraith.wallet.factory;

import com.wraith.wallet.api.Wallet;
import com.wraith.wallet.config.WalletConfig;
import com.wraith.wallet.storage.Storage;
import com.wraith.wallet.strategy.BasicWallet;

public class BasicWalletCreator extends WalletCreator {

    @Override
    public Wallet createWallet(WalletConfig config,
                               Storage storage) {
        return new BasicWallet(config.getUserId(), storage);
    }
}