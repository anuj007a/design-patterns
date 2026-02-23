package com.wraith.wallet.app;

import com.wraith.wallet.api.TransactionProcessor;
import com.wraith.wallet.api.Wallet;
import com.wraith.wallet.builder.WalletBuilder;
import com.wraith.wallet.config.WalletConfig;
import com.wraith.wallet.factory.*;
import com.wraith.wallet.model.Transaction;
import com.wraith.wallet.pool.WalletSessionPool;
import com.wraith.wallet.processor.DefaultTransactionProcessor;
import com.wraith.wallet.registry.WalletRegistry;

public class WalletApplication {

    public static void main(String[] args)
            throws InterruptedException {

        // ---------------------------------
        // Create Wallets (Builder + Factory)
        // ---------------------------------

        Wallet basicWallet =
                new WalletBuilder()
                        .config(new WalletConfig("user-1", 0))
                        .creator(new BasicWalletCreator())
                        .environment(new InMemoryEnvironmentFactory())
                        .build();

        Wallet premiumWallet =
                new WalletBuilder()
                        .config(new WalletConfig("user-2", 1000))
                        .creator(new PremiumWalletCreator())
                        .environment(new InMemoryEnvironmentFactory())
                        .build();

        // ---------------------------------
        // Singleton Registry
        // ---------------------------------

        WalletRegistry.getInstance()
                .register("user-1", basicWallet);

        WalletRegistry.getInstance()
                .register("user-2", premiumWallet);

        // ---------------------------------
        // Transaction Processing (Prototype)
        // ---------------------------------

        TransactionProcessor processor =
                new DefaultTransactionProcessor();

        Transaction creditTemplate =
                new Transaction("CREDIT", 500);

        Transaction debitTemplate =
                new Transaction("DEBIT", 200);

        processor.processCredit(
                basicWallet,
                creditTemplate.clone());

        processor.processDebit(
                basicWallet,
                debitTemplate.clone());

        System.out.println("Balance user-1: "
                + basicWallet.getBalance());

        // ---------------------------------
        // Object Pool Usage
        // ---------------------------------

        WalletSessionPool pool =
                new WalletSessionPool(2);

        var session = pool.acquire();
        session.open();

        // simulate work

        session.close();
        pool.release(session);
    }
}