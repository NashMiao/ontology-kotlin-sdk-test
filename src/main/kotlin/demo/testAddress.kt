package demo

import com.github.ontio.OntSdk
import com.github.ontio.common.Address

class TestAddress {
    fun testAddressFromVmCode() {
        OntSdk.setConnectTestNet()
        val codeHex = "54c56b6c766b00527ac46c766b51527ac4616c766b00c36c766b52527ac46c766b52c30548656c6c6f87630600621a006c766b51c300c36165230061516c766b53527ac4620e00006c766b53527ac46203006c766b53c3616c756651c56b6c766b00527ac46151c576006c766b00c3c461681553797374656d2e52756e74696d652e4e6f7469667961616c7566"
        val codeAddress = Address.AddressFromVmCode(codeHex).toHexString()
        val codeHexAddress = "362cb5608b3eca61d4846591ebb49688900fedd0"
        if (codeAddress == codeHexAddress) {
            print("codeAddress:")
            println(codeAddress)
        } else {
            print("testAddressFromVmCode Error.")
        }
    }
}