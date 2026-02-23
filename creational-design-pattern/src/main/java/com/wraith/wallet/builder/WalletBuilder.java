package com.wraith.wallet.builder;

import com.wraith.wallet.api.Wallet;
import com.wraith.wallet.config.WalletConfig;
import com.wraith.wallet.factory.*;

public class WalletBuilder {

    private WalletConfig config;
    private WalletCreator creator;
    private WalletEnvironmentFactory environmentFactory;

    public WalletBuilder config(WalletConfig config) {
        this.config = config;
        return this;
    }

    public WalletBuilder creator(WalletCreator creator) {
        this.creator = creator;
        return this;
    }

    public WalletBuilder environment(
            WalletEnvironmentFactory factory) {
        this.environmentFactory = factory;
        return this;
    }

    public Wallet build() {
        return creator.createWallet(
                config,
                environmentFactory.createStorage()
        );
    }
}