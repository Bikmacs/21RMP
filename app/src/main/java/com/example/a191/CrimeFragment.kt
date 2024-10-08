package com.example.a191

import Crime
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import org.w3c.dom.Text
import java.time.LocalDate
import java.util.UUID

class CrimeFragment : Fragment() {
    private lateinit var crime: Crime
    private lateinit var title2: TextView
    private lateinit var titleField: EditText
    private lateinit var solvedCheckBox: CheckBox
    private lateinit var dateButton: Button
    var txt = "убийство"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        crime = Crime(
            id = UUID.randomUUID(),
            title = txt,
            isSolved = true,
            date = LocalDate.now()
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crime, container, false)
        titleField = view.findViewById(R.id.crime_title) as EditText
        title2 = view.findViewById(R.id.title2) as TextView
        dateButton = view.findViewById(R.id.crime_date) as Button
        dateButton.apply {
            text = crime.date.toString()
            isEnabled = false
            solvedCheckBox = view.findViewById(R.id.crime_solved) as CheckBox

        }
        return view
    }

    override fun onStart() {
        super.onStart()
        val titleWatcher = object : TextWatcher {
            override fun beforeTextChanged(
                sequence: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {

            }

            override fun onTextChanged(
                sequence: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                crime.title = sequence.toString()
            }

            override fun afterTextChanged(sequence: Editable?) {

            }
        }
        titleField.addTextChangedListener(titleWatcher)
        solvedCheckBox.apply {
            setOnCheckedChangeListener { _, isChecked ->
                crime.isSolved = isChecked
            }
        }
        solvedCheckBox.setOnCheckedChangeListener { _, isChecked ->
            dateButton.isEnabled = isChecked
        }
        dateButton.setOnClickListener {
            title2.text = titleField.text.toString()
            android.os.Handler().postDelayed({
                val Intent = Intent(context, floating_screen::class.java)
                startActivity(Intent)
            },3000)

        }
    }
}
