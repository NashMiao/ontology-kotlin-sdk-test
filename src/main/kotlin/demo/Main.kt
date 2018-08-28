package main.kotlin.demo

import com.github.ontio.OntSdk
import com.github.ontio.account.Account
import com.github.ontio.common.Helper
import com.github.ontio.crypto.SignatureScheme
import com.github.ontio.smartcontract.nativevm.Ont

fun main(args: Array<String>) {
    OntSdk.setConnectTestNet()
    val privateKey = "523c5fcf74823831756f0bcb3634234f10b3beb1c05595058534577752ad2d9f"
    val acct = Account(Helper.hexToBytes(privateKey), SignatureScheme.SHA256WITHECDSA)
    println("address:" + acct.addressU160.toBase58())
    println("balance: " + OntSdk.rpc.getBalance(acct.addressU160.toBase58()))
    val transaction = Ont.makeTransfer("ANH5bHrrt111XwNEnuPZj6u95Dd6u7G4D6", "AazEvfQPcQ2GEFFPLF1ZLwQ7K5jDn81hve", 1, "ANH5bHrrt111XwNEnuPZj6u95Dd6u7G4D6", 20000, 500)
    OntSdk.signTx(transaction, arrayOf(arrayOf(acct)))
    val res = OntSdk.rpc.sendRawTransaction(transaction)
    println("sendRawTransaction: " + res)
}