package pl.org.seva.myapplication.main

import pl.org.seva.myapplication.main.init.instance

val poco by instance<IPoCo>()

class PoCo : IPoCo {

    override fun nieWiemPoCo() {
        println("nie wiem po co")
    }
}
