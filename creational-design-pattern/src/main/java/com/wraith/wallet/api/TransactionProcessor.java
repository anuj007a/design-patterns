package com.wraith.wallet.api;

import com.wraith.wallet.model.Transaction;

public interface TransactionProcessor {

    void processCredit(Wallet wallet, Transaction transaction);

    void processDebit(Wallet wallet, Transaction transaction);
}