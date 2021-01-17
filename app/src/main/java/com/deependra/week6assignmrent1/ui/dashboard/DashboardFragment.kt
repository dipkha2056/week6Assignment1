package com.deependra.week6assignmrent1.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.deependra.week6assignmrent1.R
import com.deependra.week6assignmrent1.buttomNavActivity
import com.deependra.week6assignmrent1.model.studentDetails


class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var etName : EditText
    private lateinit var etAge : EditText
    private lateinit var rdoGroup : RadioGroup
    private lateinit var rdoMale : RadioButton
    private lateinit var rdoFemale : RadioButton
    private lateinit var rdOthers : RadioButton
    private lateinit var etAddress: EditText
    private lateinit var etUrl : EditText
    private lateinit var btnSave : Button
    private var gender = ""
    private var lstStudent = arrayListOf<studentDetails>()

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        etName = root.findViewById(R.id.etName)
        etAge = root.findViewById(R.id.etAge)
        etAddress = root.findViewById(R.id.etAddress)
        rdoGroup = root.findViewById(R.id.rdoGroup)
        rdoMale = root.findViewById(R.id.rdoMale)
        rdoFemale = root.findViewById(R.id.rdoFemale)
        rdOthers = root.findViewById(R.id.rdOther)
        etUrl = root.findViewById(R.id.etUrl)

        btnSave = root.findViewById(R.id.btnSave)

        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            //textView.text = it

            lstStudent = (activity as buttomNavActivity).lstStudent

            rdoGroup.setOnCheckedChangeListener { radioGroup, i ->
                if (i == R.id.rdoMale) {
                    gender = "Male"
                }

                if (i == R.id.rdoFemale) {
                    gender = "Female"
                }

                if (i == R.id.rdOther) {
                    gender = "Others"
                }

            }

            btnSave.setOnClickListener {
                val studentId: Int? = null

                val studentName = etName.text.toString()
                val studentImage = etUrl.text.toString()
                val studentAge = etAge.text.toString().toInt()
                val studentAddress = etAddress.text.toString()
                gender

                val student = studentDetails(studentId, studentName, studentImage, studentAddress, studentAge, gender)
                lstStudent.add(student)
                Toast.makeText(context, "student added", Toast.LENGTH_SHORT).show()
            }

        })
        return root
    }
}