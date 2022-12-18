# Rapport Filtres de Bloom
###### Timothée Ballion - 2022

## Introduction
Un filtre de Bloom est un type de structure de données utilisée pour tester l'appartenance d'un élément à un ensemble de données. Il est souvent utilisé pour vérifier rapidement si un élément appartient ou non à un ensemble.


## Implémentation
J'ai implémenté plusieurs versions Filtres de Bloom en utilisant ces différentes structures de données :
- Un tableau classique
- Une ArrayList
- Une LinkedList
  
J'ai fait en sorte que le code soit le plus générique possible, en utilisant des interfaces et le moins de valeur harcodées possible.
J'ai écrit un script python assez simple pour mesurer les performances de chaque version. Ce script est lui aussi le plus générique possible pour que le potentiel ajout d'un nouveau filtre soit le plus simple possible.

## Analyse des performances
J'ai trouvé que pour évaluer la performance d'un filtre de Bloom, plusieurs facteurs doivent être pris en compte :
- La taille du filtre 
- Le nombre de fonctions de hachage utilisées
- Le nombre d'éléments dans le filtre

Je me suis vite rendu compte que le facteur principal était le rapport taille filtre / nombre d'éléments. En effet, plus ce rapport est grand, plus le filtre sera rempli et plus il sera probable qu'un élément qui n'est pas dans le filtre soit considéré comme présent. C'est pourquoi j'ai décidé de faire varier ce rapport pour mesurer les performances.
Je me suis rendu compte assez tôt que l'impact du nombre de fonctions de hachage était le même pour chaque filtre. En effet, plus le nombre de fonctions de hachage est grand, plus il y a de chance que l'élément soit considéré comme présent : 
![Plot](/plots/BloomArray500Elements.png "Le taux d'erreur en fonction du nombre de fonction de hachage")
*Figure 1 : Le taux d'erreur en fonction du nombre de fonction de hachage sur un tableau classique*

J'ai donc concentré mon analyse sur le rapport taille filtre / nombre d'éléments.
Je vais prendre en exemple seulement le tableau classique de taille 10000, mais les résultats sont les mêmes pour les autres filtres.


![Plot](/plots/BloomArray100Elements.png "Le taux d'erreur en fonction du rapport taille filtre / nombre d'éléments sur un tableau classique")
*Figure 2 : Le taux d'erreur en fonction du rapport taille filtre / nombre d'éléments sur un tableau classique avec un rapport de 100*

Dans cet exemple, la différence est pratiquement nul car on a un rapport faible donc il est peu probable que l'élément soit considéré comme présent alors qu'il ne l'est pas. On peut voir que le taux d'erreur est très faible, ce qui est normal.

![Plot](/plots/BloomArray500Elements.png "Le taux d'erreur en fonction du rapport taille filtre / nombre d'éléments sur un tableau classique")
*Figure 3 : Le taux d'erreur en fonction du rapport taille filtre / nombre d'éléments sur un tableau classique avec un rapport de 500*

Dans cet exemple on a un rapport plus élevé, donc on voit que le taux d'erreur est plus élevé que pour 100 éléments. On peut aussi voir que le nombre de fonctions de hachage a un impact négatif sur le taux d'erreur.

![Plot](/plots/BloomArray1000Elements.png "Le taux d'erreur en fonction du rapport taille filtre / nombre d'éléments sur un tableau classique")
*Figure 4 : Le taux d'erreur en fonction du rapport taille filtre / nombre d'éléments sur un tableau classique avec un rapport de 1000*

Dans cet exemple on a un rapport encore plus élevé, donc on voit que le taux d'erreur est encore plus élevé que pour 500 éléments.

**On peut donc en déduire que le facteur le plus important dans l'efficacité d'un Filtre de Bloom est le rapport taille filtre / nombre d'éléments**.

J'ai aussi testé la rapidité d'insertion dans chaque version de filtre :
![Plot](/plots/InsertSpeed.png "Le temps d'insertion en fonction du rapport taille filtre / nombre d'éléments")
*Figure 5 : Le temps d'insertion de chaque implémentation*
On peut voir que les temps d'insertion du tableau classique et de l'ArrayList sont presque exactement les mêmes, mais que la LinkedList est beaucoup plus lente. C'est normal car l'insertion dans une LinkedList est beaucoup plus coûteuse que dans un tableau ou une ArrayList.

## Conclusion & Retour d'expérience
J'ai trouvé cette SAE très intéressante car elle m'a permis de comprendre non seulement comment fonctionnait un Filtre de Bloom, mais aussi comment l'implémenter et l'optimiser. J'ai aimé le fait d'avoir créé quelque chose de toute pièce et d'avoir réalisé des benchmarks et des plots en utilisant des outils autres que Java et d'avoir touché à un métier qui me plait (Data scientist).

J'ai aussi fait un petit guide qui explique comment ajouter un nouveau filtre de Bloom à mon projet, à utiliser le benchmark et à générer les graphes de performance : [Guide](/Guide.md)