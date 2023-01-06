package tv.codealong.tutorials.springboot.thenewboston.adapter.persistence


class MockBankDataSource
/*: BankDataSource {

    val banks = mutableListOf(
        Bank("1234", 3.14, 17),
        Bank("1010", 17.0, 0),
        Bank("5678", 0.0, 100),
    )

    override fun retrieveBanks(): Collection<Bank> = banks

    override fun retrieveBank(accountNumber: String): Bank =
        banks.firstOrNull() { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Account number not found in data base")

    override fun createBank(bank: Bank): Bank {
        if (banks.any { it.accountNumber == bank.accountNumber }) {
            throw IllegalArgumentException("Bank with account number ${bank.accountNumber} already exists")
        }
        banks.add(bank)
        return bank
    }

    override fun updateBank(bank: Bank): Bank {
        val updateBank = banks.firstOrNull { it.accountNumber == bank.accountNumber }
            ?: throw NoSuchElementException("Account number not found in data base")

        banks.remove(updateBank)
        banks.add(bank)
        return bank
    }

    override fun deleteBank(accountNumber: String) {
        val updateBank = banks.firstOrNull { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Account number not found in data base")

        banks.remove(updateBank)
    }
}*/