package fr.paulkoTheCoder.naturecollection.adapter

import android.net.Uri
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.paulkoTheCoder.naturecollection.MainActivity
import fr.paulkoTheCoder.naturecollection.PlantModel
import fr.paulkoTheCoder.naturecollection.PlantRepository
import fr.paulkoTheCoder.naturecollection.R

/***
 * Classe donnée au RecyclerView pour adapter pour chaque plante
 * son équivalent en image
 */
class PlantAdapter(private val context : MainActivity,
                   private  val plantList: List<PlantModel>,
                   private val layoutId: Int) : RecyclerView.Adapter<PlantAdapter.ViewHolder>()
{
    /***
     *
     * Classe permettant de créer une boîte afin de ranger tous
     * les composants à contrôler
     */
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)
    {
        val plantImage = view.findViewById<ImageView>(R.id.image_item)
        val plantName:TextView? = view.findViewById(R.id.name_item)
        val plantDescription:TextView? = view.findViewById(R.id.description_item)
        val starIcon = view.findViewById<ImageView>(R.id.star_icon)
    }

    /***
     * Fonction permettant d'injecter le linear layout contenant
     * les item_horizontal & item_vertical_plant
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(layoutId,parent,false)
        return ViewHolder(view)
    }

    /***
     * Fonction permettant de renvoyer le nombre d'items à affiher dynamiquement
     * On générera N emplacements avec l'image item_horizontal_plant
     */
    override fun getItemCount(): Int = plantList.size

    /***
     * Fonction permettant de mettre à jour chaque modèle avec
     * la plante en question
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        /*Récupération des informations de la plante*/
        val currentPlant = plantList[position]

        //Récupération du repository
        val repo = PlantRepository();

        /*Utiliser <glide> pour récupérer l'image à partir de son lien -> composant*/
        //Le context est une BDD interne contenant toutes les informations
        // contextuel de l'application : numéro de version...
        Glide.with(context).load(Uri.parse(currentPlant.imageUrl)).into(holder.plantImage)
        //Mise à jour du nom et de la description de la plante
        holder.plantName?.text = currentPlant.name
        holder.plantDescription?.text = currentPlant.description
        //Vérifier si la plante a été liké ou non
        if (currentPlant.liked)
        {
            holder.starIcon.setImageResource(R.drawable.ic_star)
        }
        else
        {
            holder.starIcon.setImageResource(R.drawable.ic_unstar)
        }

        //Rajouter une interaction sur l'étoile (liked ou pas)
        holder.starIcon.setOnClickListener {

            //Inverse si le bouton est liké ou non
            currentPlant.liked = ! currentPlant.liked;
        }

    }

}