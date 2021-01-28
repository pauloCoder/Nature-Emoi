package fr.paulkoTheCoder.naturecollection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.paulkoTheCoder.naturecollection.MainActivity
import fr.paulkoTheCoder.naturecollection.PlantModel
import fr.paulkoTheCoder.naturecollection.PlantRepository
import fr.paulkoTheCoder.naturecollection.PlantRepository.Singleton.plantList
import fr.paulkoTheCoder.naturecollection.R
import fr.paulkoTheCoder.naturecollection.adapter.PlantAdapter
import fr.paulkoTheCoder.naturecollection.adapter.PlantItemDecoration

class HomeFragment(private val context : MainActivity) : Fragment()
{
    /***
     * Fonction permettant de pouvoir injecter le layout fragment_home sur la page
     *
      */
    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View?
    {
        val view =  inflater?.inflate(R.layout.fragment_home,container,false)

        // --> Enregistrement de la première plante (Exemple avec liste)
        // --> Enregistrement dans une BDD plus tard avec Firebase
        /*Création d'une liste permettant de stocker les plantes
        val plantList = arrayListOf<PlantModel>()
        plantList.add(PlantModel(
                                 "Pissenlit",
                             "Jaune soleil",
                               "https://cdn.pixabay.com/photo/2018/08/10/21/53/dandelion-3597681_1280.jpg",
                                   false
                                )
                     )
         */

        /* Récupération du recycler view */
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = PlantAdapter(context,plantList,R.layout.item_horizontal_plant)
        /*Récupérer le second recycler view*/
        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter = PlantAdapter(context,plantList,R.layout.item_vertical_plant)
        verticalRecyclerView.addItemDecoration(PlantItemDecoration())

        return view
    }
}