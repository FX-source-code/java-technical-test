# Java Technical Test – Minecraft Plugin

Bienvenue dans ce test technique destiné aux développeurs souhaitant rejoindre l'équipe de développement de notre projet Minecraft.

## 🎯 Objectif du test

L'objectif est d'implémenter un **plugin Bukkit pour Minecraft 1.8.8** qui affiche un **scoreboard dynamique** à chaque joueur connecté. Ce scoreboard doit contenir les informations suivantes, mises à jour en temps réel :

- Le pseudo du joueur.
- Le nombre de points de vie actuels.
- Le nombre de creepers tués.
- Le nombre de pains fabriqués.

Le projet est déjà initialisé avec Maven, et une classe `Main` est fournie pour faciliter le démarrage.

## 💼 Pourquoi ce test ?

Ce test a pour but d’évaluer :
- Votre maîtrise de **Java et la POO**
- Votre compréhension de **l’API Bukkit**
- Votre gestion de la **mémoire, des tâches asynchrones/synchrones**, et des événements
- Votre capacité à structurer un petit projet proprement et efficacement
- Vos **bonnes pratiques de développement**

Ce test est **court** mais suffisamment révélateur pour comprendre votre approche de développement.

## 🛠️ Environnement attendu

- Minecraft **1.8.8**
- Bukkit / Spigot / Paper API
- Java 8-11
- Maven

## 📦 Démarrage rapide

1. Clonez ce repo.
2. Importez-le dans votre IDE préféré (IntelliJ, Eclipse, etc.) en tant que projet Maven.
3. Développez votre code à partir de la classe `Main.java` existante.
4. Compilez votre plugin avec Maven (`mvn clean package`) et testez-le sur un serveur Paper 1.8.8.

## ✅ Critères de réussite

- Un scoreboard s’affiche à chaque connexion d’un joueur.
- Le scoreboard est **mis à jour automatiquement** (PV, craft, etc).
- Le code est **proprement structuré** : pas de tout dans une seule classe.
- Bonne gestion des **listeners**, **runnables**, et **ressources mémoire**.
- Vous ne devez **pas provoquer de lag** sur le serveur (attention aux tâches mal gérées !).

## 🧠 Bonus (facultatif)

- Ajout de configuration (ex : YAML pour les titres du scoreboard)
- Mise en cache ou optimisation des accès pour améliorer les performances
- Multilingue
- Support de reload sans bug

## 🚫 Ce que vous ne devez pas faire

- Copier-coller un plugin existant du web ou généré par une IA
- Laisser des classes anonymes ou du code spaghetti

## 📤 Rendu

- Faites un **pull request** sur ce dépôt, ou envoyez un lien vers votre fork.
- Merci de **commenter le code brièvement**.
- Vous pouvez aussi joindre une **courte vidéo ou capture d'écran** montrant le fonctionnement si vous le souhaitez.

---

Nous avons hâte de découvrir votre manière de coder !  
Bonne chance 🚀

L'équipe ReviveMC
