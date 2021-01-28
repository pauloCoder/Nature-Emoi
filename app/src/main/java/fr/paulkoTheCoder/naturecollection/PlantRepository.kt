package fr.paulkoTheCoder.naturecollection

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import fr.paulkoTheCoder.naturecollection.PlantRepository.Singleton.dataBaseRef
import fr.paulkoTheCoder.naturecollection.PlantRepository.Singleton.plantList
import javax.security.auth.callback.Callback

/***
 * Classe permettant de gérer la persistance des données au sein
 * de l'application
 */
class PlantRepository
{
    object Singleton
    {
        //Variable permettant de se connecter à la référence plante
        val dataBaseRef = FirebaseDatabase.getInstance().getReference("plants");

        //Création d'une liste contenant nos plantes
        val plantList = arrayListOf<PlantModel>()
    }

    /***
     * Fonction charger d'absorber les données depuis la variable
     * dataBaseRef pour les passer à la liste de plantes
     */
    fun updateData(callback: () -> Unit)
    {
        dataBaseRef.addValueEventListener(object : ValueEventListener
        {
            override fun onCancelled(error: DatabaseError)
            {
                TODO("Not yet implemented")
            }

            /***
             * Fonction permettant de récolter la liste
             */
            override fun onDataChange(snapshot: DataSnapshot)
            {
                //Retirer les anciennes plantes
                plantList.clear()
                //Récolte de la liste
                for (ds in snapshot.children)
                {
                    //Construction d'un objet plante
                    val plant = ds.getValue(PlantModel::class.java)

                    //Vérifier que la plante n'est pas null
                    if (plant != null)
                    {
                        //Ajout de la plante à notre liste
                        plantList.add(plant);
                    }
                }
                //Actionner le callback
                callback()
            }
        })
    }


}