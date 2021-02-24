package ir.mahanfr.chatapp.data

import ir.mahanfr.chatapp.data.models.Chats
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ContactApi {
    @GET("")
    suspend fun getContacts(
            @Query("base") base:String
    ):Response<Chats>
}