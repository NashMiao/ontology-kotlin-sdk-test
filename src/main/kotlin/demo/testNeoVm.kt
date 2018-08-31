package demo

import com.alibaba.fastjson.JSON
import com.github.ontio.OntSdk
import com.github.ontio.account.Account
import com.github.ontio.common.Address
import com.github.ontio.common.Helper
import com.github.ontio.crypto.SignatureScheme
import com.github.ontio.smartcontract.NeoVm
import com.github.ontio.smartcontract.Vm
import com.github.ontio.smartcontract.neovm.abi.AbiInfo
import com.github.ontio.smartcontract.neovm.abi.BuildParams

class TestNVm {
    fun testMakeDeployTransaction() {
        OntSdk.setConnectTestNet()
        val privateKey = "523c5fcf74823831756f0bcb3634234f10b3beb1c05595058534577752ad2d9f"
        val payer = Account(Helper.hexToBytes(privateKey), SignatureScheme.SHA256WITHECDSA)
        val b58Payer = payer.addressU160.toBase58()
        val codeHex = "54c56b6c766b00527ac46c766b51527ac4616c766b00c36c766b52527ac46c766b52c30548656c6c6f87630600621a006c766b51c300c36165230061516c766b53527ac4620e00006c766b53527ac46203006c766b53c3616c756651c56b6c766b00527ac46151c576006c766b00c3c461681553797374656d2e52756e74696d652e4e6f7469667961616c7566"
        val codeAddress = Address.AddressFromVmCode(codeHex).toHexString()
        val gasLimit: Long = 20000000
        val gasPrice: Long = 500
        val tx = Vm.makeDeployCodeTransaction(codeHex, true, "name", "v1.0", "author", "email", "description", b58Payer, gasLimit, gasPrice)
        OntSdk.signTx(tx, arrayOf(arrayOf(payer)))
        val result = OntSdk.rpc.sendRawTransaction(tx.toHexString())
        print("DeployTransaction: ")
        println(result)
        Thread.sleep(6000)
        val contract = OntSdk.rpc.getContract(codeAddress)
        print("Contract: ")
        println(contract)
    }

    fun testMakeInvokeTransaction() {
        OntSdk.setConnectTestNet()
        val codeHex = "54c56b6c766b00527ac46c766b51527ac4616c766b00c36c766b52527ac46c766b52c30548656c6c6f87630600621a006c766b51c300c36165230061516c766b53527ac4620e00006c766b53527ac46203006c766b53c3616c756651c56b6c766b00527ac46151c576006c766b00c3c461681553797374656d2e52756e74696d652e4e6f7469667961616c7566"
        val abi = "{\"hash\":\"0x362cb5608b3eca61d4846591ebb49688900fedd0\",\"entrypoint\":\"Main\",\"functions\":[{\"name\":\"Main\",\"parameters\":[{\"name\":\"operation\",\"type\":\"String\"},{\"name\":\"args\",\"type\":\"Array\"}],\"returntype\":\"Any\"},{\"name\":\"Hello\",\"parameters\":[{\"name\":\"msg\",\"type\":\"String\"}],\"returntype\":\"Void\"}],\"events\":[]}"
        val abiInfo = JSON.parseObject(abi, AbiInfo::class.java)
        val func = abiInfo.getFunction("Hello")
        func!!.setParamsValue("value")
        val params = BuildParams.serializeAbiFunction(func)
        val codeAddress = Address.AddressFromVmCode(codeHex).toHexString()
        val gasLimit: Long = 0
        val gasPrice: Long = 0
        val tx = Vm.makeInvokeCodeTransaction(codeAddress, null, params, null, gasLimit, gasPrice)
        val result = OntSdk.rpc.sendRawTransactionPreExec(tx.toHexString())
        print(result)
    }

    fun testSendTransaction() {
        OntSdk.setConnectTestNet()
        val codeHex = "54c56b6c766b00527ac46c766b51527ac4616c766b00c36c766b52527ac46c766b52c30548656c6c6f87630600621a006c766b51c300c36165230061516c766b53527ac4620e00006c766b53527ac46203006c766b53c3616c756651c56b6c766b00527ac46151c576006c766b00c3c461681553797374656d2e52756e74696d652e4e6f7469667961616c7566"
        val abi = "{\"hash\":\"0x362cb5608b3eca61d4846591ebb49688900fedd0\",\"entrypoint\":\"Main\",\"functions\":[{\"name\":\"Main\",\"parameters\":[{\"name\":\"operation\",\"type\":\"String\"},{\"name\":\"args\",\"type\":\"Array\"}],\"returntype\":\"Any\"},{\"name\":\"Hello\",\"parameters\":[{\"name\":\"msg\",\"type\":\"String\"}],\"returntype\":\"Void\"}],\"events\":[]}"
        val abiInfo = JSON.parseObject(abi, AbiInfo::class.java)
        val func = abiInfo.getFunction("Hello")
        func!!.setParamsValue("value")
        val codeAddress = Address.AddressFromVmCode(codeHex).toHexString()
        val result = NeoVm.sendTransaction(codeAddress, null, null, 0, 0, func, true)
        println(result)
    }


}