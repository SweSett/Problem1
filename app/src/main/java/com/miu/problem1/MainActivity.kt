package com.miu.problem1

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // CREATE TABLE
        val tableLayout = TableLayout(this)

        tableLayout.isStretchAllColumns = true;

        // CREATE TABLE ROW
        val tableVersionRow = TableRow(this)

        // CREATE PARAM FOR MARGINING
        val layoutParam: TableRow.LayoutParams =
            TableRow.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT).apply {
                setMargins(0, 6, 9, 4)
            }

        val versionText = EditText(this)
        tableVersionRow.layoutParams = layoutParam
        // SET BACKGROUND COLOR
        versionText.setBackgroundColor(Color.WHITE)

        // SET EDITTEXT
        versionText.setText("Enter Android Version")
        // ADD TEXTVIEW TO TABLEROW
        tableVersionRow.addView(versionText)
        // CREATE TABLE ROW
        val tableCodeRow = TableRow(this)
        val codeNameText = EditText(this)
        // SET PARAMS
        codeNameText.layoutParams = layoutParam
        // SET BACKGROUND COLOR
        codeNameText.setBackgroundColor(Color.WHITE)
        // SET EDITTEXT
        codeNameText.setText("Enter Android Code Name")
        // ADD TEXTVIEW TO TABLEROW
        tableCodeRow.addView(codeNameText)

        // CREATE TABLE ROW
        val tableAddRow = TableRow(this)
        val addButton = Button (this)
        
        val butParam: TableRow.LayoutParams =
            TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT)

        tableAddRow.layoutParams = butParam
        // SET BACKGROUND COLOR
        addButton.setBackgroundColor(Color.GRAY)
        // SET EDITTEXT
        addButton.text = "ADD"

        // ADD BUTTON TO TABLEROW
        tableAddRow.addView(addButton)

        // ADD TABLEROW TO TABLELAYOUT
        tableLayout.addView(tableVersionRow)
        tableLayout.addView(tableCodeRow)
        tableLayout.addView(tableAddRow)
        tableLayout.addView(addRowSpace())

        tableLayout.addView(addTableRow("Version","Code Name"))
        tableLayout.addView(addRowSpace())

        tableLayout.addView(addTableRow("Android 9.0", "Pie"))
        tableLayout.addView(addRowSpace())

        tableLayout.addView(addTableRow("Android 8.0", "Oreo"))
        tableLayout.addView(addRowSpace())


        addButton.setOnClickListener {
           tableLayout.addView(addTableRow(versionText.text.toString(),codeNameText.text.toString()))
           tableLayout.addView(addRowSpace())

        }
        setContentView(tableLayout)
    }
    private fun addRowSpace():TableRow{
        val layoutParam: TableRow.LayoutParams =
            TableRow.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT).apply {
                setMargins(0, 6, 9, 4)
            }

        val tableSpaceRow = TableRow(this)
        val tv = Space(this)
        tv.layoutParams = layoutParam
        tableSpaceRow.addView(tv)
        return tableSpaceRow
    }
    private fun  addTableRow(ver : String, code :String):TableRow{
        // CREATE TABLE ROW
        val addTableRow = TableRow(this)
        addTableRow.setBackgroundColor(Color.MAGENTA)
        val verParam: TableRow.LayoutParams =
            TableRow.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT).apply {
                setMargins(0, 6, 9, 0)
            }
        val versionText = TextView(this)
        // SET PARAMS
        versionText.layoutParams = verParam
        // SET EDITTEXT
        versionText.text=ver
        // ADD TEXTVIEW TO TABLEROW
        addTableRow.addView(versionText)

        val codeNameText = TextView(this)
        // SET PARAMS
        val codeParam: TableRow.LayoutParams =
            TableRow.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT).apply {
                setMargins(0, 3, 0, 0)
            }

        codeNameText.layoutParams = codeParam

        // SET EDITTEXT
        codeNameText.text=code
        // ADD TEXTVIEW TO TABLEROW
        addTableRow.addView(codeNameText)
        return  addTableRow
    }
}