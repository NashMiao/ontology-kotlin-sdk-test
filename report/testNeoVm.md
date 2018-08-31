# ontology-kotlin-sdk NeoVm Testing

<!-- TOC -->

- [ontology-kotlin-sdk NeoVm Testing](#ontology-kotlin-sdk-neovm-testing)
    - [Overview](#overview)
    - [](#)
        - [Test Code](#test-code)
        - [Test Result](#test-result)

<!-- /TOC -->

## Overview

- :egg: 表示在`ontology-kotlin-sdk`中未找到对应的接口。

- :hatching_chick:表示在`ontology-kotlin-sdk`中有对应接口，但可能存在不完善的地方。 

- :hatched_chick: 表示在`ontology-kotlin-sdk`中存在完全对应接口。

| Result          |                      |
| :-------------: | :------------------: |
| :hatched_chick: | sendRawTransaction() |

## 

### Test Code

```Kotlin
fun testSendTransaction() {
    OntSdk.setConnectTestNet()
    val privateKey = "523c5fcf74823831756f0bcb3634234f10b3beb1c05595058534577752ad2d9f"
    val account = Account(Helper.hexToBytes(privateKey), SignatureScheme.SHA256WITHECDSA)
    val codeHex = "54c56b6c766b00527ac46c766b51527ac4616c766b00c36c766b52527ac46c766b52c30548656c6c6f87630600621a006c766b51c300c36165230061516c766b53527ac4620e00006c766b53527ac46203006c766b53c3616c756651c56b6c766b00527ac46151c576006c766b00c3c461681553797374656d2e52756e74696d652e4e6f7469667961616c7566"
    val codeAddress = Address.AddressFromVmCode(codeHex).toHexString()
    val tx = Vm.makeDeployCodeTransaction(codeHex, true, "name", "v1.0", "author", "email", "desp", account.addressU160.toBase58(), 20000000, 500)
    OntSdk.signTx(tx, arrayOf(arrayOf(account)))
    val result = OntSdk.rpc.sendRawTransaction(tx.toHexString())
    print("sendRawTransaction: ")
    println(result)
    Thread.sleep(6000)
    val contract = OntSdk.rpc.getContract(codeAddress)
    print("Contract: ")
    println(contract)
}
```

### Test Result

```bash
POST url=http://polaris1.ont.io:20336,{"jsonrpc":"2.0","method":"sendrawtransaction","params":["00d038e53cabf401000000000000002d3101000000004756c9dd829b2142883adbe1ae4f8689a1f673e98d54c56b6c766b00527ac46c766b51527ac4616c766b00c36c766b52527ac46c766b52c30548656c6c6f87630600621a006c766b51c300c36165230061516c766b53527ac4620e00006c766b53527ac46203006c766b53c3616c756651c56b6c766b00527ac46151c576006c766b00c3c461681553797374656d2e52756e74696d652e4e6f7469667961616c756601046e616d650476312e3006617574686f7205656d61696c0464657370000142410102dae82655c6b1845fb72ad21fca0528dee4436040deab5a817f5e0295c3a3bc909c110ede6815a93b697344ae0011a6f97ab9ee8a05be006889c98cbeee9432232103036c12be3726eb283d078dff481175e96224f0b0c632c7a37e10eb40fe6be889ac"],"id":1}
sendRawTransaction: true
POST url=http://polaris1.ont.io:20336,{"jsonrpc":"2.0","method":"getcontractstate","params":["362cb5608b3eca61d4846591ebb49688900fedd0",1],"id":1}
Contract: {"NeedStorage":true,"Email":"XXX@XXXX.com","Description":"Hello World","CodeVersion":"1.0","Author":"Tester","Code":"54c56b6c766b00527ac46c766b51527ac4616c766b00c36c766b52527ac46c766b52c30548656c6c6f87630600621a006c766b51c300c36165230061516c766b53527ac4620e00006c766b53527ac46203006c766b53c3616c756651c56b6c766b00527ac46151c576006c766b00c3c461681553797374656d2e52756e74696d652e4e6f7469667961616c7566","Name":"MyHello"}
```