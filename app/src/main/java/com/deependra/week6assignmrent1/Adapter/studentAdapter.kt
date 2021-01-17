package com.deependra.week6assignmrent1.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.deependra.week6assignmrent1.R
import com.deependra.week6assignmrent1.model.studentDetails
import de.hdodenhof.circleimageview.CircleImageView

class studentAdapter (
    val lstStudent : ArrayList<studentDetails>,
    val context : Context
    ) : RecyclerView.Adapter<studentAdapter.StudentViewHolder>() {

    class StudentViewHolder(view : View) :
        RecyclerView.ViewHolder(view){

        val imgProfile: CircleImageView
        val tvName: TextView
        val tvAddress: TextView
        val tvAge : TextView
        val tvgender : TextView
        val imgDel : ImageButton

        init {
            imgProfile = view.findViewById(R.id.imgProfile)
            tvName = view.findViewById(R.id.tvName)
            tvAddress = view.findViewById(R.id.tvAddress)
            tvAge = view.findViewById(R.id.tvAge)
            tvgender = view.findViewById(R.id.tvGender)
            imgDel = view.findViewById(R.id.imgDel)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_add,parent,false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = lstStudent[position]
        holder.tvName.text = student.studentName
        holder.tvAddress.text = student.studentAddress
        holder.tvAge.text = student.studentAge.toString()
        holder.tvgender.text = student.studentGender

        Glide.with(context)
            .load(student.studentImage)
            .into(holder.imgProfile)

        holder.imgDel.setOnClickListener {
            lstStudent.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,lstStudent.size)
        }

        holder.imgProfile.setOnClickListener {
            Toast.makeText(context, "hello i am ${student.studentName}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return lstStudent.size
    }
}
