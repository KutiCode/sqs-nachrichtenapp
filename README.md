# Nachrichtenapp

## Einführung und Ziele

Die Zielsetzung der Nachrichten-App ist es, die wichtigsten aktuellen Schlagzeilen aus verschiedenen Ländern abzurufen und anzuzeigen. Benutzer können entweder die Top 10 Nachrichten eines ausgewählten Landes sehen oder gezielt nach Nachrichten zu einem bestimmten Thema suchen. Für jede Nachricht wird ein Link bereitgestellt, der direkt zur Originalquelle führt, um den vollständigen Artikel zu lesen. Die Anwendung verwendet React für das Frontend, Java Spring Boot für das Backend und Redis als Cache-Datenbank, um die Effizienz der Anfragen zu erhöhen. Die erforderlichen Nachrichteninformationen werden von der News API (https://newsapi.org/) abgerufen und in Redis zwischengespeichert, um bei wiederholten Anfragen schneller darauf zugreifen zu können. Die Suche und Anzeige der Nachrichten erfolgt über eine benutzerfreundliche Weboberfläche, die eine schnelle und intuitive Nutzung ermöglicht.

### Aufgabenstellung

Die Aufgabe umfasst die Erstellung und Umsetzung eines umfassenden Testkonzepts für eine mehrschichtige Softwarelösung. Diese Lösung besteht aus einem intuitiven Frontend, einer komplexen Schicht zur Abwicklung der Geschäftslogik und einer leistungsfähigen Datenbank zur effizienten Verwaltung von Daten. Zudem wird die Software in verschiedene externe Backends integriert, die zusätzliche Funktionen und Datenquellen bieten. Um sicherzustellen, dass die gesamte Anwendung zuverlässig und ohne Unterbrechungen funktioniert, müssen alle Komponenten gründlich getestet werden.

![Assignmetn Details](https://github.com/KutiCode/sqs-nachrichtenapp/blob/main/Dokumentationsbilder/Assignment%20Details%20SQS2024.png)

### Qualitätsziele

| Qualitätskriterium     | Beschreibung           | Ziele                                      | Maßnahmen                                       |
| -----------------------| ---------------------- | ------------------------------------------ | ------------------------------------------------|
| Usability - <br>Benutzerfreundlichkeit  | Die Anwendung soll eine benutzerfreundliche Oberfläche mit einfacher Navigation und Interaktion bieten.|- Einfache Bedienung <br>- Übersichtliche und leicht verständliche Weboberfläche <br>- Schnelle Ladezeiten |- UI-Tests <br>- End-to-End-Tests mit Playwright|
| Reliability - <br>Zuverlässigkeit  | Die Anwendung sollte stabil und fehlerfrei funktionieren, hohe Verfügbarkeit gewährleisten und auch bei unerwarteten Eingaben sowie hoher Last fehlertolerant bleiben. | - Hohe Widerstandsfähigkeit gegenüber Benutzereingaben  <br>- Stabilität unter hoher Last  |   - Integrationstest <br>- Lasttests mit Artillery  <br>- Umfangreiche Testabdeckung mit Unit-Tests|
| Portability - <br>Übertragbarkeit  | Die Anwendung muss flexibel in Bezug auf die Laufzeitumgebung sein. | - Browserunabhängige Verwendbarkeit  <br>- Effiziente Ressourcennutzung <br>- Reduktion externer Abhängigkeiten | - Durchführung von End-to-End-Tests mit Playwright <br>- Einsatz einer Docker-Compose-Datei zum Starten der Services <br>- Nutzung von Docker zur Plattformunabhängigkeit und Isolierung der Laufzeitumgebungen |

### Stakeholder

| Rolle              | Kontakt                    | Erwartungshaltung                                  | 
| ------------------ | -------------------------- | -------------------------------------------------- |
| Professor          | Beneken, Gerd (gerd.beneken@th-rosenheim.de)                 | Erwartet wird eine funktionierende Software mit erfüllten Qualitätszielen und SQS-Aspekten für eine gute Note |
| Lehrbeauftragte    | Reimer, Mario-Leander (mario-leander.reimer@th-rosenheim.de) | Erwartet wird eine funktionierende Software mit erfüllten Qualitätszielen und SQS-Aspekten für eine gute Note |
| Entwickler         | Öktem, Kutay (kutay.oektem@stud.th-rosenheim.de)             | Entwicklung einer funktionierenden Anwendung gemäß den angegebenen Qualitätszielen          |
| Anwender           |                | Erwartet eine zuverlässige, schnelle und benutzerfreundliche Anwendung zur Suche und Anzeige aktueller Nachrichten |
| API Anbieter       | https://newsapi.org/                | Verantwortungsvolle und effiziente Nutzung der API gemäß den Vorgaben des Anbieters  |

## Randbedingungen

### Technische Randbedingungen

- Software- und Framework-Abhängigkeiten: Die Anwendung benötigt React 18.3.1, Spring Boot 3.3.0, Java 17, Redis 0.7.3 und Maven 3.9.8

- Hardwareanforderung: Ein Laptop oder PC ist erforderlich, um die Anwendung auszuführen.

- Plattformanforderungen: Die Anwendung muss auf macOS, Linux oder Windows lauffähig sein.
  
- Entwicklungs- und Deployment-Anforderungen: Für die Versionskontrolle wird GitHub verwendet. Eine CI/CD-Pipeline mit GitHub Actions wird eingerichtet, um automatisiertes Testing und Deployment zu gewährleisten. Zudem wird Docker zur Containerisierung und Verwaltung der Laufzeitumgebungen eingesetzt.
  
- Integrationsanforderungen: Für die Integration sind Redis und die Polygon.io API erforderlich.

- Netzwerk- und Kommunikationsanforderungen: Alle externen API-Aufrufe müssen über HTTPS erfolgen.

### Organisatorische Randbedingungen

- Zeitvorgabe: Der Abgabetermin für das Projekt ist der 23. Juni 2024.

- Abnahmekriterien: Die Abnahme des Projekts erfolgt bei vollständiger Erfüllung der Aufgabenstellung.
  
- Dokumentationsanforderungen: Für die Projektdokumentation ist das arc42 Template zu verwenden.

- Kommunikationsweg: Es finden wöchentliche Besprechungen jeden Montag während der Vorlesung statt. Alternativ können Anliegen per E-Mail an mario-leander.reimer@th-rosenheim.de gesendet werden.
  
## Kontextabgrenzung

### Fachlicher Kontext
![Fachlicher Kontext](https://github.com/KutiCode/sqs-nachrichtenapp/blob/main/Dokumentationsbilder/Fachlicher%20Konzept.PNG)

| Kommunikationsbeziehung | Eingabe                        | Ausgabe                                            | 
| ----------------------- | -------------------------------| -------------------------------------------------- |
| User --> Nachrichtenapp | Land auswählen oder Schlagwort suchen  | Benutzeroberflächenaktualisierungen  |
| Nachrichtenapp --> User | Benutzeroberflächenaktualisierungen | Nachrichten anzeigen  |
| Nachrichtenapp --> News API  | Suchanfrage nach Land oder Schlagwort   | - |
| News API --> Nachrichtenapp | - | Übertragung der Nachrichten  |


### Technischer- oder Verteilungskontext

![Technischer Kontext](https://github.com/KutiCode/sqs-nachrichtenapp/blob/main/Dokumentationsbilder/UML_Deployment%20Diagramm.png)

| Technischer Kanal              | Eingabe                    | Ausgabe                                  | 
| ------------------ | -------------------------- | -------------------------------------------------- |
| User --> React Frontend | Benutzeraktion (Land auswählen oder Schlagwort eingeben)  | Aktualisierung der Benutzeroberfläche  |
| React Frontend --> NewsController | HTTP Request (Land oder Schlagwort)   | HTTP Response (Nachrichten)  |
| NewsController --> NewsService | Request News Data  | Ergebnis der Datenabfrage   |
| NewsService --> ApiService | API Request (Land oder Schlagwort)  | API Response (Nachrichten)  |
| ApiService --> News API | HTTP Request (Land oder Schlagwort)  | Liste der Nachrichten  |
| News API --> ApiService | - | Übertragung der Nachrichten  |
| ApiService --> NewsService | Api Response   |  Übertragung der Nachrichten  |
| NewsService --> RedisService | Datenabfrage  |  Daten speichern oder abrufen |
| RedisService --> RedisCache | Redis-Abfrage   |  Redis Response |
| RedisCache --> RedisService | -  |  Übertragung der Nachrichten  |
| RedisService --> NewsService |  Datenkonvertierung |  Übertragung der Nachrichten |
| NewsService --> NewsController | Service Response  |  Übertragung der Nachrichten |
| NewsController --> ReactFrontend | HTTP Response  | Aktualisierung der Benutzeroberfläche |

## Lösungsstrategie

## Baueinsicht

### Whitebox Gesamtsystem

#### Übersichtsdiagramm

### Ebene 2

## Laufzeitsicht

### Laufzeitszenario 1

### Laufzeiszenario 2 

## Verteilungssicht

### Infrastruktur Ebene 1

### Infrastruktur Ebene 2

## Querschnittliche Konzept

### Fachliche Struktur und Modelle

### Architektur- und Entwurfsmuster
gen
### Unter-der-Haube

### User Experience

## Entwurfsentscheidungen 

### Entwurfsentscheidungen 1

### Entwurfsentscheidungen 2

## Qualitätsanforderungen

### Qualitätsbaum

### Qualitätsszenarien

## Risiken und technische Schulden

## Glossar
