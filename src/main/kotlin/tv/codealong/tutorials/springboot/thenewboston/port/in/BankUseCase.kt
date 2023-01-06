package tv.codealong.tutorials.springboot.thenewboston.port.in

import tv.codealong.tutorials.springboot.thenewboston.model.Bank

interface BankUseCase {
    fun getBanks(): Collection<Bank>
    fun getBank(accountNumber: String): Bank
    fun addBank(bank: Bank): Bank
    fun updateBank(bank: Bank): Bank
    fun deleteBank(accountNumber: String)    
}