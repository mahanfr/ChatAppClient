package ir.mahanfr.chatapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ir.mahanfr.chatapp.R
import androidx.recyclerview.widget.RecyclerView
import ir.mahanfr.chatapp.data.models.Chat

class MessageRecyclerviewAdapter(private val dataSet: ArrayList<Chat>) :RecyclerView.Adapter<MessageRecyclerviewAdapter.ViewHolder>(){
    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val profileUsernameTextView : TextView = view.findViewById(R.id.message_item_profile_username)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.message_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get element from your dataSet at this position and replace the
        // contents of the view with that element
        //TODO:Change this to profile name of a chat
        holder.itemView.tag = position
        holder.profileUsernameTextView.text = "Mahan"
    }

    override fun getItemCount() = dataSet.size
}