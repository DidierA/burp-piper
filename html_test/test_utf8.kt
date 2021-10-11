fun main() {
    val b="Désolé".encodeToByteArray() // encode in UTF-8
    b[0]=255.toByte() // replace first byte with 255 wich will give an invalid UTF-8 sequence
    println(b.map{String.format("%02x",it)}.joinToString(" ")) // print contents as hex
    val dest=b.decodeToString(throwOnInvalidSequence=true) // decode UTF-8 (will throw java.nio.charset.MalformedInputException)
    println(dest)
}
