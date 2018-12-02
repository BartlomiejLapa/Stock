package com.bartlap.stock.wallet.service;

import com.bartlap.stock.wallet.model.Wallet;
import java.util.Set;

public interface WalletService {
    
    Set<Wallet> findAll();
    
    void save(Wallet wallet);
    
}
