package com.bartlap.stock.wallet.repository;

import com.bartlap.stock.wallet.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;



public interface WalletRepository extends JpaRepository<Wallet, String> {

}