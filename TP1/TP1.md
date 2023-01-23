# EX1
1. 
Version1
```
la thread 1 0
la thread 5 0
la thread 7 0
la thread 10 0
la thread 6 0
la thread 2 0
la thread 3 0
la thread 4 0
la thread 9 0
la thread 8 0
la thread 1apres le sommeil 
la thread 5apres le sommeil 
la thread 7apres le sommeil 
la thread 6apres le sommeil 
la thread 10apres le sommeil 
la thread 9apres le sommeil 
la thread 4apres le sommeil 
la thread 2apres le sommeil 
la thread 3apres le sommeil 
la thread 8apres le sommeil 
```

Version2
```
la thread 0 0
la thread 9 9
la thread 8 8
la thread 6 6
la thread 7 7
la thread 5 5
la thread 4 4
la thread 2 2
la thread 3 3
la thread 1 1
la thread 9apres le sommeil 
la thread 0apres le sommeil 
la thread 5apres le sommeil 
la thread 4apres le sommeil 
la thread 8apres le sommeil 
la thread 2apres le sommeil 
la thread 1apres le sommeil 
la thread 3apres le sommeil 
la thread 7apres le sommeil 
la thread 6apres le sommeil 
```

2. 
Dans la première version, l'identifiant du thread est attribué au moment de la création de l'objet MyThread2, et le même identifiant est utilisé tout au long du programme. Dans la deuxième version, l'identifiant du thread est attribué dans la méthode run(), qui est exécutée pour chaque thread, de sorte que chaque thread aura un identifiant différent.

Globalement, la principale différence entre les deux versions est que dans la première version, une nouvelle instance de la classe ThreadID est créée pour chaque objet MyThread2, et le même ID est utilisé tout au long de l'exécution du programme, tandis que dans la deuxième version, une nouvelle instance de la classe ThreadID est créée pour chaque thread à l'intérieur de la méthode run(), ce qui donne un ID différent pour chaque thread.

# EX2
- Après avoir exécuté le fichier Main2.main, les valeurs affichées sont l'ID de chaque thread, la valeur de la variable last pour chaque thread, la valeur de la variable value, et la valeur de la variable valuebis.
- Pour s'assurer qu'à la fin de Main2.main, o.value=o.valuebis= nombre total d'écritures, vous pourriez utiliser des mécanismes de synchronisation, tels que le mot-clé synchronized ou la classe ReentrantLock, pour faire en sorte qu'un seul thread puisse accéder à la méthode add() de la classe MonObjet à la fois. De cette façon, lorsque chaque thread termine d'écrire, la valeur des variables value et valuebis sera égale au nombre total d'écritures.
- La différence entre les variables value et last est que la variable value est une variable partagée qui est incrémentée par tous les threads, alors que la variable last est une variable ThreadLocal qui garde la trace du nombre d'écritures pour chaque thread, elle est unique pour chaque thread, et elle n'est pas partagée entre les threads. La variable value représente le nombre total d'écritures, et last représente le nombre d'écritures pour chaque thread.


# EX3
1. Non, t ne contiendra pas toujours les valeurs 0,1,2,3,4 à la fin de l'exécution. En raison de la concurrence entre les threads, il est possible que les valeurs dans le tableau soient mélangées.

2.  Cela est dû à la concurrence entre les threads, car plusieurs threads peuvent accéder et modifier le même tableau en même temps, ce qui entraîne des conflits d'accès et des incohérences de données.

3. Non, synchroniser la méthode "echange" ne garantit pas que le tableau contiendra toujours les valeurs 0,1,2,3,4 après les échanges. Cela peut limiter les conflits d'accès, mais il y a toujours un risque que des données soient incohérentes.

4. Les transactions distribuées. Cela garantit que toutes les modifications apportées au tableau sont effectuées de manière atomique et que le tableau est toujours dans un état cohérent.


# EX4 
La différence entre l'utilisation du mot clé "volatile" et sa non-utilisation lors de la déclaration de la variable de contrôle est la manière dont la variable est traitée par la JVM.

Lorsque la variable de contrôle est déclarée "volatile", cela indique à la JVM que cette variable peut être accédée par plusieurs threads et que sa valeur doit être immédiatement visible par tous les threads. Cela signifie que lorsqu'un thread modifie la valeur de la variable de contrôle, tous les autres threads verront la valeur mise à jour.

D'autre part, lorsque la variable de contrôle n'est pas déclarée "volatile", la JVM peut optimiser l'accès à la variable en mettant sa valeur en cache dans un registre ou dans le cache du CPU, au lieu de lire sa valeur en mémoire à chaque fois. Cela signifie qu'un thread peut voir une valeur périmée de la variable, et que les modifications apportées par un autre thread peuvent ne pas être visibles pour le premier thread, ce qui est connu comme un problème de cohérence du cache.

Dans ce programme spécifique, si la variable check est déclarée comme "volatile", le thread MyObject fonctionnera correctement, il lira la valeur correcte de check et détectera le changement effectué par le thread Stop, et imprimera le message suivant.
