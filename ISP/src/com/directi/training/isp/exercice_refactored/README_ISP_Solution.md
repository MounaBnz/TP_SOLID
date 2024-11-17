### Problème Initial
Le problème initial dans le code était que l'interface Door obligeait certaines classes à implémenter des méthodes qu'elles n'utilisaient pas, ce qui violait le Principe de Ségrégation des Interfaces (ISP). Par exemple :

La classe SensingDoor devait implémenter la méthode timeOutCallback(), ce qui n'était pas nécessaire pour cette classe.
La classe TimedDoor devait implémenter la méthode proximityCallback(), ce qui n'était pas pertinent pour son comportement.
Solution Proposée
Afin de résoudre ce problème et de respecter le principe ISP, l'interface Door a été divisée en deux interfaces spécifiques :

IProximityDoor : Interface pour les portes qui interagissent avec des capteurs de proximité.
ITimedDoor : Interface pour les portes qui fonctionnent avec une logique de temporisation.
Classes
SensingDoor implémente IProximityDoor pour gérer la logique de proximité.
TimedDoor implémente ITimedDoor pour gérer la logique de temporisation.
Sensor utilise IProximityDoor pour interagir avec les portes à capteurs de proximité.
Timer utilise ITimedDoor pour interagir avec les portes basées sur un délai.
Description des Fonctions
Interface IProximityDoor
Cette interface contient une seule méthode spécifique à la gestion des capteurs de proximité :

proximityCallback() : Cette méthode est appelée lorsqu'un capteur de proximité détecte la présence d'une personne, permettant ainsi d'ouvrir la porte.
Interface ITimedDoor
Cette interface contient une seule méthode pour gérer le temporisateur des portes :

timeOutCallback() : Cette méthode est appelée lorsqu'un délai (timeout) est atteint. Elle est utilisée pour verrouiller la porte après un certain temps.
Classe SensingDoor
proximityCallback() : Lorsque la méthode est appelée par le capteur de proximité, elle ouvre la porte en réponse à la détection d'une personne à proximité.
Autres méthodes : Pour verrouiller, déverrouiller, ouvrir et fermer la porte.
Classe TimedDoor
timeOutCallback() : Lorsque le délai spécifié est atteint, cette méthode verrouille automatiquement la porte.
Autres méthodes : Pour verrouiller, déverrouiller, ouvrir et fermer la porte.
Classe Sensor
register() : Permet d'enregistrer une porte pour être notifiée lorsque la détection de proximité se produit. Lorsque la présence d'une personne est détectée, elle appelle proximityCallback() sur la porte.
isPersonClose() : Simule la détection d'une personne en retournant un résultat aléatoire.
Classe Timer
register() : Permet d'enregistrer une porte pour recevoir une notification après un certain délai (timeout). Lorsque le délai est écoulé, la méthode timeOutCallback() de la porte est appelée.



Conclusion
En appliquant le principe ISP, nous avons refactorisé l'interface Door en deux interfaces spécifiques : IProximityDoor et ITimedDoor. Cela permet à chaque classe d'implémenter uniquement les méthodes dont elle a besoin, simplifiant ainsi le code et réduisant la complexité, tout en respectant les bonnes pratiques de conception.