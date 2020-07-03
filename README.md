# geo-rest-api
Rest API - Geocoding &amp; Reverse Geocoding per i comuni italiani

# Fonte dei dati
I confini delle unità amministrative a fini statistici sono forniti dall'ISTAT in particolare [**Versione generalizzata** **WGS84 UTM32N**](https://www.istat.it/it/archivio/210584).
I dati originariamente in formato _Shapefile_ sono stati convertiti secondo il sistema di riferimento *epsg:4326 (GCS WGS84)* in formato *GeoJSON*.
Dopo la conversione i seguenti comuni presentavo problemi di indicizzazione su **MongoDB** a causa di duplicazione di vertici o intersezioni non corrette e sono stati fixati manualmente.
 - Gallipoli 
 - Santa Cesarea Terme 
 - Acquaviva delle Fonti 
 - Rutigliano
 - Sannicandro di Bari     
 - Brindisi     
 - Santa Ninfa     
 - Bronte     
 - La Maddalena    
 - Calasetta
 - Sannicandro di Bari
# Importazione dei dati
Il file json corretto da importare nella collezione '**Com01012018_g**' si trova nelle *resources* del progetto
> src/main/resources/Com01012018_g_MongoSubsetGeoJSON.json
e può essere importato tramite *mongoimport* sia prima che dopo l'avvio dell'applicativo. (Sarà *spring-data* a creare l'indice **2DSphere** sulla collezione nel database specificato nelle *application.properties*

# Esempio utilizzo

    REQUEST 
    POST /api/v1/geocode HTTP/1.1
    Host: localhost:8080
    Content-Type: application/json
    Accept: application/json
    {
	    //Coordinate del punto
    	"x":12.489541700000018,
    	"y":41.9061177
    }
    
	RESPONSE 200 OK
    {
        "id": "5b158fad8b0daf2ce0133480",
        //Informazioni fornite dagli shape files dell'istat
        "properties": {
            "COD_RIP": "3",
            "COD_REG": "12",
            "COD_PROV": "58",
            "COD_CM": "258",
            "COD_PCM": "258",
            "PRO_COM": "58091",
            "PRO_COM_T": "058091",
            "COMUNE": "Roma", // <--------------- COMUNE RELATIVO AL PUNTO PASSATO
            "COMUNE_A": null,
            "CC_P_CM": "1",
            "Shape_Leng": "279255.140371",
            "Shape_Area": "1.28647273251E9"
        }
    }
    
# TODO LIST
 - [ ] Aggiungere gli altri file geografici forniti dall'[ISTAT](https://www.istat.it/it/archivio/210584)


