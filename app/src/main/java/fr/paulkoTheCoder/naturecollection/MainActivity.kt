package fr.paulkoTheCoder.naturecollection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.paulkoTheCoder.naturecollection.fragments.HomeFragment

/*Activités : morceaux ou partie de l'application*/

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Charger notre repository
        val repo = PlantRepository()

        //Mise à jour de la liste de plantes
        repo.updateData{
            //Injection du fragment dans la page principale (fragment_container)
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,HomeFragment(this))
            transaction.addToBackStack(null)
            transaction.commit()
        }

    }
}