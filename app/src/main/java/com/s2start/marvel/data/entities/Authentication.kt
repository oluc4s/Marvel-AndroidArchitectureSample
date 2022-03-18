package com.s2start.marvel.data.entities

import java.math.BigInteger
import java.security.MessageDigest
import java.security.Timestamp
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class Authentication {
    val publicKey: String = "00a34b99ef32cef640885260b7e1821c"
    val privateKey: String = "148d35a0e94e32593bb6086bdcb1e08c17b40842"
    val ts:String = Date().toString()
    val hash :String =  md5(ts+privateKey+publicKey)

}

fun md5(input:String): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
}