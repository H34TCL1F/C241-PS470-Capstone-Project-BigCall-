package C241.PS470.Bangkit.bigcall

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import c241.ps470.bangkit.bigcall.R
import C241.PS470.Bangkit.bigcall.ScanHistory
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    }

    fun showProfileFragment(view: View) {
        // Membuat instance Fragment
        val fragment = profile()
        // Membuat FragmentManager
        val fragmentManager: FragmentManager = supportFragmentManager
        // Memulai transaksi fragment
        val transaction: FragmentTransaction = fragmentManager.beginTransaction()
        // Mengganti fragment di fragmentContainer dengan fragment baru
        transaction.replace(R.id.fragmentContainer, fragment)
        // Menambahkan transaksi ke back stack (opsional)
        transaction.addToBackStack(null)
        // Melakukan commit transaksi
        transaction.commit()
    }


    fun toHistoryMenu(view: View){
        val intent = Intent(this, ScanHistory::class.java)
        startActivity(intent)
    }
    fun ScanCamera(view: View){
     //Intent ke kamera dan masukin AI nya
    }

    fun toCalcaMenuSummary(view: View) {
        val intent = Intent(this, CalcaMenu::class.java)
        startActivity(intent)
    }

    fun profilePP(view: View) {
        //Buka Fragment Profile logo
    }

}