package ir.mahanfr.chatapp.adapters

import android.view.LayoutInflater
import ir.mahanfr.chatapp.data.models.Message
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ir.mahanfr.chatapp.R

class ConversationRecyclerviewAdapter(private val dataSet: ArrayList<Message>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ViewHolder0(view: View):RecyclerView.ViewHolder(view) {
        val sendTextView : TextView = view.findViewById(R.id.conversation_send_item_text)
    }
    class ViewHolder1(view: View):RecyclerView.ViewHolder(view) {
        val receiveTextView : TextView = view.findViewById(R.id.conversation_receive_item_text)
    }

    override fun getItemViewType(position: Int): Int {
        return if(dataSet.elementAt(position).is_sender_message) 1 else 0
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == 1){
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.conversation_send_item, viewGroup, false)

            ViewHolder0(view)
        }else{
            val view = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.conversation_receive_item, viewGroup, false)

            ViewHolder1(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder.itemViewType == 1){
            holder as ViewHolder0
            holder.sendTextView.text = dataSet[position].content
        }else{
            holder as ViewHolder1
            holder.receiveTextView.text = dataSet[position].content
        }
    }

    override fun getItemCount(): Int = dataSet.size
}