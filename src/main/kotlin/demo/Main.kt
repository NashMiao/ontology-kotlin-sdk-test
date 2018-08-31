package demo

import com.github.ontio.OntSdk

fun runTestRPC() {
    val testRPC: demo.TestRPC = TestRPC()
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
    val testRestful: demo.TestRestful = TestRestful()
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

fun runTestNeoVm() {
    val testNeoVm: demo.TestNVm = TestNVm()
    testNeoVm.testSendTransaction()
    testNeoVm.testInvokeTransaction()
}

fun main(args: Array<String>) {
//    demo.runTestRPC()
//    demo.runTestRestful()
    demo.runTestNeoVm()
}
