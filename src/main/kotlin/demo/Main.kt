package main.kotlin.demo

import com.github.ontio.OntSdk
import com.github.ontio.account.Account
import com.github.ontio.common.Helper
import com.github.ontio.crypto.SignatureScheme
import com.github.ontio.smartcontract.nativevm.Ont

fun testGetVersion() {
    OntSdk.setConnectTestNet()
    val version = OntSdk.rpc.getVersion()
    print("Version: ")
    println(version)
}

fun testGetNodeCount() {
    OntSdk.setConnectTestNet()
    val count = OntSdk.rpc.getNodeCount()
    print("NodeCount: ")
    println(count)
}

fun testGetBlockByHash() {
    OntSdk.setConnectTestNet()
    val hash = "44425ae42a394ec0c5f3e41d757ffafa790b53f7301147a291ab9b60a956394c"
    val block = OntSdk.rpc.getBlock(hash)
    print("Block: ")
    println(block)
}

fun testGetBlockByHeight() {
    OntSdk.setConnectTestNet()
    val height = 0
    val block = OntSdk.rpc.getBlock(height)
    print("Block: ")
    println(block)
}

fun testGetBlockHeight() {
    OntSdk.setConnectTestNet()
    val blockHeight = OntSdk.rpc.getBlockHeight()
    print("BlockHeight: ")
    println(blockHeight)
}

fun testGetBalance() {
    OntSdk.setConnectTestNet()
    val b58Address = "AazEvfQPcQ2GEFFPLF1ZLwQ7K5jDn81hve"
    val balance = OntSdk.rpc.getBalance(b58Address)
    print("Balance: ")
    println(balance)
}

fun testGetAllowance() {
    OntSdk.setConnectTestNet()
    val b58Address1 = "ANH5bHrrt111XwNEnuPZj6u95Dd6u7G4D6"
    val b58Address2 = "AazEvfQPcQ2GEFFPLF1ZLwQ7K5jDn81hve"
    val ont_allowance = OntSdk.rpc.getAllowance("ont", b58Address1, b58Address2)
    print("Allowance: ")
    println(ont_allowance)
    val ong_allowance = OntSdk.rpc.getAllowance("ong", b58Address1, b58Address2)
    print("Allowance: ")
    println(ong_allowance)
}

fun testGetStorage() {
    OntSdk.setConnectTestNet()
    val contractAddress = "0100000000000000000000000000000000000000"
    val key = "746f74616c537570706c79"
    val value = OntSdk.rpc.getStorage(contractAddress, key)
    print("Storage: ")
    println(value)
}

fun testGetSmartCodeEvent() {
    OntSdk.setConnectTestNet()
    val txHash = "65d3b2d3237743f21795e344563190ccbe50e9930520b8525142b075433fdd74"
    val eventByHash = OntSdk.rpc.getSmartCodeEvent(txHash)
    print("Event: ")
    println(eventByHash)
    val height = 0
    val eventByHeight = OntSdk.rpc.getSmartCodeEvent(height)
    print("Event: ")
    println(eventByHeight)
}

fun testSendRawTransaction() {
    OntSdk.setConnectTestNet()
    val privateKey = "523c5fcf74823831756f0bcb3634234f10b3beb1c05595058534577752ad2d9f"
    val payer = Account(Helper.hexToBytes(privateKey), SignatureScheme.SHA256WITHECDSA)
    val b58Payer = payer.addressU160.toBase58()
    val b58Recv = "AazEvfQPcQ2GEFFPLF1ZLwQ7K5jDn81hve"
    println("balance: " + OntSdk.rpc.getBalance(payer.addressU160.toBase58()))
    val transaction = Ont.makeTransfer(b58Payer, b58Recv, 1, b58Payer, 20000, 500)
    OntSdk.signTx(transaction, arrayOf(arrayOf(payer)))
    val result = OntSdk.rpc.sendRawTransaction(transaction)
    print("sendRawTransaction: ")
    println(result)
}

fun main(args: Array<String>) {
    testGetVersion()
    testGetNodeCount()
    testGetBlockByHash()
    testGetBlockByHeight()
    testGetBlockHeight()
    testGetBalance()
    testGetAllowance()
    testGetStorage()
    testGetSmartCodeEvent()
    testSendRawTransaction()
}