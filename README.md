# Nachrichtenapp


### Statische Analyse Frontend: 
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=sqs-test_frontend&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=sqs-test_frontend)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=sqs-test_frontend&metric=bugs)](https://sonarcloud.io/summary/new_code?id=sqs-test_frontend)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=sqs-test_frontend&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=sqs-test_frontend)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=sqs-test_frontend&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=sqs-test_frontend)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=sqs-test_frontend&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=sqs-test_frontend)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=sqs-test_frontend&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=sqs-test_frontend)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=sqs-test_frontend&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=sqs-test_frontend)


### Statische Analyse Backend: 
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=sqs-test_backend&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=sqs-test_backend)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=sqs-test_backend&metric=bugs)](https://sonarcloud.io/summary/new_code?id=sqs-test_backend)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=sqs-test_backend&metric=code_smells)](https://sonarcloud.io/summary/new_code?id=sqs-test_backend)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=sqs-test_backend&metric=duplicated_lines_density)](https://sonarcloud.io/summary/new_code?id=sqs-test_backend)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=sqs-test_backend&metric=vulnerabilities)](https://sonarcloud.io/summary/new_code?id=sqs-test_backend)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=sqs-test_backend&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=sqs-test_backend)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=sqs-test_backend&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=sqs-test_backend)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=sqs-test_backend&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=sqs-test_backend)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=sqs-test_backend&metric=coverage)](https://sonarcloud.io/summary/new_code?id=sqs-test_backend)

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

Das System bezieht Nachrichten von einer externen News API und lädt diese in das Spring Boot-Backend. Anschließend werden die abgerufenen Daten in der Redis-Datenbank zwischengespeichert, um eine schnelle und effiziente Datenverarbeitung zu gewährleisten. Schließlich werden die gespeicherten Nachrichten über die React-Webanwendung den Benutzern zugänglich gemacht, wodurch sie auf aktuelle Nachrichteninhalte zugreifen können.

#### UML Deployment Diagramm

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
### Schnittstelle zum Backend
In der vorliegenden Anwendung bietet die Klasse `NewsController` die Schnittstelle zum Backend. Sie stellt die API-Endpunkte bereit, über die das Frontend auf die Nachrichten zugreifen kann. Die Klasse `NewsService` verarbeitet die Anfragen und steuert die Geschäftslogik, während die Klasse `ApiService` die Kommunikation mit der externen News API übernimmt. Die Klasse `RedisService` verwaltet die Datenbankkommunikation und speichert die abgerufenen Nachrichten in der Redis-Datenbank. Durch diese Struktur wird eine klare Trennung der Verantwortlichkeiten und eine effiziente Datenverarbeitung gewährleistet.

Die Schnittstellen die der `NewsController` bereitstellt sind:
- `GET /news/{land}/{datum}`: Abrufen der Top-Nachrichten eines bestimmten Landes für ein bestimmtes Datum.
- `GET /news/search/{schlagwort}`: Suche nach Nachrichten zu einem bestimmten Schlagwort.

Die unterschiedlichen Parameter bei den beiden Schnittstellen sind:
- `{land}`: Das Land, für das die Nachrichten abgerufen werden sollen. Zum Beispiel: `de` für Deutschland, `us` für die USA.
- `{datum}`: Das Datum, für das die Nachrichten abgerufen werden sollen. Zum Beispiel: `2024-06-01`.
- `{schlagwort}`: Das Schlagwort, nach dem die Nachrichten gesucht werden sollen. Zum Beispiel: `Corona`.


Die Schnittstell gibt bestimmte Responses zurück wenn der Nutzer eine Anfrage stellt:
- `200 OK`: Die Anfrage war erfolgreich und die Daten wurden gefunden.
- `500 Internal Server Error`: Ein interner Serverfehler ist aufgetreten und die Anfrage konnte nicht bearbeitet werden.

Die externe NewsAPI besitzt sehr viele Nachrichten zu allen möglichen Themen und Ländern. Aus diesem Grund ist die möglichkeit das der Nutzer eine Fehleingabe macht sehr gering. Außerdem wurde die Anwendung so entwickelt das sie auch bei einer Fehleingabe des Nutzers eine Fehlermeldung zurückgibt und der Nutzer informiert wird. Es wurde bewusst eine sehr benutzerfreundliche Oberfläche entwickelt um die Wahrscheinlichkeit einer Fehleingabe zu minimieren.
Deshalb bedeutet in diesem Fall ein `500 Internal Server Error` das ein interner Serverfehler aufgetreten oder die externe API keine Nachrichten zu diesem Land oder Schlagwort gefunden hat. Sollte eine solche Rückmeldung erfolgen, so sieht der Nutzer das ihm keine Nachrichten angezeigt werden.


### Externe Schnittstelle - News API
Die NewsAPI ist eine externe REST-API, die Nachrichten von verschiedenen Quellen und Ländern bereitstellt. Die API bietet verschiedene Endpunkte, um Nachrichten nach Kategorien, Ländern, Schlagworten und anderen Parametern abzurufen. Die Nachrichten werden im JSON-Format zurückgegeben und können nach Bedarf gefiltert und sortiert werden. Die API erfordert eine API-Schlüsselauthentifizierung, um auf die Daten zuzugreifen, und stellt eine begrenzte Anzahl von Anfragen pro Tag zur Verfügung. Die NewsAPI bietet eine zuverlässige und umfassende Datenquelle für aktuelle Nachrichten und ist eine wertvolle Ressource für die Nachrichten-App.
Innerhalb dieser Anwendung erfolgt die Kommunikation mit der NewsAPI durch den `ApiService`. Dieser Service sendet HTTP-Anfragen an die API, um Nachrichten für bestimmte Länder oder Schlagwörter abzurufen. Die empfangenen Daten werden dann vom `NewsService` verarbeitet und in der Redis-Datenbank zwischengespeichert. Durch diese Struktur wird eine effiziente und zuverlässige Datenverarbeitung gewährleistet, die eine schnelle und benutzerfreundliche Anwendung ermöglicht.

Aufrgund der Umfrangreichen Anfragemöglichkeiten und den Anforderungen dieser Anwendung wurden nur folgende Endpunkte der NewsAPI verwendet:
- `GET https://newsapi.org/v2/top-headlines?country=sample-country&apiKey=apikey`: Abrufen der Top-Nachrichten aus verschiedenen Quellen und Ländern.


- `GET https://newsapi.org/v2/everything?q=sample-keyword&apiKey=apikey`: Abrufen von Nachrichten zu einem bestimmten Schlagwort oder Thema.

Die verschiedenen Parameter bei der NewsAPI sind:
- `country`: Das Land, für das die Nachrichten abgerufen werden sollen. Zum Beispiel: `de` für Deutschland, `us` für die USA.
- `q`: Das Schlagwort, nach dem die Nachrichten gesucht werden sollen. Zum Beispiel: `Corona`.
- `apiKey`: Der API-Schlüssel, der für die Authentifizierung bei der NewsAPI erforderlich ist.
- `top-headlines`: Der Endpunkt für den Abruf der Top-Nachrichten.
- `everything`: Der Endpunkt für den Abruf von Nachrichten zu einem bestimmten Schlagwort.

Die API-Doku der NewsAPI ist unter folgendem Link zu finden: [NewsAPI Dokumentation](https://newsapi.org/docs/endpoints/top-headlines)

# Lösungsstrategie

Die Entwurfsstrategie dieses Projekts beruht in wesentlichem Maße auf sorgfältig getroffenen Technologieentscheidungen und durchdachten Systemdesigns. Diese Entscheidungen und Designs wurden speziell auf die spezifischen Anforderungen, die angestrebten Qualitätsziele und die vorgegebenen Rahmenbedingungen abgestimmt, um eine optimale Umsetzung zu gewährleisten. Durch diese gezielte Abstimmung wird sichergestellt, dass das Projekt effizient, zuverlässig und den gestellten Aufgaben entsprechend umgesetzt wird.

### Technologieentscheidungen

Die Auswahl der Technologien für dieses Projekt wurde sorgfältig getroffen, um eine optimale Leistung, Skalierbarkeit und Benutzerfreundlichkeit zu gewährleisten. Hier sind die wesentlichen Gründe für die gewählten Technologien:

**1. Spring Boot für das Backend:**
Spring Boot wurde für das Backend gewählt, da es eine robuste und ausgereifte Plattform für die Entwicklung von Java-Anwendungen bietet. Es ermöglicht die schnelle Erstellung eigenständiger, produktionsreifer Anwendungen mit minimaler Konfiguration. Zudem bietet Spring Boot eine breite Palette an integrierten Funktionen wie Sicherheit, Datenverwaltung und RESTful Webservices, die für die Anforderungen dieses Projekts ideal sind.

**2. React für das Frontend:**
React wurde als Frontend-Framework ausgewählt, weil es eine schnelle und effiziente Entwicklung interaktiver Benutzeroberflächen ermöglicht. Mit seiner komponentenbasierten Architektur und virtuellen DOM-Technologie bietet React eine hervorragende Leistung und eine hervorragende Entwicklererfahrung. Die Wiederverwendbarkeit von Komponenten und die starke Community-Unterstützung machen React zur idealen Wahl für die Erstellung einer dynamischen und responsiven Webanwendung.

**3. Redis als Cache-Datenbank:**
Redis wurde als Cache-Datenbank implementiert, um die Leistungsfähigkeit der Anwendung zu maximieren. Dank seiner In-Memory-Datenstruktur und extrem schnellen Lese- und Schreiboperationen eignet sich Redis hervorragend für die Zwischenspeicherung häufig abgefragter Daten. Dies reduziert die Latenzzeiten und entlastet die Hauptdatenbank, wodurch die Gesamtleistung der Anwendung verbessert wird.

**4. Docker für die Containerisierung:**
Docker wurde zur Containerisierung und Verwaltung der Laufzeitumgebungen verwendet. Durch die Nutzung von Docker können die Anwendungen und ihre Abhängigkeiten in isolierten Containern gebündelt werden, was die Plattformunabhängigkeit und Konsistenz der Entwicklungs- und Produktionsumgebungen gewährleistet. Docker erleichtert zudem die Bereitstellung und Skalierung der Anwendung erheblich.

**5. GitHub und GitHub Actions für Versionskontrolle und CI/CD:**
GitHub wurde für die Versionskontrolle gewählt, um eine effiziente Zusammenarbeit und Verwaltung des Quellcodes zu ermöglichen. Mit GitHub Actions wird eine CI/CD-Pipeline eingerichtet, die automatisiertes Testing und Deployment ermöglicht. Dies sorgt für eine kontinuierliche Integration und Auslieferung der Software, was die Qualität und Zuverlässigkeit der Anwendung sicherstellt.

**6. News API für externe Nachrichtenquellen:**
Die News API wurde ausgewählt, um aktuelle Nachrichten von verschiedenen Quellen zu beziehen. Sie bietet eine einfache und konsistente Möglichkeit, auf eine Vielzahl von Nachrichtenquellen zuzugreifen, was die Funktionalität der Anwendung erheblich erweitert und den Benutzern wertvolle Informationen liefert.

### Top-Level-Zerlegung des Systems

**1. Frontend (Benutzeroberfläche):**
Das Frontend bildet die Benutzerschnittstelle der Anwendung und wird mit React entwickelt. Es umfasst alle visuellen und interaktiven Elemente, die der Benutzer sieht und mit denen er interagiert. Die Hauptaufgaben des Frontends sind die Darstellung der Daten, die Kommunikation mit dem Backend über API-Aufrufe und die Bereitstellung einer benutzerfreundlichen Oberfläche.

**2. Backend (Geschäftslogik und Datenverarbeitung):**
Das Backend, entwickelt mit Spring Boot, bildet das Herzstück der Anwendung. Es verwaltet die Geschäftslogik, verarbeitet Datenanfragen, kommuniziert mit externen APIs und steuert die Datenbankzugriffe. Das Backend stellt sicher, dass alle Geschäftsprozesse korrekt und effizient ablaufen und die Anfragen des Frontends zuverlässig bedient werden.

**3. Datenbank (Datenmanagement und -speicherung):**
Die Datenbank, in diesem Fall Redis, dient als temporärer Speicher für die zwischengespeicherten Daten. Sie ermöglicht schnelle Lese- und Schreibzugriffe, um die Leistung der Anwendung zu optimieren. Redis wird verwendet, um häufig angefragte Daten zu speichern und so die Last auf das Backend zu reduzieren.

**4. Externe APIs (Datenquellen):**
Die externe News API stellt die notwendigen Daten für die Anwendung bereit. Das Backend kommuniziert mit dieser API, um aktuelle Nachrichten abzurufen, die dann verarbeitet und in der Redis-Datenbank zwischengespeichert werden. Diese Daten werden anschließend dem Frontend zur Anzeige bereitgestellt.

**5. Infrastruktur und Deployment:**
Die Infrastruktur der Anwendung wird mit Docker containerisiert, um die Plattformunabhängigkeit und Konsistenz der Entwicklungs- und Produktionsumgebungen sicherzustellen. GitHub wird für die Versionskontrolle verwendet, während GitHub Actions zur Einrichtung einer CI/CD-Pipeline genutzt wird, die automatisiertes Testing und Deployment ermöglicht.

### Qualitätsanforderungen 

Im Bereich der **Benutzerfreundlichkeit** muss die Anwendung eine intuitive und leicht verständliche Oberfläche bieten, die durch einfache Navigation und Interaktion überzeugt. Die Benutzeroberfläche soll klar strukturiert und übersichtlich gestaltet sein, sodass die Benutzer ohne großen Aufwand mit der Anwendung interagieren können. Zudem sind schnelle Ladezeiten notwendig, um die Benutzererfahrung zu verbessern. Zur Sicherstellung dieser Ziele werden UI-Tests und End-to-End-Tests mit Playwright durchgeführt, um die Funktionsfähigkeit der Benutzeroberfläche zu überprüfen.

Die **Zuverlässigkeit** der Anwendung ist ebenfalls von großer Bedeutung. Die Anwendung soll stabil und fehlerfrei laufen, eine hohe Verfügbarkeit gewährleisten und auch bei unerwarteten Eingaben sowie unter hoher Last fehlerfrei bleiben. Hierbei ist es wichtig, dass die Anwendung verschiedene Arten von Benutzereingaben robust verarbeiten kann, ohne abzustürzen, und dass sie auch bei hoher Benutzeraktivität oder Datenverarbeitung stabil bleibt. Zur Erreichung dieser Ziele werden Integrationstests und Lasttests mit Artillery durchgeführt sowie eine umfangreiche Testabdeckung mit Unit-Tests sichergestellt.

Im Hinblick auf die **Übertragbarkeit** muss die Anwendung flexibel in Bezug auf die Laufzeitumgebung sein und in allen gängigen Browsern einwandfrei funktionieren. Darüber hinaus soll die Anwendung Ressourcen wie Speicher und Prozessor effizient nutzen, um eine hohe Leistung zu gewährleisten, und minimal von externen Diensten abhängig sein, um ihre Zuverlässigkeit und Stabilität zu erhöhen. Zur Umsetzung dieser Ziele werden End-to-End-Tests mit Playwright durchgeführt, Docker-Compose-Dateien für das Starten der Services eingesetzt und Docker zur Plattformunabhängigkeit und Isolierung der Laufzeitumgebungen verwendet.

### Organisatorische Entscheidungen

**Verwendung von Docker:**
Docker wird zur Containerisierung und Verwaltung der Laufzeitumgebungen eingesetzt. Diese Entscheidung ermöglicht es, die Anwendung in isolierten Containern zu entwickeln und bereitzustellen, was die Konsistenz zwischen Entwicklungs-, Test- und Produktionsumgebungen sicherstellt. Docker-Compose wird verwendet, um die verschiedenen Services der Anwendung einfach zu starten und zu verwalten. Diese Vorgehensweise erleichtert die Einrichtung und den Betrieb der gesamten Entwicklungsumgebung und reduziert potenzielle Konflikte zwischen Abhängigkeiten.

**Versionskontrolle mit GitHub:**
GitHub dient als Plattform für die Versionskontrolle, um eine effiziente Verwaltung des Codes zu ermöglichen. Alle Code-Änderungen werden in einem zentralen Repository verwaltet, was die Nachverfolgbarkeit von Änderungen und die Sicherung der Entwicklungsfortschritte erleichtert. GitHub stellt sicher, dass der Code strukturiert und übersichtlich bleibt und frühere Versionen bei Bedarf leicht wiederhergestellt werden können.

**CI/CD-Pipeline mit GitHub Actions:**
Zur Automatisierung der Build-, Test- und Deployment-Prozesse wird eine CI/CD-Pipeline mit GitHub Actions eingerichtet. Diese Pipeline führt automatisierte Tests bei jedem Commit durch, um sicherzustellen, dass keine neuen Fehler eingeführt werden. Darüber hinaus wird der Build-Prozess automatisiert, um die Anwendung in Docker-Containern zu packen und bereitzustellen. Diese Automatisierung erhöht die Effizienz und Zuverlässigkeit der Bereitstellungsprozesse.

**Testing-Strategien:**
Ein strukturierter Ansatz für das Testen der Anwendung wird verfolgt, um die Qualität und Zuverlässigkeit sicherzustellen. UI-Tests und End-to-End-Tests werden mit Playwright durchgeführt, um die Funktionalität der Benutzeroberfläche zu überprüfen. Integrationstests und Lasttests mit Artillery werden eingesetzt, um die Stabilität und Leistung der Anwendung unter verschiedenen Bedingungen zu gewährleisten. Eine umfassende Testabdeckung mit Unit-Tests stellt sicher, dass alle Komponenten der Anwendung robust und fehlerfrei funktionieren.

## Baueinsicht

### Whitebox Gesamtsystem

#### Übersichtsdiagramm

![Übersichtsdiagramm](https://github.com/KutiCode/sqs-nachrichtenapp/blob/main/Dokumentationsbilder/%C3%9Cbersichtsdiagramm.PNG)

**Begründung:**
Die Aufteilung des Gesamtsystems in verschiedene Bausteine basiert auf den Prinzipien der Modularisierung und der klaren Aufgabenverteilung. Dies erhöht die Wartbarkeit, erleichtert die Erweiterbarkeit und fördert eine bessere Skalierbarkeit des Systems.

#### Enthaltene Bausteine

| Name  | Verantwortung                      | 
| ------------------ | -------------------------- |
| React Frontend | Bereitstellung der Benutzeroberfläche|
| Spring Boot Backend | Bereitstellung der API-Endpunkte und Ausführung der Geschäftslogik|
| Redis Datenbank | Verwaltung und Speicherung der Daten|
| News API | Externe Datenquelle für Nachrichten|

#### Wichtige Schnittstellen
| Schnittstelle  | Beschreibung                      | 
| ------------------ | -------------------------- |
| Frontend-Backend | Schnittstelle für die Kommunikation zwischen React Frontend und Spring Boot Backend |
| Backend-Datenbank | Schnittstellte für die Kommunikation zwischen Spring Boot Backend und Redis Datenbank |
| Backend-Externe API | Schnittstelle für die Kommunikation zwischen Spring Boot Backend und News API|

### React Frontend

**Zweck/Verantwortung:** Das React-Frontend bietet die Benutzeroberfläche, über die Anwender Nachrichten suchen und Informationen anzeigen können. 
**Schnittstelle:** 

### Spring Boot Backend

**Zweck/Verantwortung:** Das Spring Boot Backend stellt API-Endpunkte bereit und verarbeitet die Geschäftslogik, sodass das Frontend und externe Systeme auf die Anwendung zugreifen können.

**Schnittstelle:**

### Redis Datenbank

**Zweck/Verantwortung:** Die Redis-Datenbank verwaltet und speichert alle benötigten Daten der Anwendung, einschließlich der gecachten Nachrichten.
**Schnittstelle:**

### News API

**Zweck/Verantwortung:** Das Backend verwendet die News API als externe Quelle für Nachrichten, um Daten abzurufen, die nicht im lokalen Cache vorhanden sind.

**Schnittstelle:**

## Ebene 1

### Whitebox Spring Boot Backend

#### Übersichtsdiagramm

![Whitebox Spring Boot Backend](https://github.com/KutiCode/sqs-nachrichtenapp/blob/main/Dokumentationsbilder/Whitebox%20Spring%20Boot%20Backend.PNG)

#### Enthaltene Bausteine

| Name  | Verantwortung                      | 
| ------------------ | -------------------------- |
| News Controller | Bereitstellung Bereitstellung von API-Endpunkten für die Abfrage von Nachrichten|
| News Service | Verarbeitung der Nachrichtenanfragen durch Geschäftslogik |
| ApiService | Anbindung an die News API|
| RedisService | Datenmodell für Brauereidaten und Datenbankkommunikation|
### Whitebox React Frontend

#### Übersichtsdiagramm
![Frontend-Whitebox](https://github.com/KutiCode/sqs-nachrichtenapp/blob/main/Dokumentationsbilder/Frontend-whiteBox.png)

#### Enthaltene Bausteine

| Name         | Verantwortung                                                                                                                                                                 |
|--------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| AppComponent | Kommunikation mit den unterschiedlichen Elementen und korrekte Darstellung dieser. Stellt die Weboberfläche bereit.                                                           |
| Header       | Stellt die Kopfzeile der Webanwendung zur Verfügung                                                                                                                           |
| SearchBar    | Komponente für die Eingabe von Schlagwörtern. Kommuniziert mit AppComponent für die übermittlung der Daten an das Backend                                                     |
| Dropdown     | Stellt verschiedene Länder dem Nutzer zur Verfügung um die Trend Nachrichten auswählen zu können. Kommuniziert mit AppComponent für die Übermittlung der Daten an das Backend |
| ResultsList  | Stellt die Ergebnisse der Anfrage dar. Kommuniziert für die Richtige Darstellung mit AppComponent.                                                                            |
| DetailedView | Detaillierte Ansicht der ausgewählten Nachricht aus ResultsList                                                                                                               |

## Laufzeitsicht

### Szenario 1: Abruf von Nachrichten durch Auswahl des Landes (Cache-Hit)
#### Ablaufbeschreibung
1. **Benutzeranfrage im Frontend:** Auf der React basierten Webanwendung navigiert der Benutzer und wählt ein Land aus, um Nachrichten abzurufen.
2. **Anfrage an das Backend:** Das Frontend übermittelt eine HTTP GET-Anfrage an das Spring Boot-Backend mit dem Endpunkt /news/{land}/{datum}.
3. **Überprüfung des Caches im Backend:** Das Backend kontrolliert, ob die Nachrichten für das ausgewählte Land bereits im Cache (Redis-Datenbank) gespeichert sind.
4. **Cache-Hit:** Sind die Informationen im Cache vorhanden, werden sie von dort an das Backend übermittelt.
5. **Antwort an das Frontend:** Das Backend leitet die Nachrichten an das Frontend weiter.
6. **Anzeige der Daten:** Das Frontend präsentiert die empfangenen Nachrichten dem Benutzer.
![Laufzeitdiagramm 1](https://github.com/KutiCode/sqs-nachrichtenapp/blob/main/Dokumentationsbilder/Laufdiagramm%201.PNG)

### Szenario 2: Abruf von Nachrichten durch Suche nach einem Schlagwort (Cache-Hit)
#### Ablaufbeschreibung
1. **Benutzeranfrage im Frontend:** Auf der React basierten Webanwendung navigiert der Benutzer und gibt ein Schlagwort ein, um Nachrichten abzurufen.
2. **Anfrage an das Backend:** Das Frontend übermittelt eine HTTP GET-Anfrage an das Spring Boot-Backend mit dem Endpunkt /news/search/{schlagwort}.
3. **Überprüfung des Caches im Backend:** Das Backend kontrolliert, ob die Nachrichten für das ausgewählte Land bereits im Cache (Redis-Datenbank) gespeichert sind.
4. **Cache-Hit:** Sind die Informationen im Cache vorhanden, werden sie von dort an das Backend übermittelt.
5. **Antwort an das Frontend:** Das Backend leitet die Nachrichten an das Frontend weiter.
6. **Anzeige der Daten:** Das Frontend präsentiert die empfangenen Nachrichten dem Benutzer.

![Laufzeitdiagramm 2](https://github.com/KutiCode/sqs-nachrichtenapp/blob/main/Dokumentationsbilder/Laufzeitdiagramm%202.PNG)

### Szenario 3: Abruf von Nachrichten (Cache-Miss)
#### Ablaufbeschreibung
1. **Benutzeranfrage im Frontend:** Auf der React basierten Webanwendung navigiert der Benutzer und wählt ein Land aus, um Nachrichten abzurufen.
2. **Anfrage an das Backend:** Das Frontend übermittelt eine HTTP GET-Anfrage an das Spring Boot-Backend mit dem Endpunkt /news/{land}/{datum}.
3. **Überprüfung des Caches im Backend:** Das Backend kontrolliert, ob die Nachrichten für das ausgewählte Land bereits im Cache (Redis-Datenbank) gespeichert sind.
4. **Cache Miss:** Sind die Informationen nicht im Cache vorhanden, wird eine Anfrage an die externe API der News API gesendet.
5. Anfrage an die News API: Das Backend stellt eine HTTP GET-Anfrage an die API der News API, um Nachrichten für das ausgewählte Land abzurufen.
6. **Empfang und Speicherung der Daten:** Die News API liefert die Daten im JSON-Format zurück, und das Backend speichert diese im Cache (Redis-Datenbank).
7. **Antwort an das Frontend:** Das Backend übermittelt die Nachrichten an das Frontend.
8. **Anzeige der Daten:** Das Frontend präsentiert die empfangenen Nachrichten dem Benutzer.
   
![Laufzeitdiagramm 3](https://github.com/KutiCode/sqs-nachrichtenapp/blob/main/Dokumentationsbilder/Laufzeitdiagramm%203.PNG)

## Verteilungsschicht

### Infrastruktur
![Infrastrukturdiagramm](https://github.com/KutiCode/sqs-nachrichtenapp/blob/main/Dokumentationsbilder/infrastruktur.png)
Begründung: 
In der Nachrichtenapp wurde die Archtitektur bewusst unterteilt und aufgeteilt. Das Frontend und Backend sind voneinander getrennt und kommunizieren über eine API miteinander. Das Frontend ist für die Darstellung der Nachrichten und die Interaktion mit dem Nutzer zuständig. Das Backend ist für die Verarbeitung der Anfragen und die Kommunikation mit der Datenbank und der externen API zuständig. Die Datenbank speichert die Nachrichten und dient als Zwischenspeicher. Die externe API liefert die Nachrichten, die nicht im Cache vorhanden sind. Durch diese Aufteilung wird eine klare Trennung der Verantwortlichkeiten und eine effiziente Datenverarbeitung gewährleistet.
Durch die verwendung von React und Spring Boot wird eine hohe Flexibilität und Skalierbarkeit erreicht. Die Verwendung von Redis als Cache-Datenbank ermöglicht eine schnelle und effiziente Datenverarbeitung, während die externe News API eine zuverlässige und umfassende Datenquelle für aktuelle Nachrichten bereitstellt. Die Containerisierung mit Docker und die CI/CD-Pipeline mit GitHub Actions erleichtern die Entwicklung und Bereitstellung der Anwendung erheblich und sorgen für eine hohe Qualität und Zuverlässigkeit.

- Skalierbarkeit: Die Anwendung kann bei Bedarf horizontal skaliert werden, um eine hohe Benutzeraktivität und Datenverarbeitung zu bewältigen. Durch die Containerisierung mit Docker und die Verwendung von Spring Boot und React wird eine hohe Flexibilität und Skalierbarkeit erreicht.


- Portabilität: Die Anwendung ist plattformunabhängig und kann auf verschiedenen Betriebssystemen und Umgebungen ausgeführt werden. Durch die Verwendung von Docker und GitHub Actions wird eine konsistente Entwicklungsumgebung und Bereit


- Zuverlässigkeit: Die Anwendung ist stabil und fehlerfrei und bleibt auch bei unerwarteten Eingaben oder hoher Last zuverlässig. Durch die umfangreichen Tests und die kontinuierliche Integration und Auslieferung wird eine hohe Qualität und Zuverlässigkeit der Anwendung sichergestellt.


- Isolation: Die Anwendung ist in isolierten Containern gebündelt, um die Abhängigkeiten zu verwalten und Konflikte zu vermeiden. Durch die Verwendung von Docker und GitHub Actions wird eine klare Trennung der Entwicklungs- und Produktionsumgebungen gewährleistet.

### Docker-Compose-Datei

In diesem Projekt genutzte Docker-Compose-Datei: [Docker-Compose-File]()

Die Images für das Front- und Backend werden aus der GitHub-Registry des Projektes gezogen.

<table>
  <tr>
    <td>
      <pre>
+-----------------------+
|         db            |
|   postgres:14         |
|   Port: 5432          |
|   Volumes:            |
|   postgres_data       |
+-----------------------+
      </pre>
    </td>
    <td>
      <pre>
+-----------------------+
|       backend         |
|     sqs_backend       |
|    Ports: 8080        |
|    Depends on: db     |
+-----------------------+
      </pre>
    </td>
    <td>
      <pre>
+-----------------------+
|       frontend        |
|     sqs_frontend      |
|    Port: 4200         |
|    Depends on: backend|
+-----------------------+
      </pre>
    </td>
  </tr>
</table>


## Querschnittliche Konzept
### Backend UML-Klassendiagramm
![Klassendiagramm](https://github.com/KutiCode/sqs-nachrichtenapp/blob/main/Dokumentationsbilder/klassendiagramm.png)

### Github Actions CI/CD Pipeline
[GitHub Actions Workflow](https://github.com/KutiCode/sqs-nachrichtenapp/blob/main/.github/workflows/ci-cd-pipeline.yml)

### Artillery Lasttest
[Artillery Lasttest](https://github.com/KutiCode/sqs-nachrichtenapp/blob/main/artillery/artillery.yml)

### Playwright End-to-End-Tests

[Playwright End-to-End-Tests](https://github.com/KutiCode/sqs-nachrichtenapp/tree/main/tests/tests)

### Sonarcloud-Report
[Sonarcloud-Report-Backend](https://sonarcloud.io/project/overview?id=sqs-test_backend)

[Sonarcloud-Report-Frontend](https://sonarcloud.io/project/overview?id=sqs-test_frontend)
## Architekturentscheidungen 

### Technologieentscheidungen

Die Auswahl der Technologien für dieses Projekt sind wie folgt:

- **Spring Boot für das Backend:** Spring Boot wurde für das Backend gewählt, da es eine robuste und ausgereifte Plattform für die Entwicklung von Java-Anwendungen bietet. Es ermöglicht die schnelle Erstellung eigenständiger, produktionsreifer Anwendungen mit minimaler Konfiguration. Zudem bietet Spring Boot eine breite Palette an integrierten Funktionen wie Sicherheit, Datenverwaltung und RESTful Webservices, die für die Anforderungen dieses Projekts ideal sind.


- **React für das Frontend:** React wurde als Frontend-Framework ausgewählt, weil es eine schnelle und effiziente Entwicklung interaktiver Benutzeroberflächen ermöglicht. Mit seiner komponentenbasierten Architektur und virtuellen DOM-Technologie bietet React eine hervorragende Leistung und eine hervorragende Entwicklererfahrung.


- **Redis als Cache-Datenbank:** Redis wurde als Cache-Datenbank implementiert, um die Leistungsfähigkeit der Anwendung zu maximieren. Dank seiner In-Memory-Datenstruktur und extrem schnellen Lese- und Schreiboperationen eignet sich Redis hervorragend für die Zwischenspeicherung häufig abgefragter Daten. Dies reduziert die Latenzzeiten und entlastet die Hauptdatenbank, wodurch die Gesamtleistung der Anwendung verbessert wird.


- **Docker für die Containerisierung:** Docker wurde zur Containerisierung und Verwaltung der Laufzeitumgebungen verwendet. Durch die Nutzung von Docker können die Anwendungen und ihre Abhängigkeiten in isolierten Containern gebündelt werden, was die Plattformunabhängigkeit und Konsistenz der Entwicklungs- und Produktionsumgebungen gewährleistet. Docker erleichtert zudem die Bereitstellung und Skalierung der Anwendung erheblich.


- **GitHub und GitHub Actions für Versionskontrolle und CI/CD:** GitHub wurde für die Versionskontrolle gewählt, um eine effiziente Zusammenarbeit und Verwaltung des Quellcodes zu ermöglichen. Mit GitHub Actions wird eine CI/CD-Pipeline eingerichtet, die automatisiertes Testing und Deployment ermöglicht. Dies sorgt für eine kontinuierliche Integration und Auslieferung der Software, was die Qualität und Zuverlässigkeit der Anwendung sicherstellt.


- **News API für externe Nachrichtenquellen:** Die News API wurde ausgewählt, um aktuelle Nachrichten von verschiedenen Quellen zu beziehen. Sie bietet eine einfache und konsistente Möglichkeit, auf eine Vielzahl von Nachrichtenquellen zuzugreifen, was die Funktionalität der Anwendung erheblich erweitert und den Benutzern wertvolle Informationen liefert.


- **Playwright für UI-Tests:** Playwright wurde für die Durchführung von UI-Tests ausgewählt, um die Funktionsfähigkeit der Benutzeroberfläche zu überprüfen. Mit Playwright können automatisierte Tests auf verschiedenen Browsern und Geräten durchgeführt werden, um sicherzustellen, dass die Anwendung benutzerfreundlich und fehlerfrei ist.


- **Artillery für Lasttests:** Artillery wird für die Durchführung von Lasttests verwendet, um die Stabilität und Leistung der Anwendung unter verschiedenen Bedingungen zu gewährleisten. Mit Artillery können Tests mit hoher Benutzeraktivität und Datenverarbeitung durchgeführt werden, um sicherzustellen, dass die Anwendung auch bei hoher Last stabil bleibt.


- **JUnit für Unit-Tests:** JUnit wird für die Durchführung von Unit-Tests eingesetzt, um sicherzustellen, dass alle Komponenten der Anwendung robust und fehlerfrei funktionieren. Mit JUnit können automatisierte Tests auf einzelne Komponenten des Codes durchgeführt werden, um sicherzustellen, dass sie korrekt arbeiten und die erwarteten Ergebnisse liefern.


- **Docker-Compose für die Koordination der Services:** Docker-Compose wird für die Koordination der verschiedenen Services der Anwendung verwendet. Mit Docker-Compose können mehrere Container gleichzeitig gestartet und verwaltet werden, was die Entwicklung und Bereitstellung der Anwendung erleichtert.


- **ArchUnit für Architekturtests:** ArchUnit wird für die Durchführung von Architekturtests eingesetzt, um sicherzustellen, dass die Architektur der Anwendung den definierten Regeln und Standards entspricht. Mit ArchUnit können automatisierte Tests auf die Struktur des Codes durchgeführt werden, um sicherzustellen, dass die Architektur konsistent und wartbar bleibt.


- **SonarCloud für statische Codeanalyse:** SonarCloud wird für die Durchführung von statischer Codeanalyse verwendet, um potenzielle Probleme und Schwachstellen im Code zu identifizieren. Mit SonarCloud können automatisierte Tests auf den Code durchgeführt werden, um sicherzustellen, dass er den besten Praktiken und Standards entspricht.

### Schichtenmodell

Das Schichtenmodell der Anwendung besteht aus den folgenden Schichten:

- **Präsentationsschicht (Frontend):** Die Präsentationsschicht dieser Anwendung umfasst ein React Frontend welches über REST-APIs mit dem Backend kommuniziert. Die Präsentationsschicht ist für die Darstellung der Benutzeroberfläche und die Interaktion mit dem Benutzer verantwortlich.


- Geschäftslogikschicht (Backend): Die Geschäftslogikschicht besteht aus einem Spring Boot Backend, das die API-Endpunkte bereitstellt und die Geschäftslogik der Anwendung implementiert. Das Backend verarbeitet die Anfragen des Frontends, kommuniziert mit der Datenbank und der externen API und steuert die Datenverarbeitung.


- Datenzugriffsschicht (Datenbank): Die Datenzugriffsschicht umfasst eine Redis-Datenbank, die als Cache für die zwischengespeicherten Daten dient. Die Datenbank verwaltet und speichert die Daten der Anwendung und ermöglicht schnelle Lese- und Schreibzugriffe.


- Inegrationsschicht (Externe API): Die Integrationsschicht besteht aus der News API, die als externe Datenquelle für Nachrichten dient. Das Backend kommuniziert mit der News API, um aktuelle Nachrichten abzurufen, die dann verarbeitet und in der Redis-Datenbank zwischengespeichert werden.

### Entwicklungsprozess

Der Entwicklungsprozess dieser Anwendung wurde sorgfältig geplant und strukturiert, um eine effiziente und zuverlässige Umsetzung zu gewährleisten. Der Prozess umfasst die folgenden Schritte:

1. Backend-Entwicklung: Die Entwicklung des Spring Boot-Backends erfolgt in mehreren Schritten. Zunächst werden die API-Endpunkte definiert und implementiert, um die Kommunikation mit dem Frontend zu ermöglichen. Anschließend wird die Geschäftslogik der Anwendung implementiert, um die Datenverarbeitung und -verwaltung sicherzustellen. Die Integration mit der Redis-Datenbank und der News API wird ebenfalls durchgeführt, um die Datenverarbeitung zu optimieren. Es werden umfangreiche Tests durchgeführt, um die Funktionalität und Zuverlässigkeit des Backends sicherzustellen. Eine Robuste Entwicklungsumgebung wird eingerichtet, um die Entwicklung und den Testprozess zu erleichtern.

2. Frontend-Entwicklung: Das Frontend wurde mithilfe von React erstellt. Die Benutzeroberfläche wird entwickelt, um die Anzeige der Nachrichten und die Interaktion mit dem Benutzer zu ermöglichen. Die Kommunikation mit dem Backend erfolgt über REST-APIs, um die Datenabfrage und -anzeige zu steuern. Die Benutzeroberfläche wird benutzerfreundlich und intuitiv gestaltet, um eine optimale Benutzererfahrung zu gewährleisten. Umfangreiche Tests werden durchgeführt, um die Funktionalität und Benutzerfreundlichkeit des Frontends sicherzustellen.

3. API-Integration: Die Integration mit der News API erfolgt, um aktuelle Nachrichten von verschiedenen Quellen abzurufen. Das Backend kommuniziert mit der News API, um die Datenabfrage und -verarbeitung zu steuern. Die Daten werden verarbeitet und in der Redis-Datenbank zwischengespeichert, um die Leistung der Anwendung zu optimieren. Die Integration wird sorgfältig geplant und durchgeführt, um eine reibungslose Datenübertragung und -verarbeitung sicherzustellen.

4. Testen: Umfangreiche Tests werden durchgeführt, um die Funktionalität, Zuverlässigkeit und Leistung der Anwendung sicherzustellen. UI-Tests und End-to-End-Tests mit Playwright werden durchgeführt, um die Benutzeroberfläche zu überprüfen. Integrationstests und Lasttests mit Artillery werden eingesetzt, um die Stabilität und Leistung der Anwendung zu gewährleisten. Eine umfassende Testabdeckung mit Unit-Tests wird sichergestellt, um alle Komponenten der Anwendung zu überprüfen.

5. CI/CD-Pipeline: Eine CI/CD-Pipeline mit GitHub Actions wird eingerichtet, um automatisierte Tests und Deployment-Prozesse zu ermöglichen. Die Pipeline führt automatisierte Tests bei jedem Commit durch, um sicherzustellen, dass keine neuen Fehler eingeführt werden. Der Build-Prozess wird automatisiert, um die Anwendung in Docker-Containern zu packen und bereitzustellen. Diese Automatisierung erhöht die Effizienz und Zuverlässigkeit der Bereitstellungsprozesse.

### Technologische Eigenschaften dieser Anwendung

**Backend** 

| Begriff     | Beschreibung |
|-------------|--------------|
| Technologie | Version      |
| Java        | 17           |
| Spring Boot | 3.3.0        |
| Maven       | 3.9.8        |

**Frontend**

| Begriff     | Beschreibung |
|-------------|--------------|
| Technologie | Version      |
| React       | 18.3.1       |
| Node        | 18           |

**Datenbank**

| Begriff     | Beschreibung |
|-------------|--------------|
| Technologie | Version      |
| Redis       | 0.7.3        |


**Tests**

| Begriff     | Beschreibung |
|-------------|--------------|
| Technologie | Version      |
| ArchUnit    | 0.22.0       |
| Playwright  | latest       |
| Artillery   | latest       |
| JUnit       | 5.8.1        |
## Qualitätsanforderungen

Im Bereich der **Benutzerfreundlichkeit** muss die Anwendung eine intuitive und leicht verständliche Oberfläche bieten, die durch einfache Navigation und Interaktion überzeugt. Die Benutzeroberfläche soll klar strukturiert und übersichtlich gestaltet sein, sodass die Benutzer ohne großen Aufwand mit der Anwendung interagieren können. Zudem sind schnelle Ladezeiten notwendig, um die Benutzererfahrung zu verbessern. Zur Sicherstellung dieser Ziele werden UI-Tests und End-to-End-Tests mit Playwright durchgeführt, um die Funktionsfähigkeit der Benutzeroberfläche zu überprüfen.

Die **Zuverlässigkeit** der Anwendung ist ebenfalls von großer Bedeutung. Die Anwendung soll stabil und fehlerfrei laufen, eine hohe Verfügbarkeit gewährleisten und auch bei unerwarteten Eingaben sowie unter hoher Last fehlerfrei bleiben. Hierbei ist es wichtig, dass die Anwendung verschiedene Arten von Benutzereingaben robust verarbeiten kann, ohne abzustürzen, und dass sie auch bei hoher Benutzeraktivität oder Datenverarbeitung stabil bleibt. Zur Erreichung dieser Ziele werden Integrationstests und Lasttests mit Artillery durchgeführt sowie eine umfangreiche Testabdeckung mit Unit-Tests sichergestellt.

Im Hinblick auf die **Übertragbarkeit** muss die Anwendung flexibel in Bezug auf die Laufzeitumgebung sein und in allen gängigen Browsern einwandfrei funktionieren. Darüber hinaus soll die Anwendung Ressourcen wie Speicher und Prozessor effizient nutzen, um eine hohe Leistung zu gewährleisten, und minimal von externen Diensten abhängig sein, um ihre Zuverlässigkeit und Stabilität zu erhöhen. Zur Umsetzung dieser Ziele werden End-to-End-Tests mit Playwright durchgeführt, Docker-Compose-Dateien für das Starten der Services eingesetzt und Docker zur Plattformunabhängigkeit und Isolierung der Laufzeitumgebungen verwendet.

### Qualitätsbaum
![Qualitätsbaum](https://github.com/KutiCode/sqs-nachrichtenapp/blob/main/Dokumentationsbilder/Qualit%C3%A4tsbaum.PNG)

### Qualitätsszenarien

| Attribut              | Szenario                   | Maßnahme                                  | 
| ------------------ | -------------------------- | -------------------------------------------------- |
| Usability - Benutzerfreundlichkeit| Nutzungsszenario:Das System präsentiert Nachrichten in einer klaren und leicht verständlichen Weise. | Aufgeräumtes Layout undEinheitliche Datenpräsentation |
|  | Änderungsszenario: Neue Nutzeranforderungen werden fortlaufend in das Design eingebunden. | Regelmäßige Überprüfung und Anpassung an die Bedürfnisse der Nutzer |
|  | Nutzungsszenario: Die Benutzer können mühelos ein Land auswählen oder ein Schlagwort eingeben, um die entsprechenden Ergebnisse anzuzeigen. |End-to-End-Tests werden mit Playwrigh und benutzerfreundliche Benutzeroberfläche mit einfacher Navigation.|
|  | Änderungsszenario: Optimierungen der Benutzeroberfläche werden kontinuierlich vorgenommen.| UI-Tests, Benutzerfeedback einholen und umsetzen, regelmäßige Usability-Tests |
| Reliability - Zuverlässigkeit | Nutzungsszenario: Das System bleibt auch bei hoher Auslastung stabil und reagiert zügig.| Lasttests mit Artillery |
|  | Änderungsszenario: Neue Anforderungen erfordern Anpassungen sowie erneute Überprüfungen der Systemstabilität.| Anpassung der Testverfahren |
|  | Nutzungsszenario: Das System wird umfassend getestet, um die Zuverlässigkeit sicherzustellen. | Integrationstests, End-to-End-Tests, Lasttests, Unit-Tests|
|  | Das Testkonzept wird regelmäßig aktualisiert, wenn Änderungen im Code vorgenommen werden. | Umfangreiche Testabdeckung |
| Portability - Übertragbarkeit| Nutzungsszenario: Das System läuft reibungslos in verschiedenen Browsern. | End-to-End-Tests mit Playwright |
|  |  Änderungsszenario: Neue Browserversionen werden unterstützt und getestet.| Regelmäßige Aktualisierungen und Tests mit Playwright |
|  | Nutzungsszenario: Das System funktioniert auf verschiedenen Plattformen innerhalb unterschiedlicher Docker-Container.| Einsatz von Docker für die Containerisierung und Verwendung von Docker Compose zur Koordination|
|  | Änderungsszenario: Neue Containerumgebungen werden unterstützt und geprüft.| Isolierte Laufzeitumgebung |

## Risiken und technische Schulden

| Risiko/Technische Schuld    | Beschreibung           | Maßnahme zur Risikovermeidung/Risikominimierung/Abbau der technischen Schuld | Priorität                                      |
| ------------------ | -------------------------- | -------------------------------------------------- |-------------------------------------------------- |
| Abhängigkeit von externer API| Die Anwendung ist stark von der externen News API abhängig. Wenn die API ausfällt oder Änderungen an ihrem Interface vornimmt, kann die Anwendung nicht korrekt funktionieren.| Implementierung eines Fallback-Mechanismus, der auf alternative Datenquellen zugreift, sowie regelmäßige Überprüfung der API-Verfügbarkeit und Anpassungen bei Änderungen. | Hoch|
| Unzureichende Testabdeckung| Nicht alle Codepfade und Funktionen sind ausreichend getestet, was dazu führen kann, dass Fehler oder unerwartete Verhaltensweisen unentdeckt bleiben. | Erhöhung der Testabdeckung durch zusätzliche Unit- und Integrationstests, regelmäßige Code-Reviews und Automatisierung der Tests in der CI/CD-Pipeline. | Mittel |
| Komplexität der Containerisierung | Die Verwaltung und Orchestrierung mehrerer Docker-Container kann komplex und fehleranfällig sein, was die Wartung und Skalierbarkeit der Anwendung erschwert. | Dokumentation der Containerisierungsprozesse, Schulung der Entwickler im Umgang mit Docker und Docker Compose, sowie regelmäßige Überprüfungen und Optimierungen. | Mittel |
| Performanceprobleme bei hoher Last| Das System könnte bei hoher Benutzerlast Leistungseinbußen erleiden, was zu längeren Ladezeiten oder sogar Ausfällen führen kann. | Durchführung von Lasttests zur Identifikation von Engpässen, Optimierung der Datenbankabfragen und des Codes, sowie Skalierung der Infrastruktur nach Bedarf.| Hoch |
| Veraltete Bibliotheken | Verwendete Bibliotheken und Frameworks könnten veralten und Sicherheitslücken enthalten, was die Sicherheit und Stabilität der Anwendung beeinträchtigen kann. | Regelmäßige Updates der verwendeten Bibliotheken und Abhängigkeiten, Überwachung von Sicherheitswarnungen und Durchführung von Sicherheitsaudits | Niedrig|
| Sicherheitslücken | Die Anwendung könnte Sicherheitslücken aufweisen, die von Angreifern ausgenutzt werden könnten, was zu Datenverlust oder -manipulation führen kann. | Durchführung regelmäßiger Sicherheitsaudits, Implementierung von Sicherheitsmaßnahmen wie Verschlüsselung und Authentifizierung, sowie Schulung der Entwickler in sicheren Programmierpraktiken. | Hoch |	

## Glossar

| Begriff | Beschreibung                      | 
| ------------------ | -------------------------- |
| React | Eine JavaScript-Bibliothek zur Erstellung von Benutzeroberflächen, die eine komponentenbasierte Architektur nutzt. |
| Redis | Ein In-Memory-Datenbank, die als Cache und Nachrichtenbroker dient, bekannt für hohe Geschwindigkeit und Effizienz. |
| Spring Boot | Ein Framework zur Erstellung von Microservices in Java, das schnelle und eigenständige Anwendungen ermöglicht. |
| News API | Eine externe Schnittstelle, die aktuelle Nachrichten von verschiedenen Quellen abruft und bereitstellt. |
| Chaching | Eine Methode zur Zwischenspeicherung von Daten, um schnelleren Zugriff und reduzierte Ladezeiten zu ermöglichen. |
| SonerCloud | Ein Tool zur kontinuierlichen Inspektion der Codequalität, das Fehler, Schwachstellen und Verbesserungsmöglichkeiten aufzeigt. |
| GitHub | Eine Plattform für Versionskontrolle und kollaborative Softwareentwicklung, die Git verwendet. |
| GitHub Actions| Ein CI/CD-Tool von GitHub, das Workflows für automatisierte Software-Builds, Tests und Deployments ermöglicht. |
| CI/CD-Pipeline | Eine Automatisierungspipeline, die kontinuierliche Integration (CI) und kontinuierliche Bereitstellung (CD) von Software ermöglicht. |
| Fallback-Mechanismus | Ein System, das alternative Verfahren nutzt, wenn der Hauptweg fehlschlägt, um die Verfügbarkeit zu gewährleisten. |
| ArchUnit | Ein Testframework für Architektur- und Designregeln in Java, das die Einhaltung von Architekturvorgaben überprüft. |
| JUnit | Ein beliebtes Framework für das Testen von Java-Anwendungen durch Unit-Tests. |
| Artillery | Ein Lasttest-Tool, das zur Prüfung der Performance und Skalierbarkeit von Anwendungen eingesetzt wird. |
| Playwright | Ein Framework für End-to-End-Tests von Webanwendungen, das browserübergreifende Automatisierung ermöglicht. |
| Unit-Test | Ein Test, der einzelne Komponenten oder Funktionen isoliert prüft, um deren korrekte Funktion sicherzustellen. |
| End-to-End-Test | Ein Test, der das gesamte System von Anfang bis Ende prüft, um sicherzustellen, dass alle Komponenten zusammenarbeiten.|
| Lasttest | Ein Test, der die Leistung eines Systems unter hoher Last oder Benutzeranzahl überprüft. |
| Integrationstest | Ein Test, der überprüft, ob verschiedene Komponenten eines Systems korrekt zusammenarbeiten. |
| Docker | Eine Plattform zur Containerisierung, die es ermöglicht, Anwendungen in isolierten Umgebungen zu betreiben. |
| Docker-Compose | Ein Tool zur Definition und Verwaltung mehrerer Docker-Container, die zusammen eine Anwendung bilden. |
| Statische Code Analyse | Eine Methode zur Überprüfung des Quellcodes ohne dessen Ausführung, um Fehler, Schwachstellen und Verbesserungspotenziale zu identifizieren. |



