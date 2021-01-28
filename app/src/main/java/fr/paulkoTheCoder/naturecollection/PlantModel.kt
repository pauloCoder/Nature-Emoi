package fr.paulkoTheCoder.naturecollection

/***
 * Classe permettant d'avoir du contenu dynamisé pour les différentes
 * plante. Elle prend en paramètres les caractéristiques d'une plante
 */
class PlantModel(val name: String = "Tulipe",
                 val description: String = "Petite description",
                 val imageUrl: String = "http://graven.yt/plante.jpg",
                 var liked: Boolean = false)
