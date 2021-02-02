package com.raistlin.netologysample

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raistlin.netologysample.logic.Theme
import com.raistlin.netologysample.logic.parseThemes
import com.raistlin.netologysample.net.JSONRequester
import com.raistlin.netologysample.ui.ThemeAdapter
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {

    private val requester = JSONRequester()

    private lateinit var viewProgress: ProgressBar
    private lateinit var viewData: View
    private lateinit var dataTitle: TextView
    private lateinit var dataList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewProgress = findViewById(R.id.main_progress)
        viewData = findViewById(R.id.main_data)
        dataTitle = findViewById(R.id.main_title)
        dataList = findViewById(R.id.main_list)

        readData()
    }

    private fun readData() {
        toggleProgress(true)
        thread {
            try {
                Thread.sleep(1000) // to view the loader, delete if necessary
                val data = parseThemes(requester.requestJSON())
                runOnUiThread {
                    toggleProgress(false)
                    showHtmlTitle()
                    showData(data)
                }
            } catch (ex: Exception) {
                runOnUiThread {
                    toggleProgress(false)
                    showError(ex.message ?: "")
                }
            }
        }
    }

    private fun showHtmlTitle() {
        dataTitle.text = HtmlCompat.fromHtml(getString(R.string.data_title), HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

    private fun showError(error: String) {
        dataTitle.text = error
        showMessage(error)
    }

    private fun showData(data: List<Theme>) {
        dataList.layoutManager = LinearLayoutManager(this)
        dataList.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        dataList.adapter = ThemeAdapter(data)
    }

    private fun toggleProgress(show: Boolean) {
        viewProgress.visibility = if (show) View.VISIBLE else View.GONE
        viewData.visibility = if (!show) View.VISIBLE else View.GONE
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, "Error while accessing the file: $message", Toast.LENGTH_LONG).show()
    }
}