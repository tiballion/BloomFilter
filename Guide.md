# Guide d'ajout d'un nouveau Filtre
###### Timothée Ballion - 2022

## Création du Filtre en Java
Pour créer un nouveau filtre, créez une classe qui implémente la classe BloomFilterI. Cette classe doit donc implémenter les méthodes suivantes :
- `public void add(String s)` : Ajoute une chaîne de caractères au filtre
- `public boolean contains(String s)` : Vérifie si une chaîne de caractères est présente dans le filtre
- `public void empty()` : Vide le filtre

## Ajout aux benchmarks
Pour ajouter votre filtre aux benchmarks, créez une fonction en prenant exemple sur les fonctions présentes dans `src/benchmark/RunBenchmark` et ajoutez cette fonction à la méthode Main. Quand vous lancerez la méthode Main, votre filtre sera testé et le résultats des benchmarks seront écrits dans des fichiers csv. Ces fichiers csv sont stockés dans un dossier qui porte le nom du Filtre.

## Création de des graphiques
Pour créer des graphiques, créez une fonction en prenant exemple sur la fonction plot_array() dans `chart.py` et ajoutez cette fonction à la méthode Main. Au lancement du script, les graphiques seront créés et stockés dans le dossier `plots`.

_*Notes : le fichier csv contient aussi le temps d'insertion pour chaque filtre, cette donnée n'est pas utilisée mais vous pouvez facilement ajouter une fonction pour exploiter ces données*_