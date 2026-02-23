package com.wraith.wallet.processor;

import com.wraith.wallet.api.TransactionProcessor;
import com.wraith.wallet.api.Wallet;
import com.wraith.wallet.model.Transaction;

public class DefaultTransactionProcessor
        implements TransactionProcessor {

    @Override
    public void processCredit(Wallet wallet,
                              Transaction transaction) {

        if (!"CREDIT".equals(transaction.getType())) {
            throw new IllegalArgumentException("Invalid transaction type");
        }

        wallet.credit(transaction.getAmount());
    }

    @Override
    public void processDebit(Wallet wallet,
                             Transaction transaction) {

        if (!"DEBIT".equals(transaction.getType())) {
            throw new IllegalArgumentException("Invalid transaction type");
        }

        wallet.debit(transaction.getAmount());
    }
}