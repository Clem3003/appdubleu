# appdubleu
L’app du bleu est une application web interactive développée pour le Comité de baptême Saint-Laurent à Liège. Elle a pour objectif d'accompagner les nouveaux membres (les "bleus") dans leur intégration, en leur proposant une plateforme tout-en-un alliant tradition folklorique, gamification, entraide et communication.

## Hibernate
```bash
  liquibase generateChangeLog --url=jdbc:postgresql://localhost:5432/postgres --username=postgres --password=secret --changeLogFile=changelog.yaml
```
* Don't forget to go in the appropriate repertory : src/main/resources/db/changelog/