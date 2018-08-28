# FTBU_ChunkUnloader

Système d'unload des chunks chargés par le mod FTB Utilities

Le plugin ajouté au serveur minecraft, ajoute à une liste le nom de chaque joueur se connectant initialisant également son nombre de cycle de restart avant le unload de ces chunks à zéro.

Si le joueur est déjà compris dans la liste, alors le nombre de cycle avant l'unload est remis à zéro.

A chaque redémarrage du serveur, le cycle est incrémenté de 1. Si le nombre limite de cycle est atteint, alors les chunks sont unloads et le nom du joueur est supprimé de la liste.


## Guide d'utilisation

#### Plugin Sponge API-7.0.0                                                                                     
Arretez votre serveur, ajouter le plugin **FTBU-ChunkUnloader-v_1.0.0-Sponge.jar**. Puis relancez votre serveur.
#### Executable .jar
Ajoutez dans un script (bash/shell) de redémarage, l'exécution du script **FTBU-ChunkUnloader-v_1.0.0.jar**. Vous pouvez suivre l'exemple donné pour creer votre propre script d'unload.
