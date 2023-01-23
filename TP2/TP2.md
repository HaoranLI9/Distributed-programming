# EX1
- fair false
```
Thread entered critical section 1 times
Thread entered critical section 2 times
Thread entered critical section 3 times
Thread entered critical section 4 times
Thread entered critical section 5 times
Thread entered critical section 6 times
Thread entered critical section 7 times
Thread entered critical section 8 times
Thread entered critical section 9 times
Thread entered critical section 10 times
Thread entered critical section 11 times
Thread entered critical section 12 times
Thread entered critical section 13 times
Thread entered critical section 14 times
Thread entered critical section 15 times
Thread entered critical section 16 times
Thread entered critical section 17 times
Thread entered critical section 18 times
Thread entered critical section 19 times
Thread entered critical section 20 times
Thread entered critical section 1 times
```

- fair true
```
Thread entered critical section 1 times
Thread entered critical section 1 times
Thread entered critical section 1 times
Thread entered critical section 1 times
Thread entered critical section 1 times
Thread entered critical section 1 times
Thread entered critical section 1 times
Thread entered critical section 1 times
Thread entered critical section 1 times
Thread entered critical section 1 times
Thread entered critical section 2 times
Thread entered critical section 2 times
Thread entered critical section 2 times
Thread entered critical section 2 times
Thread entered critical section 2 times
Thread entered critical section 2 times
Thread entered critical section 2 times
Thread entered critical section 2 times
Thread entered critical section 2 times
```

Lorsque l'on utilise un verrou équitable, les threads sont servis dans l'ordre où ils ont demandé le verrou. Cela signifie que si un thread demande le verrou alors qu'un autre thread l'a déjà, il devra attendre jusqu'à ce que le thread qui l'a actuellement libère le verrou. Si l'on ne demande pas d'équité, les threads peuvent obtenir le verrou dans un ordre aléatoire, ce qui peut entraîner des inégalités dans l'accès à la section critique.

# Ex2
c'est bloque ici
```
Entered critical section: 1
```
# EX3
a. Non. Dans l'algorithme Bakery, chaque thread s'attribue une valeur d'étiquette supérieure d'une unité à la valeur d'étiquette la plus élevée du tableau d'étiquettes. Toutefois, cela ne garantit pas que la valeur de l'étiquette d'un fil sera toujours inférieure à celle d'un autre fil.

b. Non. Cela ne garantit pas que la valeur de l'étiquette d'un thread sera toujours inférieure à celle d'un autre thread, même si flag[j] est faux.

c. Il n'est pas possible de dire combien de threads peuvent entrer en section critique après t et avant que la thread i n'entre en section critique, car cela dépend de l'ordre d'exécution des threads et de leur état actuel.
Un exemple d'exécution où la thread laisse passer le plus grand nombre de threads avant de pouvoir rentrer en SC est que la thread i obtient le verrou, mais avec un label élevé, et qu'il y a plusieurs autres threads qui ont des labels plus élevés et qui peuvent entrer en SC avant la thread i.


# EX4

- Non, on ne peut pas avoir plusieurs rédacteurs qui écrivent en même temps dans base.tab car les threads rédacteurs utilisent la méthode writeLock() pour accéder à la ressource, qui garantit l'exclusion mutuelle entre les rédacteurs. Seul un rédacteur à la fois peut obtenir le verrou writeLock() et accéder à la ressource pour écrire. Les autres rédacteurs doivent attendre jusqu'à ce que le verrou soit libéré avant de pouvoir accéder à la ressource.

- Oui, on peut avoir plusieurs lecteurs qui lisent en même temps dans base.tab car les threads lecteurs utilisent la méthode readLock() pour accéder à la ressource, qui permet à plusieurs lecteurs de lire en même temps. Il est possible que plusieurs lecteurs obtiennent le verrou readLock() simultanément sans bloquer les autres lecteurs. Cela est possible car la méthode readLock() permet à plusieurs threads d'accéder en même temps à la ressource en lecture.

- Non, on ne peut pas avoir des lecteurs et des rédacteurs qui accèdent en même temps à base.tab car les threads rédacteurs utilisent la méthode writeLock() pour accéder à la ressource, qui garantit l'exclusion mutuelle avec les autres threads rédacteurs et les threads lecteurs. Cela signifie qu'un thread rédacteur peut accéder à la ressource seulement s'il n'y a pas de threads lecteurs ou rédacteurs qui utilisent actuellement la ressource. Les threads lecteurs utilisent readLock() pour accéder à la ressource, ce qui permet à plusieurs threads lecteurs de lire en même temps, mais pas avec des rédacteurs.

- Si on utilise la méthode interrupt() sur le thread lecteur[0] dans le main de la classe LectRed, cela va envoyer un signal d'interruption au thread lecteur[0]. Si ce thread gère correctement cette interruption, il va terminer proprement et sortir de la boucle for, sinon, l'exception sera propagée et causer des erreurs dans le thread.