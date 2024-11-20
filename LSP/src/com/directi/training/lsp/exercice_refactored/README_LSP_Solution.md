
# Solution du Problème LSP avec ElectronicDuck et ElectronicPool

## Problème Initial

Dans le code initial, nous avons deux classes principales : `Duck` et `ElectronicDuck`. La classe `ElectronicDuck` hérite de `Duck` et modifie les comportements de `quack()` et `swim()` en fonction de l'état interne de l'objet (allumé ou éteint).

Le problème survient lorsque nous utilisons un objet `ElectronicDuck` dans une méthode qui attend un objet `Duck`. Par exemple, dans la méthode `Pool.run()`, nous utilisons à la fois des objets `Duck` et `ElectronicDuck` dans les méthodes `quack()` et `swim()`. Si un `ElectronicDuck` est éteint et que nous essayons d'exécuter une action, cela lance une exception (`RuntimeException`), car la méthode attend que l'objet soit allumé pour qu'il fonctionne correctement.

## Solution proposée

La solution consiste à introduire une nouvelle classe `ElectronicPool` qui traite spécifiquement les objets `ElectronicDuck`. Cette classe gère les comportements spécifiques d'un `ElectronicDuck`, comme vérifier s'il est allumé avant d'essayer d'appeler `quack()` ou `swim()`. Ainsi, au lieu de laisser la classe `Pool` gérer directement tous les types d'objets de manière uniforme, nous séparons la logique de gestion des `ElectronicDuck` dans une nouvelle classe dédiée.

### Classes impliquées

1. **Duck** : Classe de base représentant un canard standard avec des comportements de base (`quack()` et `swim()`).
2. **ElectronicDuck** : Sous-classe de `Duck` qui ajoute une gestion de l'état "allumé" ou "éteint" avant de permettre l'exécution de `quack()` et `swim()`.
3. **ElectronicPool** : Classe qui gère spécifiquement les objets `ElectronicDuck` en vérifiant leur état avant d'exécuter les actions.

## Respect du Principe de Substitution de Liskov (LSP)

Le principe de Liskov stipule qu'une sous-classe doit être capable de remplacer sa classe parente sans que cela ne modifie le comportement attendu du programme. Dans notre cas, le problème initial était que `ElectronicDuck` ne respectait pas cette règle car il ne pouvait pas toujours se comporter comme un `Duck` (en raison de son état "on/off").

En introduisant la classe `ElectronicPool`, nous permettons une gestion distincte et appropriée des objets `ElectronicDuck`, ce qui respecte le principe de LSP. Au lieu d'essayer de forcer un comportement générique pour tous les types de canards, nous offrons une gestion spécifique pour chaque type de canard.


## Conclusion

En créant une classe `ElectronicPool` dédiée aux `ElectronicDuck`, nous avons résolu le problème de non-respect du LSP en permettant une gestion plus fine des sous-classes tout en évitant les comportements inattendus lors de l'exécution des méthodes de `Duck` sur `ElectronicDuck`. Cette solution assure également que le code reste flexible et maintenable à long terme.
