# FTBU_ChunkUnloader

Système d'unload des chunks chargés par le mod FTB Utilities

A chaque redémarrage du serveur, le programme regarde depuis combien de temps le joueur ne s'est pas connecté, si ce temps est suppérieur à 2 heures alors, ces chunks sont unloads.

## Guide d'utilisation

#### Executable .jar
Ajoutez dans le meme dossier que votre serveur l'executable et le fichier de configuration.
Remplacez le nom du monde dans le fichier de configuration, par le nom du votre.

Ajoutez dans un script (bash/shell) de redémarage, l'exécution du script **FTBU-ChunkUnloader-v_1.0.0.jar**. Vous pouvez suivre l'exemple donné pour creer votre propre script d'unload.

Voilà, le scrip est pret à etre utiliser.


## A faire
- Ajouter dans les configurations les réglages du temps
- Faire une calcul par team et non par joueur
- Ajouter une différence de temps selon le grade
