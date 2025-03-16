# 🔄 Projet d'Injection de Dépendances

Ce projet démontre différentes techniques d'injection de dépendances en Java, allant de l'instanciation statique à l'utilisation du framework Spring.

## 📂 Structure du Projet

Le projet est organisé en plusieurs packages :

- `ma.saifdine.enset.dao` : Contient l'interface DAO et son implémentation
- `ma.saifdine.enset.metier` : Contient l'interface métier et son implémentation
- `ma.saifdine.enset.pres` : Contient les classes de présentation qui démontrent différentes techniques d'injection

## 💉 Techniques d'Injection de Dépendances

### 1️⃣ Instanciation Statique

La classe `PresStatique` montre comment injecter des dépendances de manière statique, en créant explicitement les instances et en les reliant.

```java
public class PresStatique {
    public static void main(String[] args) {
        IMetier metier = new MetierImpl(new DaoImpl());
        System.out.println(metier.calcule());
    }
}
```

### 2️⃣ Instanciation Dynamique avec Réflexion Java ✨

La classe `PresDynamique` utilise la réflexion Java pour instancier dynamiquement les classes à partir d'un fichier de configuration.

```java
// Lecture du fichier config.txt
// Chargement dynamique des classes
// Instanciation et injection des dépendances
```

### 3️⃣ Injection avec Spring Framework 🍃

#### 📄 Version XML

La classe `PresSpringXML` utilise la configuration XML de Spring pour l'injection de dépendances.

```java
ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
IMetier metier = context.getBean("metier", IMetier.class);
```

#### 🏷️ Version Annotations

La classe `PresSpringAnnotations` utilise les annotations Spring pour l'injection de dépendances.

```java
ApplicationContext context = new AnnotationConfigApplicationContext("ma.saifdine.enset");
IMetier metier = context.getBean(IMetier.class);
```

## ⚙️ Configuration

### Pour la version dynamique avec réflexion

Créez un fichier `config.txt` à la racine du projet avec le contenu suivant :

```
dao=ma.saifdine.enset.dao.DaoImpl
metier=ma.saifdine.enset.metier.MetierImpl
```

### Pour la version Spring XML

Créez un fichier `applicationContext.xml` dans le dossier `src/main/resources` avec la configuration appropriée.

### Pour la version Spring Annotations

Assurez-vous d'avoir les annotations suivantes dans vos classes :

```java
@Repository // Pour DaoImpl
@Service // Pour MetierImpl
@Autowired // Pour l'injection dans le constructeur de MetierImpl
```

## 📚 Dépendances

Pour les versions Spring, ajoutez la dépendance Spring Context à votre pom.xml :

```xml
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.3.23</version>
</dependency>
```

## 🚀 Exécution

Pour exécuter chaque version, lancez la classe correspondante :

- `PresStatique` pour l'instanciation statique
- `PresDynamique` pour l'instanciation dynamique avec réflexion
- `PresSpringXML` pour l'injection avec Spring XML
- `PresSpringAnnotations` pour l'injection avec Spring Annotations