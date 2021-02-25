package ir.mahanfr.chatapp.ui.activities

import android.annotation.SuppressLint
import android.content.Context
import android.hardware.input.InputManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.mahanfr.chatapp.R
import ir.mahanfr.chatapp.adapters.ConversationRecyclerviewAdapter
import ir.mahanfr.chatapp.data.models.Message

class MessagingActivity : AppCompatActivity() {
    @SuppressLint("ServiceCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messaging)
        val dummyDataList:ArrayList<Message> = ArrayList()
        val button : Button = findViewById(R.id.activity_messaging_message_send_button)
        val editText :EditText = findViewById(R.id.activity_messaging_message_content_edit_text)

        //TODO: Change Dummy For The Real one

        dummyDataList.add(Message(1,"mahan","SalamAleik","12",true))
        dummyDataList.add(Message(2,"admin","Salam","12",false))
        dummyDataList.add(Message(3,"mahan","halet cheto re??","12",true))
        dummyDataList.add(Message(4,"admin","khobam mer30","12",false))
        dummyDataList.add(Message(5,"mahan","to hijvaght halamo dark nemikoni on roze ke ba mahtab dashtim miraftim kafsh charimaro bekharim to be nastarn gofti ina keili zeshtan vali be man nagofty","12",true))
        dummyDataList.add(Message(6,"admin","ok","12",false))
        dummyDataList.add(Message(7,"mahan","ko chi mikardam?","12",false))
        Log.d("DummyList",dummyDataList.size.toString())

        val recyclerView: RecyclerView = findViewById(R.id.activity_messaging_conversation_list_recyclerView)
        val myAdapter = ConversationRecyclerviewAdapter(dummyDataList)
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        val inputManager = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        button.setOnClickListener {
            dummyDataList.add(Message(10,"mahan",editText.text.toString(),"12",true))
            editText.setText("")

            inputManager.hideSoftInputFromWindow(this.currentFocus?.windowToken,InputMethodManager.HIDE_NOT_ALWAYS)
            //editText.clearFocus()
            myAdapter.notifyDataSetChanged()
        }

    }
}