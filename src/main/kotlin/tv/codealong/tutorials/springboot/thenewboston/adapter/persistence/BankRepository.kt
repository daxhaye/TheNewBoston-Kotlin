package tv.codealong.tutorials.springboot.thenewboston.adapter.persistence

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import tv.codealong.tutorials.springboot.thenewboston.adapter.persistence.entities.BankEntity


@Repository
interface BankRepository : JpaRepository<BankEntity, Long> {
    fun findBankEntityByAccountNumber(accountNumber : String) : BankEntity
    fun existsBankEntityByAccountNumber(accountNumber: String) : Boolean
}