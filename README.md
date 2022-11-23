# Abschlussprojekt: Coworking-Space

Coworking-Space ist ein Projekt bei welchem Mitglieder Büroplätze und Postfächer buchen können. Dieses Projekt wurde mit Quarkus entwickelt.

## Erste Schritte

1. Erstelle eine Kopie (fork) von diesem Projekt.
1. Stelle sicher, dass Docker installiert ist und läuft.
1. Stelle sicher, dass Visual Studio Code und die Erweiterung Remote Container installiert ist.
1. Klone (clone) das Projekt lokal, um damit arbeiten zu können.
1. Öffne das Projekt mit Visual Studio Code.
1. Öffne das Projekt im Entwicklungscontainer.
1. Starte das Projekt mit dem Kommando `Quarkus: Debug current Quarkus Project`
1. Probiere die Client-Applikation unter http://localhost:8080 aus.
1. Schaue die API auf http://localhost:8080/q/swagger-ui/ an.

## Datenbank

Die Daten werden in einer PostgreSQL-Datenbank gespeichert. In der Entwicklungsumgebung wird diese in der [docker-compose-yml](./.devcontainer/docker-compose.yml) konfiguriert.

### Datenbankadministration

Über http://localhost:5050 ist PgAdmin4 erreichbar. Damit lässt sich die Datenbank komfortabel verwalten. Der Benutzername lautet `zli@example.com` und das Passwort `zli*123`. Die Verbindung zur PostgreSQL-Datenbank muss zuerst mit folgenden Daten konfiguriert werden:
 - Host name/address: `db`
 - Port: `5432`
 - Maintenance database: `postgres`
 - Username: `postgres`
 - Password: `postgres`

## Automatische Tests

Die automatischen Tests können mit `./mvnw quarkus:test` ausgeführt werden. Für die automatischen Tests wird nicht die PostgreSQL-Datenbank verwendet, sondern eine H2-Datenbank, welche sich im Arbeitsspeicher während der Ausführung befindet.

## Zugangsdaten

### Member Daten
| Email                    | Password |
|--------------------------|----------|
| davidbucher@gmail.com    | 1234     |

### Admin Daten
| Email                   | Password |
|-------------------------|----------|
| alexchristen@gmail.com  | 1324     |

## Testdaten

Die Testdaten liegen im File import.sql im Ordner /resources und werden beim Start des Projektes automatisch in die Datenbank geladen

# Zusätzliches
## Mein Github
Mein Gituhub ist erreichbar unter diesem Link:
- https://github.com/Modul223/lorismueller_coworking

