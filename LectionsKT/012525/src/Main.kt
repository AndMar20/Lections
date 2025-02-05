import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel

suspend fun main() = coroutineScope {
//    var channel = Channel<Int>()
//
//
//    launch{
//        for (n in 1..5){
//            channel.send(n)
//        }
//        channel.close()
//    }
//
//    repeat(5){
//        val number = channel.receive()
//        println(number)
//    }
//
//    for (n in channel) {
//        println(n)
//    }
//
//    println("End")
    //withTimeoutOrNull() без исключений
    withTimeout(1000L){     //
        repeat(1000){
            println("1")
            delay(300L)
        }
    }
    Unit
}