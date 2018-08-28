# ontology-kotlin-sdk RPC Testing

- :egg: 表示在`ontology-kotlin-sdk`中未找到对应的接口。

- :hatching_chick:表示在`ontology-kotlin-sdk`中有对应接口，但可能存在不完善的地方。 

- :hatched_chick: 表示在`ontology-kotlin-sdk`中存在完全对应接口。

|      Result     |              |
|:---------------:|:------------:|
| :hatched_chick: | getVersion() |

## getVersion()

### Test Code

```Kotlin
fun testGetVersion() {
    OntSdk.setConnectTestNet()
    val version = OntSdk.rpc.getVersion()
    print("Version: ")
    println(version)
}
```

### Test Result

```bash
POST url=http://polaris1.ont.io:20336,{"jsonrpc":"2.0","method":"getversion","params":[],"id":1}
Version: v1.0.2
```

## getNodeCount()

### Test Code

```Kotlin
fun testGetNodeCount() {
    OntSdk.setConnectTestNet()
    val count = OntSdk.rpc.getNodeCount()
    print("NodeCount: ")
    println(count)
}
```

### Test Result

```bash
POST url=http://polaris1.ont.io:20336,{"jsonrpc":"2.0","method":"getconnectioncount","params":[],"id":1}
NodeCount: 14
```

## GetBlock()

### Test Code

```Kotlin
fun testGetBlock() {
    OntSdk.setConnectTestNet()
    val hash = "44425ae42a394ec0c5f3e41d757ffafa790b53f7301147a291ab9b60a956394c"
    val block = OntSdk.rpc.getBlock(hash)
    print("Block: ")
    println(block)
}
```

### Test Result

```bash
POST url=http://polaris1.ont.io:20336,{"jsonrpc":"2.0","method":"getblock","params":["44425ae42a394ec0c5f3e41d757ffafa790b53f7301147a291ab9b60a956394c"],"id":1}
Block: com.github.ontio.core.block.Block@a956394c
```