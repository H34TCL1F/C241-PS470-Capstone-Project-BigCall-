package C241.PS470.Bangkit.bigcall

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import c241.ps470.bangkit.bigcall.R
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

class CalcaMenu : AppCompatActivity() {

    private lateinit var pieChart: PieChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calca_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        pieChart = findViewById(R.id.KalPiechart)
    }

    private fun setupPieChart() {
        pieChart.isDrawHoleEnabled = true
        pieChart.setHoleColor(Color.WHITE)
        pieChart.setUsePercentValues(true)
        pieChart.setEntryLabelTextSize(12f)
        pieChart.setEntryLabelColor(Color.BLACK)
        pieChart.centerText = "Pie Chart Example"
        pieChart.setCenterTextSize(24f)
        pieChart.description.isEnabled = false

        val legend = pieChart.legend
        legend.isEnabled = true
        legend.verticalAlignment = com.github.mikephil.charting.components.Legend.LegendVerticalAlignment.TOP
        legend.horizontalAlignment = com.github.mikephil.charting.components.Legend.LegendHorizontalAlignment.RIGHT
        legend.orientation = com.github.mikephil.charting.components.Legend.LegendOrientation.VERTICAL
        legend.setDrawInside(false)
        legend.textColor = Color.BLACK
    }

    private fun loadPieChartData() {
        val entries = ArrayList<PieEntry>()
        entries.add(PieEntry(0.2f, "Category 1"))
        entries.add(PieEntry(0.3f, "Category 2"))

        val colors = ArrayList<Int>()
        colors.add(Color.rgb(255, 99, 132))
        colors.add(Color.rgb(54, 162, 235))


        val dataSet = PieDataSet(entries, "Categories")
        dataSet.colors = colors

        val data = PieData(dataSet)
        data.setDrawValues(true)
        data.setValueTextSize(12f)
        data.setValueTextColor(Color.BLACK)

        pieChart.data = data
        pieChart.invalidate()
    }

    fun kembali(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}