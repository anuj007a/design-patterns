package com.wraith.wallet.factory;

import com.wraith.wallet.api.Wallet;
import com.wraith.wallet.config.WalletConfig;
import com.wraith.wallet.storage.Storage;
import com.wraith.wallet.strategy.PremiumWallet;

public class PremiumWalletCreator extends WalletCreator {

    @Override
    public Wallet createWallet(WalletConfig config,
                               Storage storage) {

        return new PremiumWallet(
                config.getUserId(),
                storage,
                config.getCreditLimit()
        );
    }
}