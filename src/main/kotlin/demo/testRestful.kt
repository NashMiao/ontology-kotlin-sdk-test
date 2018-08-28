package demo

import com.github.ontio.OntSdk
import com.github.ontio.account.Account
import com.github.ontio.common.Helper
import com.github.ontio.crypto.SignatureScheme
import com.github.ontio.smartcontract.nativevm.Ont

class testRestful {
    fun testGetVersion() {
        val restUrl = "http://polaris3.ont.io:20334"
        OntSdk.setRestful(restUrl)
        val version = OntSdk.restful.getVersion()
        print("Version: ")
        println(version)
    }

    fun testGetNodeCount() {
        val restUrl = "http://polaris1.ont.io:20334"
        OntSdk.setRestful(restUrl)
        val count = OntSdk.restful.getNodeCount()
        print("NodeCount: ")
        println(count)
    }

    fun testGetBlockByHash() {
        val restUrl = "http://polaris1.ont.io:20334"
        OntSdk.setRestful(restUrl)
        val hash = "44425ae42a394ec0c5f3e41d757ffafa790b53f7301147a291ab9b60a956394c"
        val block = OntSdk.restful.getBlock(hash)
        print("Block: ")
        println(block)
    }

    fun testGetBlockByHeight() {
        val restUrl = "http://polaris1.ont.io:20334"
        OntSdk.setRestful(restUrl)
        val height = 0
        val block = OntSdk.restful.getBlock(height)
        print("Block: ")
        println(block)
    }

    fun testGetBlockHeight() {
        val restUrl = "http://polaris1.ont.io:20334"
        OntSdk.setRestful(restUrl)
        val blockHeight = OntSdk.restful.getBlockHeight()
        print("BlockHeight: ")
        println(blockHeight)
    }

    fun testGetBalance() {
        val restUrl = "http://polaris1.ont.io:20334"
        OntSdk.setRestful(restUrl)
        val b58Address = "AazEvfQPcQ2GEFFPLF1ZLwQ7K5jDn81hve"
        val balance = OntSdk.restful.getBalance(b58Address)
        print("Balance: ")
        println(balance)
    }

    fun testGetAllowance() {
        val restUrl = "http://polaris1.ont.io:20334"
        OntSdk.setRestful(restUrl)
        val b58Address1 = "ANH5bHrrt111XwNEnuPZj6u95Dd6u7G4D6"
        val b58Address2 = "AazEvfQPcQ2GEFFPLF1ZLwQ7K5jDn81hve"
        val ont_allowance = OntSdk.restful.getAllowance("ont", b58Address1, b58Address2)
        print("Allowance: ")
        println(ont_allowance)
        val ong_allowance = OntSdk.restful.getAllowance("ong", b58Address1, b58Address2)
        print("Allowance: ")
        println(ong_allowance)
    }

    fun testGetStorage() {
        val restUrl = "http://polaris1.ont.io:20334"
        OntSdk.setRestful(restUrl)
        val contractAddress = "0100000000000000000000000000000000000000"
        val key = "746f74616c537570706c79"
        val value = OntSdk.restful.getStorage(contractAddress, key)
        print("Storage: ")
        println(value)
    }

    fun testGetSmartCodeEvent() {
        val restUrl = "http://polaris1.ont.io:20334"
        OntSdk.setRestful(restUrl)
        val txHash = "65d3b2d3237743f21795e344563190ccbe50e9930520b8525142b075433fdd74"
        val eventByHash = OntSdk.restful.getSmartCodeEvent(txHash)
        print("Event: ")
        println(eventByHash)
        val height = 0
        val eventByHeight = OntSdk.restful.getSmartCodeEvent(height)
        print("Event: ")
        println(eventByHeight)
    }

    fun testGetTransaction() {
        val restUrl = "http://polaris1.ont.io:20334"
        OntSdk.setRestful(restUrl)
        val txHash = "65d3b2d3237743f21795e344563190ccbe50e9930520b8525142b075433fdd74"
        val transaction = OntSdk.restful.getTransaction(txHash)
        print("Transaction: ")
        println(transaction)
    }

    fun testGetMerkleProof() {
        val restUrl = "http://polaris1.ont.io:20334"
        OntSdk.setRestful(restUrl)
        val txHash = "65d3b2d3237743f21795e344563190ccbe50e9930520b8525142b075433fdd74"
        val proof = OntSdk.restful.getMerkleProof(txHash)
        print("MerkleProof: ")
        println(proof)
    }

    fun testSendRawTransaction() {
        val restUrl = "http://polaris1.ont.io:20334"
        OntSdk.setRestful(restUrl)
        val privateKey = "523c5fcf74823831756f0bcb3634234f10b3beb1c05595058534577752ad2d9f"
        val payer = Account(Helper.hexToBytes(privateKey), SignatureScheme.SHA256WITHECDSA)
        val b58Payer = payer.addressU160.toBase58()
        val b58Recv = "AazEvfQPcQ2GEFFPLF1ZLwQ7K5jDn81hve"
        println("balance: " + OntSdk.restful.getBalance(payer.addressU160.toBase58()))
        val transaction = Ont.makeTransfer(b58Payer, b58Recv, 1, b58Payer, 20000, 500)
        OntSdk.signTx(transaction, arrayOf(arrayOf(payer)))
        val result = OntSdk.restful.sendRawTransaction(transaction)
        print("sendRawTransaction: ")
        println(result)
    }

    fun testSendRawTransactionPreExec() {
        val restUrl = "http://polaris1.ont.io:20334"
        OntSdk.setRestful(restUrl)
        val privateKey = "523c5fcf74823831756f0bcb3634234f10b3beb1c05595058534577752ad2d9f"
        val payer = Account(Helper.hexToBytes(privateKey), SignatureScheme.SHA256WITHECDSA)
        val b58Payer = payer.addressU160.toBase58()
        val b58Recv = "AazEvfQPcQ2GEFFPLF1ZLwQ7K5jDn81hve"
        println("balance: " + OntSdk.restful.getBalance(payer.addressU160.toBase58()))
        val transaction = Ont.makeTransfer(b58Payer, b58Recv, 1, b58Payer, 20000, 500)
        OntSdk.signTx(transaction, arrayOf(arrayOf(payer)))
        val result = OntSdk.restful.sendRawTransactionPreExec(transaction.toHexString())
        print("sendRawTransactionPreExec: ")
        println(result)
    }

}