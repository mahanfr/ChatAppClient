package ir.mahanfr.chatapp.data.models

data class Chat(val id:Long
                , val messages:List<Message>
                , val participants:List<String>)
