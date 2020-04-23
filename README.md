# Java-oblig-2

## Oppgave 1.1

Lag deg en oversikt over hva følgende ord/begreper betyr, med egne ord (lurt å gjøre dette bra nå, kan være nyttig til eksamen):

* Class
* Object (konseptet, ikke klassen)
* Instansvariabel
* Overloading
* Overriding
* Extends 
* Polymorphism
* private,public,(protected) (klasse,variabel,metode)
* this og super

 
## Programmering

Vi skal lage en applikasjon som skal holde på data om universet. Det blir i stor grad en generalisering, men vi skal opprette klasser og lage objekter som reflekterer deler av dette.

Litt data om vårt solsystem som kan benyttes i oppgaven finnes her:  solar_system_data.txtForhåndsvis dokumentet

### Oppgave 2.1

Vi skal kunne opprette planetsystemer med tilhørende data, vi trenger derfor noen klasser for å representere et planetsystem. Til å begynne med definerer vi at et planetsystem skal kunne ha flere planeter, samt én stjerne.

Lag derfor 3 klasser med instansvariabler:

* Planet
    * name, radius, mass
* Star
    * name, radius, mass, effectiveTemp
* PlanetSystem
    * name, centerStar, planets

Vi ønsker å benytte km for radius, og kg for masse. Velg passende datatyper for instansvariablene, samt passende konstruktører for klassene.

Husk å gjøre instansvariablene private, og lag get- og set-metoder for disse (innkapsling).

### Oppgave 2.2

Lag en klasse kalt Main.java som skal benytte klassene du akkurat laget.

Opprett et objekt av PlanetSystem-klassen for vårt eget planetsystem kalt "Solar system", med tilhørende Planet-objekter og ett Star-objekt "Sun".

### Oppgave 2.3

Implementer toString()-metoden i klassene du laget i Oppgave 2.1, lag en passende utskrift som gir relevant informasjon om objektet.

Benytt denne til å skrive ut informasjon om planetsystemet og noen av planetene du har laget i Main.java.

### Oppgave 2.4

Når vi snakker om data i universet, så får vi store tall når vi benytter vanlige enheter. Astronomene benytter ofte andre enheter enn kg og km når vi snakker om masse og radius i universet. De har derfor definert enheter som er relatert til større objekter i vårt eget solsystem. 

For planeter har man enheten Jupiter Mass (Mjup eller MJ) for masse, og Jupiter Radius (Rjup eller RJ) for størrelse.
For stjerner har man enheten Solar Mass (Msun eller M☉) for masse, og Solar Radius (Rsun eller R☉) for størrelse.

Forholdet for disse er slik:
Astronomisk Enhet | "Vanlig" enhet
------------------|---------------
1 Mjup / MJ |	1.898×1027kg (1.898E27)
1 Rjup / RJ |	71 492 km
1 Msun / M☉ |	1.98892×1030kg (1.98892E30)
1 Rsun / R☉ |	695 700 km

Legg til en metode som returnerer masse i Mjup for en Planet.
Legg til en metode som returnerer radius i Rjup for en Planet.

Legg til en metode som returnerer masse i Msun for en Star.
Legg til en metode som returnerer radius i Rsun for en Star.

Hva blir Mjup og Rjup for "Saturn"? 
Hva blir Msun og Rsun for vår stjerne "Sun"?

Benytt metodene du har laget å skriv ut dette i Main.java.

### Oppgave 2.5

Vi ønsker å kunne finne surfaceGravity (g) for en Planet, lag en metode som beregner og returnerer dette ut i fra formelen:

g = GM/R^2

G = Gravitasjonskonstanten - 6.67408 × 10-11 m3⋅kg−1⋅s−2 altså ca. tallet: 0.00000000006674
M = Massen til planeten (formelen benytter her kg)
R = Radius til planeten (formelen benytter her meter)

Hva blir surface gravity til Neptune?

Benytt metoden du har laget å skriv ut dette i Main.java.

### Oppgave 2.6

Vi ønsker å kunne hente den største og minste planeten i et PlanetSystem. Sammenligningen skal først gjøres basert på radiusen, hvis radiusen er lik skal massen sammenlignes. Metoden bør returnere planeten.

Lag metoder som gjør dette, benytte disse og skriv ut informasjon om planetene i Main.java.

 
## Bonusoppgaver

### Bonusoppgave 3.1

Som beskrevet i oppgave 2.4 så har vi forskjellige enheter vi forholder oss til når det kommer til størrelser i universet. Vi har også en som forholder seg til vår egen planet,  Mearth og Rearth. Denne benyttes også til å gi en indikasjon på størrelsen til andre planeter, terrestriske planeter og exoplaneter.

Astronomisk Enhet |	"Vanlig" enhet
------------------|---------------
1 Mearth / ME / M⊕ |	5.972×1024 kg (5.972E24)
1 Rearth / RE / R⊕ |	6371 km

Legg til en metode som returnerer masse i Mearth for en Planet.
Legg til en metode som returnerer radius i Rearth for en Planet.

Hva blir Mearth og Rearth for "Mars"? 

Benytt metodene du har laget å skriv ut dette i Main.java.
