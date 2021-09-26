fun main(args: Array<String>) {
    printPairings(getPairings(getSenders(getParticipants())))
}

fun getPairings(senders: List<String>, numParticipants: Int = senders.count(), offset: Int = getOffset(numParticipants)) : List<Pair<String, String>> {
    return senders.mapIndexed {senderIdx, sender -> Pair(sender, senders.elementAt(getReceiverIndex(senderIdx, numParticipants, offset))}
}

fun printPairings(pairings: List<Pair<String, String>>) { pairings.forEach(){ pair -> println("${pair.first} -> ${pair.second}")} }

fun getSenders(participants: List<String>): List<String> { return participants.shuffled() }

fun getParticipants(): List<String> { return mutableListOf("Michael", "Alice", "Bob", "Charlie", "Diane", "Elmar", "Fiona") }

fun getOffset(numParticipants: Int): Int { return (1..(numParticipants - 1)).random() }

fun getReceiverIndex(senderIndex: Int, numParticipants: Int, offset: Int): Int { return (senderIndex + offset) % numParticipants }