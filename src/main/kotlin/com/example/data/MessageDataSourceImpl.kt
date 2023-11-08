package com.example.data

import com.example.data.model.Message
import org.litote.kmongo.coroutine.CoroutineDatabase

class MessageDataSourceImpl(
    private val db:CoroutineDatabase
):MessageDataSource {

//    In Mongo DB we save everything in collection of database
    private val messages = db.getCollection<Message>() //to create message collection //if not exist create new.

    override suspend fun getAllMessages(): List<Message> {
        return  messages.find()
            .descendingSort(Message::timestamp) //In mongo sort in decending acc to timeStamp
            .toList()
    }

    override suspend fun insertMessage(message: Message) {
        messages.insertOne(message)
    }
}