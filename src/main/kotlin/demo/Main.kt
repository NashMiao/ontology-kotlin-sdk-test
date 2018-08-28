package main.kotlin.demo

import demo.testRPC

fun testRPC(){
    val testRPC: testRPC = testRPC()
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

fun main(args: Array<String>) {
    main.kotlin.demo.testRPC()
}