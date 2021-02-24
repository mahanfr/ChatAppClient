package ir.mahanfr.chatapp.data.models

data class Message(val id:Long,
                   val author:String,
                   val content:String,
                   val timestamp:String)
