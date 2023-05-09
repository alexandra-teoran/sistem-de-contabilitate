# Titlu proiect
Sistem de contabilitate
## Descriere
Sistemul de contabilitate ajută o persoană să își genstioneze bugetul lunar. 
## Obiective/Functionalitati
Utilizatorul poate să:
- adauge informații cu privire la veniturile primite și cheltuielile efectuate
- vizualizeze lista veniturilor și a cheltuielilor
- vizualizeze veniturile și cheltuielile sub formă de grafic
- caute o intrare după un anumit criteriu (ex. după sumă, dată, categorie (venituri/cheltuieli), etc.)
- vizualizeze soldul curent
## Arhitectura
Pachete:
- dao
  - ConnectionProvider.java
  - BDOperations.java
  - Tables.java   
  - IntrareDao.java
  - SursaDao.java
  - CategorieDao.java
- model
  - Categorie.java
  - Intrare.java
  - Sursa.java
- sistem_contabilitate
  - AdaugareIntrare.java
  - Cautare.java
  - Home.java
  - VizualizareGrafic.java
  - VizualizareIntrari.java
  - VizualizareSold.java
