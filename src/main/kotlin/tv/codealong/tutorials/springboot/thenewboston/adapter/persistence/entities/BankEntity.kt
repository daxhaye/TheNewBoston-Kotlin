package tv.codealong.tutorials.springboot.thenewboston.adapter.persistence.entities

import tv.codealong.tutorials.springboot.thenewboston.model.Bank
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Entity
import javax.persistence.Table
import javax.persistence.Column
import javax.persistence.Id

@Entity
@Table(name = "banks")
data class BankEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bank")
    val idBank: Long = 0,
    @Column(name = "account_number")
    val accountNumber: String,
    @Column(name = "trust")
    val trust: Double,
    @Column(name = "transaction_fee")
    val transactionFee: Int) {

    constructor(bank : Bank) : this(
        accountNumber = bank.accountNumber,
        trust = bank.trust,
        transactionFee = bank.transactionFee
    )
}

fun BankEntity.toBank() = Bank(accountNumber, trust, transactionFee)