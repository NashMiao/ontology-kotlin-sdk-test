package demo

import com.github.ontio.OntSdk

fun runTestRPC() {
    val testRPC: demo.testRPC = testRPC()
    testRPC.testGetVersion()
    testRPC.testGetNodeCount()
    testRPC.testGetBlockByHash()
    testRPC.testGetBlockByHeight()
    testRPC.testGetBlockHeight()
    testRPC.testGetBalance()
    testRPC.testGetAllowance()
    testRPC.testGetStorage()
    testRPC.testGetSmartCodeEvent()
    testRPC.testGetTransaction()
    testRPC.testGetMerkleProof()
    testRPC.testSendRawTransaction()
    testRPC.testSendRawTransactionPreExec()
}

fun runTestRestful() {
    val testRestful: demo.testRestful = testRestful()
    testRestful.testGetVersion()
    testRestful.testGetNodeCount()
    testRestful.testGetBlockByHash()
    testRestful.testGetBlockByHeight()
    testRestful.testGetBlockHeight()
    testRestful.testGetBalance()
    testRestful.testGetAllowance()
    testRestful.testGetStorage()
    testRestful.testGetSmartCodeEvent()
    testRestful.testGetTransaction()
    testRestful.testGetMerkleProof()
    testRestful.testSendRawTransaction()
    testRestful.testSendRawTransactionPreExec()
}

fun main(args: Array<String>) {
    demo.runTestRPC()
    demo.runTestRestful()
}
