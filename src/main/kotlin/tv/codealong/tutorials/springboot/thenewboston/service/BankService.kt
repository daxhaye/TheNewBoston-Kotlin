package tv.codealong.tutorials.springboot.thenewboston.service

import org.springframework.stereotype.Service
import tv.codealong.tutorials.springboot.thenewboston.port.`in`.BankDataSource
import tv.codealong.tutorials.springboot.thenewboston.model.Bank
import tv.codealong.tutorials.springboot.thenewboston.port.`out`.BankUseCase

@Service
class BankService(private val dataSource: BankDataSource) : BankUseCase {

    override fun getBanks(): Collection<Bank> = dataSource.retrieveBanks()
    override fun getBank(accountNumber: String): Bank = dataSource.retrieveBank(accountNumber)
    override fun addBank(bank: Bank): Bank = dataSource.createBank(bank)
    override fun updateBank(bank: Bank): Bank = dataSource.updateBank(bank)
    override fun deleteBank(accountNumber: String) = dataSource.deleteBank(accountNumber)
}