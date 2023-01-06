package tv.codealong.tutorials.springboot.thenewboston.adapter.persistence

import org.springframework.stereotype.Component
import tv.codealong.tutorials.springboot.thenewboston.adapter.persistence.entities.BankEntity
import tv.codealong.tutorials.springboot.thenewboston.adapter.persistence.entities.toBank
import tv.codealong.tutorials.springboot.thenewboston.model.Bank
import tv.codealong.tutorials.springboot.thenewboston.port.`in`.BankDataSource

@Component
class BankAdapter(private val bankRepository: BankRepository) : BankDataSource {
    override fun retrieveBanks(): Collection<Bank> = bankRepository.findAll().map { it.toBank() }

    override fun retrieveBank(accountNumber: String): Bank = checkIfExists(accountNumber).toBank()

    override fun createBank(bank: Bank): Bank {
        if (bankRepository.existsBankEntityByAccountNumber(bank.accountNumber)) {
            throw IllegalArgumentException("Bank with account number ${bank.accountNumber} already exists")
        }
        return bankRepository.save(BankEntity(bank)).toBank()
    }

    override fun updateBank(bank: Bank): Bank {
        val bankEntity = checkIfExists(bank.accountNumber)

        val result = BankEntity(bankEntity.idBank, bank.accountNumber, bank.trust, bank.transactionFee)
        return bankRepository.save(result).toBank()

    }

    override fun deleteBank(accountNumber: String) {
        val bankEntity = checkIfExists(accountNumber)
        bankRepository.delete(bankEntity)
    }

    fun checkIfExists(accountNumber: String): BankEntity = try {
        bankRepository.findBankEntityByAccountNumber(accountNumber)
    } catch (e: Exception) {
        throw IllegalArgumentException("Bank with account number $accountNumber doesn't exists")
    }

}