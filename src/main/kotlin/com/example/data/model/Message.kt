package com.example.data.model

import kotlinx.serialization.Serializable
import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId


@Serializable
data class Message(
    val text:String,
    val username:String,
    val timestamp:Long,
    @BsonId
    val id:String = ObjectId().toString()  //create random id for each message
)
//ObjectId is commonly used in MongoDB to generate unique identifiers for documents in a collection.